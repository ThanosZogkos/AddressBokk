package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries {

	private static final String URL = "jdbc:mysql//Thanos:3306:addressbook";
	private static final String USERNAME = "thanos";
	private static final String PASSWORD = "root";
	
	private Connection connection = null;//διαχειρίζεται την σύνδεση
	private PreparedStatement selectAllPeople = null;
	private PreparedStatement selectPeopleByLastName = null;
	private PreparedStatement insertNewPerson = null;
	
	//συνάρτηση δημιουργίας
	public PersonQueries()
	{
		try
		{
			connection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
			
			//δημιουργεί ερώτημα που επιλέγει όλες τις καταχωρίσεις στην AddressBook
			selectAllPeople = connection.prepareStatement( "SELECT * FROM addresses");
			
			//δημιουργεί μια insert που προσθέτει μια νέα καταχώριση στη βάση δεδομένων
			insertNewPerson = connection.prepareStatement( "INSERT INTO addresses " + "( FirstName, LastName, Email, PhoneNumber )" + "VALUES ( ?, ?, ?, ? )" ); 
			
		}//τέλος της try
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
			System.exit( 1 );
		}//τέλος catch
	}//τέλος της συνάρτησης δημιουργίας PersonQueries
	
	//επιλέγει όλες τις διευθύνσεις στην βάση δεδομένων
	public List< Person > getAllPeople()
	{
		List< Person > results = null;
		ResultSet resultSet = null;
		
		try
		{
			//η executeQuery επιστρέφει ένα ResultSet που περιέχει καταχωρίσεις που ταιριάζουν
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList< Person >();
			
			while ( resultSet.next())
			{
				results.add( new Person(
					resultSet.getInt( "addressID" ),
					resultSet.getString( "FirstName" ),
					resultSet.getString( "LastName" ),
					resultSet.getString( "Email" ),
					resultSet.getString( "PhoneNumber" ) ) );
			}//τέλος της while
		}//τέλος της try
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}//τέλος της catch
		finally
		{
			try
			{
				resultSet.close();
			}//τέλος της try
			catch ( SQLException sqlException )
			{
				sqlException.printStackTrace();
				close();
			}//τέλος της catch
		}//τέλος της finally
		
		return results;
	}//τέλος της μεθόδου getAllPeople
	
	//επιλέγει άτομο με το επώνυμο
	public List< Person > getPeopleByLastName( String name )
	{
		
	
	ResultSet resultSet = null;
	
	try
	{
		selectPeopleByLastName.setString( 1, name );//καθορίζει το επώνυμο
		
		resultSet = selectPeopleByLastName.executeQuery();
		
		results = new ArrayList< Person >();
		
		while ( resultSet.next() )
		{
			results.add( new Person( resultSet.getInt( "addressID" ),
				resultSet.getString( "Firstname" ),
				resultSet.getString( "LastName " ),
				resultSet.getString( "Email" ),
				resultSet.getString( "PhoneNumber" ) ) );
		}//τέλος της while
	}//τέλος της try
	catch (SQLException sqlException )
	{
		sqlException.printStackTrace();
	}//τέλος της catch
	finally
	{
		try
		{
			resultSet.close();
		}//τέλος της try
		catch (SQLException sqlException )
		{
			sqlException.printStackTrace();
			close();
		}//τέλος της catch
	}//τέλος της finally
	
	return results;
	}//τέλος της μεθόδου getPeopleByName
	
	//προσθέτει μια καταχώριση
	public int addPerson( String fname, String lname, String email, String num )
	{
		int result = 0;
		
		//ορίζει παραμέτρους και μετά εκτελεί την insertNewPerson
		try
		{
			insertNewPerson.setString( 1, fname );
			insertNewPerson.setString( 2, lname );
			insertNewPerson.setString( 3, email );
			insertNewPerson.setString( 3, num );
			
			//εισάγει την νέα καταχώριση και επιστρέφει τον αριθμό των ενημερωμένων γραμμών
			result = insertNewPerson.executeUpdate();
			
		}//τέλος της try
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
			close();
		}//τέλος της catch
		
		return result;
	}//τέλος της μεθόδου addPerson
	
	//κλείσιμο της σύνδεσης της βάσεις δεδομένων
	public void close()
	{
		try
		{
			connection.close();
		}//τέλος της try
		catch ( SQLException sqlException )
		{
			sqlException.printStackTrace();
		}//τέλος της catch
	}//τέλος της μεθόδου close
}//τέλος της κλάσης PersonQueries
