package supermarket;
import java.util.*;
public class Bill {
	private int bill_id,quantity;
	private float rate;
	private String product_id,product_name;
	private int total=0;
	Scanner obj=new Scanner(System.in);
	private HashMap<String,Bill> product=new HashMap<>();
	
	Bill(int id)
	{
		bill_id=id;
	}
	Bill(int id,String p_id,String p_name,int qnty,float price)
	{
		bill_id=id;
		quantity=qnty;
		rate=price;
		product_id=p_id;
		product_name=p_name;
	}
	public void addProduct(SuperMarket market,String id,int qnty)
	{
	
		Product obj=market.getProduct(id);
		int avail=obj.getQnty();
		if(avail<qnty)
		{
			System.out.println("only "+avail+" quantity is available");
			return;
		}
		//quantity=qnty;
		//product_id=id;
		//product_name=obj.getName();
		rate=obj.getPrice();
		total+=(rate*qnty);
		product.put(id,new Bill(bill_id,id,obj.getName(),qnty,rate));		
	}
	public void removeProduct(String id)
	{
		product.remove(id);
	}
	public int printBill()
	{
		System.out.println("Bill Id :"+bill_id);
		product.forEach((k,i)->
		{
			System.out.println(i.product_id+" "+i.product_name+" "+i.rate+" "+i.quantity);
		});
		System.out.println("Total amount"+total);
		System.out.println();
		return total;
	}
	
	
}
