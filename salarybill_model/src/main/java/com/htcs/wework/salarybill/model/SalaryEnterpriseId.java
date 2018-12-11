package com.htcs.wework.salarybill.model;

import java.io.Serializable;
import java.util.Date;

public class SalaryEnterpriseId implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String userName;

    /**
     * 企业微信id
     */
    private String enterpriseId;

    /**
     * 逻辑删除标志
     */
    private Byte logicalDel;

    /**
     * 创建人id
     */
    private Byte createBy;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Byte udpateBy;

    /**
     * 更新人名字
     */
    private String updateName;

    /**
     * 更新时间
     */
    private Date udpateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public Byte getLogicalDel() {
        return logicalDel;
    }

    public void setLogicalDel(Byte logicalDel) {
        this.logicalDel = logicalDel;
    }

    public Byte getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Byte createBy) {
        this.createBy = createBy;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getUdpateBy() {
        return udpateBy;
    }

    public void setUdpateBy(Byte udpateBy) {
        this.udpateBy = udpateBy;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getUdpateTime() {
        return udpateTime;
    }

    public void setUdpateTime(Date udpateTime) {
        this.udpateTime = udpateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", logicalDel=").append(logicalDel);
        sb.append(", createBy=").append(createBy);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
        sb.append(", udpateBy=").append(udpateBy);
        sb.append(", updateName=").append(updateName);
        sb.append(", udpateTime=").append(udpateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}