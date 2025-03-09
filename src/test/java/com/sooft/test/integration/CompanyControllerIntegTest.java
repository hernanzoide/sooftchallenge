package com.sooft.test.integration;
import com.sooft.test.dto.CompanyDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyControllerIntegTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "/companies"; // This is the URL to test
    }

    @Test
    public void testAddCompany() {
        // Prepare an invalid CompanyDTO (e.g., missing company name)
        CompanyDTO companyDTO = CompanyDTO.builder()
                .cuit("20-12345678-9")
                .companyName("La Factoria")
                .subscriptionDate(LocalDate.now()).build();

        // Perform the POST request
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, companyDTO, String.class);

        // Verify that the response is 400 (Bad Request)
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
