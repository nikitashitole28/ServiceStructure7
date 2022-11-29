package demo.testexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.testexample.model.MobileModel;
@Repository
public interface MobileRepository extends CrudRepository<MobileModel, Integer>{

	
}
