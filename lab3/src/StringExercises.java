import java.util.StringTokenizer;

public class StringExercises {
    // 1. SQL запрос для вставки данных
    public static String generateInsertSQL(String group, int dolgCount) {
        // Формируем SQL запрoс с использованием параметров group и dolgCount
        // Одинарные кавычки вокруг строкового значения group обязательны
        return "INSERT INTO T_GroupSelected (id_Student, firstName, lastName, id_Group) " +
                "SELECT id_Student, firstName, lastName, id_Group " +
                "FROM T_Student " +
                "WHERE id_Group = '" + group + "' AND dolgCount > " + dolgCount;
    }

    // 2. Класс Person с методом для формирования ФИО
    public static class Person {
        private String firstName; // Имя
        private String lastName;  // Фамилия
        private String middleName; // Отчество

        public Person(String firstName, String lastName, String middleName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
        }

        // Метод для получения ФИО в формате "Фамилия И.О."
        public String getFullName() {
            StringBuilder sb = new StringBuilder(); // Используем StringBuilder для эффективного построения строки

            if (lastName != null && !lastName.isEmpty()) {
                sb.append(lastName).append(" "); // Добавляем фамилию и пробел
            }
            if (firstName != null && !firstName.isEmpty()) {
                sb.append(firstName.charAt(0)).append(". "); // Добавляем первую букву имени и точку
            }
            if (middleName != null && !middleName.isEmpty()) {
                sb.append(middleName.charAt(0)).append("."); // Добавляем первую букву отчества и точку
            }

            return sb.toString().trim(); // Удаляем лишние пробелы в начале и конце строки
        }
    }

    // 3. Класс Address для работы с адресами
    public static class Address {
        public String country; // Страна
        public String region; // Регион
        public String city; // Город
        public String street; // Улица
        public String house; // Дом
        public String building; // Корпус
        public String apartment; // Квартира

        // Метод для разбора строки адреса с разделителем по умолчанию (запятая)
        public void parseAddress(String addressStr) {
            parseAddress(addressStr, ","); // Вызываем метод с указанием разделителя
        }

        // Метод для разбора строки адреса с заданным разделителем
        public void parseAddress(String addressStr, String delimiter) {
            if (delimiter.equals(",")) {  // Если разделитель - запятая, используем split()
                String[] parts = addressStr.split(delimiter); // Разбиваем строку на части
                assignParts(parts); // Присваиваем значения полям класса
            } else { // Иначе используем StringTokenizer для произвольного разделителя
                StringTokenizer st = new StringTokenizer(addressStr, delimiter);
                String[] parts = new String[7]; // Создаем массив для частей адреса
                int i = 0;
                while (st.hasMoreTokens() && i<7) { // Перебираем токены, пока они есть
                    parts[i++] = st.nextToken().trim(); // Добавляем токен в массив, удаляя пробелы
                }
                assignParts(parts);  // Присваиваем значения полям класса
            }
        }


        // Вспомогательный метод для присваивания значений полям класса
        private void assignParts(String[] parts) {
            this.country = parts.length > 0 && parts[0] != null ? parts[0].trim() : null;
            this.region = parts.length > 1 && parts[1] != null ? parts[1].trim() : null;
            this.city = parts.length > 2 && parts[2] != null ? parts[2].trim() : null;
            this.street = parts.length > 3 && parts[3] != null ? parts[3].trim() : null;
            this.house = parts.length > 4 && parts[4] != null ? parts[4].trim() : null;
            this.building = parts.length > 5 && parts[5] != null ? parts[5].trim() : null;
            this.apartment = parts.length > 6 && parts[6] != null ? parts[6].trim() : null;
        }
    }

    // 4. Класс Shirt для представления рубашки
    public static class Shirt {
        String id; // Идентификатор
        String description; // Описание
        String color; // Цвет
        String size; // Размер


        public Shirt(String id, String description, String color, String size) {
            this.id = id;
            this.description = description;
            this.color = color;
            this.size = size;
        }


        @Override
        public String toString() {
            return "id: " + id + "\n" +
                    "description: " + description + "\n" +
                    "color: " + color + "\n" +
                    "size: " + size + "\n";

        }

        // Метод для преобразования массива строк в массив объектов Shirt
        public static Shirt[] parseShirts(String[] shirtsArray) {
            Shirt[] shirts = new Shirt[shirtsArray.length];
            for (int i = 0; i < shirtsArray.length; i++) {
                String[] parts = shirtsArray[i].split(","); // Разбиваем строку на части
                shirts[i] = new Shirt(parts[0], parts[1], parts[2], parts[3]); // Создаем объект Shirt
            }
            return shirts;
        }

    }

    // 5. Метод для форматирования номера телефона
    public static String formatPhoneNumber(String phoneNumber) {
        // Удаляем все нецифровые символы из входной строки
        String cleanedNumber = phoneNumber.replaceAll("[^0-9]", "");

        // Объявляем переменные для хранения кода страны и основного номера
        String countryCode;
        String mainNumber;

        // Используем switch для определения длины очищенного номера
        switch (cleanedNumber.length()) {
            case 10: // Если длина номера 10 цифр (номер без кода страны, предполагаем Россию)
                countryCode = "+7"; // Устанавливаем код страны +7
                mainNumber = cleanedNumber; // Основной номер равен очищенному номеру
                break; // Выходим из switch
            case 11: // Если длина номера 11 цифр (российский номер с 8 или 7, или номер с другим кодом страны)
                if (cleanedNumber.startsWith("8")) { // Если номер начинается с 8
                    countryCode = "+7"; // Устанавливаем код страны +7
                    mainNumber = cleanedNumber.substring(1); // Основной номер - это очищенный номер без первой цифры (8)
                } else if (cleanedNumber.startsWith("7")) { // Если номер начинается с 7
                    countryCode = "+7"; // Устанавливаем код страны +7
                    mainNumber = cleanedNumber.substring(1); // Основной номер - это очищенный номер без первой цифры (7) // Либо можно оставить как cleanedNumber. т.к 7 уже верная часть кода.
                } else { // Иначе (номер с другим кодом страны, но неизвестный формат)
                    return "Invalid phone number format"; // Возвращаем сообщение об ошибке
                }
                break; // Выходим из switch
            case 12: // Если длина номера 12 цифр (номер с кодом страны)
                countryCode = "+" + cleanedNumber.substring(0, 2); // Код страны - первые две цифры с плюсом
                mainNumber = cleanedNumber.substring(2); // Основной номер - это очищенный номер без первых двух цифр (код страны)
                break; // Выходим из switch
            default: // Если длина номера не соответствует ни одному из вышеперечисленных случаев
                return "Invalid phone number format"; // Возвращаем сообщение об ошибке
        }

        // Форматируем основной номер в зависимости от его длины
        if (mainNumber.length() == 10) { // Российский номер (10 цифр)
            return countryCode + mainNumber.substring(0, 3) + "-" + mainNumber.substring(3, 6) + "-" + mainNumber.substring(6); // Форматируем номер как +7XXX-XXX-XXXX
        } else if (mainNumber.length() == 7) { // Возможный городской номер (7 цифр)
            return countryCode + mainNumber.substring(0, 3) + "-" + mainNumber.substring(3); // Форматируем номер как +7XXX-XXXX

        } else { // Если длина основного номера не соответствует ни одному из известных форматов
            return "Invalid phone number format"; // Возвращаем сообщение об ошибке
        }
    }
}
