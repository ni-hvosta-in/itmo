package nihvostain.managers.validate;

import common.managers.*;
import common.utility.*;
import common.model.*;
import common.exceptions.*;
import nihvostain.managers.Communication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Валидный ввод паспорта
 */
public class InputValidatePassportID implements Validable {
    private final Scanner sc;
    private final boolean skipFlag;
    private final Communication communication;
    public InputValidatePassportID(Scanner sc, boolean skipFlag, Communication communication) {
        this.sc = sc;
        this.skipFlag = skipFlag;
        this.communication = communication;
    }

    /**
     * @param passportID строка ввода
     * @return валидность паспорта
     */
    @Override
    public boolean isValidate(String passportID) throws IOException, TimeoutException, ClassNotFoundException {
        ArrayList<String> passport = new ArrayList<>();
        passport.add(passportID);
        Request request = new Request(TypeRequest.REQUEST_PASSPORT, passport);
        communication.send(request.serialize());
        InvalidParamMessage message = new Deserialize<ResponseParam>(communication.receive()).deserialize().getParam();
        return message != InvalidParamMessage.FALSE;
    }

    /**
     * @param fileFlag флаг файла
     * @return результат валидного ввода паспорта
     * @throws InputFromScriptException ошибка в скрипте
     */
    @Override
    public String inputValidate(boolean fileFlag) throws InputFromScriptException, IOException, ClassNotFoundException, TimeoutException {
        String passportID;
        Console.write("Введите паспорт ", fileFlag);
        do{
            passportID = sc.nextLine().trim();
            if (passportID.length() < 5){
                if (fileFlag){
                    throw new InputFromScriptException();
                }
                System.out.println("Такого паспорта не существует");
                System.out.println("Введите паспорт ");
            } else if (!isValidate(passportID) & !skipFlag){
                if (fileFlag){
                    throw new InputFromScriptException();
                }
                System.out.println("Это не ваш паспорт");
                System.out.println("Введите паспорт ");
            } else{
                break;
            }
        } while (!fileFlag);
        return passportID;
    }
}
