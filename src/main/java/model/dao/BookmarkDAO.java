
package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bookmark;


public class BookmarkDAO {
    private JDBCUtil jdbcUtil = null;
   
    public BookmarkDAO() {          
        jdbcUtil = new JDBCUtil();
    }
   
    //create Bookmark
    public int create(Bookmark Bookmark) throws SQLException {
        String sql = "INSERT INTO create (userId, productId) "
                    + "VALUES (?, ?)";    
        Object[] param = new Object[] {Bookmark.getUserId(), Bookmark.getProductId()};              
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

    //update Bookmark
    public int update(Bookmark Bookmark) throws SQLException {
        String sql = "UPDATE Bookmark "
                    + "SET productId=? "
                    + "WHERE userId=?";
        Object[] param = new Object[] {Bookmark.getProductId(), Bookmark.getUserId()};                
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

   //remove Bookmark
    public int remove(int productId) throws SQLException {
        String sql = "DELETE FROM Bookmark WHERE productId=?";    
        jdbcUtil.setSqlAndParameters(sql, new Object[] {productId});  

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

   //find Bookmark
    public Bookmark findBookmark(String userId) throws SQLException {
        String sql = "SELECT productId "
                    + "FROM Bookmark "
                    + "WHERE userId=? ";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});  
       
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
            Bookmark Bookmark = new Bookmark(
                    userId,
                    rs.getInt("productId"));
                return Bookmark;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    //find Bookmark List
    public List<Bookmark> findBookmarkList() throws SQLException {
        String sql = "SELECT userId, productId "
                   + "FROM Bookmark "
                   + "ORDER BY userId";
        jdbcUtil.setSqlAndParameters(sql, null);  
                   
        try {
            ResultSet rs = jdbcUtil.executeQuery();          
            List<Bookmark> BookmarkList = new ArrayList<Bookmark>();  
            while (rs.next()) {
            Bookmark Bookmark = new Bookmark(
                    rs.getString("userId"),
                    rs.getInt("productId"));
            BookmarkList.add(Bookmark);  
            }      
            return BookmarkList;                    
           
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      
        }
        return null;
    }

//    public boolean existingCustomer(String userId) throws SQLException {
//        String sql = "SELECT count(*) FROM Customer WHERE userId=?";      
//        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});  
//        
//        try {
//            ResultSet rs = jdbcUtil.executeQuery();    
//            if (rs.next()) {
//                int count = rs.getInt(1);
//                return (count == 1 ? true : false);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            jdbcUtil.close();    
//        }
//        return false;
//    }
}