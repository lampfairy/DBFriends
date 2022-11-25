package model.service;

public class ResvNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

    public ResvNotFoundException() {
        super();
    }
  
    public ResvNotFoundException(String arg) {
        super(arg);
    }
}
