package nihvostain.commands;

import nihvostain.common.managers.Request;
import nihvostain.common.managers.RequestObj;
import nihvostain.common.model.StudyGroup;
import nihvostain.common.model.TypeOfElement;
import nihvostain.common.utility.InvalidParamMessage;
import nihvostain.managers.CollectionManager;
import nihvostain.managers.Communication;
import nihvostain.utility.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Команда группировки вывода по семестру
 */
public class GroupCountingBySemesterEnum implements Command {

    private final CollectionManager collectionManager;
    private final Communication communication;
    public GroupCountingBySemesterEnum(CollectionManager collectionManager, Communication communication) {
        this.collectionManager = collectionManager;
        this.communication = communication;
    }

    /**
     * @param request запрос с клиента
     */
    @Override
    public void execute(Request request) throws IOException {

        List<StudyGroup> studyGroups = new ArrayList<>(collectionManager.getStudyGroupList().values());
        Collections.sort(studyGroups);
        String ans = "";
        if (studyGroups.size() == 0) {
            System.out.println("Коллекция пуста");
            ans = "Коллекция пуста";
        }
        else {
            long k = 1;
            for (int i = 0; i < studyGroups.size() - 1; i++) {
                ans += studyGroups.get(i) + "\n";
                if (studyGroups.get(i).getSemesterEnum() != studyGroups.get(i + 1).getSemesterEnum()) {
                    ans += "\nКол-во групп " + studyGroups.get(i).getSemesterEnum().getSem() + " семестра равно " + k + "\n";
                } else {
                    k += 1;
                }
            }
            if (studyGroups.get(studyGroups.size() - 2).getSemesterEnum() != studyGroups.get(studyGroups.size() - 1).getSemesterEnum()) {
                ans += studyGroups.get(studyGroups.size() - 1);
                ans += "\nКол-во групп " + studyGroups.get(studyGroups.size() - 1).getSemesterEnum().getSem() + " семестра равно " + 1;
            } else {
                ans += studyGroups.get(studyGroups.size() - 1);
                ans += "\nКол-во групп " + studyGroups.get(studyGroups.size() - 1).getSemesterEnum().getSem() + " семестра равно " + (k + 1);
            }
        }
        System.out.println(ans);
        communication.send(new RequestObj(ans).serialize());
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
