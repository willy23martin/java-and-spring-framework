package openweb.wmc.security;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigA extends WebSecurityConfigurerAdapter{

	// Reference: https://www.baeldung.com/java-config-spring-security
	
	public SecurityConfigA() {
		
	}

}
