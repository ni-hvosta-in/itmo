package nihvostain.command;

import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;

/**
 * Команда выхода из программы
 */
public class ExitCommand implements Command {
    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {
        System.exit(0);
    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "exit : завершить программу (без сохранения в файл)";
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
        return 0;
    }

    @Override
    public Integer getNeededParamLen() {
        return 0;
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
