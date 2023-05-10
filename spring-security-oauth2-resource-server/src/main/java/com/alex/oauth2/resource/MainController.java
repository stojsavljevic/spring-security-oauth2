package com.alex.oauth2.resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/username")
	public String getUsername(JwtAuthenticationToken principal) {
		
		// this is where username is stored in case of Keycloak
//		String username = principal.getTokenAttributes().get("preferred_username").toString();
		
		// because of configured JwtAuthenticationConverter we can get proper username with:
//		String username = principal.getName();
		
		// or with SecurityContextHolder:
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return username;
	}
}
