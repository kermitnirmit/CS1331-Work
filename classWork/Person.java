public class Person {
    private String firstName;
    private String lastName;
    private int age;
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


	/**
	* Returns value of firstName
	* @return
	*/
	public String getFirstName() {
		return firstName;
	}

	/**
	* Sets new value of firstName
	* @param
	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	* Returns value of lastName
	* @return
	*/
	public String getLastName() {
		return lastName;
	}

	/**
	* Sets new value of lastName
	* @param
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	* Returns value of age
	* @return
	*/
	public int getAge() {
		return age;
	}

	/**
	* Sets new value of age
	* @param
	*/
	public void setAge(int age) {
		this.age = age;
	}
    public String toString() {
        return "Name: " + firstName + " " + lastName + ". Age: " + age;
    }
    
    // public int compareTo(Person p) {
    //     return this.getAge() - p.getAge();
    // }
}
