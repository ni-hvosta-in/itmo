package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Команда удаления элементов, ключ которых больше заданных
 */
public class RemoveGreaterKeyCommand implements Command {

    final private CollectionManager collectionManager;

    public RemoveGreaterKeyCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {

        String key = args.get(0);

        Iterator<String> iterator = collectionManager.getStudyGroupList().keySet().iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.compareTo(key) > 0){
                iterator.remove();
            }
        }

    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный";
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
