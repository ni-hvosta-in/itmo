package nihvostain.commands;

import nihvostain.common.managers.Request;
import nihvostain.common.managers.RequestObj;
import nihvostain.common.model.Person;
import nihvostain.common.model.StudyGroup;
import nihvostain.common.model.TypeOfElement;
import nihvostain.common.utility.InvalidParamMessage;
import nihvostain.managers.CollectionManager;
import nihvostain.managers.Communication;
import nihvostain.utility.Command;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Команда вывода элементов коллекции, значение старосты которых больше заданного
 */
public class FilterGreaterThanGroupAdminCommand implements Command {

    private final CollectionManager collectionManager;
    private final Communication communication;

    public FilterGreaterThanGroupAdminCommand(CollectionManager collectionManager, Communication communication) {
        this.collectionManager = collectionManager;
        this.communication = communication;
    }

    /**
     * @param request запрос с клиента
     */
    @Override
    public void execute(Request request) throws IOException {

        Person person;
        if (request.getPerson() == null){
           person = null;
        } else {
            person = request.getPerson();
        }
        String ans = "";
        if (person != null) {
            for (StudyGroup st : collectionManager.getSortedStudyGroupList().values()) {
                if (st.getGroupAdmin() != null) {
                    if (st.getGroupAdmin().compareTo(person) > 0) {
                        System.out.println(st);
                        ans += st;
                    }
                }
            }
        } else {
            for (StudyGroup st : collectionManager.getStudyGroupList().values()) {
                System.out.println(st);
                ans += st;
            }
        }
        communication.send(new RequestObj(ans).serialize());
    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
        return "filter_greater_than_group_admin groupAdmin : вывести элементы, значение поля groupAdmin которых больше заданного";
    }

    /**
     * @return класс, который будет вводиться
     */
    @Override
    public TypeOfElement getElementType() {
        return TypeOfElement.PERSON;
    }

    /**
     * @return размер массива аргументов
     */
    @Override
    public Integer getNeededArgsLen() {
        return 5;
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
