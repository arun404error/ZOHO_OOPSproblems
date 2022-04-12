package supermarket;
import supermarket.*;
import java.util.*;

public class User {
private String email,password,role;
private int credit=1000;

Scanner obj=new Scanner(System.in);
Main mainObj=new Main(); 

public String getPassword()
{
	return password;
}
public String getRole()
{
	return role;
}
public int getCredit()
{
	return credit;
}
public void setCredit(int amt)
{
	credit=amt;
}

User(String a,String b,String c)
{
	email=a;
	password=b;
	role=c;
}



}









