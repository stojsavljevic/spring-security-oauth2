package alex.spring.security.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class MainController {
	
	private static final String AUTHORIZATION_CODE_CLIENT = "oauth2-client-ac";
	
	private static final String CLIENT_CREDENTIALS_CLIENT = "oauth2-client-cc";
	
	@Value("${custom.resource-server-url}")
	String resourceServerUrl;
	
	@Autowired
	WebClient webClient;
	
	/**
	 * This GET is for testing unprotected endpoint.
	 * 
	 */
	@GetMapping("/free")
	public String free() {
		
		return "free";
	}
	
	@GetMapping("/local-username")
	public String localUsernameGet(@AuthenticationPrincipal OAuth2User principal) {
		
		return getLocalUsername(principal);
	}
	
	/**
	 * This POST is for testing if CSRF is disabled.
	 * 
	 */
	@PostMapping("/local-username")
	public String localUsernamePost(@AuthenticationPrincipal OAuth2User principal) {
		
		return getLocalUsername(principal);
	}

	@GetMapping("/authorization-code-username")
	public String getAuthorizationCodeUsername(@AuthenticationPrincipal OAuth2User principal) {
		
		return getResourceServerUsername(AUTHORIZATION_CODE_CLIENT);
	}
	
	@GetMapping("/client-credentials-username")
	public String getClientCredentialsUsername(@AuthenticationPrincipal OAuth2User principal) {
		
		return getResourceServerUsername(CLIENT_CREDENTIALS_CLIENT);
	}
	
	private String getLocalUsername(OAuth2User principal) {
		// for Keycloak:
		Object username = principal.getAttribute("preferred_username");

		// for GitHub:
		// Object username = principal.getAttribute("login");
		
		return username.toString();
	}
	
	private String getResourceServerUsername(String clientId) {
		return this.webClient
				.get()
				.uri(resourceServerUrl)
				.attributes(ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId(clientId)) 
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}

}
