package model;

import java.util.Date;

public class User {
    private String name;
    private String userId;
    private String userPw;
    private String phoneNumber;
    private String emailAddress;
    private Date birthDate;
    
    public User() {
        super();
    }
    
    public User(String name, String userId, String userPw, String phoneNumber, String emailAddress,
            Date birthDate) {
        super();
        this.name = name;
        this.userId = userId;
        this.userPw = userPw;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
    }

    public User(String name, String userId, String phoneNumber, String emailAddress, Date birthDate) {
        super();
        this.name = name;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPw() {
        return userPw;
    }
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "Customer [name=" + name + ", userId=" + userId + ", userPw=" + userPw + ", phoneNumber=" + phoneNumber
                + ", emailAddress=" + emailAddress + ", birthDate=" + birthDate + "]";
    }
}
