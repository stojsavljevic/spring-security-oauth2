package alex.spring.security.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class MainController {
	
	@Value("${custom.resource-server-url}")
	String resourceServerUrl;
	
	@Autowired
	WebClient webClient;
	
	@GetMapping("/free")
	public String free() {
		return "free";
	}

	@GetMapping("/hello")
	public String hello(@AuthenticationPrincipal OAuth2User principal) {
		
		return getResponse(principal);
	}
	
	@PostMapping("/hello")
	public String helloPost(@AuthenticationPrincipal OAuth2User principal) {
		
		return getResponse(principal);
	}
	
	private String getResponse(OAuth2User principal) {
		String resourceServerResponse = getResourceServerResponse();

		// for Keycloak:
		Object username = principal.getAttribute("preferred_username");
		
		// for GitHub:
//		Object username = principal.getAttribute("login");
		
		return "Local username: " + username + " ::::: Resource server username: " + resourceServerResponse;
	}

	private String getResourceServerResponse() {
		return this.webClient
				.get()
				.uri(resourceServerUrl)
				
				// uses ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId
				// not needed because oauth2Client.setDefaultOAuth2AuthorizedClient(true);
//				.attributes(clientRegistrationId("oauth2-client")) 
				
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}

}
