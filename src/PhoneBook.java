import java.util.ArrayList;
import java.util.Iterator;

public class PhoneBook {
    private ArrayList<Contact> contacts;

    public PhoneBook(){
        this.contacts = new ArrayList<>();
    }

    public boolean addContact (Contact inputContact){
        for(Contact contact : contacts){
            if (inputContact.equals(contact)){
                return false;
            }
        }
        contacts.add(inputContact);
        return true;
    }

    public boolean deleteContact(String firstName, String lastName){
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()){
            Contact contact = it.next();
            if (contact.getFirstName().equals(firstName) &&
                contact.getLastName().equals(lastName)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Contact findContact (String firstName, String lastName){
        for (Contact contact : contacts){
            if (contact.getFirstName().equals(firstName) &&
                    contact.getLastName().equals(lastName)){
                return contact;
            }
        }
        return null;
    }

    public ArrayList<Contact> findContacts (String group){
        ArrayList<Contact> groupContacts = new ArrayList<>();

        for(Contact contact : contacts){
            if (contact.getGroup().equals(group)){
                groupContacts.add(contact);
            }
        }

        if (groupContacts.isEmpty()){
            return null;
        }
        return groupContacts;
    }

    public void  printContacts(){
        if (contacts.isEmpty()){
            System.out.println("No contact in phone book!");
            return;
        }
        for (Contact contact : contacts){
            System.out.println(contact.getFirstName() + " " + contact.getLastName());
        }
    }
}
