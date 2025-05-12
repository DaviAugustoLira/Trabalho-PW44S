package edu.br.utpfr.trabalho_pw44s.server;

import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.repository.AddressRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PersonControllerTest {


    private static final String API_USERS = "/person";

    @BeforeEach
    public void cleanUp(){
        personRepository.deleteAll();
        restTemplate.getRestTemplate();
    }

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    PersonRepository personRepository;


//    @Test
//    public void post_addressValid_receiveStatusOk(){
//        ResponseEntity<Object> response = restTemplate.postForEntity(API_USERS, createPresonValid(), Object.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
//    }


    public static Address createAddressValid(){
        Address address = new Address();
        address.setNumber(1);
        address.setCep("85503200");
        address.setStreet("Rua 01");
        address.setCity("Pato Branco");
        return address;
    }

//    public static Person createPresonValid(){
//        Person person = new Person();
//        person.setName("João Silva");
//        person.setPhone("5546911330499");
//        person.setCpf("09177204905");
//        person.setRg("1482692514");
//
//        List<Address> addressList = new ArrayList<>();
//        addressList.add(createAddressValid());
//
//        person.setAddress(addressList);
//        return person;
//    }


}
