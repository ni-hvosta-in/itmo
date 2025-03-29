package nihvostain.utility;

import nihvostain.exceptions.InputFromScriptException;


/**
 * интерфейс валидности
 */
public interface Validable {
    /**
     * Проверяет валидность
     * @param s строка ввода
     * @return валидна ли
     */
    boolean isValidate(String s);

    /**
     * Валидный ввод
     * @param fileFlag флаг файла
     * @return результат валидного ввода
     * @throws InputFromScriptException ошибка в скрипте
     */
    String inputValidate(boolean fileFlag) throws InputFromScriptException;
}
