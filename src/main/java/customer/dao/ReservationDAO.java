package customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class ReservationDAO {
    private JDBCUtil jdbcUtil = null;
    
    public ReservationDAO() {          
        jdbcUtil = new JDBCUtil();
    }
    
    //怨좉컼 �벑濡�
    public int create(Reservation Reservation) throws SQLException {
        String sql = "INSERT INTO Reservation (reservationId, productId, startDate, endDate, "
                + "headCount, price, reservationList, customerId) "              
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";     
        Object[] param = new Object[] {Reservation.getReservationId(), Reservation.getProductId(), Reservation.getStartDate(), Reservation.getEndDate(),
                Reservation.getHeadCount(), Reservation.getPrice(), Reservation.getReservationList(), Reservation.getCustomerId()};              
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

    //怨좉컼 �닔�젙
    public int update(Reservation Reservation) throws SQLException {
        String sql = "UPDATE Reservation "
                    + "SET productId=?, startDate=?, endDate=?, headCount=?, price=?, customerId=? "
                    + "WHERE reservationId=?";
        Object[] param = new Object[] {Reservation.getProductId(), Reservation.getStartDate(), Reservation.getEndDate(),
                Reservation.getHeadCount(), Reservation.getPrice(), Reservation.getReservationList(), Reservation.getCustomerId(), Reservation.getReservationId()};           
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

   //�쉶�썝 �궘�젣
    public int remove(int reservationId) throws SQLException {
        String sql = "DELETE FROM Reservation WHERE reservationId=?";     
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

   //�쉶�썝 �젙蹂� 蹂닿린
    public Reservation findReservation(int reservationId) throws SQLException {
        String sql = "SELECT productId, startDate, endDate, headCount, price, reservationList, customerId "
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
                    rs.getInt("customerId"));
                return Reservation;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }
        return null;
    }

    //�쉶�썝�젙蹂� 由ъ뒪�듃蹂닿린
    public List<Reservation> findReservationList() throws SQLException {
        String sql = "SELECT reservationId, productId, startDate, endDate, "
                + "headCount, price, reservationList, customerId "
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
                        rs.getInt("customerId"));
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

  //아이디 중복 확인
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