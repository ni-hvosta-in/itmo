package nihvostain;

import nihvostain.exceptions.InputFromScriptException;
import nihvostain.exceptions.RecursionDepthExceededException;
import nihvostain.managers.CollectionManager;
import nihvostain.managers.Invoker;
import nihvostain.model.Coordinates;
import nihvostain.model.Person;
import nihvostain.model.StudyGroup;
import nihvostain.utility.FieldsCoordinate;
import nihvostain.utility.FieldsPerson;
import nihvostain.utility.FieldsStudyGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {


        System.out.println("Добро пожаловать в консоль для управления коллекцией StudyGroup");
        System.out.println("Название файла для чтения и записи в него должно передаваться при помощи переменной окружения MY_VAR");

        Coordinates.setFields(new FieldsCoordinate[]{FieldsCoordinate.X, FieldsCoordinate.Y});

        Person.setFields(new FieldsPerson[]{FieldsPerson.NAME, FieldsPerson.BIRTHDAY,
                FieldsPerson.PassportID, FieldsPerson.EyeCOLOR, FieldsPerson.HairCOLOR});

        StudyGroup.setFields(new FieldsStudyGroup[]{FieldsStudyGroup.NAME,
                FieldsStudyGroup.COORDINATES, FieldsStudyGroup.StudentsCount,
                FieldsStudyGroup.FormOFEducation, FieldsStudyGroup.SEMESTER, FieldsStudyGroup.GroupADMIN});


        CollectionManager collectionManager = new CollectionManager();
        collectionManager.load(System.getenv("MY_VAR"));

        Scanner sc = new Scanner(System.in);
        Invoker invoker = new Invoker(collectionManager, sc);
        try {
            System.out.print("~ ");
            invoker.scanning();
        } catch (InputFromScriptException | RecursionDepthExceededException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}