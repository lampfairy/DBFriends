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
        String sql = "INSERT INTO Reservation (reservationId, productId, startDate, endDate, "
                + "headCount, price, reservationList, userId) "              
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";     
        Object[] param = new Object[] {Reservation.getReservationId(), Reservation.getProductId(), Reservation.getStartDate(), Reservation.getEndDate(),
                Reservation.getHeadCount(), Reservation.getPrice(), Reservation.getReservationList(), Reservation.getUserId()};              
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
                    + "SET productId=?, startDate=?, endDate=?, headCount=?, price=?, reservationList=?, userId=? "
                    + "WHERE reservationId=? ";
        Object[] param = new Object[] {Reservation.getProductId(), Reservation.getStartDate(), Reservation.getEndDate(),
                Reservation.getHeadCount(), Reservation.getPrice(), Reservation.getReservationList(), Reservation.getUserId(), Reservation.getReservationId()};           
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
        String sql = "SELECT productId, startDate, endDate, headCount, price, reservationList, userId "
                    + "FROM Reservation "
                    + "WHERE reservationId=? ";              
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
                    rs.getInt("reservationList"),
                    rs.getString("userId"));
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
    public List<Reservation> findReservationList() throws SQLException {
        String sql = "SELECT reservationId, productId, startDate, endDate, "
                + "headCount, price, reservationList, userId "
                    + "FROM Reservation "
                    + "ORDER BY reservationId";
        jdbcUtil.setSqlAndParameters(sql, null);  
                    
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
                        rs.getInt("reservationList"),
                        rs.getString("userId"));
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