package cn.edu.gsli.its.system.entity;



import java.io.Serializable;
import java.util.Date;


/**
 * 用户�?属机�?
 * @author Admin
 *
 */

public class Organization implements Serializable {
    /***/
	private static final long serialVersionUID = 1L;
	// 机构编号
    private Integer id;
    // 机构名称
    private String name;
    // 机构编码
    private String code;
    //上级机构编号
    private Integer parentId;
    //上级机构多级编号
    private String parentIds; 
	// 备注
    private String note;
    // 有效标志
    private Integer valid;
    // 新增用户
    private String createdUser;
    // 新增时间
    private Date createdTime;
    // 更新用户
    private String modifiedUser;
    // 更新时间
    private Date modifiedTime;

    public void setId(Integer id) {
		this.id = id;
	}
    public void setName(String name) {
		this.name = name;
	}

    public Integer getId() {
		return id;
	}
    public String getName() {
		return name;
	}
    public Integer getParentId() {
		return parentId;
	}
    public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	
    public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
    public String makeSelfAsParentIds() {

        return getParentIds() + getId() + "/";
    }

	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", parentId=" + parentId + ", note=" + note + ", valid="
				+ valid + ", createdUser=" + createdUser + ", createdTime=" + createdTime + ", modifiedUser="
				+ modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
    
    
    
    
}
