package model;

public class TClassroom {
    private Integer classroomId;

    private String classroomType;

    private String classroomName;

    private String buildingName;

    private String imageUrl;

    private Integer capacity;

    private String administrator;

    private String adminPhone;

    private String equipmentDesc;

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(String classroomType) {
        this.classroomType = classroomType == null ? null : classroomType.trim();
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator == null ? null : administrator.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getEquipmentDesc() {
        return equipmentDesc;
    }

    public void setEquipmentDesc(String equipmentDesc) {
        this.equipmentDesc = equipmentDesc == null ? null : equipmentDesc.trim();
    }

    @Override
    public String toString() {
        return "TClassroom{" +
                "classroomId=" + classroomId +
                ", classroomType='" + classroomType + '\'' +
                ", classroomName='" + classroomName + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", capacity=" + capacity +
                ", administrator='" + administrator + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", equipmentDesc='" + equipmentDesc + '\'' +
                '}';
    }
}