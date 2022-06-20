import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

//    String directory = "chase-cory-org";
//    String filename = "contacts.txt";

//    public void tryContactsAdd() {
//        try {
//            Path contactsDirectory = Paths.get(directory);
//            Path dataFile = Paths.get(directory, filename);
//            if (Files.notExists(contactsDirectory)) {
//                Files.createDirectories(contactsDirectory);
//            }
//
//            if (!Files.exists(dataFile)) {
//                //does info.txt exist within the directory?
//                System.out.println("Your new file has been created ");
//                Files.createFile(dataFile);
//            }
//
//
//        } catch (IOException iox) {
//            iox.printStackTrace();
//        }



    public static void main(String[] args) {


        String filename = "contacts.txt";

        try {

            Path dataFile = Paths.get(filename);


            if (!Files.exists(dataFile)) {
                //does info.txt exist within the directory?
                System.out.println("Your new file has been created ");
                Files.createFile(dataFile);
            }

            List<String> contactList = new ArrayList<>();

            contactList.add("Jack | 555-555-5555");
            contactList.add("Jill | 666-666-6666");
            contactList.add("Mary | 777-777-7777");
            contactList.add("Bill | 888-888-8888");
            contactList.add("Ben | 999-999-9999");


            //write to the file with the list of greek gods
            if (Files.exists(dataFile)) {
                //Files.write(Path path, List<> data)
                Files.write(dataFile, contactList); //dataText needs to be something iterable like a list
                // appended the 2 names apollo and gaia to info.txt.    overwritten instead if no StandardOpenOption

                System.out.println(contactList); // dont have apollo or gaia here because different collection


            }

        } catch (IOException iox) {
            iox.printStackTrace();
        }

        try {

            List<String> fileData = Files.readAllLines(Paths.get( "contacts.txt")); //converts contents of info.txt back into a list of strings
            System.out.println(fileData);

            //new list to dump appropriate data
            List<String> newList = new ArrayList<>();
            //iterate thru file data. if string equals Hades, replace with Deimos.
            for (String god : fileData) {
                if (god.equals("Hades")) {
//                    newList.add("Deimos"); //comment this out to effectively skip adding deimos
                    continue;
                }
                newList.add(god);
            }

            //over write file with updated contents
            Files.write(Paths.get( "contacts.txt"), newList);
            //after update, reassign to updated version
            fileData = Files.readAllLines(Paths.get( "contacts.txt"));
            //print out each line in the info.txt file
            for (String line : fileData) {
                System.out.println(line);
            }

        } catch (IOException iox) {
            iox.printStackTrace();
        }

    }


//        ArrayList<Person> contactList = new ArrayList<>();
//
//        contactList.add(new Person("Jack", "555-555-5555"));
//        contactList.add(new Person("Jill", "666-666-6666"));
//        contactList.add(new Person("Mary", "777-777-7777"));
//        contactList.add(new Person("Bill", "888-888-8888"));
//        contactList.add(new Person("Ben", "999-999-9999"));

    Scanner scanner = new Scanner(System.in);

//        while (true) {
//            System.out.println("Please choose an action: ");
//            System.out.println("""
//
//                    1. View contacts.
//                    2. Add a new contact.
//                    3. Search a contact by name.
//                    4. Delete an existing contact.
//                    5. Exit.
//                    Enter an option (1, 2, 3, 4 or 5):
//                    """);
//            String userChoice = scanner.nextLine();
//
//            if (userChoice.equals("5")) {
//
//                System.out.println("Thank you, have a nice day!");
//                break;
//            }
//
//            switch (userChoice) {
//                case "1":
//                    System.out.println("Name | Phone number");
//                    System.out.println("-----------------");
////                    for (int i = 0; i < contactList.size(); i++) {
////                        System.out.println(contactList.get(i).getName() + " | " + contactList.get(i).getPhoneNumber());
////                    }
//                    break;
//                case "2":
//
//                    break;
//                case "3":
//                    break;
//                case "4":
//                    break;
//
//
//            }
//        }

}



