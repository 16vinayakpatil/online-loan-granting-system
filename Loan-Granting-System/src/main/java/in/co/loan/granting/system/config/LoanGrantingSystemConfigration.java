package in.co.loan.granting.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
public class LoanGrantingSystemConfigration  implements WebMvcConfigurer{

	
	@Bean(name = "viewResolver")
	public ViewResolver getViewResolver() {

		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
        
		return viewResolver;
	}

	@Bean(name = "tilesConfigure")
	public TilesConfigurer getTilesConfigure() {
		TilesConfigurer tilesConfigure = new TilesConfigurer();
		tilesConfigure.setDefinitions("/WEB-INF/tiles.xml");
		return tilesConfigure;
	}

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	/*
	 * @Bean public MultipartResolver multipartResolver() { return new
	 * CommonsMultipartResolver(); }
	 */
	
	/*
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(new LocaleChangeInterceptor());
	 * registry.addInterceptor(new
	 * ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns(
	 * "/ctl/**");
	 * 
	 * // multiple urls (same is possible for `exludePathPatterns`) }
	 */
	
}
