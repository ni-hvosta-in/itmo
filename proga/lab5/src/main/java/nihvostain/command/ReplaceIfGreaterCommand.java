package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;

/**
 * Команда замена значения по ключу, если новое значение больше старого
 */
public class ReplaceIfGreaterCommand implements Command {

    final private CollectionManager collectionManager;

    public ReplaceIfGreaterCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {
        String key = args.get(0);
        args.remove(0);
        if (collectionManager.getStudyGroupList().containsKey(key)){
            StudyGroup studyGroup = new StudyGroup(args);
            if (studyGroup.compareTo(collectionManager.getStudyGroupList().get(key)) > 0){
                collectionManager.updateStudyGroup(key, studyGroup);
            }
        } else {
            System.out.println("Такого ключа не существует");
        }
    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого";
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
        if (collectionManager.getStudyGroupList().containsKey(key)){
            return InvalidParamMessage.TRUE;
        } else {
            return InvalidParamMessage.NoKey;
        }
    }

    @Override
    public boolean skipValidateField() {
        return true;
    }
}
