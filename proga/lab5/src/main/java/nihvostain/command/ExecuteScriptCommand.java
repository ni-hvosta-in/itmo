package nihvostain.command;

import nihvostain.exceptions.InputFromScriptException;
import nihvostain.exceptions.RecursionDepthExceededException;
import nihvostain.managers.CollectionManager;
import nihvostain.managers.Invoker;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Команда исполнения скрипта
 */
public class ExecuteScriptCommand implements Command {

    private final CollectionManager collectionManager;
    public ExecuteScriptCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(args.get(0)));
            Invoker invoker = new Invoker(collectionManager, sc);
            invoker.setFileFlag(true);
            try {
                invoker.scanning();
                invoker.setDepth(1);
            } catch (InputFromScriptException | RecursionDepthExceededException | IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не удается найти указанный файл");;
        }

    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла." +
                " В скрипте содержатся команды в таком же виде," +
                " в котором их вводит пользователь в интерактивном режиме";
    }

    /**
     * @return класс, который будет вводиться
     */
    @Override
    public TypeOfElement getElementType() {
        return TypeOfElement.PRIMITIVE;
    }

    /**
     * @return размер массива аргументов
     */
    @Override
    public Integer getNeededArgsLen() {
        return 1;
    }

    @Override
    public Integer getNeededParamLen() {
        return 1;
    }

    @Override
    public InvalidParamMessage isValidParam(ArrayList<String> params) {
        return InvalidParamMessage.TRUE;
    }

    @Override
    public boolean skipValidateField() {
        return false;
    }
}
