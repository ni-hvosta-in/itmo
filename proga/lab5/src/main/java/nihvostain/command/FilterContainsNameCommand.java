package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Команда вывода элементов коллекции в имени, которых содержится заданная подстрока
 */
public class FilterContainsNameCommand implements Command {

    final private CollectionManager collectionManager;

    public FilterContainsNameCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {

        String substring = args.get(0);
        String regex = ".*" + substring + ".*";

        for (Map.Entry<String, StudyGroup> pair : collectionManager.getStudyGroupList().entrySet()) {
            if (Pattern.matches(regex, pair.getValue().getName())){
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }
    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "filter_contains_name name : вывести элементы," +
                " значение поля name которых содержит заданную подстроку";
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
