package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;
import java.util.Map;

/**
 * Команда вывода коллекции на экран
 */
public class ShowCommand implements Command {

    private final CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {

        if (!collectionManager.getStudyGroupList().isEmpty()) {
            for (Map.Entry<String, StudyGroup> pair : collectionManager.getStudyGroupList().entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }
        else {
            System.out.println("Коллекция пуста");
        }

    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
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
