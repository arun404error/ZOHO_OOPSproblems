package librarymanagement;

public class Book {
	private String book_name;
	private int isbn,cost,totalCount,availCount;

	public String getBookDetails()
	{
		return isbn+"  "+book_name+"  available: "+availCount;
	}
	public String getBookDetailsAdmin()
	{
		return isbn+"  "+book_name+" total: "+totalCount+"  available: "+availCount;
	}
	Book(int id,String name,int ttl,int avail,int rate)
	{
		isbn=id;
		book_name=name;
		totalCount=ttl;
		availCount=avail;
		cost=rate;
	}
	public int getAvail()
	{
		return availCount;
	}
	public void setAvail(int n)
	{
		availCount+=n;
	}
	public int getCost()
	{
		return cost;
	}
}
