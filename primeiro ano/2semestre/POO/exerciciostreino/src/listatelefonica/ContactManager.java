package listatelefonica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactManager implements ContactManagerInterface {
    private List<Contact> contactos;

    public ContactManager() {
        contactos = new ArrayList<>();
    }

    @Override
    public void addContact(Contact contacto) {
        contactos.add(contacto);
    }

    @Override
    public void removeContact(Contact contacto) {
        contactos.remove(contacto);
    }

    @Override
    public void updateContact(Contact contacto) {
        // Não é necessário fazer nada aqui, pois os contatos são atualizados automaticamente na lista.
    }

    @Override
    public Contact searchContact(String nome) {
        for (Contact contacto : contactos) {
            if (contacto.getNome().equals(nome)) {
                return contacto;
            }
        }
        return null; // Retorna null se o contato não for encontrado.
    }

    @Override
    public void listContacts() {
        for (Contact contacto : contactos) {
            System.out.println(contacto);
        }
    }

    @Override
    public void listContactsOrderedByName() {
        List<Contact> sortedContacts = new ArrayList<>(contactos);
        Collections.sort(sortedContacts, Comparator.comparing(Contact::getNome));
        for (Contact contacto : sortedContacts) {
            System.out.println(contacto);
        }
    }

    @Override
    public void listContactsOrderedByEmail() {
        List<Contact> sortedContacts = new ArrayList<>(contactos);
        Collections.sort(sortedContacts, Comparator.comparing(Contact::getEmail));
        for (Contact contacto : sortedContacts) {
            System.out.println(contacto);
        }
    }

    @Override
    public void listContactsOrderedByNumber() {
        List<Contact> sortedContacts = new ArrayList<>(contactos);
        Collections.sort(sortedContacts, Comparator.comparing(Contact::getNumero));
        for (Contact contacto : sortedContacts) {
            System.out.println(contacto);
        }
    }

    @Override
    public void listContactsOrderedByBirthDate() {
        List<Contact> sortedContacts = new ArrayList<>(contactos);
        Collections.sort(sortedContacts, Comparator.comparing(Contact::getDataNascimento));
        for (Contact contacto : sortedContacts) {
            System.out.println(contacto);
        }
    }
}
