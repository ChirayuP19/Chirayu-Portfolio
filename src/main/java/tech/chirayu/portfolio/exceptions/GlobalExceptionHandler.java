package tech.chirayu.portfolio.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handlegenralException(Exception e,RedirectAttributes redirectAttributes,
			HttpServletRequest httpServletRequest) {
		String header = httpServletRequest.getHeader("referer");
		System.out.println(header);
		redirectAttributes.addFlashAttribute("error","Somthing went Wrong");
		return "redirect:"+header;	
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxUploadSizeException(Exception e,RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		String header = httpServletRequest.getHeader("referer");
		System.out.println(header);
		redirectAttributes.addFlashAttribute("result","File Size Must not exceed 5MB");
		return "redirect:"+header;
	}
	}