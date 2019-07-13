package clinic;

/**
 * Клиент
 * @author Ivan Kachkin
 * @since 12.07.2019
 */
public class Client {
    private String name;
    private Pet pet;

    /**
     * Конструктор
     * @param name Имя клиента
     * @param pet Питомец
     */
    public Client(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    /**
     * Геттер Имени клиента
     * @return Имя клиента
     */
    public String getClientName() {
        return this.name;
    }

    /**
     * Сеттер Имени клиента
     */
    public void setClientName(String name) {
        this.name = name;
    }

    /**
     * Геттер питомца
     * @return Обьект питомца
     */
    public Pet getClientPet() {
        return this.pet;
    }

    /**
     * Сеттер Имени питомца
     */
    public void setPetName(String name) {
        this.pet.setName(name);
    }
}
