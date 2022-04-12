package librarymanagement;
import java.util.*;
public class User {

	private String email,password,role;
	private int deposit;
	private HashMap<Integer,Book> booksBorrowed=new HashMap<>();
	User(String id,String pass,String typ,int amt)
	{
		email=id;
		password=pass;
		role=typ;
		deposit=amt;
	}
	public String getPassword()
	{
		return password;
	}
	public String getRole()
	{
		return role;
	}
	public boolean addBook(int id,Book obj)
	{
		if(booksBorrowed.containsKey(id))
		return false;
		booksBorrowed.put(id, obj);
		return true;
	}
	public boolean removeBook(int id)
	{
		if(!booksBorrowed.containsKey(id))
		return false;
		booksBorrowed.remove(id);
		return true;
	}
	public void setDeposit(int n)
	{
		deposit+=n;
	}
	public int getDeposit()
	{
		return deposit;
	}
}
