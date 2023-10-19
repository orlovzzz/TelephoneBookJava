package org.example.controller;

import org.example.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private ContactService homeService;

    @GetMapping("/")
    public String getHome(Model model) {
        homeService.getAllContacts(model);
        return "allContacts";
    }

    @PostMapping("/searchByName")
    public String getById(@RequestParam("partialName") String partialName, Model model) {
        homeService.searchContactByName(model, partialName);
        return "searchContacts";
    }

    @PostMapping("/deleteById")
    public String deleteByID(@RequestParam("id") String id, Model model) {
        Long delete_id = Long.parseLong(id);
        homeService.deleteById(model, delete_id);
        return "allContacts";
    }

    @PostMapping("/addContact")
    public String addContact(@RequestParam("name") String name, @RequestParam("number") String number, Model model) {
        homeService.addContact(model, name, number);
        return "allContacts";
    }

    @PostMapping("/changeName")
    public String changeName(@RequestParam("id") String id, @RequestParam("name") String name, Model model) {
        homeService.changeNameById(model, name, id);
        return "allContacts";
    }

    @PostMapping("/changeNumber")
    public String changeNumber(@RequestParam("id_n") String id, @RequestParam("number") String number, Model model) {
        homeService.changeNumberById(model, number, id);
        return "allContacts";
    }

}
