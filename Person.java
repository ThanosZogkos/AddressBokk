//κλάση java που αντιπροσωπεύει μια καταχώριση στο βιβλίο διευθύνσεων
package util;

public class Person {
private int addressID;
private String firstName;
private String lastName;
private String email;
private String phoneNumber;

//συνάρτηση δημιουργίας χωρίς ορίσματα
public Person(){
	}// τέλος της συνάρτησης δημιουργίας χωρίς ορίσματα Person

//συνάρτηση δημιουργίας
public Person( int id, String first, String last, String emailAddress, String phone )
{
	setAddressID( id );
	setFirstName( first );
	setLastName( last );
	setEmail( emailAddress );
	setPhoneNumber( phone );
}//τέλος συνάρτησης δημιουργίας 5 ορισμάτων Person

//ορίζει το addressID
public void setAddressID( int id )
{
	addressID = id;
}//τέλος μεθόδου setAddressID

//επιστρέφει το addressID
public int getAddressID()
{
	return addressID;
}//τέλος της μεθόδου getAddressID

//ορίζει το firstName
public void setFirstName( String first )
{
	firstName = first;
}//τέλος της μεθόσου setFirstName

//επιστρέφει το όνομα
public String getFirstName()
{
	return firstName;
}//τέλος της μεθόδου getFirstName

//ορίζει το επώνυμο
public void setLastName( String last )
{
	lastName = last;
}//τέλος της μεθόδου setLastName

//επιστρέφει το επώνυμο
public String getLastName()
{
	return lastName;
}//τέλος της μοθόδου getlastName

//ορίζει την διεύθυνση email
public void setEmail( String emailAddress )
{
	email = emailAddress;
}//τέλος της μεθόδου setEmail

//επιστρέφει την διεύθυνση email
public String getEmail()
{
	return email;
}//τέλος της μεθόδου getEmail

//ορίζει τον αριθμό τηλεφώνου
public void setPhoneNumber( String phone)
{
	phoneNumber = phone;
}//τέλος της μεθόδου setPhoneNumber

//επιστρέφει τον αριθμό τηλεφώνου
public String getPhoneNumber()
{
	return phoneNumber;
}//τέλος της μεθόδου getPhoneNumber

}//τέλος τησ κλάσης Person
