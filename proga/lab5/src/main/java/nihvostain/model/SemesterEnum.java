package nihvostain.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Перечисление семестров
 */
public enum SemesterEnum {
    FIRST("1"),
    SECOND("2"),
    THIRD("3"),
    SIXTH("6"),
    SEVENTH("7");

    private final String sem;

    SemesterEnum(String sem){
        this.sem = sem;
    }

    /**
     * Возвращает название цвета
     * @return название цвета
     */
    public String getSem(){
        return this.sem;
    }

    /**
     * @return словарь номер семестра + элемент из enum'а
     */
    static public Map<String, SemesterEnum> getSemester(){
        Map <String, SemesterEnum> semesterMap = new HashMap<>();
        semesterMap.put(FIRST.sem, FIRST);
        semesterMap.put(SECOND.sem, SECOND);
        semesterMap.put(THIRD.sem, THIRD);
        semesterMap.put(SIXTH.sem, SIXTH);
        semesterMap.put(SEVENTH.sem, SEVENTH);

        return semesterMap;
    }
}