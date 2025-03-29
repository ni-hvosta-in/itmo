package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;

/**
 * Удаление элемента по ключу
 */
public class RemoveKeyCommand implements Command {

    final private CollectionManager collectionManager;

    public RemoveKeyCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {
        collectionManager.removeKey(args.get(0));
    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "remove_key null : удалить элемент из коллекции по его ключу";
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
        String key = params.get(0);
        if (collectionManager.getStudyGroupList().containsKey(key)){
            return InvalidParamMessage.TRUE;
        } else {
            return InvalidParamMessage.NoKey;
        }

    }

    @Override
    public boolean skipValidateField() {
        return false;
    }

}
