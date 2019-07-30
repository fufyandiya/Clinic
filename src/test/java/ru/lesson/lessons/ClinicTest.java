package ru.lesson.lessons;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClinicTest {

    @Test
    public void addClient() {
    }

    @Test
    public void findClientByClientNumber() {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.addClient(1, new Client("Nick", new Dog("Sparky")));
        assertEquals(clinic.clients.get(0), clinic.findClientByClientNumber(0));
    }

    @Test
    public void findClientByClientName() {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.addClient(1, new Client("Nick", new Dog("Sparky")));
        assertEquals(clinic.clients.get(0), clinic.findClientByClientName("Brown"));
    }

    @Test
    public void findClientByPetName() {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.addClient(1, new Client("Nick", new Dog("Sparky")));
        assertEquals(clinic.clients.get(1), clinic.findClientByPetName("Sparky"));
    }

    @Test
    public void editClientName() {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.editClientName(0, "Maks");
        assertEquals("Maks", clinic.clients.get(0).getClientName());
    }

    @Test
    public void editPetName() {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.editPetName(0, "Snow");
        assertEquals("Snow", clinic.clients.get(0).getClientPet().getName());
    }

    @Test
    public void deleteClient() throws IndexOutOfBoundsException {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.deleteClient(0);
        try {
            assertEquals(null, clinic.clients.get(0));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Такого элемента нет!");
        }
    }

    @Test
    public void deleteClientName() {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.deleteClientName(0);
        assertEquals("Нет имени", clinic.clients.get(0).getClientName());
    }

    @Test
    public void deleteClientPet() {
        final Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));
        clinic.deleteClientPet(0);
        assertEquals("Нет имени", clinic.clients.get(0).getClientPet().getName());
    }

    @Test
    public void startMenu() {

    }

    @Test
    public void checkResponse() throws NullPointerException {
        final Clinic clinic = new Clinic();
    }
}