package org.nadarkanloev.vkbackendtest.Exception;

public class WeakPasswordException extends RuntimeException{
    public WeakPasswordException(String message){
        super(message);
    }
}
