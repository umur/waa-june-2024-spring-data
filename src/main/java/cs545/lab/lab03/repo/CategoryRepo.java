package cs545.lab.lab03.repo;

import cs545.lab.lab03.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
