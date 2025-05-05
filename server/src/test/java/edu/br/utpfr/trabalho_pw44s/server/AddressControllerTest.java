package edu.br.utpfr.trabalho_pw44s.server;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AddressControllerTest {

    private static final String API_USERS = "/address";

    @BeforeEach
    public void cleanUp(){
        addressRepository.deleteAll();
        restTemplate.getRestTemplate();
    }

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    AddressRepository addressRepository;


    @Test
    public void post_addressValid_receiveStatusOk(){
        ResponseEntity<Object> response = restTemplate.postForEntity(API_USERS, createAddressValid(), Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
    }

    @Test
    public void post_addressInvalid_receiveError(){
        ResponseEntity<Object> response = restTemplate.postForEntity(API_USERS, new Address(), Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));
    }

    @Test
    public void post_streetInvalid_receiveError(){
        AddressRequestDto address = createAddressValid();
        address.setStreet("");
        ResponseEntity<Object> response = restTemplate.postForEntity(API_USERS, address, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));
    }

    @Test
    public void post_cepInvalid_receiveError(){
        AddressRequestDto address = createAddressValid();
        address.setCep("123");
        ResponseEntity<Object> response = restTemplate.postForEntity(API_USERS, address, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));
    }

    @Test
    public void post_cityInvalid_receiveError(){
        AddressRequestDto address = createAddressValid();
        address.setCity("");
        ResponseEntity<Object> response = restTemplate.postForEntity(API_USERS, address, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));
    }

    @Test
    public void post_Invalid_receiveError(){
        AddressRequestDto address = createAddressValid();
        address.setNumber(0);
        ResponseEntity<Object> response = restTemplate.postForEntity(API_USERS, address, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));
    }

    @Test
    public void patch_addressValid_receiveStatusOk(){
        AddressRequestDto address = createAddressValid();
        restTemplate.postForEntity(API_USERS, address, Object.class);

        address.setCity("Francisco Beltrão");
        Address response = restTemplate.patchForObject(API_USERS, address, Address.class);

        assertThat(response.getCity().equals(address.getCity()));
    }

    public static PersonRequestDto createPresonValid(){
        PersonRequestDto person = new PersonRequestDto();
        person.setName("João Silva");
        person.setPhone("5546911330499");
        person.setCpf("09177204905");
        person.setRg("1482692514");
        return person;
    }

    public static AddressRequestDto createAddressValid(){
        AddressRequestDto address = new AddressRequestDto();
        address.setNumber(1);
        address.setCep("85503200");
        address.setStreet("Rua 01");
        address.setCity("Pato Branco");
        address.setPerson(1L);
        return address;
    }

}
