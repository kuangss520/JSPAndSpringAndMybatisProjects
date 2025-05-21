package model;

import java.util.Date;

public class TRentalOrder {
    private String orderid;

    private String vehicleid;

    private String userid;

    private Date starttime;

    private Date endtime;

    private String vehiclestatus;

    private String remarks;

    private String orderstatus;

    private Long orderprice;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid == null ? null : vehicleid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getStartTime() {
        return starttime;
    }

    public void setStartTime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndTime() {
        return endtime;
    }

    public void setEndTime(Date endtime) {
        this.endtime = endtime;
    }

    public String getVehiclestatus() {
        return vehiclestatus;
    }

    public void setVehiclestatus(String vehiclestatus) {
        this.vehiclestatus = vehiclestatus == null ? null : vehiclestatus.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getOrderStatus() {
        return orderstatus;
    }

    public void setOrderStatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    public Long getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Long orderprice) {
        this.orderprice = orderprice;
    }

    @Override
    public String toString() {
        return "TRentalOrder{" +
                "orderid='" + orderid + '\'' +
                ", vehicleid='" + vehicleid + '\'' +
                ", userid='" + userid + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", vehiclestatus='" + vehiclestatus + '\'' +
                ", remarks='" + remarks + '\'' +
                ", orderstatus='" + orderstatus + '\'' +
                ", orderprice=" + orderprice +
                '}' + "\n";
    }
}