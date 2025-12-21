package tech.chirayu.portfolio.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 100)
	private String subject;
	@Column(length = 1000)
	private String message;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime datatime;

}
