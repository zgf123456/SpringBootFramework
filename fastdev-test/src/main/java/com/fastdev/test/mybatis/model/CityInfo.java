package com.fastdev.test.mybatis.model;

import java.util.Date;

public class CityInfo {
    private Integer id;

    private String lemmaItem;

    private String itemName;

    private Integer version;

    private String modelFlag;

    private String remark;

    private Date createTime;

    private String creator;

    private Date modifyTime;

    private String updater;

    private String praentLemmaItem;

    private Integer modelOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLemmaItem() {
        return lemmaItem;
    }

    public void setLemmaItem(String lemmaItem) {
        this.lemmaItem = lemmaItem == null ? null : lemmaItem.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getModelFlag() {
        return modelFlag;
    }

    public void setModelFlag(String modelFlag) {
        this.modelFlag = modelFlag == null ? null : modelFlag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public String getPraentLemmaItem() {
        return praentLemmaItem;
    }

    public void setPraentLemmaItem(String praentLemmaItem) {
        this.praentLemmaItem = praentLemmaItem == null ? null : praentLemmaItem.trim();
    }

    public Integer getModelOrder() {
        return modelOrder;
    }

    public void setModelOrder(Integer modelOrder) {
        this.modelOrder = modelOrder;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "id=" + id +
                ", lemmaItem='" + lemmaItem + '\'' +
                ", itemName='" + itemName + '\'' +
                ", version=" + version +
                ", modelFlag='" + modelFlag + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", modifyTime=" + modifyTime +
                ", updater='" + updater + '\'' +
                ", praentLemmaItem='" + praentLemmaItem + '\'' +
                ", modelOrder=" + modelOrder +
                '}';
    }
}