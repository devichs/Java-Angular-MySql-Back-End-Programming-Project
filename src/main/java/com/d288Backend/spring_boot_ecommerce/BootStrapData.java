package com.d288Backend.spring_boot_ecommerce;

import com.d288Backend.spring_boot_ecommerce.dao.CustomerRepository;
import com.d288Backend.spring_boot_ecommerce.dao.DivisionRepository;
import com.d288Backend.spring_boot_ecommerce.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String...args) throws Exception{
        if(customerRepository.count() == 1){
            Customer frank = new Customer();
            frank.setFirstName("Frank");
            frank.setLastName("Smith");
            frank.setAddress("123 Elm Street");
            frank.setPhone("(123)456-7894");
            frank.setPostal_code("12345");
            frank.setDivision(divisionRepository.getReferenceById(3L));
            customerRepository.save(frank);

            Customer jane = new Customer();
            jane.setFirstName("Jane");
            jane.setLastName("Smith");
            jane.setAddress("123 Elm Street");
            jane.setPhone("(123)459-6789");
            jane.setPostal_code("12345");
            jane.setDivision(divisionRepository.getReferenceById(5L));
            customerRepository.save(jane);

            Customer stew = new Customer();
            stew.setFirstName("Stew");
            stew.setLastName("Bee");
            stew.setAddress("584 Oak Street");
            stew.setPhone("(987)456-0321");
            stew.setPostal_code("36985");
            stew.setDivision(divisionRepository.getReferenceById(7L));
            customerRepository.save(stew);

            Customer mary = new Customer();
            mary.setFirstName("Mary");
            mary.setLastName("Shelly");
            mary.setAddress("654 Maple Street");
            mary.setPhone("(123)665-0478");
            mary.setPostal_code("98745");
            mary.setDivision(divisionRepository.getReferenceById(9L));
            customerRepository.save(mary);

            Customer del = new Customer();
            del.setFirstName("Del");
            del.setLastName("Burby");
            del.setAddress("965 Logan Street");
            del.setPhone("(456)214-9586");
            del.setPostal_code("45214");
            del.setDivision(divisionRepository.getReferenceById(11L));
            customerRepository.save(del);

        }
    }

}

