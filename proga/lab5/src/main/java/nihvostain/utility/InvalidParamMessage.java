package nihvostain.utility;

/**
 * Перечисление ошибок в параметре
 */
public enum InvalidParamMessage {
    TRUE("все гуд"),
    ExistingKey("такой ключ уже есть"),
    NoKey("нет такого ключа"),
    NoID("нет такого id"),
    NotLongID("id должен быть Long");


    private final String message;

    InvalidParamMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
