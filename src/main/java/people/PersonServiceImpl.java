package people;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Transactional
	@Override
	public Person createPerson(Person person) throws Exception {
		if (person.getId() != null) {
			throw new Exception("The person allready exists !! ");
		}
		return personRepository.save(person);
	}

	@Transactional
	@Override
	public Person readPerson(String personId) throws Exception {
		return personRepository.findPersonById(personId);
	}

	@Transactional
	@Override
	public List<Person> readAllPorsons() throws Exception {
		return personRepository.findAll();
	}

	@Transactional
	@Override
	public Person updatePerson(Person person, String personId) throws Exception {
		Person origin = readPerson(personId);
		if (origin == null) {
			throw new Exception("The Person not exsists !! ");
		}
		person.setId(personId);
		Person updatedPerson = personRepository.save(person);
		return updatedPerson;
	}

	@Transactional
	@Override
	public void deletePerson(String personId) throws Exception {
		personRepository.deleteById(personId);

	}

	// all persons with name starting with A or K
	@Transactional
	@Override
	public List<Person> readAllPorsonsAK() throws Exception {
		List<Person> allPersons = readAllPorsons();
		List<Person> allPersonsAK = new ArrayList<Person>();
		for (Person p : allPersons) {
			String name = p.getName();
			if (name.charAt(0) == 'A' || name.charAt(0) == 'a' ||

					name.charAt(0) == 'K' || name.charAt(0) == 'k') {
				allPersonsAK.add(p);
			}
		}
		return allPersonsAK;
	}

	// all persons above average weight and from Israel
	@Transactional
	@Override
	public List<Person> readAllPorsonsAboveAvgIsrael() throws Exception {
		List<Person> allPersons = readAllPorsons();
		List<Person> allPersonsAboveAvgIsrael = new ArrayList<Person>();
		double totalWeight = 0;
		double avgWeight = 0;
		int counter = 0;
		for (Person p : allPersons) {
			double weight = p.getWeight();
			totalWeight = weight + totalWeight;
			counter++;
			avgWeight = totalWeight / counter;
		}
		for (Person p : allPersons) {
			if (p.getWeight() > avgWeight && p.getAddress().getState() == State.Israel) {
				allPersonsAboveAvgIsrael.add(p);
			}
		}
		return allPersonsAboveAvgIsrael;

	}

}
