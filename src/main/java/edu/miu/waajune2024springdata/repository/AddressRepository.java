package edu.miu.waajune2024springdata.repository;

import edu.miu.waajune2024springdata.entity.Address;
import org.springframework.data.repository.ListCrudRepository;

/**
 * @author kush
 */
public interface AddressRepository extends ListCrudRepository<Address,Long> {
}
