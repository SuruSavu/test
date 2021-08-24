package com.shareup.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path brandUploadDir = Paths.get("./user-post/");
		String brandUploadPath = brandUploadDir.toFile().getAbsolutePath();
		
		Path storiesUploadDir = Paths.get("./user-stories/");
		String storiesUploadPath = storiesUploadDir.toFile().getAbsolutePath();

		Path profileUploadDir = Paths.get("./data/user/");
		String profileUploadPath = profileUploadDir.toFile().getAbsolutePath();

		Path groupUploadDir = Paths.get("./data/group/");
		String groupUploadPath = groupUploadDir.toFile().getAbsolutePath();

		registry.addResourceHandler("/user-post/**","/user-stories/**", "/data/user/**", "/data/group/**")
				.addResourceLocations("file:/" + brandUploadPath + "/","file:/" + storiesUploadPath + "/", "file:/" + profileUploadPath + "/", "file:/" + groupUploadPath + "/");

	}

}
