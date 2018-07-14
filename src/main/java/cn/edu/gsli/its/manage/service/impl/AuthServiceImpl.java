package cn.edu.gsli.its.manage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import cn.edu.gsli.its.common.exception.ServiceException;
import cn.edu.gsli.its.common.web.PageObject;
import cn.edu.gsli.its.manage.dao.AuthDao;
import cn.edu.gsli.its.manage.dao.MessageDao;
import cn.edu.gsli.its.manage.entity.Auth;
import cn.edu.gsli.its.manage.entity.Message;
import cn.edu.gsli.its.manage.service.AuthService;
import cn.edu.gsli.its.system.entity.SysUser;

@Service
public class AuthServiceImpl implements AuthService {
	@Resource
	AuthDao authDao;
	@Resource
	private MessageDao messageDao;
	SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
	@Override
	public Map<String, Object> getAuthObjects(int pageNo, Integer state) {
		PageObject page=new PageObject();
		page.setPageCurrent(pageNo);
		page.setPageSize(5);
		page.setRowCount(authDao.findAuthCount(state));
		page.setStartIndex((pageNo-1)*page.getPageSize());
		List<Auth> list=authDao.findAuth(state, page.getStartIndex(), page.getPageSize());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("auth", list);
		map.put("pageCount", page.getPageCount());
		return map;
	}
	@Override
	public Auth getAuthObject(int id) {
		return authDao.findById(id);
	}
	@Override
	public void dueWithAuth(int id, int state, String opinion) throws Exception{
		if("".equals(opinion.trim()))throw new ServiceException("审核意见不能为空！");
		authDao.dueWithAuth(id, state, opinion,user.getUsername());
		Auth auth=authDao.findById(id);
		if(state==1) {
			authDao.updateValidByUsername(auth.getUsername(), 2);//2-认证状态
		}
		// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
	    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）, 
	    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
	    String myEmailAccount = "13099215706@163.com";
	    String myEmailPassword = "Gl960811";
	    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
	    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
	    String myEmailSMTPHost = "smtp.163.com";
	    // 收件人邮箱（替换为自己知道的有效邮箱）
	    String receiveMailAccount = auth.getEmail();
	    Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        /*
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        */
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
        // 3. 创建一封邮件
        // 3.1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 3.2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(myEmailAccount, "ITS_Admin", "UTF-8"));

        // 3.3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount,auth.getName(), "UTF-8"));
        
        // 3.4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        String title="[互助教学系统]教师认证审核结果";
        message.setSubject(title, "UTF-8");

        // 3.5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        String content=state==1?"[互助教学系统]恭喜您，已成为本站的认证教师！"
        		:"[互助教学系统]很遗憾，您未通过认证教师的审核，审核意见："+opinion;
        message.setContent(content, "text/html;charset=UTF-8");
        // 3.6. 设置发件时间
        message.setSentDate(new Date());

        // 3.7. 保存设置
        message.saveChanges();
        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
     // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        // 
        //    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
        //           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
        //           类型到对应邮件服务器的帮助网站上查看具体失败原因。
        //
        //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
        //           (1) 邮箱没有开启 SMTP 服务;
        //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
        //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
        //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
        //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
        //
        //    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
        transport.connect(myEmailAccount, myEmailPassword);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        // 7. 关闭连接
        transport.close();
        //发送消息到前台系统
        Message msg=new Message();
        msg.setType(0);
        msg.setCreatedUser("admin");
        msg.setUser(auth.getUsername());
        msg.setTitle(title);
        msg.setContent(content);
        messageDao.insertMsg(msg);
	}

}
