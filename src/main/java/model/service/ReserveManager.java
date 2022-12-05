package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Reservation;
import model.dao.ReservationDAO;

public class ReserveManager {
	private static ReserveManager resvMan = new ReserveManager();
	private ReservationDAO resvDAO;
	
	private ReserveManager() {
		try {
			resvDAO = new ReservationDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ReserveManager getInstance() {
		return resvMan;
	}
	
	public int create(Reservation Reservation) throws SQLException, ExistingException {
		if(resvDAO.existingReservation(Reservation.getReservationId()) == true) {
			throw new ExistingException(Reservation.getReservationId() + "exists");
		}
		return resvDAO.create(Reservation);
	}
	
	public int update(Reservation Reservation) throws SQLException {
		return resvDAO.update(Reservation);
	}
	
	public int remove(int ReservationId) throws SQLException {
        return resvDAO.remove(ReservationId);
    }

    public Reservation findReservation(int ReservationId)
        throws SQLException, ExistingException {
        Reservation prod = resvDAO.findReservation(ReservationId);
        
        if (prod == null) {
            throw new ExistingException(ReservationId + "doesn't exist");
        }       
        return prod;
    }

    public List<Reservation> findReservationList(String userId) throws SQLException {
            return resvDAO.findReservationList(userId);
    }
    
    public ReservationDAO getresvDAO() {
		return this.resvDAO;
	}
}
