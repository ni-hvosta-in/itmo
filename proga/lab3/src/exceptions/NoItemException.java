package exceptions;

public class NoItemException extends Exception{
    @Override
    public String getMessage() {
        return "НЕЧЕГО ПОХИЩАТЬ";
    }

}
