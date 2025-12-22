package tech.chirayu.portfolio.controller;

import java.sql.ResultSet;
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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tech.chirayu.portfolio.dto.ContactDto;
import tech.chirayu.portfolio.dto.ServiceDto;
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
	public String deleteContact(@RequestParam int id, RedirectAttributes redirectAttributes) {
		contactService.deleteContactByID(id);
		redirectAttributes.addFlashAttribute("deletemsg","DELETE SUCCESSFUllY");
		return "redirect:/admin/readAllContacts";
	}
	
	@GetMapping("/addservice")
	public String addServiceView() {
		return "admin/addService";
		
	}
	
	@PostMapping("/addservice")
	public String addService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
	
		if(bindingResult.hasErrors()) {
			model.addAttribute("result","Invalid input");
			model.addAttribute("error", bindingResult.getFieldErrors());
			return "admin/addService";
		}
		
		MultipartFile serviceFile = serviceDto.getServiceFile();
		if(serviceFile==null || serviceFile.isEmpty()) {
			model.addAttribute("result","Must have to Upload file.");
			return "admin/addService";
		}
		
		MultipartFile file = serviceDto.getServiceFile();
		long size = file.getSize();
		if(size>(2*(1024*1024))) {
			model.addAttribute("Fileerror","File size must not Exceed 2MB");
			return "admin/addService";
		}
		
		return "admin/addService";
		
	}
	
	
}
