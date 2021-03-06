package ie.cit.crowdfunding;

import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import ie.cit.crowdfunding.entity.Pledge;
import ie.cit.crowdfunding.entity.Project;
import ie.cit.crowdfunding.entity.User;
import ie.cit.crowdfunding.repository.PledgeRepository;
import ie.cit.crowdfunding.repository.ProjectRepository;
import ie.cit.crowdfunding.repository.UserRepository;

@SpringBootApplication
@Configuration 
public class CrowdfundingApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PledgeRepository pledgeRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(CrowdfundingApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("----------Projects----------");
		projectTest();
		System.out.println("----------Pledges----------");
		pledgeTest();
		System.out.println("----------Users----------");
		userTest();
//		System.out.println("----------test----------");
//		User u = userRepository.findOne(1);
//		for (Project p: u.getProjects()) {
//			System.out.println(p.getName());
//		}
//		System.out.println(u.getNumProjects());
//		for (Pledge p: u.getPledges()) {
//			System.out.println(p.getAmount());
//		}
//		System.out.println(u.getNumPledges());
		DatabaseMetaData s = dataSource.getConnection().getMetaData();
		System.out.println(s.toString());
	}
	
	public void userTest() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User u: users) {
			System.out.println(u.toString());
		}
	}
	
	public void pledgeTest() {
		List<Pledge> pledges = (List<Pledge>) pledgeRepository.findAll();
		for (Pledge p: pledges) {
			System.out.println(p.toString());
		}
	}
	
	public void projectTest() {
		List<Project> projects = (List<Project>) projectRepository.findAll();
		for (Project p: projects) {
			System.out.println(p.toString());
		}
	}
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry)
    {
    	registry.addInterceptor(localeChangeInterceptor());
    }
}
