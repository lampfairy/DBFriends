package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Bookmark;
import model.dao.BookmarkDAO;


public class BookmarkManager {
    private static BookmarkManager BookmarkMan = new BookmarkManager();
    private BookmarkDAO BookmarkDAO;

    private BookmarkManager() {
        try {
            BookmarkDAO = new BookmarkDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static BookmarkManager getInstance() {
        return BookmarkMan;
    }
    
}