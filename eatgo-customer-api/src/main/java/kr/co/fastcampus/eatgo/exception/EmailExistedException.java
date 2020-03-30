package kr.co.fastcampus.eatgo.exception;

public class EmailExistedException extends RuntimeException{

    public EmailExistedException(String email) {
        super("Email is already registered : " + email);
    }
}
