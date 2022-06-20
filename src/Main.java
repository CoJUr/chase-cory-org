import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    String directory = "chase-cory-org";
    String filename = "contacts.txt";

    public void tryContactsAdd(){
        try {
            Path contactsDirectory = Paths.get(directory);

        }
    }


    public static void main(String[] args) {


        ArrayList<Person> personArrayList = new ArrayList<>();

        personArrayList.add(new Person("Jack", "555-555-5555"));
        personArrayList.add(new Person("Jill", "666-666-6666"));
        personArrayList.add(new Person("Mary", "777-777-7777"));
        personArrayList.add(new Person("Bill", "888-888-8888"));
        personArrayList.add(new Person("Ben", "999-999-9999"));

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Please choose an action: ");
            System.out.println("""

                    1. View contacts.
                    2. Add a new contact.
                    3. Search a contact by name.
                    4. Delete an existing contact.
                    5. Exit.
                    Enter an option (1, 2, 3, 4 or 5):
                    """);
                String userChoice = scanner.nextLine();

                if (userChoice.equals("5")){

                    System.out.println("Thank you, have a nice day!");
                    break;
                }

                switch (userChoice) {
                    case "1":
                        System.out.println("Name | Phone number");
                        System.out.println("-----------------");
                        for (int i = 0; i < personArrayList.size(); i++) {
                            System.out.println(personArrayList.get(i).getName()+ " | " + personArrayList.get(i).getPhoneNumber());
                        }
                        break;
                    case "2":

                        break;
                    case "3":
                        break;
                    case "4":
                        break;


                }
        }

    }


    public ArrayList<Person> printContacts() {

    }

}
