package nihvostain.managers.inputManagers;

import nihvostain.exceptions.InputFromScriptException;
import nihvostain.exceptions.NoAdminException;
import nihvostain.managers.validate.InputValidateFormOfEducation;
import nihvostain.managers.validate.InputValidateNameSt;
import nihvostain.managers.validate.InputValidateSemesterEnum;
import nihvostain.managers.validate.InputValidateStudentCount;
import nihvostain.model.StudyGroup;
import nihvostain.utility.FieldsStudyGroup;
import nihvostain.utility.Validable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс для ввода учебной группы
 */
public class InputStudyGroup extends InputClass{

    private boolean skipFlag;
    public InputStudyGroup(Scanner sc, boolean fileFlag, boolean skipFlag) {
        super(sc, fileFlag);
        this.skipFlag = skipFlag;
    }

    /**
     * @return ввод
     * @throws InputFromScriptException ошибка в скрипте
     */
    @Override
    public ArrayList<String> input() throws InputFromScriptException {

        ArrayList<String> args = new ArrayList<>();
        HashMap<FieldsStudyGroup, Validable> validableHashMap = new HashMap<>();
        validableHashMap.put(FieldsStudyGroup.NAME, new InputValidateNameSt(this.getSc()));
        validableHashMap.put(FieldsStudyGroup.StudentsCount, new InputValidateStudentCount(this.getSc()));
        validableHashMap.put(FieldsStudyGroup.FormOFEducation, new InputValidateFormOfEducation(this.getSc()));
        validableHashMap.put(FieldsStudyGroup.SEMESTER, new InputValidateSemesterEnum(this.getSc()));

        for (FieldsStudyGroup fieldsStudyGroup : StudyGroup.getFields()){
            if (fieldsStudyGroup == FieldsStudyGroup.COORDINATES){
                ArrayList<String> coordinates = new InputCoordinates(this.getSc(), this.isFileFlag()).input();
                args.addAll(coordinates);
            } else if (fieldsStudyGroup == FieldsStudyGroup.GroupADMIN) {
                try {
                    ArrayList<String> groupAdmin = new InputPerson(this.getSc(), this.isFileFlag(), skipFlag).input();
                    args.addAll(groupAdmin);
                } catch (NoAdminException e){
                    args.add(null);
                }
            } else {
                args.add(validableHashMap.get(fieldsStudyGroup).inputValidate(this.isFileFlag()));
            }
        }

        return args;
    }
}
