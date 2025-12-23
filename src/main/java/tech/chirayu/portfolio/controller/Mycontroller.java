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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tech.chirayu.portfolio.dto.ContactDto;
import tech.chirayu.portfolio.services.ContactService;
import tech.chirayu.portfolio.services.ServicesService;

@Controller
@RequestMapping("/client")
public class Mycontroller {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ServicesService servicesService;

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/services")
	public String services(Model model) {
		model.addAttribute("ListofServices",servicesService.readServices());
		return "services";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@PostMapping("/savecontact")
	public String savecontact(@Valid @ModelAttribute ContactDto contactDto, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("Invalid", "Invalid SOMETHING WRONG");
			model.addAttribute("errors", bindingResult.getFieldErrors());
			return "contact";
		}

		if (contactService.isContactEmailExist(contactDto.getEmail())) {
			redirectAttributes.addFlashAttribute("result","You have already send with same email");
			return "redirect:/client/contact";
		}
		
		

		contactService.saveContact(contactDto);
		redirectAttributes.addFlashAttribute("result", "Contact save Successfully");
		return "redirect:/client/contact";
	}

}
