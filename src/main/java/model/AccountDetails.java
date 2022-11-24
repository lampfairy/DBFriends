package model;

public class AccountDetails {

    private String userId;
    private String bankName;
    private String nameOnAccount;
    private String accountNumber;
    
    //getter & setter 
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
    
    //constructor
    public AccountDetails(String userId, String bankName, String nameOnAccount, String accountNumber) {
        super();
        this.userId = userId;
        this.bankName = bankName;
        this.nameOnAccount = nameOnAccount;
        this.accountNumber = accountNumber;
    }
    
    //toString
    @Override
    public String toString() {
        return "AccountDetails [userId=" + userId + ", bankName=" + bankName + ", nameOnAccount=" + nameOnAccount
                + ", accountNumber=" + accountNumber + "]";
    }
    
    
    
}
