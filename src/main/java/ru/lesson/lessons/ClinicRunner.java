package ru.lesson.lessons;

import java.util.Scanner;
/**
 * Работа клиники
 * @author Ivan Kachkin
 * @since 12.07.2019
 */
public class ClinicRunner {

    public static void main(String[] args) {
        new ClinicRunner().go();
    }

    public void go() {
        final Clinic clinic = new Clinic();

        clinic.addClient(0, new Client("Brown", new Cat("Diggy")));

        clinic.addClient(1, new Client("Nick", new Dog("Sparky")));

        clinic.startMenu();

    }
}
