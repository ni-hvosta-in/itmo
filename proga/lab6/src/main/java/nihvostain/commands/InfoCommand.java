package nihvostain.commands;

import nihvostain.managers.CollectionManager;
import nihvostain.managers.Communication;
import nihvostain.common.managers.Request;
import nihvostain.common.managers.RequestObj;
import nihvostain.common.model.TypeOfElement;
import nihvostain.utility.Command;
import nihvostain.common.utility.InvalidParamMessage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Команда вывода информации о командах
 */
public class InfoCommand implements Command {

    final private CollectionManager collectionManager;
    final private Communication communication;
    public InfoCommand(CollectionManager collectionManager, Communication communication) {
        this.collectionManager = collectionManager;
        this.communication = communication;
    }

    /**
     * @param request запрос с клиента
     */
    @Override
    public void execute(Request request) throws IOException {
        System.out.println(collectionManager.info());
        RequestObj requestObj = new RequestObj(collectionManager.info());
        communication.send(requestObj.serialize());
    }

    /**
     * @return описание команды
     */
    @Override
    public String description() {
            return "info : вывести в стандартный поток вывода информацию о коллекции";
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
