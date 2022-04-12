package supermarket;

public class Product {
	private String p_name,p_id;
	private float price;
	private int quantity;
	
//	public void getProductName(String id)
//	{
//		System.out.println(p_name);
//	}
	public String getProductDetails()
	{
		return p_id+"  "+p_name+"  "+price+"  quantity Available(kg): "+quantity;
	}
//	public String getProductDetailsBill()
//	{
//		return p_id+"  "+p_name+"  "+price;
//	}
//	public void setProduct(String id,String name,float rate,float qnty)
//	{
//		p_id=id;
//		p_name=name;
//		price=rate;
//		quantity=qnty;
//	}
	public int getQnty()
	{
		return quantity;
	}
	public float getPrice()
	{
		return price;
	}
	public String getName()
	{
		return p_name;
	}
	
	public String getId()
	{
		return p_id;
	}
	public void setQnty(int qnty)
	{
		quantity=qnty;
	}
	public void setPrice(float a)
	{
		price=a;
	}
	Product(String id,String name,int qnty,float rate)
	{
		p_id=id;
		p_name=name;
		price=rate;
		quantity=qnty;
	}
	{
		
	}
}
