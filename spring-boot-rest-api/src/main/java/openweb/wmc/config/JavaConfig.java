package openweb.wmc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JavaConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	// Cross-Origin Resource Sharing in global configuration as a Bean.
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// registry.addMapping("/**");
				registry.addMapping("/contacts/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST").maxAge(3600);
			}
		};
	}
	
}
