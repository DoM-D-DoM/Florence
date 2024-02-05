package it.domenico.responses;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import it.domenico.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@NoArgsConstructor

@EqualsAndHashCode
@ResponseBody
public class UserSearchResponse {
	
	private List<User> byName;
	private List<User> byLastName;

}
