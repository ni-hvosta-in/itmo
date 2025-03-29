package nihvostain.managers.inputManagers;

import nihvostain.exceptions.InputFromScriptException;
import nihvostain.managers.validate.InputValidateX;
import nihvostain.managers.validate.InputValidateY;
import nihvostain.model.Coordinates;
import nihvostain.utility.FieldsCoordinate;
import nihvostain.utility.Validable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс для ввода координат
 */
public class InputCoordinates extends InputClass{

    public InputCoordinates(Scanner sc, boolean fileFlag) {
        super(sc, fileFlag);
    }

    /**
     * @return введенный массив строк
     * @throws InputFromScriptException ошибка скрипта
     */
    @Override
    public ArrayList<String> input() throws InputFromScriptException {
        ArrayList<String> args = new ArrayList<>();

        HashMap<FieldsCoordinate, Validable> validableHashMap = new HashMap<>();
        validableHashMap.put(FieldsCoordinate.X, new InputValidateX(this.getSc()));
        validableHashMap.put(FieldsCoordinate.Y, new InputValidateY(this.getSc()));

        for (FieldsCoordinate fieldsCoordinate : Coordinates.getFields()){
            args.add(validableHashMap.get(fieldsCoordinate).inputValidate(this.isFileFlag()));
        }
        return args;
    }
}
