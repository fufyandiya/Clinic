package clinic;

import clinic.Client;

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
    private final Client[] clients;
    Scanner scanner = new Scanner(System.in);

    public Clinic(final int size) {

        this.clients = new Client[size];
    }

    /**
     * Добавить клиента
     * @param position Позиция
     * @param client Клиент
     */
    public void addClient(final int position, final Client client) {
        this.clients[position] = client;
    }

    /**
     * Поиск клиента по имени клиента
     * @param name Имя клиента
     * @return Обьект Client из Списка клиентов clients
     */
    public Client findClientByClientNumber(int ClientNumber) {
        Client foundClient = clients[ClientNumber];
        return foundClient;
    }

    /**
     * Поиск клиента по имени клиента
     * @param name Имя клиента
     * @return Обьект Client из Списка клиентов clients
     */
    public Client findClientByClientName(final String name) {
        Client foundClient = null;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getClientName().equals(name)) {
                foundClient = clients[i];
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
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getClientPet().getName().equals(name)) {
                foundClient = clients[i];
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
        clients[ClientNumber].setClientName(name);
    }

    /**
     * Редактирование имени питомца клиента
     * @param ClientNumber
     * @param name
     */
    public void editPetName(int ClientNumber, String name) {
        clients[ClientNumber].getClientPet().setName(name);
    }

    /**
     * Удаление клиента из базы
     * @param ClientNumber номер клиента в базе
     */
    public void deleteClient(int ClientNumber) {
        clients[ClientNumber] = null;
    }

    /**
     * Удаление имени клиента по номеру в базе
     * @param ClientNumber номер клиента в базе
     */
    public void deleteClientName(int ClientNumber) {
        clients[ClientNumber].setClientName("Empty");
    }

    /**
     * Удаление имени питомца клиента по номеру в базе
     * @param ClientNumber номер клиента в базе
     */
    public void deleteClientPet(int ClientNumber) {
        clients[ClientNumber].getClientPet().setName("Empty");
    }

    public void startMenu() {
        boolean exitFlag = false;
        while(!exitFlag) {
            System.out.println("1 - Add client");
            System.out.println("2 - Find client by client number");
            System.out.println("3 - Find client by client name");
            System.out.println("4 - Find client by client's pet name");
            System.out.println("5 - Edit client name");
            System.out.println("6 - Edit client's pet name");
            System.out.println("7 - Delete client");
            System.out.println("8 - Delete client's name");
            System.out.println("9 - Delete client's pet name");
            System.out.println("10 - Show all clients");
            System.out.println("0 - Exit");
            exitFlag = checkResponse();
        }
    }

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
                    System.out.println("Enter the number in base");
                    String numberInBase = scanner.nextLine();
                    System.out.println("Enter the Client name");
                    String clientName = scanner.nextLine();
                    System.out.println("Enter the type of pet");
                    System.out.println("1 - Cat");
                    System.out.println("2 - Dog");
                    String typeOfPet = scanner.nextLine();
                    System.out.println("Enter the Pet name");
                    String petName = scanner.nextLine();
                    if (Integer.valueOf(typeOfPet) == 1) {
                        clients[Integer.valueOf(numberInBase)] = new Client(clientName, new Cat(petName));
                    } else if (Integer.valueOf(typeOfPet) == 2) {
                        clients[Integer.valueOf(numberInBase)] = new Client(clientName, new Dog(petName));
                    } else {
                        System.out.println("Wrong typeOfPet!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the number of client:");
                    int numberToSearch = Integer.parseInt(scanner.nextLine());
                    System.out.println("Name: " + findClientByClientNumber(numberToSearch).getClientName() +
                            "; Pet's name: " + findClientByClientNumber(numberToSearch).getClientPet().getName());
                    break;
                }
                case 3: {
                    System.out.println("Enter the client name:");
                    String nameToSearch = scanner.nextLine();
                    System.out.println("Name: " + findClientByClientName(nameToSearch).getClientName() +
                            "; Pet's name: " + findClientByClientName(nameToSearch).getClientPet().getName());
                    break;
                }
                case 4: {
                    System.out.println("Enter the pet name:");
                    String nameToSearch = scanner.nextLine();
                    System.out.println("Name: " + findClientByPetName(nameToSearch).getClientName() +
                            "; Pet's name: " + findClientByPetName(nameToSearch).getClientPet().getName());
                    break;
                }
                case 5: {
                    System.out.println("Enter the client number");
                    int clientNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new client name");
                    String newName = scanner.nextLine();
                    editClientName(clientNumber, newName);
                    System.out.println("Done");
                    break;
                }
                case 6: {
                    System.out.println("Enter the client number");
                    int clientNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new client's pet name");
                    String newName = scanner.nextLine();
                    editPetName(clientNumber, newName);
                    System.out.println("Done");
                    break;
                }
                case 7: {
                    System.out.println("Enter the client number");
                    int clientNumber = Integer.parseInt(scanner.nextLine());
                    deleteClient(clientNumber);
                    break;
                }
                case 8: {
                    System.out.println("Enter the client number");
                    int clientNumber = Integer.parseInt(scanner.nextLine());
                    deleteClientName(clientNumber);
                    break;
                }
                case 9: {
                    System.out.println("Enter the client number");
                    int clientNumber = Integer.parseInt(scanner.nextLine());
                    deleteClientPet(clientNumber);
                    break;
                }
                case 10: {
                    for (int i = 0; i < clients.length; i++) {
                        if (clients[i] != null) {
                            System.out.println("Number: " + i +
                                    "; Name: " + clients[i].getClientName() +
                                    "; Pet's name: " + clients[i].getClientPet().getName());
                        }
                    }
                    break;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Wrong information!");
        } finally {
            System.out.println("Enter to continue");
            scanner.nextLine();
            return exit;
        }
    }
}
