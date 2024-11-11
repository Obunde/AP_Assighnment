package Lecture4_interfaces_abstract_classes;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException (){
        super ("Insufficient balance");
    }
    public InsufficientFundsException (String message){
        super(message);
    }
    public InsufficientFundsException (String message, Throwable cause){
        super(message,cause);
    }
    public InsufficientFundsException (Throwable cause){
        super(cause);
    }
}
