<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>网站管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a id="load-project-id"><i class="fa fa-circle-o"></i>活动管理</a></li>
            <li><a id="load-news-id"><i class="fa fa-circle-o"></i>新闻管理</a></li>
            <li><a id="load-notice-id"><i class="fa fa-circle-o"></i>公告管理</a></li>
            <li><a id="load-report-id"><i class="fa fa-circle-o"></i>举报处理</a></li>
            <li><a id="load-attachment-id"><i class="fa fa-circle-o"></i>附件管理</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>系统管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a id="load-auth-id"><i class="fa fa-circle-o"></i>认证审核</a></li>
            <li><a id="load-role-id"><i class="fa fa-circle-o"></i>角色管理</a></li>
            <li><a id="load-menu-id"><i class="fa fa-circle-o"></i>菜单管理</a></li>
            <li><a id="load-user-id"><i class="fa fa-circle-o"></i>用户管理</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
<script type="text/javascript">
$('#load-project-id').click(function(){
	var url="project/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-news-id').click(function(){
	var url="news/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-notice-id').click(function(){
	var url="notice/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-attachment-id').click(function(){
	var url="attachment/attachmentUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-report-id').click(function(){
	var url="report/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-role-id').click(function(){
	var url="role/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-menu-id').click(function(){
	var url="menu/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-user-id').click(function(){
	var url="user/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
$('#load-auth-id').click(function(){
	var url="auth/listUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
</script>