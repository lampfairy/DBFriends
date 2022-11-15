package rrr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import rrr.Customer;
import util.JDBCUtil;

public class CustomerDAO {
    private JDBCUtil jdbcUtil = null;
    
    public CustomerDAO() {          
        jdbcUtil = new JDBCUtil();      // JDBCUtil ��ü ����
    }
    
    //고객 등록
    public int create(Customer Customer) throws SQLException {
        String sql = "INSERT INTO Customer (userId, name, userPw, phoneNumber, "
                + "emailAddress) "
                    + "VALUES (?, ?, ?, ?, ?)";     
        Object[] param = new Object[] {Customer.getUserId(), Customer.getName(), 
                Customer.getUserPw(), Customer.getPhoneNumber(), Customer.getEmailAddress()};              
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

    //고객 수정
    public int update(Customer Customer) throws SQLException {
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

   //회원 삭제
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

   //회원 정보 보기
    public Customer findCustomer(String userId) throws SQLException {
        String sql = "SELECT name, phoneNumber, emailAddress, birthDate "
                    + "FROM Customer "
                    + "WHERE userId=? ";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
                Customer Customer = new Customer(
                    rs.getString("name"),
                    userId,
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

    //회원정보 리스트보기
    public List<Customer> findCustomerList() throws SQLException {
        String sql = "SELECT userId, name, userPw, "
                + "phoneNumber, emailAddress, birthDate " 
                   + "FROM Customer "
                   + "ORDER BY userId";
        jdbcUtil.setSqlAndParameters(sql, null);  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<Customer> CustomerList = new ArrayList<Customer>();   
            while (rs.next()) {
                Customer Customer = new Customer(
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

    //아이디 중복 확인
    public boolean existingCustomer(String userId) throws SQLException {
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