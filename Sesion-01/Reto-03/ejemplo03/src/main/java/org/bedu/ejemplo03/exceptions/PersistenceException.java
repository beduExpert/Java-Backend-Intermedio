package org.bedu.ejemplo03.exceptions;

public class PersistenceException extends RuntimeException {
    public PersistenceException(String message){
        super(message);
    }
}
