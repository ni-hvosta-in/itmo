package nihvostain.managers.inputManagers;

import common.managers.*;
import common.utility.*;
import common.model.*;
import common.exceptions.*;
import nihvostain.managers.Communication;
import nihvostain.managers.validate.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Класс для ввода людей
 */
public class InputPerson extends InputClass{

    private boolean skipFlag;
    private final Communication communication;
    public InputPerson(Scanner sc, boolean fileFlag, boolean skipFlag, Communication communication) {
        super(sc, fileFlag);
        this.skipFlag = skipFlag;
        this.communication = communication;
    }

    /**
     * @return введенный массив строк
     * @throws InputFromScriptException ошибка скрипта
     */
    @Override
    public ArrayList<String> input() throws InputFromScriptException, IOException, ClassNotFoundException, TimeoutException {

        ArrayList<String> args = new ArrayList<>();

        HashMap<FieldsPerson, Validable> validableHashMap = new HashMap<>();
        validableHashMap.put(FieldsPerson.NAME, new InputValidateNameP(this.getSc()));
        validableHashMap.put(FieldsPerson.BIRTHDAY, new InputValidateBirthday(this.getSc()));
        validableHashMap.put(FieldsPerson.PassportID, new InputValidatePassportID(this.getSc(), skipFlag, communication));
        validableHashMap.put(FieldsPerson.EyeCOLOR, new InputValidateEye(this.getSc()));
        validableHashMap.put(FieldsPerson.HairCOLOR, new InputValidateHair(this.getSc()));

        args.add(validableHashMap.get(FieldsPerson.NAME).inputValidate(this.isFileFlag()));
        validableHashMap.remove(FieldsPerson.NAME);
        if (args.get(0) != null) {
            for (FieldsPerson fieldsPerson : Person.getFields()) {
                if (fieldsPerson != FieldsPerson.NAME) {
                    args.add(validableHashMap.get(fieldsPerson).inputValidate(this.isFileFlag()));
                }
            }
        } else {
            return args;
        }

        return args;
    }

    public void setSkipFlag(boolean skipFlag) {
        this.skipFlag = skipFlag;
    }
}
