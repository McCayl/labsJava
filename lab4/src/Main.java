import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Тестирование класса Person
        Person person = new Person("1990-05-15"); // Создаем объект Person с датой рождения
        System.out.println(person); // Вывод информации о персоне с помощью toString()
        System.out.println(person.getFormattedBirthDate("dd.MM.yyyy")); // Вывод даты рождения в формате dd.MM.yyyy
        System.out.println(person.getFormattedBirthDate("MMMM d, yyyy")); // Вывод даты рождения в формате MMMM d, yyyy
        System.out.println(person.getFormattedBirthDate(DateFormat.SHORT)); // Вывод даты рождения в коротком формате
        System.out.println(person.getFormattedBirthDate(DateFormat.MEDIUM)); // Вывод даты рождения в среднем формате
        System.out.println(person.getFormattedBirthDate(DateFormat.LONG)); // Вывод даты рождения в длинном формате


        // Тестирование создания Date и Calendar
        createDateAndCalendar();

        // Тестирование частотного анализа
        String str1 = "Hello, world!"; // Первая строка
        String str2 = "Java is cool"; // Вторая строка
        frequencyAnalysis(str1, str2);


        // Тестирование бинарного дерева
        BinaryTree<Integer> tree = new BinaryTree<>(); // Создаем бинарное дерево целых чисел
        tree.add(50); // Добавляем элементы в дерево
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);

        System.out.println("Прямой обход:"); // Выводим результаты обходов
        tree.traversePreOrder();
        System.out.println("\nОбратный обход:");
        tree.traversePostOrder();
        System.out.println("\nЦентрированный обход:");
        tree.traverseInOrder();

        System.out.println("\nДлина дерева: " + tree.getLength()); // Выводим длину дерева


    }

    // Метод для создания объектов Date и Calendar
    public static void createDateAndCalendar() {
        Scanner scanner = new Scanner(System.in); // Создаем сканер для ввода данных
        System.out.println("Введите дату и время в формате ГГГГ ММ ДД ЧЧ ММ:");
        try {
            int year = scanner.nextInt(); // Считываем год
            int month = scanner.nextInt() - 1; // Считываем месяц (уменьшаем на 1, т.к. в Calendar месяцы нумеруются с 0)
            int day = scanner.nextInt(); // Считываем день
            int hour = scanner.nextInt(); // Считываем час
            int minute = scanner.nextInt(); // Считываем минуты

            Date date = new Date(year - 1900, month, day, hour, minute); // Создаем объект Date (обратите внимание на корректировку года)
            System.out.println("Date: " + date); // Выводим созданный объект Date

            Calendar calendar = Calendar.getInstance(); // Создаем объект Calendar
            calendar.set(year, month, day, hour, minute, 0); // Устанавливаем дату и время в Calendar
            System.out.println("Calendar: " + calendar.getTime()); // Выводим созданный объект Calendar
        } catch (InputMismatchException e) { // Обрабатываем исключение, если введены некорректные данные
            System.out.println("Неверный формат ввода.");
        }
    }

    // Метод для частотного анализа строк
    public static void frequencyAnalysis(String str1, String str2) {
        // Конвертируем строки в наборы символов
        Set<Character> set1 = stringToSet(str1);
        Set<Character> set2 = stringToSet(str2);

        // Символы, входящие в обе строки
        Set<Character> intersection = new HashSet<>(set1); // Создаем копию set1
        intersection.retainAll(set2); // Оставляем в intersection только элементы, присутствующие в set2
        System.out.println("Символы, входящие в обе строки: " + intersection);
        System.out.println("Символы в обратном порядке : " + new StringBuilder(intersection.toString()).reverse().toString());


        // Символы, входящие в первую строку, но не входящие во вторую
        Set<Character> difference = new HashSet<>(set1); // Создаем копию set1
        difference.removeAll(set2); // Удаляем из difference все элементы, присутствующие в set2
        System.out.println("Символы, входящие в первую строку, но не входящие во вторую: " + difference);


        // Символы, содержащиеся хотя бы в одной строке
        Set<Character> union = new HashSet<>(set1); // Создаем копию set1
        union.addAll(set2); // Добавляем в union все элементы из set2 (дубликаты игнорируются)
        System.out.println("Символы, содержащиеся хотя бы в одной строке: " + union);


    }

    // Метод для преобразования строки в набор символов
    private static Set<Character> stringToSet(String str) {
        Set<Character> set = new HashSet<>(); // Создаем пустой набор символов
        for (char c : str.toCharArray()) { // Перебираем символы строки
            set.add(c); // Добавляем символ в набор
        }
        return set; // Возвращаем набор символов
    }


}


// Класс Person для хранения даты рождения
class Person {
    private Date birthDate; // Дата рождения

    // Конструктор
    public Person(String birthDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Формат даты
        try {
            this.birthDate = format.parse(birthDate); // Парсим строку в дату
        } catch (ParseException e) { // Обрабатываем исключение, если формат даты неверный
            System.err.println("Неверный формат даты рождения.");
            this.birthDate = new Date(); // Устанавливаем текущую дату в качестве даты рождения по умолчанию
        }
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "Дата рождения: " + birthDate;
    }


    // Метод для форматирования даты рождения
    public String getFormattedBirthDate(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern); // Создаем SimpleDateFormat с заданным шаблоном
        return format.format(birthDate); // Форматируем дату рождения и возвращаем строку
    }

    // Перегруженный метод для форматирования даты рождения с использованием DateFormat
    public String getFormattedBirthDate(int style) {
        DateFormat format = DateFormat.getDateInstance(style); // Получаем DateFormat для заданного стиля
        return format.format(birthDate); // Форматируем дату рождения и возвращаем строку
    }
}


// Класс для реализации бинарного дерева
class BinaryTree<T extends Comparable<T>> {
    private Node<T> root; // Корень дерева
    private int length; // Длина дерева

    // Метод для добавления нового узла в дерево
    public void add(T data) {
        root = addRecursive(root, data); // Вызываем рекурсивный метод добавления
        length++;
    }

    // Рекурсивный метод для добавления нового узла
    private Node<T> addRecursive(Node<T> current, T data) {
        if (current == null) { // Если текущий узел пустой, создаем новый узел
            return new Node<>(data);
        }

        // Сравниваем данные нового узла с данными текущего узла
        if (data.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, data); // Рекурсивно добавляем в левое поддерево
        } else if (data.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, data); // Рекурсивно добавляем в правое поддерево
        } else {
            // Значение уже существует
            return current;
        }

        return current;
    }

    // Прямой обход (корень-левый-правый)
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " "); // Посещаем текущий узел
            traversePreOrder(node.left); // Рекурсивно обходим левое поддерево
            traversePreOrder(node.right); // Рекурсивно обходим правое поддерево
        }
    }

    // Обратный обход (левый-правый-корень)
    public void traversePostOrder() {
        traversePostOrder(root);

    }

    private void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.left); // Рекурсивно обходим левое поддерево
            traversePostOrder(node.right); // Рекурсивно обходим правое поддерево
            System.out.print(node.data + " "); // Посещаем текущий узел
        }
    }

    // Центрированный обход (левый-корень-правый)
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.left);  // Рекурсивно обходим левое поддерево
            System.out.print(node.data + " "); // Посещаем текущий узел
            traverseInOrder(node.right); // Рекурсивно обходим правое поддерево
        }
    }

    public int getLength() {
        return length;
    }

    // Внутренний класс для представления узла дерева
    private class Node<T> {
        private T data; // Данные, хранящиеся в узле
        private Node<T> left; // Левый потомок
        private Node<T> right; // Правый потомок


        // Конструктор узла
        public Node(T data) {
            this.data = data;
        }

    }
}