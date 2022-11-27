package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Bookmark;
import model.User;
import model.dao.BookmarkDAO;
import model.dao.UserDAO;


public class BookmarkManager {
    private static BookmarkManager BookmarkMan = new BookmarkManager();
    private BookmarkDAO bookmarkDAO;

    private BookmarkManager() {
        try {
            bookmarkDAO = new BookmarkDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static BookmarkManager getInstance() {
        return BookmarkMan;
    }
    
    public int create(Bookmark bookmark) throws SQLException, ExistingException {
        if (bookmarkDAO.existingBookmark(bookmark.getUserId(), bookmark.getProductId()) == true) {
            throw new ExistingException(bookmark.getProductId() + "is alraedy book marked.");
        }
        return bookmarkDAO.create(bookmark);
    }  

    public int remove(String userId, int productId) throws SQLException {
        return bookmarkDAO.remove(userId, productId);
    }

    public List<Bookmark> findUserBookmarkList(String userId) throws SQLException {
            return bookmarkDAO.findUserBookmarkList(userId);
    }
    
    public BookmarkDAO getBookmarkDAO() {
        return this.bookmarkDAO;
    }
}