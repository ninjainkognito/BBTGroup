package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactResource {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Autowired
    private ContactRepository contactRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    // ======================================
    // =             POST METHOD            =
    // ======================================

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    // ======================================
    // =          DELETE METHOD             =
    // ======================================
}
