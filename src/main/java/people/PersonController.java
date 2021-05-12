package people;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/createperson", method = RequestMethod.POST)
	public Person createPerson(@RequestBody Person person) throws Exception {
		return personService.createPerson(person);
	}

	@RequestMapping(value = "/readperson/{personId}", method = RequestMethod.GET)
	public Person readPerson(@PathVariable("personId") String personId) throws Exception {
		return personService.readPerson(personId);
	}

	@RequestMapping(value = "/readallpersons", method = RequestMethod.GET)
	public List<Person> readAllPorsons() throws Exception {
		return personService.readAllPorsons();
	}

	@RequestMapping(value = "/updateperson/{personId}", method = RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person person, @PathVariable("personId") String personId) throws Exception {
		return personService.updatePerson(person, personId);
	}

	@RequestMapping(value = "/deleteperson/{personId}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable("personId") String personId) throws Exception {
		personService.deletePerson(personId);
	}

	// all persons with name starting with A or K
	@RequestMapping(value = "/readallpersonsAK", method = RequestMethod.GET)
	public List<Person> readAllPorsonsAK() throws Exception {
		return personService.readAllPorsonsAK();
	}

	// all persons above average weight and from Israel
	@RequestMapping(value = "/readallpersonsavgisrael", method = RequestMethod.GET)
	public List<Person> readAllPorsonsAboveAvgIsrael() throws Exception {
		return personService.readAllPorsonsAboveAvgIsrael();
	}

}
