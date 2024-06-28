package miu.waa.spring_demo.repository;

import miu.waa.spring_demo.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepo extends ListCrudRepository<Address, Integer> {
}
