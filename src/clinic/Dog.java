package clinic;
/**
 * Класс, описывающий собаку
 * @author Ivan Kachkin
 * @since 12.07.2019
 */
public class Dog extends Pet {
    String typeOfPet = "Dog";
    /**
     * Конструктор
     * @param name Имя собаки
     */
    public Dog (String name) {
        super(name);
    }
}
