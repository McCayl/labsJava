public class Main {
    public static void main(String[] args) {
        String sql = StringExercises.generateInsertSQL("Group A", 3);
        System.out.println(sql);

        StringExercises.Person person1 = new StringExercises.Person("Ivan", "Ivanov", "Ivanovich");
        System.out.println(person1.getFullName()); // Output: Ivanov I.I.
        StringExercises.Person person2 = new StringExercises.Person("Petr", null, null);
        System.out.println(person2.getFullName()); // Output: Petr

        StringExercises.Address address = new StringExercises.Address();
        address.parseAddress("USA,California,Los Angeles,Hollywood Blvd,123,A,5");
        System.out.println(address.country + " " + address.building); // Output: USA  A

        address.parseAddress("Russia.Moscow;Red Square-1.2-3","-.;"); //Testing different delimiters
        System.out.println(address.country + " " + address.building); // Output: Russia 2


        String[] shirtsArray = {
                "S001,Black Polo Shirt,Black,XL",
                // ... other shirts
                "S011,Maroon Polo Shirt,Maroon,S"

        };
        StringExercises.Shirt[] shirts = StringExercises.Shirt.parseShirts(shirtsArray);
        for (StringExercises.Shirt shirt : shirts) {
            System.out.println(shirt);
        }

        String formattedNumber = StringExercises.formatPhoneNumber("+79175655655");
        System.out.println(formattedNumber); // +7917-565-5655

        formattedNumber = StringExercises.formatPhoneNumber("79175655655");
        System.out.println(formattedNumber);  // Output +8917-565-5655


        formattedNumber = StringExercises.formatPhoneNumber("+104289652211");
        System.out.println(formattedNumber);  // Output +1042-896-52211
    }
}