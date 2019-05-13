package com.hongtu.crawler.entity;

import java.util.Date;

public class UpWaybillData {

    /**
     * Id
     */
    private Long Id;

    /**
     * 交换事件Id
     */
    private String eventId;

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
     * 车牌类型
     */
    private String vehicleNuType;

    /**
     * 道路运输证号
     */
    private String transportLicense;

    /**
     * 启运地
     */
    private String loadAdress;

    /**
     * 送达地
     */
    private String reunloadAdress;

    /**
     * 接收时间
     * YYYY-MM-DD hh:mm:ss
     */
    private Date createDate;

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public String getVehicleNuType() {
        return vehicleNuType;
    }

    public void setVehicleNuType(String vehicleNuType) {
        this.vehicleNuType = vehicleNuType;
    }

    public String getTransportLicense() {
        return transportLicense;
    }

    public void setTransportLicense(String transportLicense) {
        this.transportLicense = transportLicense;
    }

    public String getLoadAdress() {
        return loadAdress;
    }

    public void setLoadAdress(String loadAdress) {
        this.loadAdress = loadAdress;
    }

    public String getReunloadAdress() {
        return reunloadAdress;
    }

    public void setReunloadAdress(String reunloadAdress) {
        this.reunloadAdress = reunloadAdress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String toString(){
        String s = "Id:" + Id + "交换事件Id:" + eventId + " 委托单号:" + bookingNo + " 运单号:" + jobOrderNo
                + " 车牌号码:" + vehicleNumber + " 车牌类型:" + vehicleNuType + " 道路运输证号:" + transportLicense
                + " 启运地:" + loadAdress + " 送达地:" + reunloadAdress + " 接收时间:" + createDate;
        return s;
    }
}
