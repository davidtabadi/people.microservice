package people;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("address")
public class Address {

	private State state;
	private String city;
	private String street;
	private String zipcode;
	private boolean containsAnimals;

	public Address() {
		super();
	}

	public Address(State state, String city, String street, String zipcode, boolean containsAnimals) {
		super();
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.containsAnimals = containsAnimals;
	}

	@NotNull(message = "State cannot be null")
	@Enumerated(EnumType.STRING)
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@NotNull(message = "City cannot be null")
	@Size(min = 3, max = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@NotNull(message = "Street cannot be null")
	@Size(min = 3, max = 50)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@NotNull(message = "Zipcode cannot be null")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@NotNull(message = "isContainsAnimals cannot be null")
	public boolean isContainsAnimals() {
		return containsAnimals;
	}

	public void setContainsAnimals(boolean containsAnimals) {
		this.containsAnimals = containsAnimals;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", street=" + street + ", zipcode=" + zipcode
				+ ", containsAnimals=" + containsAnimals + "]";
	}

}
