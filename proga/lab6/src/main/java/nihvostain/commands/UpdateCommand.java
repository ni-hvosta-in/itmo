package nihvostain.commands;

import nihvostain.common.managers.RequestObj;
import nihvostain.managers.CollectionManager;
import nihvostain.common.managers.Request;
import nihvostain.common.model.StudyGroup;
import nihvostain.common.model.TypeOfElement;
import nihvostain.managers.Communication;
import nihvostain.utility.Command;
import nihvostain.common.utility.InvalidParamMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Команда обновления элемента по заданному id
 */
public class UpdateCommand implements Command {

    private final CollectionManager collectionManager;
    private final Communication communication;

    public UpdateCommand(CollectionManager collectionManager, Communication communication) {
        this.collectionManager = collectionManager;
        this.communication = communication;
    }

    /**
     * @param request запрос с клиента
     */
    @Override
    public void execute(Request request) throws IOException {
        try {
            Long id = Long.parseLong(request.getParams().get(0));
            StudyGroup studyGroup = request.getStudyGroup();
            studyGroup.setID(id);
            for (Map.Entry<String, StudyGroup> pair : collectionManager.getStudyGroupList().entrySet()){
                if (pair.getValue().getId().equals(id)) {
                    collectionManager.updateStudyGroup(pair.getKey(), studyGroup);
                    RequestObj req = new RequestObj("обновил id " + id + " " + studyGroup);
                    communication.send(req.serialize());
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
