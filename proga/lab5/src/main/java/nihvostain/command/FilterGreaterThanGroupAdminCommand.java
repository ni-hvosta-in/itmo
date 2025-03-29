package nihvostain.command;

import nihvostain.managers.CollectionManager;
import nihvostain.model.Person;
import nihvostain.model.StudyGroup;
import nihvostain.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.utility.InvalidParamMessage;

import java.util.ArrayList;

/**
 * Команда вывода элементов коллекции, значение старосты которых больше заданного
 */
public class FilterGreaterThanGroupAdminCommand implements Command {

    private final CollectionManager collectionManager;

    public FilterGreaterThanGroupAdminCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void execute(ArrayList<String> args) {

        Person person;
        if (args.get(0) == null){
           person = null;
        } else {
            person = new Person(args);
            Person.removePassportID(person.getPassportID());
        }

        if (person != null) {
            for (StudyGroup st : collectionManager.getStudyGroupList().values()) {
                if (st.getGroupAdmin() != null) {
                    if (st.getGroupAdmin().compareTo(person) > 0) {
                        System.out.println(st);
                    }
                }
            }
        } else {
            for (StudyGroup st : collectionManager.getStudyGroupList().values()) {
                System.out.println(st);
            }
        }
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
