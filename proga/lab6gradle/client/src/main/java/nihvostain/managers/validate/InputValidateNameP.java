package nihvostain.managers.validate;

import common.managers.*;
import common.utility.*;
import common.model.*;
import common.exceptions.*;

import java.util.Scanner;

/**
 * Валидный ввод имени
 */
public class InputValidateNameP implements Validable {

    private final Scanner sc;

    public InputValidateNameP(Scanner sc){
        this.sc = sc;
    }

    /**
     * @param name строка ввода
     * @return валидность имени
     */
    @Override
    public boolean isValidate(String name) throws NoAdminException{
        if (name.isEmpty()){
            throw new NoAdminException();
        }
        return true;
    }

    /**
     * @param fileFlag флаг файла
     * @return результат валидного ввода имени
     * @throws InputFromScriptException ошибка в скрипте
     */
    @Override
    public String inputValidate(boolean fileFlag) throws InputFromScriptException, NoAdminException{
        String name;
        Console.write("Введите имя ", fileFlag);
        do{
            if (sc.hasNext()) {
                name = sc.nextLine().trim();
                if (!isValidate(name)) {
                    if (fileFlag) {
                        throw new InputFromScriptException();
                    }
                    System.out.println("имя не может быть пустым");
                    System.out.print("Введите имя ");
                } else {
                    break;
                }
            } else {
                return null;
            }

        } while (!fileFlag);
        return name;
    }
}
