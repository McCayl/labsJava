import humanity.Address;
import humanity.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainTask3 {
    public static void main(String[] args) {
        // Создаем несколько объектов Адрес
        Address address1 = new Address("ул. Пушкина", "10", "кв. 5", "Москва");
        Address address2 = new Address("пр. Ленина", "32", "кв. 15", "Санкт-Петербург");
        Address address3 = new Address("ул. Садовая", "8", "кв. 10", "Москва");
        Address address4 = new Address("ул. Пушкина", "22", "кв. 30", "Москва");

        // Создаем несколько объектов Человек
        Person person1 = new Person("Иванов", "Иван", LocalDate.of(1985, 5, 10), address1);
        Person person2 = new Person("Петрова", "Мария", LocalDate.of(1992, 8, 25), address2);
        Person person3 = new Person("Сидоров", "Петр", LocalDate.of(1978, 12, 2), address3);
        Person person4 = new Person("Кузнецова", "Анна", LocalDate.of(2001, 4, 18), address4);

        // Создаем массив объектов Человек
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        // Поиск человека по фамилии
        findPersonByLastName(people, "Петрова");

        // Поиск человека по атрибуту адреса
        findPersonByAddressAttribute(people, "город", "Москва");

        // Вывод людей, родившихся между определенными датами
        printPeopleBornBetweenDates(people, LocalDate.of(1980, 1, 1), LocalDate.of(2000, 12, 31));

        // Находим самого старого и самого молодого человека
        findOldestAndYoungest(people);

        // Находим людей, проживающих на одной улице
        findPeopleLivingOnTheSameStreet(people);
    }

    // Метод для поиска человека по фамилии
    public static void findPersonByLastName(List<Person> people, String lastName) {
        for (Person person : people) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Найден человек по фамилии " + lastName + ": " + person);
                return;
            }
        }
        System.out.println("Человек с фамилией " + lastName + " не найден.");
    }

    // Метод для поиска человека по атрибуту адреса
    public static void findPersonByAddressAttribute(List<Person> people, String attributeName, String attributeValue) {
        for (Person person : people) {
            Address address = person.getAddress();
            switch (attributeName.toLowerCase()) {
                case "улица" -> {
                    if (address.getStreet().equalsIgnoreCase(attributeValue)) {
                        System.out.println("Найден человек по адресу: " + person);
                    }
                }
                case "дом" -> {
                    if (address.getHouseNumber().equalsIgnoreCase(attributeValue)) {
                        System.out.println("Найден человек по адресу: " + person);
                    }
                }
                case "квартира" -> {
                    if (address.getApartmentNumber().equalsIgnoreCase(attributeValue)) {
                        System.out.println("Найден человек по адресу: " + person);
                    }
                }
                case "город" -> {
                    if (address.getCity().equalsIgnoreCase(attributeValue)) {
                        System.out.println("Найден человек по адресу: " + person);
                    }
                }
                default -> System.out.println("Неверно указан атрибут адреса.");
            }
        }
        System.out.println("Человек с указанным атрибутом адреса не найден.");
    }

    // Метод для вывода людей, родившихся между определенными датами
    public static void printPeopleBornBetweenDates(List<Person> people, LocalDate startDate, LocalDate endDate) {
        System.out.println("Люди, родившиеся между " + startDate + " и " + endDate + ":");
        for (Person person : people) {
            LocalDate birthDate = person.getBirthDate();
            if (birthDate.isAfter(startDate.minusDays(1)) && birthDate.isBefore(endDate.plusDays(1))) {
                System.out.println(person);
            }
        }
    }

    // Метод для нахождения самого старого и самого молодого человека
    public static void findOldestAndYoungest(List<Person> people) {
        Person oldest = people.get(0);
        Person youngest = people.get(0);
        for (Person person : people) {
            if (person.getBirthDate().isBefore(oldest.getBirthDate())) {
                oldest = person;
            }
            if (person.getBirthDate().isAfter(youngest.getBirthDate())) {
                youngest = person;
            }
        }
        System.out.println("Самый старый человек: " + oldest);
        System.out.println("Самый молодой человек: " + youngest);
    }

    // Метод для нахождения людей, проживающих на одной улице
    public static void findPeopleLivingOnTheSameStreet(List<Person> people) {
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                if (people.get(i).getAddress().getStreet().equals(people.get(j).getAddress().getStreet())) {
                    System.out.println(people.get(i).getLastName() + " и " + people.get(j).getLastName() +
                            " проживают на одной улице (" + people.get(i).getAddress().getStreet() + ")");
                }
            }
        }
    }
}
