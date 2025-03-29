package nihvostain.managers.inputManagers;

import nihvostain.exceptions.InputFromScriptException;
import nihvostain.managers.validate.*;
import nihvostain.model.Person;
import nihvostain.utility.FieldsPerson;
import nihvostain.utility.Validable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс для ввода людей
 */
public class InputPerson extends InputClass{

    private boolean skipFlag;
    public InputPerson(Scanner sc, boolean fileFlag, boolean skipFlag) {
        super(sc, fileFlag);
        this.skipFlag = skipFlag;
    }

    /**
     * @return введенный массив строк
     * @throws InputFromScriptException ошибка скрипта
     */
    @Override
    public ArrayList<String> input() throws InputFromScriptException {

        ArrayList<String> args = new ArrayList<>();

        HashMap<FieldsPerson, Validable> validableHashMap = new HashMap<>();
        validableHashMap.put(FieldsPerson.NAME, new InputValidateNameP(this.getSc()));
        validableHashMap.put(FieldsPerson.BIRTHDAY, new InputValidateBirthday(this.getSc()));
        validableHashMap.put(FieldsPerson.PassportID, new InputValidatePassportID(this.getSc(), skipFlag));
        validableHashMap.put(FieldsPerson.EyeCOLOR, new InputValidateEye(this.getSc()));
        validableHashMap.put(FieldsPerson.HairCOLOR, new InputValidateHair(this.getSc()));

        for (FieldsPerson fieldsPerson : Person.getFields()){
            args.add(validableHashMap.get(fieldsPerson).inputValidate(this.isFileFlag()));
        }

        return args;
    }

    public void setSkipFlag(boolean skipFlag) {
        this.skipFlag = skipFlag;
    }
}
