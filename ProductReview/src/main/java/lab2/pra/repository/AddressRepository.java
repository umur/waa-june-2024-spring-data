package lab2.pra.repository;

import lab2.pra.domain.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepository extends ListCrudRepository<Address, Integer> {
}
