package clinic;
/**
 * Класс, описывающий кошку
 * @author Ivan Kachkin
 * @since 12.07.2019
 */
public class Cat extends Pet {
    String typeOfPet = "Cat";
    /**
     * Конструктор
     * @param name Имя кота
     */
    public Cat (String name) {
        super(name);
    }
}
