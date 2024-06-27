package edu.miu.cs545.lab3.lab3.repository;

import edu.miu.cs545.lab3.lab3.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepo extends ListCrudRepository<Address, Long> {
}
