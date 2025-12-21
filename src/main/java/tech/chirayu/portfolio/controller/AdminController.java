package tech.chirayu.portfolio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tech.chirayu.portfolio.dto.ContactDto;
import tech.chirayu.portfolio.services.ContactService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/home")
	public String home() {
		return "admin/adminHome";
	}
	
	@GetMapping("/readAllContacts")
	public String readAllContacts(Model model) {
		model.addAttribute("contactData",contactService.readAllContacts());
		return "admin/readAllContacts";
	}
	
	@GetMapping("/deleteContactByID")
	public String deleteContact(@RequestParam int id) {
		contactService.deleteContactByID(id);
		return "redirect:/admin/readAllContacts";
	}
	
}
