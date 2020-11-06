package br.com.ithappens.model.exception;

public class ProductInvalidFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductInvalidFoundException(String msg) {
        super(msg);
    }
}