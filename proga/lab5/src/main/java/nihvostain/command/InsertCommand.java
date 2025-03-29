package nihvostain.command;

import nihvostain.exceptions.ExistingKeyException;
import nihvostain.managers.CollectionManager;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;

/**
 * Команда добавления элемента в коллекцию с ключом
 */
public class InsertCommand implements Command {

    private final CollectionManager collectionManager;

    public InsertCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {

        String key = args.get(0);
        args.remove(0);
        try {
            collectionManager.insert(key, new StudyGroup(args));
        } catch (ExistingKeyException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "insert null {element} : добавить новый элемент с заданным ключом";
    }

    /**
     * @return класс, который будет вводиться
     */
    @Override
    public TypeOfElement getElementType() {
        return TypeOfElement.STUDYGROUP;
    }

    /**
     * @return размер массива аргументов
     */
    @Override
    public Integer getNeededArgsLen() {
        return 12;
    }

    @Override
    public Integer getNeededParamLen() {
        return 1;
    }

    @Override
    public InvalidParamMessage isValidParam(ArrayList<String> params) {
        String key = params.get(0);
        if (!collectionManager.getStudyGroupList().containsKey(key)){
            return InvalidParamMessage.TRUE;
        } else {
            return InvalidParamMessage.ExistingKey;
        }

    }

    @Override
    public boolean skipValidateField() {
        return false;
    }

}
