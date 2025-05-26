package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.model.Person;
@Component
public class FindAdhar implements CommandLineRunner {
	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("Client app triggered");
			String url="http://localhost:8081/BootRest-PersonDetails/person-api/find/{id}";
			
			
			ResponseEntity<String> prodmsg=template.exchange(url, HttpMethod.GET, null, String.class, 2000003);
			System.out.println(prodmsg);
			String res=prodmsg.getBody();
			ObjectMapper mapper=new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			Person per=mapper.readValue(res, Person.class);
			
			
			System.out.println("pno : "+per.getPno());
			System.out.println("name : "+per.getPname());
			System.out.println("add : "+per.getPadd());
			System.out.println("mobile : "+per.getPmobile());
			System.out.println("adhar : "+per.getPadhar());System.out.println("dob : "+per.getPdob());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
