package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reservation;
//import util.JDBCUtil; //

public class ReservationDAO {
    private JDBCUtil jdbcUtil = null;
    
    public ReservationDAO() {          
        jdbcUtil = new JDBCUtil();
    }
    
    //create Reservation
    public int create(Reservation Reservation) throws SQLException {
        String sql = "INSERT INTO Reservation (reservationId, startDate, endDate, "
                + "headCount, price, productId, userId) "              
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";     
        Object[] param = new Object[] {Reservation.getReservationId(), Reservation.getStartDate(), Reservation.getEndDate(),
                Reservation.getHeadCount(), Reservation.getPrice(), Reservation.getProductId(), Reservation.getUserId()};              
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

    //update Reservation
    public int update(Reservation Reservation) throws SQLException {
        String sql = "UPDATE Reservation "
                    + "SET productId=?, startDate=?, endDate=?, headCount=?, price=?, userId=? "
                    + "WHERE reservationId=? ";
        Object[] param = new Object[] {Reservation.getProductId(), Reservation.getStartDate(), Reservation.getEndDate(),
                Reservation.getHeadCount(), Reservation.getPrice(), Reservation.getUserId(), Reservation.getReservationId()};           
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

   //remove Reservation
    public int remove(int reservationId) throws SQLException {
        String sql = "DELETE FROM Reservation WHERE reservationId=? ";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reservationId});   

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

   //find Reservation
    public Reservation findReservation(int reservationId) throws SQLException {
        String sql = "SELECT r.productId AS productId, r.startDate AS startDate, r.endDate AS endDate, r.headCount AS headCount, r.price AS price, r.userId AS userId, p.name AS name "
                    + "FROM Reservation r JOIN Product p ON r.productId = p.productId "
                    + "WHERE reservationId=?";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reservationId});   
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();    
            if (rs.next()) {                      
                Reservation Reservation = new Reservation(
                    reservationId,
                    rs.getInt("productId"),
                    rs.getDate("startDate"),
                    rs.getDate("endDate"),
                    rs.getInt("headCount"),
                    rs.getInt("price"),
                    rs.getString("userId"),
                    rs.getString("name"));
                return Reservation;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }
        return null;
    }

    //find Reservation List
    public List<Reservation> findReservationList(String userId) throws SQLException {
        String sql = "SELECT r.reservationId AS reservationId, r.productId AS productId, "
                + "r.startDate AS startDate, r.endDate AS endDate, r.headCount AS headCount, r.price AS price, r.userId AS userId, p.name AS name "
                    + "FROM Reservation r JOIN Product p ON r.productId = p.productId "
                    + "WHERE userId=? "
                    + "ORDER BY reservationId";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});  
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();           
            List<Reservation> ReservationList = new ArrayList<Reservation>();   
            while (rs.next()) {
                Reservation Reservation = new Reservation(
                        rs.getInt("reservationId"),
                        rs.getInt("productId"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getInt("headCount"),
                        rs.getInt("price"),
                        userId,
                        rs.getString("name")
                        );
                ReservationList.add(Reservation);   
            }       
            return ReservationList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      
        }
        return null;
    }

  //Reservation 아이디 중복 확인
    public boolean existingReservation(int reservationId) throws SQLException {
        String sql = "SELECT count(*) FROM Reservation WHERE reservationId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reservationId});  
        
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