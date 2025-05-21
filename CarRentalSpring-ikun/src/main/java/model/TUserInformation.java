package model;

public class TUserInformation {
    private String userid;

    private String username;

    private String pwd;

    private String mail;

    private String mobile;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
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

    @Override
    public String toString() {
        return "TUserInformation{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mail='" + mail + '\'' +
                ", mobile='" + mobile + '\'' +
                '}' + "\n";
    }
}