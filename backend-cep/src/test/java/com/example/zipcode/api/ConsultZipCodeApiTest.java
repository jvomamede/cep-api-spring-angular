package com.example.zipcode.api;

import com.example.zipcode.model.RequestCep;
import com.example.zipcode.model.ResponseAddress;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConsultZipCodeApiTest {

    private RequestCep requestCep;
    private ResponseEntity<ResponseAddress> response;

    @Given("a valid cep {string}")
    public void givenValidCep(String cep) {
        requestCep = new RequestCep(cep);
    }

    @When("the client requests the address by cep")
    public void whenRequestAddress() {
        response = new ConsultZipCodeApi().getAddress(requestCep);
    }

    @Then("the response status code should be {int}")
    public void thenResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCodeValue());
    }

    @And("the response should contain the address information")
    public void andResponseShouldContainAddressInformation() {
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getCep());
        assertNotNull(response.getBody().getLogradouro());
        assertNotNull(response.getBody().getBairro());
        assertNotNull(response.getBody().getLocalidade());
        assertNotNull(response.getBody().getUf());
    }

}
