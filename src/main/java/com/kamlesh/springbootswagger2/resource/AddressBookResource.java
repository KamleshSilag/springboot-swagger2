package com.kamlesh.springbootswagger2.resource;

import com.kamlesh.springbootswagger2.models.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Find Contacts by id", notes = "Provide any id to look up for specific contact from Address Book",
                    response = Contact.class)
    public Contact getContact(@ApiParam(value = "ID value for the contact you need to retrive") @PathVariable String id){
        return contacts.get(id);
    }


    @ApiOperation(value = "Find All contacts", notes = "", response = List.class)
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
