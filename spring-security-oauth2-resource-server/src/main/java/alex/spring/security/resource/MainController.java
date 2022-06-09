package alex.spring.security.resource;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/username")
	public String getUsername(JwtAuthenticationToken principal) {
		return principal.getTokenAttributes().get("preferred_username").toString();
	}
}
