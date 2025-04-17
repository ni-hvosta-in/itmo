package nihvostain.commands;

import common.model.TypeOfElement;
import common.managers.*;
import common.utility.*;
import common.model.*;
import nihvostain.managers.Communication;
import nihvostain.utility.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 * Команда вывода информации о командах
 */
public class InfoCommand implements Command {

    public final Communication communication;
    public InfoCommand(Communication communication){
        this.communication = communication;
    }

    /**
     * @param args массив аргументов
     */
    @Override
    public void request(ArrayList<String> args) throws IOException, ClassNotFoundException, TimeoutException {
        Request request = new Request(TypeRequest.REQUEST_COMMAND, TypeCommand.INFO);
        communication.send(request.serialize());
        byte[] message = communication.receive();
        System.out.println(new Deserialize<RequestObj>(message).deserialize().getRequest());
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
