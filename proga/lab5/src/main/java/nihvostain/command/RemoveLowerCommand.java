package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Команда удаления элементов меньших заданному
 */
public class RemoveLowerCommand implements Command {

    final private CollectionManager collectionManager;

    public RemoveLowerCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {

        //Map<String,StudyGroup> studyGroupList = new LinkedHashMap<>();
        StudyGroup studyGroup = new StudyGroup(0L, args);
        if (!collectionManager.getStudyGroupList().isEmpty()) {

            Iterator<StudyGroup> iterator = collectionManager.getStudyGroupList().values().iterator();
            while (iterator.hasNext()){
                StudyGroup st = iterator.next();
                if (st.compareTo(studyGroup) < 0){
                    iterator.remove();
                }
            }
            /*
            for (Map.Entry<String, StudyGroup> pair : collectionManager.getStudyGroupList().entrySet()) {
                if (studyGroup.compareTo(pair.getValue()) < 0){
                    studyGroupList.put(pair.getKey(), pair.getValue());
                }
            }
            collectionManager.setStudyGroupList(studyGroupList);
             */
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
        return "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
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
        return 11;
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
        return true;
    }
}
