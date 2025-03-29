package nihvostain.managers.validate;

import nihvostain.exceptions.InputFromScriptException;
import nihvostain.managers.Console;
import nihvostain.model.Person;
import nihvostain.utility.Validable;

import java.util.Scanner;

/**
 * Валидный ввод паспорта
 */
public class InputValidatePassportID implements Validable {
    private final Scanner sc;
    private final boolean skipFlag;
    public InputValidatePassportID(Scanner sc, boolean skipFlag){
        this.sc = sc;
        this.skipFlag = skipFlag;
    }

    /**
     * @param passportID строка ввода
     * @return валидность паспорта
     */
    @Override
    public boolean isValidate(String passportID) {
        return !Person.getPassportIDList().contains(passportID);
    }

    /**
     * @param fileFlag флаг файла
     * @return результат валидного ввода паспорта
     * @throws InputFromScriptException ошибка в скрипте
     */
    @Override
    public String inputValidate(boolean fileFlag) throws InputFromScriptException {
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
            } else if (Person.getPassportIDList().contains(passportID) & !skipFlag){
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
