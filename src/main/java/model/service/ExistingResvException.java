package model.service;

public class ExistingResvException extends Exception{
	private static final long serialVersionUID = 1L;

    public ExistingResvException() {
        super();
    }
    
    public ExistingResvException(String arg) {
        super(arg);
    }
}

