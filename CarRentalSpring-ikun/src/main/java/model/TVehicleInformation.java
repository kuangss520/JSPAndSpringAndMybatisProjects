package model;

public class TVehicleInformation {
    private String vehicleid;

    private String vehicletype;

    private String vehiclegrade;

    private Integer ridenum;

    private String vehiclebrand;

    private String vehiclename;

    private String vehiclepic;

    private String vehicledis;

    private Long dailyrental;

    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        return "TVehicleInformation{" +
                "vehicleid='" + vehicleid + '\'' +
                ", vehicletype='" + vehicletype + '\'' +
                ", vehiclegrade='" + vehiclegrade + '\'' +
                ", ridenum=" + ridenum +
                ", vehiclebrand='" + vehiclebrand + '\'' +
                ", vehiclename='" + vehiclename + '\'' +
                ", vehiclepic='" + vehiclepic + '\'' +
                ", vehicledis='" + vehicledis + '\'' +
                ", dailyrental=" + dailyrental +
                ", state='" + state + '\'' +
                '}' + "\n";
    }
}