package com.example.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class MovieControllerTest {

	
	
	public MovieControllerTest() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int localServerPort;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {

    	ResponseEntity<String> response = this.restTemplate.getForEntity("/movies/", String.class, "Honda");
System.out.println(response.getBody().toString());
		assertThat(response.getBody()).contains("Dangal updated");
		
		Movie movie=new Movie();
		movie.setMovie_name("Agnipath");
		ResponseEntity<String> response1=this.restTemplate.postForEntity("/movies/", movie, String.class);
		System.out.println(response1.getBody());
		
    }
	}


