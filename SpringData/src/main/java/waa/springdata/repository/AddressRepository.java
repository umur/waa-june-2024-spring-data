package waa.springdata.repository;

import org.springframework.data.repository.ListCrudRepository;
import waa.springdata.entity.Address;

public interface AddressRepository extends ListCrudRepository<Address,Integer> {
}
