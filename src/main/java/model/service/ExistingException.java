package model.service;

public class ExistingException extends Exception{
	private static final long serialVersionUID = 1L;

    public ExistingException() {
        super();
    }
   
    public ExistingException(String arg) {
        super(arg);
    }
}
