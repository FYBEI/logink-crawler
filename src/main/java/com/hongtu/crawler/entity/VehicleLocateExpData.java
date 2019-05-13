package com.hongtu.crawler.entity;

import java.util.Date;

public class VehicleLocateExpData {

    /**
     * Id
     */
    private Long Id;

    /**
     * 交换事件Id
     */
    private String eventId;

    /**
     * 接收时间
     * YYYY-MM-DD hh:mm:ss
     */
    private Date exceptCompaTime;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 物流交换代码
     */
    private String senderCode;

    /**
     * 委托单号
     */
    private String bookingNo;

    /**
     * 运单号
     */
    private String jobOrderNo;

    /**
     * 车牌号
     */
    private String vehicleNumber;

    /**
     * 出发地
     */
    private String loadRegCode;

    /**
     * 出发时间
     */
    private Date despatchDate;

    /**
     * 到达地
     */
    private String unloadRegCode;

    /**
     * 到达时间
     */
    private Date receiptDate;

    /**
     * 定位状态
     */
    private String dwState;

    /**
     * 备注
     */
    private String dwContent;

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getExceptCompaTime() {
        return exceptCompaTime;
    }

    public void setExceptCompaTime(Date exceptCompaTime) {
        this.exceptCompaTime = exceptCompaTime;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getJobOrderNo() {
        return jobOrderNo;
    }

    public void setJobOrderNo(String jobOrderNo) {
        this.jobOrderNo = jobOrderNo;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getLoadRegCode() {
        return loadRegCode;
    }

    public void setLoadRegCode(String loadRegCode) {
        this.loadRegCode = loadRegCode;
    }

    public Date getDespatchDate() {
        return despatchDate;
    }

    public void setDespatchDate(Date despatchDate) {
        this.despatchDate = despatchDate;
    }

    public String getUnloadRegCode() {
        return unloadRegCode;
    }

    public void setUnloadRegCode(String unloadRegCode) {
        this.unloadRegCode = unloadRegCode;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getDwState() {
        return dwState;
    }

    public void setDwState(String dwState) {
        this.dwState = dwState;
    }

    public String getDwContent() {
        return dwContent;
    }

    public void setDwContent(String dwContent) {
        this.dwContent = dwContent;
    }

    @Override
    public String toString(){
        String s = "Id:" + Id + "交换事件Id:" + eventId + " 接收时间:" + exceptCompaTime + " 企业名称:" + entName + " 物流交换代码:" + senderCode
                + " 委托单号:" + bookingNo + " 运单号:" + jobOrderNo + " 车牌号:" + vehicleNumber + " 出发地:" + loadRegCode
                + " 出发时间:" + despatchDate + " 到达地:" + unloadRegCode + " 到达时间:" + receiptDate + " 定位状态:" + dwState
                + " 备注:" + dwContent;
        return s;
    }
}
