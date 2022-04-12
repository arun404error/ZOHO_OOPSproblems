package librarymanagement;
import java.util.*;


public class Library {

	private HashMap<Integer,Book> books=new HashMap<>();
	private HashMap<String,User> users=new HashMap<>();
	
	public boolean addUser(String id,User obj)
	{
		if(users.containsKey(id))
			return false;
		users.put(id, obj);
		return true;
	}
	public boolean validLogin(String email,String pswd,String role)
	{
		if(users.containsKey(email))
		{
		String cpswd=users.get(email).getPassword();
		String crole=users.get(email).getRole();
		if(cpswd.equals(pswd)&&crole.equals(role))
			return true;
		}
		return false;
	}
	public void addBook(int id,Book obj)
	{
		books.put(id, obj);
	}
	public void showBooks()
	{
	books.forEach((k,v)->System.out.println(v.getBookDetails()));		
	}
	public void showBooksAdmin()
	{
	books.forEach((k,v)->System.out.println(v.getBookDetailsAdmin()));		
	}
	public boolean removeBook(int id)
	{
		if(books.containsKey(id))
		{
			books.remove(id);
			return true;
		}
		System.out.println("book not found");
		return false;
	}
	
	public boolean addCheckOut(String email,int id)
	{
		Book obj1=books.get(id);
		User obj2=users.get(email);
		int avail=obj1.getAvail();
		if(avail==0)
		{
			System.out.println("Book out of stock");
			return false;
		}		
		if(!obj2.addBook(id, obj1))
		{
			System.out.println("Already borrowed book is not avail");
			return false;
		}
		obj1.setAvail(-1);
		return true;
	}
	public boolean removeCheckOut(String email,int id)
	{
		User obj1=users.get(email);
		Book obj2=books.get(id);
		if(!obj1.removeBook(id))
		{
			System.out.println("book not in checkout list");return false;
		}
		
		obj2.setAvail(1);
		return true;
	}
	public User getUser(String id)
	{
		return users.get(id);
	}
	public Book getBook(int id)
	{
		return books.get(id);
	}
	Library()
	{
		books.put(0, new Book(0,"book1",25,22,340));
		books.put(1, new Book(1,"book1",20,12,230));
		books.put(2, new Book(2,"book1",25,17,110));
		books.put(3, new Book(3,"book1",25,20,450));
		users.put("arun", new User("arun","1234","borrower",1500));
		users.put("hari", new User("hari","1234","admin",0));
	}
	
	
	
	
	
	
	
	
}
