package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Команда группировки вывода по семестру
 */
public class GroupCountingBySemesterEnum implements Command {

    private final CollectionManager collectionManager;

    public GroupCountingBySemesterEnum(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {

        List<StudyGroup> studyGroups = new ArrayList<>(collectionManager.getStudyGroupList().values());
        Collections.sort(studyGroups);
        long k = 1;
        for (int i = 0; i < studyGroups.size()-1; i++) {
            System.out.println(studyGroups.get(i));
            if (studyGroups.get(i).getSemesterEnum() != studyGroups.get(i+1).getSemesterEnum()){
                System.out.println("\nКол-во групп " + studyGroups.get(i).getSemesterEnum().getSem() + " семестра равно " + k + "\n");
            } else {
                k+=1;
            }
        }
        if (studyGroups.get(studyGroups.size()-2).getSemesterEnum() != studyGroups.get(studyGroups.size()-1).getSemesterEnum()){
            System.out.println(studyGroups.get(studyGroups.size()-1));
            System.out.println("\nКол-во групп " + studyGroups.get(studyGroups.size()-1).getSemesterEnum().getSem() + " семестра равно " + 1 + "\n");
        } else {
            System.out.println(studyGroups.get(studyGroups.size()-1));
            System.out.println("\nКол-во групп " + studyGroups.get(studyGroups.size()-1).getSemesterEnum().getSem() + " семестра равно " + (k + 1) + "\n");
        }

    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "group_counting_by_semester_enum : сгруппировать элементы коллекции по значению поля semesterEnum," +
                " вывести количество элементов в каждой группе";
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
