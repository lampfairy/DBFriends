package model.service;

import java.sql.SQLException;
import java.util.List;

import model.AccountDetails;
import model.dao.AccountDetailsDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * AccountDetailsDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class AccountDetailsManager {
    private static AccountDetailsManager accountMan = new AccountDetailsManager();
    private AccountDetailsDAO accountDAO;

    private AccountDetailsManager() {
        try {
            accountDAO = new AccountDetailsDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static AccountDetailsManager getInstance() {
        return accountMan;
    }
    
    public int create(AccountDetails account) throws SQLException, ExistingException {
        if (accountDAO.existingAccount(account.getUserId()) == true) {
            throw new ExistingException(account.getUserId() + "has account number.");
        }
        return accountDAO.create(account);
    }

    public int update(AccountDetails user) throws SQLException {
        return accountDAO.update(user);
    }   

    public int remove(String userId) throws SQLException {
        return accountDAO.remove(userId);
    }

    public AccountDetails findAccountDetails(String userId)
        throws SQLException, ExistingException {
        AccountDetails user = accountDAO.findAccountDetails(userId);
        
        if (user == null) {
            throw new ExistingException(userId + "doesn't exist.");
        }       
        return user;
    }

    public List<AccountDetails> findAccountDetailsList() throws SQLException {
            return accountDAO.findAccountDetailsList();
    }
    
    public AccountDetailsDAO getAccountDetailsDAO() {
        return this.accountDAO;
    }
}