package com.mine.alpha.security;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg){
        super(msg);
    }

    public UnauthorizedException(){}
}
