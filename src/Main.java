import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        String filename = "contacts.txt";
        try {
            // Check for contacts.txt and create if it does not exist
            Path dataFile = Paths.get(filename);
            if (!Files.exists(dataFile)) {
                System.out.println("Your new file has been created ");
                Files.createFile(dataFile);
            }

//            Contacts list
//            Writes default contacts to contacts.txt
//            List<String> contactList = new ArrayList<>();
//            contactList.add("Jack | 555-555-5555");
//            contactList.add("Jill | 666-666-6666");
//            contactList.add("Mary | 777-777-7777");
//            contactList.add("Bill | 888-888-8888");
//            contactList.add("Ben | 999-999-9999");
//            if (Files.exists(dataFile)) {
//                Files.write(dataFile, contactList);
//                System.out.println(contactList);
//            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
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
            if (userChoice.equals("5")) {
                System.out.println("Thank you, have a nice day!");
                break;
            }
            switch (userChoice) {
                case "1":
                    retrieveContacts();
                    break;
                case "2":
                    addContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    deleteContact();
                    break;
            }
        }
    }

    public static void retrieveContacts() {
        System.out.println("Name | Phone number");
        System.out.println("-----------------");
        try {
            List<String> contactList = Files.readAllLines(Paths.get("contacts.txt"));
            for (String contact : contactList) {
                System.out.println(contact);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public static void addContact() {
        Scanner scanner = new Scanner(System.in);
        try {
            List<String> contactList = Files.readAllLines((Paths.get("contacts.txt")));
            System.out.println("Please enter the contact's name: ");
            String nameInput = scanner.nextLine();
            System.out.println("Please enter the contact's phone number: ");
            String phoneInput = scanner.nextLine();
            contactList.add(nameInput + " | " + phoneInput);
            Files.write(Paths.get("contacts.txt"), contactList);
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public static void searchContact() {
        try {
            List<String> contactList = Files.readAllLines((Paths.get("contacts.txt")));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the contact.");
            String name = scanner.nextLine();
            for (String contact : contactList) {
                String contactCheck = contact.toLowerCase();
                if (contactCheck.contains(name.toLowerCase())) {
                    System.out.println(contact);
                }
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public static void deleteContact() {
        try {
            List<String> contactList = Files.readAllLines((Paths.get("contacts.txt")));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the contact you wish to remove.");
            String name = scanner.nextLine();
            String lineToRemove = null;
            for (String contact : contactList) {
                String contactCheck = contact.toLowerCase();
                if (contactCheck.contains(name.toLowerCase())) {
                    lineToRemove = contact;
                    System.out.println(contact + " removed.");
                }
            }
            if (lineToRemove != null) {
                contactList.remove(lineToRemove);
            } else {
                System.out.println("Contact not found.");
            }
            Files.write(Paths.get("contacts.txt"), contactList);
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }
}