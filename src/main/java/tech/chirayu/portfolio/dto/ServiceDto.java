package tech.chirayu.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {

	@Size(min = 2,max = 30,message = "Invalid entry")
	@NotBlank(message = "Must have to Give  Title")
	private String title;
	
	@Size(min = 15, max = 200,message = "Invalid description")
	@NotBlank(message = "Description can't be empty.")
	private String description;
	
	private MultipartFile serviceFile;
}
