import java.util.*;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactBook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> list = new ArrayList<>();

        while(true) {

            System.out.println("\n1 Add");
            System.out.println("2 Show");
            System.out.println("3 Delete");
            System.out.println("4 Update");
            System.out.println("5 Exit");

            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch(ch) {

                // ADD CONTACT
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    boolean duplicate=false;
                    for(Contact c : list){
                        if(c.name.equalsIgnoreCase(name) || c.phone.equals(phone)){
                            duplicate=true;
                            break;
                        }
                    }

                    if(duplicate)
                        System.out.println("Duplicate contact!");
                    else{
                        list.add(new Contact(name, phone));
                        System.out.println("Added successfully");
                    }
                    break;

                // SHOW CONTACTS
                case 2:
                    if(list.isEmpty())
                        System.out.println("No contacts");
                    else
                        for(Contact c : list)
                            System.out.println(c.name+" - "+c.phone);
                    break;

                // DELETE CONTACT
                case 3:
                    System.out.print("Enter name to delete: ");
                    String del=sc.nextLine();

                    list.removeIf(c -> c.name.equalsIgnoreCase(del));
                    System.out.println("Deleted if existed");
                    break;

                // UPDATE CONTACT
                case 4:
                    System.out.print("Enter name to update: ");
                    String up=sc.nextLine();

                    boolean found=false;
                    for(Contact c : list){
                        if(c.name.equalsIgnoreCase(up)){
                            System.out.print("New phone: ");
                            c.phone=sc.nextLine();
                            found=true;
                            System.out.println("Updated");
                        }
                    }
                    if(!found) System.out.println("Contact not found");
                    break;

                case 5:
                    System.out.println("Bye");
                    return;
            }
        }
   
    }
}

