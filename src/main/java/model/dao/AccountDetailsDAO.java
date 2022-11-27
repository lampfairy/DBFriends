package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountDetails;
//import util.JDBCUtil;

public class AccountDetailsDAO {
    private JDBCUtil jdbcUtil = null;
    
    public AccountDetailsDAO() {          
        jdbcUtil = new JDBCUtil();
    }
    
    // create Account
    public int create(AccountDetails AccountDetails) throws SQLException {
        String sql = "INSERT INTO AccountDetails (userId, bankName, nameOnAccount, accountNumber) "
                    + "VALUES (?, ?, ?, ?)";     
        Object[] param = new Object[] {AccountDetails.getUserId(), AccountDetails.getBankName(), AccountDetails.getNameOnAccount(), AccountDetails.getAccountNumber()};
                             
        jdbcUtil.setSqlAndParameters(sql, param);
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close(); 
        }       
        return 0;           
    }

    // update Account
    public int update(AccountDetails AccountDetails) throws SQLException {
        String sql = "UPDATE AccountDetails "
                    + "SET bankName=?, nameOnAccount=?, accountNumber=? "
                    + "WHERE userId=? ";
        Object[] param = new Object[] {AccountDetails.getBankName(), AccountDetails.getNameOnAccount(), AccountDetails.getAccountNumber(), AccountDetails.getUserId()};                
        jdbcUtil.setSqlAndParameters(sql, param);   
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }       
        return 0;
    }

   // remove Account
    public int remove(String userId) throws SQLException {
        String sql = "DELETE FROM AccountDetails WHERE userId=?";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});   

        try {               
            int result = jdbcUtil.executeUpdate(); 
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close(); 
        }       
        return 0;
    }

   // find Account
    public AccountDetails findAccountDetails(String userId) throws SQLException {
        String sql = "SELECT bankName, nameOnAccount, accountNumber "
                    + "FROM AccountDetails "
                    + "WHERE userId=? ";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
                AccountDetails AccountDetails = new AccountDetails(
                    userId,
                    rs.getString("bankName"),
                    rs.getString("nameOnAccount"),
                    rs.getString("accountNumber"));
                return AccountDetails;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }
        return null;
    }

    //find Account Details List
    public List<AccountDetails> findAccountDetailsList() throws SQLException {
        String sql = "SELECT userId, bankName, nameOnAccount, accountNumber "
                    + "FROM AccountDetails "
                    + "ORDER BY userId";
        jdbcUtil.setSqlAndParameters(sql, null);  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<AccountDetails> AccountDetailsList = new ArrayList<AccountDetails>();   
            while (rs.next()) {
                AccountDetails AccountDetails = new AccountDetails(
                        rs.getString("userId"),
                        rs.getString("bankName"),
                        rs.getString("nameOnAccount"),
                        rs.getString("accountNumber"));
                AccountDetailsList.add(AccountDetails);   
            }       
            return AccountDetailsList;                    
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      
        }
        return null;
    }
 
    
    public boolean existingAccount(String userId) throws SQLException {
        String sql = "SELECT count(*) FROM AccountDetails WHERE userId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});  
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();     
        }
        return false;
    }
}