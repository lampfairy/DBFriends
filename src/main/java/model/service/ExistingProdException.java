package model.service;

public class ExistingProdException extends Exception{
	private static final long serialVersionUID = 1L;

    public ExistingProdException() {
        super();
    }
   
    public ExistingProdException(String arg) {
        super(arg);
    }
}
