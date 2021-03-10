import java.util.ArrayList;
import java.util.Scanner;

class ContactDetails {

	public String firstName;
	public String lastName;
	public String area;
	public String city;
	public String state;
	public int pin;
	public int phoneNumber;
	public String email;

	public ContactDetails(String firstName, String lastName, String area, String city, String state, int pin,
			int phoneNumber, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String fname) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lname) {
		this.lastName = lastName;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String ar) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String cty) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String st) {
		this.state = state;
	}

	public int getPin() {
		return this.pin;
	}

	public void setZip(int zp) {
		this.pin = pin;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phn) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String eml) {
		this.email = email;
	}

	public String toString() {
		return "Details of: " + firstName + " " + lastName + "\n" + "Area: " + area + "\n" + "City: " + city + "\n"
				+ "State: " + state + "\n" + "Pin: " + pin + "\n" + "Phone Number: " + phoneNumber + "\n" + "Email: "
				+ email;
	}

	public void setpin(int nextInt) {


	}
}

class AddressBookDetails {

	public String addressBookName;
	public String firstName;
	public String lastName;
	public String area, city, state, email;
	public int pin, phoneNumber;
	public static int indexNum;

	public AddressBookDetails(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public static ArrayList<ContactDetails> list = new ArrayList<ContactDetails>();

	public Scanner sc = new Scanner(System.in);

	public boolean checkName() {

		System.out.println("Enter First Name");
		firstName = sc.next();
		System.out.println("Enter Last Name");
		lastName = sc.next();

		for (indexNum = 0; indexNum < list.size(); indexNum++) {
			if (firstName.equals(list.get(indexNum).getFirstName())
					&& lastName.equals(list.get(indexNum).getLastName())) {
				System.out.println("Contact Name Exists");
				return true;
			}
		}
		return false;
	}

	public void addDetails() {

		if (!checkName()) {

			System.out.println("Enter Area");
			area = sc.next();
			System.out.println("Enter CityName");
			city = sc.next();
			System.out.println("Enter StateName");
			state = sc.next();
			System.out.println("Enter pinCode");
			pin = sc.nextInt();
			System.out.println("Enter PhoneNumber");
			phoneNumber = sc.nextInt();
			System.out.println("Enter Email");
			email = sc.next();
		}
		list.add(new ContactDetails(firstName, lastName, area, city, state, pin, phoneNumber, email));
	}

	public String editDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Details to be Edited: ");

		if (checkName()) {
			System.out.println("Enter FirstName");
			list.get(indexNum).setFirstName(sc.next());
			System.out.println("Enter LastName");
			list.get(indexNum).setLastName(sc.next());
			System.out.println("Enter Area");
			list.get(indexNum).setArea(sc.next());
			System.out.println("Enter CityName");
			list.get(indexNum).setCity(sc.next());
			System.out.println("Enter StateName");
			list.get(indexNum).setState(sc.next());
			System.out.println("Enter pinCode");
			list.get(indexNum).setpin(sc.nextInt());
			System.out.println("Enter PhoneNumber");
			list.get(indexNum).setPhoneNumber(sc.nextInt());
			System.out.println("Enter Email");
			list.get(indexNum).setEmail(sc.next());

			return "Edited";

		}

		return "Name Not Available in List";
	}

	public String deleteDetails() {

		System.out.print("Details to be Deleted");
		if (checkName()) {
			list.remove(indexNum);
			return "Deleted";
		}
		return "Name Not Available in List";
	}

	public void displayDetails() {

		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.println(list.get(i));
		}
	}

	@Override
	public String toString() {
		return addressBookName;
	}
}

public class AddressBook {

	public static int bookNumber = 0;

	public static Scanner sc = new Scanner(System.in);

	public static ArrayList<AddressBookDetails> addressBook = new ArrayList<>();

	public static void addAdressBookDetails() {

		System.out.println("Enter Name of Address Book");
		String name = sc.next();

		addressBook.add(new AddressBookDetails(name));
	}

	public static void pickAddressBook() {

		System.out.println("You are Currently in " + addressBook.get(bookNumber) + " AddressBook");
		if (addressBook.size() > 1) {
			for (int i = 0; i < addressBook.size(); i++)
				System.out.println(i + ". " + addressBook.get(i));
			System.out.println("Pick Address Book Number");
			bookNumber = Integer.parseInt(sc.next());
		}
	}

	public static void option() {

		Scanner sc = new Scanner(System.in);

		String check = "Y";
		while ((check.equals("Y")) || (check.equals("y"))) {

			System.out.println("Choose Below Option");
			System.out.println("1: Add Contact");
			System.out.println("2: Edit Contact");
			System.out.println("3: Delete Contact");
			System.out.println("4: Display Contact");
			System.out.println("5: Exit");

			String choose = sc.next();
			switch (choose) {

			case "1":
				addressBook.get(bookNumber).addDetails();
				break;
			case "2":
				pickAddressBook();
				System.out.println(addressBook.get(bookNumber).editDetails());
				break;
			case "3":
				pickAddressBook();
				System.out.println(addressBook.get(bookNumber).deleteDetails());
				break;
			case "4":
				pickAddressBook();
				addressBook.get(bookNumber).displayDetails();
				break;
			default:
				System.out.println("Exit");

				System.out.println("Want to Make More Changes in This Address Book? (y/n)");
				check = sc.next();

			}

		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program");

		String check = "Y";
		while ((check.equals("Y")) || (check.equals("y"))) {

			addAdressBookDetails();
			option();

			System.out.println("Want to Add More Address Book (y/n)");
			check = sc.next();
		}

	}
}
