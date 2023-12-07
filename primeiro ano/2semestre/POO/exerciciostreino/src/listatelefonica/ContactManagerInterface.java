package listatelefonica;

public interface ContactManagerInterface {
    public void addContact(Contact contacto);
    public void removeContact(Contact contacto);
    public void updateContact(Contact contacto);
    public Contact searchContact(String nome);
    public void listContacts();
    public void listContactsOrderedByName();
    public void listContactsOrderedByEmail();
    public void listContactsOrderedByNumber();
    public void listContactsOrderedByBirthDate();


    
}
