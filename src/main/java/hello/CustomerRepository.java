package hello;

import java.util.List;

public interface CustomerRepository {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
