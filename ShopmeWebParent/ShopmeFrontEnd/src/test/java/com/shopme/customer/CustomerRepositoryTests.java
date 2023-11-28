package com.shopme.customer;

import com.shopme.common.entity.Customer;
import com.shopme.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository repo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateCustomer1() {

        Customer customer = new Customer();
        customer.setFirstName("Thai");
        customer.setLastName("Nguyen");
        customer.setPassword("11111111");
        customer.setEmail("thai123@gmail.com");
        customer.setPhoneNumber("0987666222");
        customer.setAddressLine1("Ha Noi");
        customer.setCreatedTime(new Date());
        customer.setCity("Ha noi");
        customer.setPostalCode("100000");
        customer.setState("VN");

        Customer savedCustomer = repo.save(customer);

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isGreaterThan(0);
    }

    @Test
    void test() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Customer customer = repo.findById(2).get();
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        repo.save(customer);
    }
}
