package supermarket;
import supermarket.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		SuperMarket market=new SuperMarket();
		int billId=0;
		while(true)
		{
		System.out.println("Enter 1 to login and enter 2 to signup");
		int l_choice=obj.nextInt();
		if(l_choice==1)
		{
			System.out.println("Enter Email & password & role");
			String email=obj.next();
			String pass=obj.next();
			String role=obj.next();
			if(market.validLogin(email,pass,role))
			{
				System.out.println("Login Successful");
				if(role.equals("customer"))
				{
				int logout=0;
				while(logout==0)
				{
				System.out.println("Enter 1 for operation menu or Enter 2 for logout");
				int op=obj.nextInt();
				if(op==1)
				{
					int exit=0;
					do {
					System.out.println("1.View Products\n2.Bill Products\n3.View Bills\n4.Exit\nEnter operation to perform");
					op=obj.nextInt();
					if(op==1)
						market.showProducts();
					else if(op==2)
					{
						int add=1;
						Bill billObj=new Bill(billId);
						do
						{
							if(add==1)
							{
							System.out.println("Enter product id to add");
							String id=obj.next();
							System.out.println("Enter quantity");
							int qnty=obj.nextInt();
							billObj.addProduct(market,id,qnty);
							}
							if(add==2)
							{
								System.out.println("Enter product_id to remove");
								String id=obj.next();
								billObj.removeProduct(id);
							}
							System.out.println("Enter 1 to add product to bill or Enter 2 to remove billproduct or Enter 3 to printBill");
							add=obj.nextInt();
						}while(add!=3);
						int total=billObj.printBill();
						market.calculateCredit(email,total);
						market.addBill(billObj,billId,email);
						billId++;
					}
					else if(op==3)
					{
						market.showBillHistory(email);
					}
					else if(op==4)
						exit=1;
					}while(exit==0);
				}
				else
					logout=1;
				}
				}
				else
				{
					int logout=0;
					while(logout==0)
					{
					System.out.println("\nEnter 1 for operation menu or Enter 2 for logout");
					int op=obj.nextInt();
					if(op==1)
					{
						int exit=0;
						do {
						System.out.println("\n1.View Products\n2.Add Products\n3.Edits Product\n4.Remove product\n5.Add Admin\n6.Exit\nEnter operation no to perform");
						op=obj.nextInt();
						if(op==1)
							market.showProducts();
						else if(op==2)
						{
							System.out.println("Enter product_id ,product_name ,quantity ,price");
							String id=obj.next();
							String name=obj.next();
							int qnty=obj.nextInt();
							float rate=obj.nextFloat();
							market.addProduct(id,new Product(id,name,qnty,rate));
						}
						else if(op==3)
						{
							System.out.println("Enter product id");
							String id=obj.next();
							Product pObj=market.getProduct(id);
							System.out.println("Enter 1 to edit quantity or Enter 2 to edit price ");
							op=obj.nextInt();
							if(op==1)
							{
								System.out.println("enter new quantity");
								int qnty=obj.nextInt();								
								pObj.setQnty(qnty);
							}
							else
							{
								System.out.println("enter new price");
								float price=obj.nextFloat();								
								pObj.setPrice(price);	
							}
							
						}
						else if(op==4) {
							
							System.out.println("Enter Product id");
							if(market.removeProduct(obj.next()))
							{
								System.out.println("product removed");
							}
						}
						else if(op==5)
						{
							System.out.println("enter admin email & password");
							String adm_email=obj.next();
							String adm_pass=obj.next();
							if(market.addUser(adm_email,new User(adm_email,adm_pass,"admin")))
								System.out.println("admin created");
							else
								System.out.println("email already exist");
						}
						else if(op==6)
							exit=1;
						}while(exit==0);
					}
					else
						logout=1;
					}
				}
			}
			else
				System.out.println("Invalid login credentials");
		}
		else
		{
			System.out.println("Enter Email & password");
			String email=obj.next();
			String pass=obj.next();
			//String role=obj.next();
			if(market.addUser(email,new User(email,pass,"customer")))
			{
				System.out.println("SignUp Successful");
			}
			else
				System.out.println("Email already exist");
		}
		}
		
	}

}
