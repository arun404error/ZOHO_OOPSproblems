package librarymanagement;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		Library lib=new Library();
		int isbn=0;
		while(true)
		{
			System.out.println("1.Login\n2.signup");
			int l_type=obj.nextInt();
			if(l_type==2)
			{
				System.out.println("Enter email & password");
				String email=obj.next();
				String pass=obj.next();
				if(lib.addUser(email,new User(email,pass,"borrower",1500)))
				{
					System.out.println("Account Created");
				}
				else
					System.out.println("email already exits");
			}
			else if(l_type==1)
			{
				System.out.println("1.Admin\n2.User");
				l_type=obj.nextInt();
				System.out.println("Enter email & password");
				String email=obj.next();
				String pass=obj.next();
				if(l_type==1)
				{
					if(lib.validLogin(email,pass,"admin"))
					{
						System.out.println("Admin login successfull");
						int logout=0;
						do
						{
						System.out.println("1.view operation\n2.logout");
						int choice=obj.nextInt();
						if(choice==1)
						{
							int exit=0;
							do
							{
							System.out.println("1.view books\n2.Add Book\n3.Delete Book\n4.Add Admin\n5.Exit");
							int op=obj.nextInt();
							if(op==1)
								lib.showBooksAdmin();
							else if(op==2)
							{
								System.out.println("Enter book name & count & cost");
								String name=obj.next();
								int count=obj.nextInt();
								int cost=obj.nextInt();
								lib.addBook(isbn,new Book(isbn,name,count,count-3,cost));
							}
							else if(op==3)
							{
								System.out.println("enter isbn(id) number");
								int id=obj.nextInt();
								if(lib.removeBook(id))
									System.out.println("book removed");
							}
							else if(op==4)
							{
								System.out.println("Enter email & password");
								String ad_email=obj.next(),ad_pass=obj.next();
								if(lib.addUser(ad_email,new User(ad_email,ad_pass,"admin",0)))
									System.out.println("Admin added");
								else
									System.out.println("email already exist");
							}
							else if(op==5)
								exit=1;
							}while(exit==0);
						}
						else if(choice==2)
							logout=1;
						}while(logout==0);
						
					}
					else
					{
						System.out.println("Invalid Login");
					}
				}
				else if(l_type==2)
				{
					if(lib.validLogin(email,pass,"borrower"))
					{
						System.out.println("login successfull");
						int logout=0;
						do
						{
						System.out.println("1.view operation\n2.logout");
						int choice=obj.nextInt();
						if(choice==1)
						{
							int exit=0;
							do
							{
							System.out.println("1.view books\n2.Add Book to checkout\n3.Return book\n4.Pay fine\n5.Deposi Amount\n6.Exit");
							int op=obj.nextInt();
							User userObj=lib.getUser(email);
							if(op==1)
								lib.showBooks();
							else if(op==2)
							{
								if(userObj.getDeposit()>=500)
								{
								System.out.println("Enter no of books to borrow (max=3)");
								int n=obj.nextInt();
								if(n>3||n<1)
								{
									System.out.println("maximum 3 and minimum 1 book can borrow");
								}
								else
								{
									int f=1;
								do
								{
								System.out.println("Enter book id ("+f+")");
								int id=obj.nextInt();
								if(!lib.addCheckOut(email,id))
								{
									System.out.println("Enter 1 to borrow or 2 to exit");
									int borrow=obj.nextInt();
									if(borrow==1)
										f--;
									else
										f=n+1;
								}
								else
									System.out.println("Book added to CheckOut");
								f++;
								}while(f<=n);
								}
								}
								else
									System.out.println("low deposit");
							}
							else if(op==3)
							{
								System.out.println("enter isbn(id) number");
								int id=obj.nextInt();
								if(lib.removeCheckOut(email,id))
									System.out.println("book returned");
							}
							else if(op==4)
							{
								System.out.println("1.membership lost fine\n2.book lost fine");
								int fine=obj.nextInt();
								
								if(fine==1)
								{
									userObj.setDeposit(-10);
									System.out.println("mebership added");
								}
								else if(fine==2)
								{
									System.out.println("Enter book isbn(id) that lost");
									int id=obj.nextInt();
									Book bookObj=lib.getBook(id);
									int cost=bookObj.getCost();
									cost=(int)(cost*0.5);
									userObj.removeBook(id);
									cost=-cost;
									userObj.setDeposit(cost);
									
								}
							}
							else if(op==5)
							{
								System.out.println("Enter amount to be deposited");
								int deposit=obj.nextInt();
								userObj.setDeposit(deposit);
							}
							else if(op==6)
								exit=1;
							}while(exit==0);
						}
						else if(choice==2)
							logout=1;
						}while(logout==0);

					}
					else
					{
						System.out.println("Invalid Login");
					}
				}
			}
		}

	}

}
