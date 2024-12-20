package conact_manager.repository;


import conact_manager.dto.Contact;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ContactRepository {
    private List<Contact> contactList = new LinkedList<>();

    public boolean saveContact(Contact contact) {
        contactList.add(contact);
        return true;
    }

    public Contact getByPhone(String phone) {
        return contactList.stream().filter(contact -> contact.getPhone().equals(phone)).findFirst().orElse(null);
    }

    public List<Contact> getList() {
        return contactList;
    }

    public boolean delete(String phone) {
        return contactList.removeIf(contact -> contact.getPhone().equals(phone));
    }

    public List<Contact> search(String query) {
        String lowerQuery = query.toLowerCase();
        return contactList.stream().filter(contact ->
                contact.getPhone().toLowerCase().startsWith(lowerQuery)
                        || contact.getName().toLowerCase().startsWith(lowerQuery)
                        || contact.getSurname().toLowerCase().startsWith(lowerQuery)).collect(Collectors.toList());
    }
}
