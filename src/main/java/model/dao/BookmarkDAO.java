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
        String sql = "INSERT INTO Bookmark (userId, productId) "
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

   //remove Bookmark
    public int remove(String userId, int productId) throws SQLException {
        String sql = "DELETE FROM Bookmark WHERE userId=? AND productId=?";    
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, productId});  

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
    public List<Bookmark> findUserBookmarkList(String userId) throws SQLException {
        String sql = "SELECT productId "
                    + "FROM Bookmark "
                    + "WHERE userId=? "
                    + "ORDER BY productId";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});  
       
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            List<Bookmark> BookmarkList = new ArrayList<Bookmark>();  
            while (rs.next()) {
            Bookmark Bookmark = new Bookmark(
            		userId,
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

    //find Bookmark List
    public List<Bookmark> findBookmarkList() throws SQLException {
        String sql = "SELECT userId, productId "
                   + "FROM Bookmark "
                   + "ORDER BY userId, productId";
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

    public boolean existingBookmark(String userId, int productId) throws SQLException {
        String sql = "SELECT count(*) FROM Bookmark WHERE userId=? AND productId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, productId});  
        
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