package it.domenico.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id; 
	
	@NotBlank(message = "Il nome non può mancare")
	private String nome; 

	@NotBlank(message = "Il cognome non può mancare")
	private String cognome;

	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,5}$", message = "Email mancante o formato errato")
	private String email;

	@NotBlank(message = "L'indirizzo non può mancare")
	private String indirizzo;
	
}
