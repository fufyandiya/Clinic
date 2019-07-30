package ru.lesson.lessons;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс, описывающий клинику
 * @author Ivan Kachkin
 * @since 12.07.2019
 */
public class Clinic {
    /**
     * Список клиентов
     */
    ArrayList<Client> clients = new ArrayList<Client>();
    Scanner scanner = new Scanner(System.in);

    /**
     * Добавить клиента
     * @param position Позиция
     * @param client Клиент
     */
    public void addClient(final int position, final Client client) {
        clients.add(position, client);
    }

    /**
     * Поиск клиента по имени клиента
     * @param name Имя клиента
     * @return Обьект Client из Списка клиентов clients
     */
    public Client findClientByClientNumber(int ClientNumber) {
        return clients.get(ClientNumber);
    }

    /**
     * Поиск клиента по имени клиента
     * @param name Имя клиента
     * @return Обьект Client из Списка клиентов clients
     */
    public Client findClientByClientName(final String name) {
        Client foundClient = null;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientName().equals(name)) {
                foundClient = clients.get(i);
            }
        }
        return foundClient;
    }

    /**
     * Поиск клиента по имени питомца
     * @param name Имя питомца
     * @return Обьект Client из Списка клиентов clients
     */
    public Client findClientByPetName(final String name) {
        Client foundClient = null;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientPet().getName().equals(name)) {
                foundClient = clients.get(i);
            }
        }
        return foundClient;
    }

    /**
     * Редактирование имени клиента
     * @param ClientNumber Номер клиента в базе
     * @param name Новое имя
     */
    public void editClientName(int ClientNumber, String name) {
        clients.get(ClientNumber).setClientName(name);
    }

    /**
     * Редактирование имени питомца клиента
     * @param ClientNumber
     * @param name
     */
    public void editPetName(int ClientNumber, String name) {
        clients.get(ClientNumber).getClientPet().setName(name);
    }

    /**
     * Удаление клиента из базы
     * @param ClientNumber номер клиента в базе
     */
    public void deleteClient(int ClientNumber) {
        clients.remove(ClientNumber);
    }

    /**
     * Удаление имени клиента по номеру в базе
     * @param ClientNumber номер клиента в базе
     */
    public void deleteClientName(int ClientNumber) {
        clients.get(ClientNumber).setClientName("Нет имени");
    }

    /**
     * Удаление имени питомца клиента по номеру в базе
     * @param ClientNumber номер клиента в базе
     */
    public void deleteClientPet(int ClientNumber) {
        clients.get(ClientNumber).getClientPet().setName("Нет имени");
    }

    /**
     * Меню приложения с выбором действий
     */
    public void startMenu() {
        boolean exitFlag = false;
        while(!exitFlag) {
            System.out.println("1 - Добавить клиента");
            System.out.println("2 - Найти клиента по номеру клиента");
            System.out.println("3 - Найти клиента по имени клиента");
            System.out.println("4 - Найти клиента по кличке питомца");
            System.out.println("5 - Изменить имя клиента");
            System.out.println("6 - Изменить кличку питомца клиента");
            System.out.println("7 - Удалить клиента из базы");
            System.out.println("8 - Удалить имя клиента");
            System.out.println("9 - Удалить кличку питомца клиента");
            System.out.println("10 - Вывести всех клиентов");
            System.out.println("0 - Выход");
            exitFlag = checkResponse();
        }
    }

    /**
     * Метод для выбора действий через командную строку
     * @return Флаг окончания работы программы
     * @throws NullPointerException Исключение при выходе за пределы массива или работе с несуществующими клиентами
     */
    private boolean checkResponse() throws NullPointerException {
        boolean exit = false;
        try {
            String response = scanner.nextLine();
            int responseInt = Integer.parseInt(response);
            switch (responseInt) {
                case 0: {
                    exit = true;
                    break;
                }
                case 1: {
                    System.out.println("Введите имя клиента");
                    String clientName = scanner.nextLine();

                    System.out.println("Введите тип питомца");
                    System.out.println("1 - Кошка");
                    System.out.println("2 - Собака");
                    String typeOfPet = scanner.nextLine();

                    System.out.println("Введите кличку питомца");
                    String petName = scanner.nextLine();
                    if (Integer.valueOf(typeOfPet) == 1) {
                        clients.add(new Client(clientName, new Cat(petName)));
                    } else if (Integer.valueOf(typeOfPet) == 2) {
                        clients.add(new Client(clientName, new Dog(petName)));
                    } else {
                        System.out.println("Неправильный тип питомца!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Введите номер клиента:");
                    int numberToSearch = Integer.parseInt(scanner.nextLine());

                    System.out.println("Имя: " + findClientByClientNumber(numberToSearch).getClientName() +
                            "; Кличка питомца: " + findClientByClientNumber(numberToSearch).getClientPet().getName());
                    break;
                }
                case 3: {
                    System.out.println("Введите имя клиента:");
                    String nameToSearch = scanner.nextLine();

                    System.out.println("Имя: " + findClientByClientName(nameToSearch).getClientName() +
                            "; Кличка питомца: " + findClientByClientName(nameToSearch).getClientPet().getName());
                    break;
                }
                case 4: {
                    System.out.println("Введите кличку питомца:");
                    String nameToSearch = scanner.nextLine();

                    System.out.println("Имя: " + findClientByPetName(nameToSearch).getClientName() +
                            "; Кличка питомца: " + findClientByPetName(nameToSearch).getClientPet().getName());
                    break;
                }
                case 5: {
                    System.out.println("Введите номер клиента");
                    int clientNumber = Integer.parseInt(scanner.nextLine());

                    System.out.println("Введите новое имя клиента");
                    String newName = scanner.nextLine();

                    editClientName(clientNumber, newName);
                    System.out.println("Выполнено");
                    break;
                }
                case 6: {
                    System.out.println("Введите номер клиента");
                    int clientNumber = Integer.parseInt(scanner.nextLine());

                    System.out.println("Введите новую кличку питомца");
                    String newName = scanner.nextLine();

                    editPetName(clientNumber, newName);
                    System.out.println("Выполнено");
                    break;
                }
                case 7: {
                    System.out.println("Введите номер клиента");
                    int clientNumber = Integer.parseInt(scanner.nextLine());

                    deleteClient(clientNumber);
                    break;
                }
                case 8: {
                    System.out.println("Введите номер клиента");
                    int clientNumber = Integer.parseInt(scanner.nextLine());

                    deleteClientName(clientNumber);
                    break;
                }
                case 9: {
                    System.out.println("Введите номер клиента");
                    int clientNumber = Integer.parseInt(scanner.nextLine());

                    deleteClientPet(clientNumber);
                    break;
                }
                case 10: {
                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i) != null) {
                            System.out.println("Номер: " + i +
                                    "; Имя: " + clients.get(i).getClientName() +
                                    "; Кличка питомца: " + clients.get(i).getClientPet().getName());
                        }
                    }
                    break;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Неверная информация!");
        } finally {
            System.out.println("Нажмите для продолжения");
            scanner.nextLine();
            return exit;
        }
    }
}
