package lektion5;

public class Name {
	
	private String first;
	private String middle;
	private String last;
	
	
	public Name(String firstname, String middlename, String lastname) {
		
		first = firstname;
		middle = middlename;
		last = lastname;
		
	}
	
	public void setfirstname(String firstname) {
		first = firstname;
	}
	
	public void setmiddlename(String middlename) {
		middle = middlename;
	}
	
	public void setlastname(String lastname) {
		last = lastname;
	}
	
	public String getfirstname() {
		return first;
	}
	
	public String getmiddlename() {
		return middle;
	}
	
	public String getlastname() {
		return last;
	}
	
	public String getInit() {
		return "" + first.charAt(0) + middle.charAt(0) + last.charAt(0);
	}
	
	public String getUsername() {
		return first.substring(0, 2).toUpperCase() + middle.length() + last.substring(last.length()-2).toLowerCase()  ;
	}
	
	public void printName() {
		System.out.println(first + " " + middle + " " + last);
		
	}
	
	
	
	
	
	
	
	
	
}
