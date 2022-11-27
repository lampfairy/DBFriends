package model.service;

public class ExistingBookmarkException extends Exception{
	private static final long serialVersionUID = 1L;

    public ExistingBookmarkException() {
        super();
    }
   
    public ExistingBookmarkException(String arg) {
        super(arg);
    }
}
