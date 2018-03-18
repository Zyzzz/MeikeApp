package zyzzz.imudges.com.model;

/**
 * Created by Administrator on 2018/3/18.
 */

public class UserModel extends BaseModel{

    /**
     * id : 1
     * nickname : 周炎
     * age : 123
     * phone : 123
     * address : 123
     * email : 123
     * information : null
     * password : 123
     * cookie : 1f94f579601d13fbeeb9963d3a65490ab08f5e0c7cf758aaa5ed6635f6088f77
     * nowstatus : null
     * securityCode : null
     */

    private int id;
    private String nickname;
    private int age;
    private String phone;
    private String address;
    private String email;
    private Object information;
    private String password;
    private String cookie;
    private Object nowstatus;
    private Object securityCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getInformation() {
        return information;
    }

    public void setInformation(Object information) {
        this.information = information;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Object getNowstatus() {
        return nowstatus;
    }

    public void setNowstatus(Object nowstatus) {
        this.nowstatus = nowstatus;
    }

    public Object getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Object securityCode) {
        this.securityCode = securityCode;
    }
}
