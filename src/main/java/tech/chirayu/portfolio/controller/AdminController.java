package tech.chirayu.portfolio.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
import tech.chirayu.portfolio.entity.ServiceEntity;
import tech.chirayu.portfolio.repositories.ServiceRepository;
import tech.chirayu.portfolio.services.ContactService;
import tech.chirayu.portfolio.services.ServicesService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ServiceRepository serviceRepository;

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ServicesService servicesService;

    AdminController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

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
	public String addService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) throws IllegalStateException, IOException, Exception {
	
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
		
		MultipartFile multipart = serviceDto.getServiceFile();
		long size = multipart.getSize();
		if(size>(1*(1024*1024))) {
			model.addAttribute("Fileerror","File size must not Exceed 1MB");
			return "admin/addService";
		}
		
		
		String realPath=httpServletRequest.getServletContext().getRealPath("img/services/");
		
	
//		String originalFilename=UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "!")+multipart.getOriginalFilename();
//		Path path = Paths.get(realPath, originalFilename);
//		File file2 = path.toFile();
//		
//		multipart.transferTo(file2);
	
		servicesService.saveservice(realPath, multipart,serviceDto);
		redirectAttributes.addFlashAttribute("result","Service Added Successfully");
		return "redirect:/admin/addservice";
	}
	
	@GetMapping("/readAllServices")
	public String readAllServices(Model model) {
		model.addAttribute("listOfServices",servicesService.readServices());
		return "admin/readAllServices";
	}
	
	@GetMapping("/deleteServices")
	public String deleteService(@RequestParam int id, @RequestParam String filename, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		String realPath=httpServletRequest.getServletContext().getRealPath("img/services/");
		servicesService.deleteServicedata(realPath, id, filename);
		redirectAttributes.addFlashAttribute("deletemsg","Deleted Sucessfully");
		return "redirect:/admin/readAllServices";
	}
	
	@GetMapping("/updateService")
	public String updateserviceview(@RequestParam int id,Model model) {
		Optional<ServiceEntity> service = servicesService.readService(id);
		ServiceEntity serviceEntity = service.get();
		model.addAttribute("serviceData",serviceEntity);
		return "admin/updateService";
	}
	
	@PostMapping("/updateService")
	public String updateserviceget(@RequestParam int id,@RequestParam String oldfilename ,@ModelAttribute ServiceDto serviceDto,HttpServletRequest httpServletRequest,RedirectAttributes redirectAttributes) throws IllegalStateException, IOException, Exception {
		String realPath=httpServletRequest.getServletContext().getRealPath("img/services/");
		MultipartFile serviceFile = serviceDto.getServiceFile();
		servicesService.updateService(realPath, serviceFile, serviceDto, id, oldfilename);
		return "redirect:/admin/readAllServices";
	}

}
