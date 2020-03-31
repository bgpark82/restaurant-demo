package kr.co.fastcampus.eatgo.exception;

public class PasswordWrongException extends RuntimeException{

    public PasswordWrongException() {
        super("Password is wrong");
    }
}
