package clinic;
/**
 * Класс, описывающий питомца
 * @author Ivan Kachkin
 * @since 12.07.2019
 */
public abstract class Pet {
    public String name;

    /**
     * Конструктор
     * @param name Имя питомца
     */
    public Pet(String name) {
        this.name = name;
    }

    /**
     * Геттер
     * @return Имя питомца
     */
    public String getName() {
        return this.name;
    }

    /**
     * Сеттер
     * @param name Имя питомца
     */
    public void setName(String name) {
        this.name = name;
    }
}
