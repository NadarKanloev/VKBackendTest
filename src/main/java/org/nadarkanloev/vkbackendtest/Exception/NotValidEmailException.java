package org.nadarkanloev.vkbackendtest.Exception;

public class NotValidEmailException extends RuntimeException{
    public NotValidEmailException(String message){
        super(message);
    }
}
