package people;

import java.util.List;

public interface PersonService {

	public Person createPerson(Person person) throws Exception;

	public Person readPerson(String personId) throws Exception;

	public List<Person> readAllPorsons() throws Exception;

	public Person updatePerson(Person person, String personId) throws Exception;

	public void deletePerson(String personId) throws Exception;

	public List<Person> readAllPorsonsAK() throws Exception;

	public List<Person> readAllPorsonsAboveAvgIsrael() throws Exception;

}
