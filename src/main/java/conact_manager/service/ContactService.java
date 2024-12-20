package conact_manager.service;

import conact_manager.dto.Contact;
import conact_manager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void addContact(Contact contact) {
        // check
        Contact exists = contactRepository.getByPhone(contact.getPhone());
        if (exists != null) {
            System.out.println("Phone already exists.Mazgi.");
            return;
        }
        // save
        boolean result = contactRepository.saveContact(contact);
        if (result) {
            System.out.println("dto.Contact added.");
        } else {
            System.out.println("Something wend wrong. Mazgi.");
        }
    }

    public void contactList() {
        List<Contact> contactList = contactRepository.getList();
        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());
        }
    }

    public void deleteContact(String phone) {
        boolean result = contactRepository.delete(phone); // delete
        if (result) {
            System.out.println("dto.Contact successfully deleted.");
        } else {
            System.out.println("dto.Contact not exists. Mazgi.");
        }
    }

    public void search(String query) {
        List<Contact> contactList = contactRepository.search(query);
        for (Contact contact : contactList) {
            System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());
        }
    }

}
