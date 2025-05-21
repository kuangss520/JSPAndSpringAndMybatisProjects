package model;

import java.util.Date;

public class Rental_Order_View {
    private String orderid;

    private String vehicleid;

    private String vehicletype;

    private String vehiclegrade;

    private Integer ridenum;

    private String vehiclebrand;

    private String vehiclename;

    private String vehiclepic;

    private String vehicledis;

    private Long dailyrental;

    private String userid;

    private String username;

    private String mail;

    private String mobile;

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

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype == null ? null : vehicletype.trim();
    }

    public String getVehiclegrade() {
        return vehiclegrade;
    }

    public void setVehiclegrade(String vehiclegrade) {
        this.vehiclegrade = vehiclegrade == null ? null : vehiclegrade.trim();
    }

    public Integer getRidenum() {
        return ridenum;
    }

    public void setRidenum(Integer ridenum) {
        this.ridenum = ridenum;
    }

    public String getVehiclebrand() {
        return vehiclebrand;
    }

    public void setVehiclebrand(String vehiclebrand) {
        this.vehiclebrand = vehiclebrand == null ? null : vehiclebrand.trim();
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename == null ? null : vehiclename.trim();
    }

    public String getVehiclepic() {
        return vehiclepic;
    }

    public void setVehiclepic(String vehiclepic) {
        this.vehiclepic = vehiclepic == null ? null : vehiclepic.trim();
    }

    public String getVehicledis() {
        return vehicledis;
    }

    public void setVehicledis(String vehicledis) {
        this.vehicledis = vehicledis == null ? null : vehicledis.trim();
    }

    public Long getDailyrental() {
        return dailyrental;
    }

    public void setDailyrental(Long dailyrental) {
        this.dailyrental = dailyrental;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
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

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
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
        return "Rental_Order_View{" +
                "orderid='" + orderid + '\'' +
                ", vehicleid='" + vehicleid + '\'' +
                ", vehicletype='" + vehicletype + '\'' +
                ", vehiclegrade='" + vehiclegrade + '\'' +
                ", ridenum=" + ridenum +
                ", vehiclebrand='" + vehiclebrand + '\'' +
                ", vehiclename='" + vehiclename + '\'' +
                ", vehiclepic='" + vehiclepic + '\'' +
                ", vehicledis='" + vehicledis + '\'' +
                ", dailyrental=" + dailyrental +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", mobile='" + mobile + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", vehiclestatus='" + vehiclestatus + '\'' +
                ", remarks='" + remarks + '\'' +
                ", orderstatus='" + orderstatus + '\'' +
                ", orderprice=" + orderprice +
                '}' + "\n";
    }
}