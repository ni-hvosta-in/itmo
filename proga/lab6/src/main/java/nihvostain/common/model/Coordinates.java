package nihvostain.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import nihvostain.common.utility.FieldsCoordinate;
import nihvostain.common.utility.ValidateClass;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Класс координат
 */
public class Coordinates implements ValidateClass, Serializable {

    /**
     * Массив вводимых полей
     */
    private static FieldsCoordinate[] fields;

    @JacksonXmlProperty(localName = "x")
    private Integer x; //Поле не может быть null

    @JacksonXmlProperty(localName = "Y")
    private BigDecimal y;

    /**
     * Конструктор по умолчанию для сериализации
     */
    public Coordinates(){}

    /**
     * @param x координата x
     * @param y координата y
     */
    public Coordinates(Integer x, BigDecimal y){
        this.x = x;
        this.y = y;
    }

    public static FieldsCoordinate[] getFields() {
        return fields;
    }

    public static void setFields(FieldsCoordinate[] fieldCoordinate) {
        Coordinates.fields = fieldCoordinate;
    }

    /**
     * Возвращает строковое представление класса
     * @return текстовое представление класса координат
     */
    @Override
    public String toString() {
        return "Координаты:" + "\n" + "x: " + x + "\n" + "y: " + y + "\n";
    }

    /**
     * @return валиден ли X
     */
    boolean isXValidate(){
        return this.x != null;
    }

    /**
     * @return валиден ли класс
     */
    @JsonIgnore
    @Override
    public boolean isValidateClass() {
        return isXValidate();
    }
}
