package nihvostain.managers;

import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import nihvostain.command.*;
import nihvostain.exceptions.InputFromScriptException;
import nihvostain.exceptions.NoAdminException;
import nihvostain.exceptions.RecursionDepthExceededException;
import nihvostain.managers.inputManagers.InputCoordinates;
import nihvostain.managers.inputManagers.InputPerson;
import nihvostain.managers.inputManagers.InputStudyGroup;
import nihvostain.managers.validate.*;
import nihvostain.model.*;
import nihvostain.utility.*;

import java.io.IOException;
import java.util.*;

/**
 * Класс вызывателя команд
 */
public class Invoker {

    private final CollectionManager collectionManager;
    private Scanner sc;
    /**
     * Флаг файла
     */
    private boolean fileFlag = false;
    /**
     * Текущая глубина рекурсии
     */
    private static int depth;
    /**
     * Максимальная глубина рекурсии
     */
    private static final int maxDepth = 10;
    /**
     * @param collectionManager менеджер коллекции
     * @param sc сканер
     */
    public Invoker(CollectionManager collectionManager, Scanner sc){

        this.collectionManager = collectionManager;
        this.sc = sc;
        depth+=1;

    }

    /**
     * исполнение команд и сканирование ввода
     * @throws InputFromScriptException ошибка в скрипте
     * @throws RecursionDepthExceededException ошибка глубины рекурсии
     */
    public void scanning() throws InputFromScriptException, RecursionDepthExceededException, IOException {

        if (depth > maxDepth){
            throw new RecursionDepthExceededException();
        }
        Map<String, Command> commands = new LinkedHashMap<>();

        commands.put("help", new HelpCommand(commands.values()));
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("insert", new InsertCommand(collectionManager));
        commands.put("update", new UpdateCommand(collectionManager));
        commands.put("remove_key", new RemoveKeyCommand(collectionManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand(collectionManager));
        commands.put("execute_script", new ExecuteScriptCommand(collectionManager));
        commands.put("exit", new ExitCommand());
        commands.put("remove_lower", new RemoveLowerCommand(collectionManager));
        commands.put("replace_if_greater", new ReplaceIfGreaterCommand(collectionManager));
        commands.put("remove_greater_key", new RemoveGreaterKeyCommand(collectionManager));
        commands.put("group_counting_by_semester_enum", new GroupCountingBySemesterEnum(collectionManager));
        commands.put("filter_contains_name", new FilterContainsNameCommand(collectionManager));
        commands.put("filter_greater_than_group_admin", new FilterGreaterThanGroupAdminCommand(collectionManager));

        while (sc.hasNext()){

            String line = sc.nextLine().trim();
            ArrayList <String> tokens = new ArrayList<>(List.of(line.split(" +")));

            Command command = commands.get(tokens.get(0));
            tokens.remove(0);
            ArrayList<String> args = new ArrayList<>(tokens);
            if (command != null) {
                if (command.getNeededParamLen() == tokens.size()){
                    if (command.isValidParam(tokens) == InvalidParamMessage.TRUE){

                        if (command.getElementType().equals(TypeOfElement.PERSON)) {
                            try {
                                args.addAll(new InputPerson(sc, fileFlag, command.skipValidateField()).input());
                            } catch (NoAdminException e){
                                args.add(null);
                            }
                        } else if (command.getElementType().equals(TypeOfElement.STUDYGROUP)) {
                            args.addAll(new InputStudyGroup(sc, fileFlag, command.skipValidateField()).input());
                        }
                        command.execute(args);
                    } else if (fileFlag) {
                        throw new InputFromScriptException();
                    } else {
                        System.out.println(command.isValidParam(tokens).getMessage());
                    }
                } else {
                    if (fileFlag){
                        throw new InputFromScriptException();
                    }
                    System.out.println("Неверные параметры для вызванной команды");
                }
            } else {
                if (fileFlag) {
                    throw new InputFromScriptException();
                }
                System.out.println("такой команды нет");
            }
            Console.write("~ ", (fileFlag & Invoker.depth != 1));

        }
        if (!fileFlag){
            Invoker invoker = new Invoker(collectionManager, new Scanner(System.in));
            invoker.setDepth(1);
            System.out.println("чтобы выйти из консоли введите exit");
            System.out.print("~ ");
            invoker.scanning();
        }

    }

    /**
     * Устанавливает флаг файла
     * @param fileFlag читаем ли из файла
     */
    public void setFileFlag(boolean fileFlag) {
        this.fileFlag = fileFlag;
    }

    /**
     * Установить текущую глубину рекурсии
     * @param depth рекурсия
     */
    public void setDepth(int depth){
        Invoker.depth = depth;
    }
}
