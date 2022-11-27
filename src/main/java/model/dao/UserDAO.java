package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;


public class UserDAO {
    private JDBCUtil jdbcUtil = null;
    
    public UserDAO() {          
        jdbcUtil = new JDBCUtil();
    }
    
    //�� ���
    public int create(User Customer) throws SQLException {
        String sql = "INSERT INTO Customer (userId, name, userPw, phoneNumber, "
                + "emailAddress, birthDate) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";     
        Object[] param = new Object[] {Customer.getUserId(), Customer.getName(), 
                Customer.getUserPw(), Customer.getPhoneNumber(), Customer.getEmailAddress(), 
                Customer.getBirthDate()};              
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

    //�� ����
    public int update(User Customer) throws SQLException {
        String sql = "UPDATE Customer "
                    + "SET name=?, userPw=?, phoneNumber=?, emailAddress=?, birthDate=? "
                    + "WHERE userId=?";
        Object[] param = new Object[] {Customer.getName(), Customer.getUserPw(), Customer.getPhoneNumber(), 
                Customer.getEmailAddress(), Customer.getBirthDate(), Customer.getUserId()};                
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

   //ȸ�� ����
    public int remove(String userId) throws SQLException {
        String sql = "DELETE FROM Customer WHERE userId=?";     
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

   //ȸ�� ���� ����
    public User findUser(String userId) throws SQLException {
        String sql = "SELECT name, userPw, phoneNumber, emailAddress, birthDate "
                    + "FROM Customer "
                    + "WHERE userId=? ";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
                User Customer = new User(
                    rs.getString("name"),
                    userId,
                    rs.getString("userPw"),
                    rs.getString("phoneNumber"),
                    rs.getString("emailAddress"),
                    rs.getDate("birthDate"));
                return Customer;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }
        return null;
    }

    //ȸ������ ����Ʈ����
    public List<User> findUserList() throws SQLException {
        String sql = "SELECT userId, name, userPw, "
                + "phoneNumber, emailAddress, birthDate " 
                   + "FROM Customer "
                   + "ORDER BY userId";
        jdbcUtil.setSqlAndParameters(sql, null);  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<User> CustomerList = new ArrayList<User>();   
            while (rs.next()) {
                User Customer = new User(
                    rs.getString("name"),
                    rs.getString("userId"),
                    rs.getString("userPw"),
                    rs.getString("phoneNumber"),
                    rs.getString("emailAddress"),
                    rs.getDate("birthDate"));
                CustomerList.add(Customer);   
            }       
            return CustomerList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      
        }
        return null;
    }

    //���̵� �ߺ� Ȯ��
    public boolean existingUser(String userId) throws SQLException {
        String sql = "SELECT count(*) FROM Customer WHERE userId=?";      
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