package irctc.app;

public class PassengerDto {

	private String name;
	private int age;
	private String gender;
	private String preferBirth;
	private String seatNumber;
	private String status;

	public PassengerDto() {
	}

	public PassengerDto(String name, int age, String gender, String preferBirth, String seatNumber, String status) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.preferBirth = preferBirth;
		this.seatNumber = seatNumber;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPreferBirth() {
		return preferBirth;
	}

	public void setPreferBirth(String preferBirth) {
		this.preferBirth = preferBirth;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PassengerDto [name=" + name + ", age=" + age + ", gender=" + gender + ", preferBirth=" + preferBirth
				+ ", seatNumber=" + seatNumber + ", status=" + status + "]";
	}
	
}
