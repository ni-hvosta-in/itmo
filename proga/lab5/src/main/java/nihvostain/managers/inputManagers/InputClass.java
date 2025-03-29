package nihvostain.managers.inputManagers;

import nihvostain.exceptions.InputFromScriptException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Абстрактный класс для описания наследников для ввода друг их классов
 */
public abstract class InputClass {

    private final Scanner sc;
    /**
     * флаг файла
     */
    private final boolean fileFlag;
    public InputClass(Scanner sc, boolean fileFlag){
        this.sc = sc;
        this.fileFlag = fileFlag;
    }

    /**
     * @return введенный массив строк
     * @throws InputFromScriptException ошибка в скрипте
     */
    public abstract ArrayList<String> input() throws InputFromScriptException;

    public Scanner getSc() {
        return sc;
    }

    public boolean isFileFlag() {
        return fileFlag;
    }
}
