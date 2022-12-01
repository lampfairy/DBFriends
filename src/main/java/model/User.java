package model;

import java.util.Date;

public class User {
    private String name;
    private String userId;
    private String userPw;
    private String phoneNumber;
    private String emailAddress;
    private Date birthDate;
    private String bankName;
    private String nameOnAccount;
    private String accountNumber;
    
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
    // all
    public User(String name, String userId, String userPw, String phoneNumber, String emailAddress, Date birthDate,
			String bankName, String nameOnAccount, String accountNumber) {
		super();
		this.name = name;
		this.userId = userId;
		this.userPw = userPw;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.birthDate = birthDate;
		this.bankName = bankName;
		this.nameOnAccount = nameOnAccount;
		this.accountNumber = accountNumber;
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
    public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getNameOnAccount() {
		return nameOnAccount;
	}
	public void setNameOnAccount(String nameOnAccount) {
		this.nameOnAccount = nameOnAccount;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", userId=" + userId + ", userPw=" + userPw + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", birthDate=" + birthDate + ", bankName=" + bankName
				+ ", nameOnAccount=" + nameOnAccount + ", accountNumber=" + accountNumber + "]";
	}
    
	
    /* 비밀번호 검사 */
    public boolean matchPassword(String userPw) {
        if (userPw == null) {
            return false;
        }
        return this.userPw.equals(userPw);
    }
    
    public boolean isSameUser(String userid) {
        return this.userId.equals(userid);
    }
}
