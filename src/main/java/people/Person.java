package people;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("people")
public class Person {

	private String id;
	private String name;
	private int age;
	private Gender gender;
	private double height;
	private double weight;
	private Address address;

	public Person() {
		super();
	}

	public Person(String name, int age, Gender gender, double height, double weight, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.address = address;
	}

	@Id
	@Size(min = 3, max = 40)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(min = 0, max = 200, message = "age must be between 0 and 200 ")
	@NotNull(message = "Age cannot be null")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@NotNull(message = "Gender cannot be null")
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Min(value = 0, message = "Height should not be less than 0")
	@NotNull(message = "Height cannot be null")
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Min(value = 0, message = "Weight should not be less than 0")
	@NotNull(message = "Weight cannot be null")
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@NotNull(message = "Address cannot be null")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height
				+ ", weight=" + weight + ", address=" + address + "]";
	}

}
