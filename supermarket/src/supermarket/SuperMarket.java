package supermarket;
import java.util.*;
import supermarket.*;
public class SuperMarket {
	private HashMap<String,User> users=new HashMap<>();
	private HashMap<String,Product> products=new HashMap<>();
	private HashMap<Integer,Bill> bills=new HashMap<>();
	private HashMap<Integer,String> userbills=new HashMap<>();
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
	public boolean addUser(String email,User obj)
	{
		if(users.containsKey(email))
			return false;
		users.put(email, obj);
		return true;
	}
	public void addProduct(String id,Product obj)
	{
		products.put(id, obj);
	}
	public void addBill(Bill obj,int id,String email)
	{
		bills.put(id, obj);
		userbills.put(id, email);
	}
	public void showProducts()
	{
	products.forEach((k,v)->System.out.println(v.getProductDetails()));		
	}
	public Product getProduct(String id)
	{
		return products.get(id);
	}
	public void calculateCredit(String id,int ttl)
	{
		int amt=(ttl/5000)*100;
		User obj=users.get(id);
		int credit=obj.getCredit();
		obj.setCredit(credit+amt);
	}
	public void showBillHistory(String id)
	{	
//		userbills.forEach((k,v)->{
//			if(v.equals(id)) {
//				Bill obj=bills.get(k);
//				obj.printBill();
//			}
//		});
		int f=0;
		for(Map.Entry<Integer,String> entry:userbills.entrySet())
		{
			if(entry.getValue().equals(id)) {
				f++;
				Bill obj=bills.get(entry.getKey());
				obj.printBill();
			}
		}
		if(f==0)
			System.out.println("No Bill History");
	}
	public boolean removeProduct(String id)
	{
		if(products.containsKey(id))
		{
			products.remove(id);
			return true;
		}
		System.out.println("product not found");
		return false;
	}
	SuperMarket()
	{
		products.put("p1", new Product("p1","sugar",1000,55));
		products.put("p2", new Product("p2","jaggry",1000,55));
		products.put("p3", new Product("p3","rice",1000,55));
		products.put("p4", new Product("p4","dhal",1000,55));
		users.put("arun",new User("arun","1234","admin"));
		users.put("hari",new User("hari","1234","customer"));
		users.put("ram",new User("ram","1234","customer"));
	}
	
	
	
	
	
	
	
}
