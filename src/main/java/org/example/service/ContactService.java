package org.example.service;

import org.example.entity.Contact;
import org.example.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void getContact(Model model, Long id) {
        Contact contact = contactRepository.getById(id);
        model.addAttribute("name", contact.getName());
        model.addAttribute("number", contact.getNumber());
    }

    public void getAllContacts(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
    }

    public void searchContactByName(Model model, String partialName) {
        model.addAttribute("contacts", contactRepository.findByNameContaining(partialName));
    }

    @Transactional
    public void deleteById(Model model, Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if(contactOptional.isPresent()) {
            contactRepository.deleteContactById(id);
            model.addAttribute("contacts", contactRepository.findAll());
        }
    }

    public void addContact(Model model, String name, String number) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setNumber(number);
        contactRepository.save(contact);
        model.addAttribute("contacts", contactRepository.findAll());
    }

    public void changeNameById(Model model, String name, String id) {
        Long changeId = Long.parseLong(id);
        contactRepository.updateNameById(changeId, name);
        model.addAttribute("contacts", contactRepository.findAll());
    }

    public void changeNumberById(Model model, String number, String id) {
        Long changeId = Long.parseLong(id);
        contactRepository.updateNumberById(changeId, number);
        model.addAttribute("contacts", contactRepository.findAll());
    }

}