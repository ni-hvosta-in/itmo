package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;
import java.util.Map;

/**
 * Команда обновления элемента по заданному id
 */
public class UpdateCommand implements Command {

    final private CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {
        try {
            Long id = Long.parseLong(args.get(0));
            args.remove(0);
            for (Map.Entry<String, StudyGroup> pair : collectionManager.getStudyGroupList().entrySet()){
                if (pair.getValue().getId().equals(id)) {
                    collectionManager.updateStudyGroup(pair.getKey(), new StudyGroup(id, args));
                    break;
                }
            }
        } catch (NumberFormatException e){
            System.out.println("id введен не верно");
        }

    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
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

    /**
     * @return кол-во параметров для функции
     */
    @Override
    public Integer getNeededParamLen() {
        return 1;
    }

    /**
     * @param params массив параметров для команды
     * @return валидность этих параметров
     */
    @Override
    public InvalidParamMessage isValidParam(ArrayList<String> params) {
        String id = params.get(0);
        try{
            long idLong = Long.parseLong(id);
            if (StudyGroup.getIdList().contains(idLong)){
                return InvalidParamMessage.TRUE;
            } else {
                return InvalidParamMessage.NoID;
            }
        } catch (NumberFormatException e){
            return InvalidParamMessage.NotLongID;
        }
    }

    @Override
    public boolean skipValidateField() {
        return false;
    }


}
