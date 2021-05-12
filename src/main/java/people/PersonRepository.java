package people;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface PersonRepository extends

		MongoRepository<Person, String> {

	public Person findPersonById(String personId) throws Exception;
}
