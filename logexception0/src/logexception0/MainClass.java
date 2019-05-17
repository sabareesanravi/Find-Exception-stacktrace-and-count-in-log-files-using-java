package logexception1;
import java.util.*;
public class MainClass {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		searchForexception searchObj=new searchForexception();
		try{
		
			boolean out=true;
			
			while(true)
			{
			System.out.println("Enter folder path having log files");
			String pathName="";
			pathName=sc.nextLine();
			System.out.println("Enter exception name 1 to exit ");
			String exceptionName="";

			exceptionName=sc.nextLine();
			if(exceptionName.equals(""))
			{
				exceptionName=sc.nextLine();
			}
			if(exceptionName.charAt(0)=='1')
			{
				break;
			}
			out=true;
			while(out)
			{
			
			System.out.println("Enter choice 1.print line 2.print stacktrace 3.count 4.close");
			int choice=sc.nextInt();
			
			out=searchObj.openFolder(choice, exceptionName,pathName);
			
			}
			
			}
		}
		catch(Exception e){
			System.out.println("invalid input");
		}
		finally{
			sc.close();
		}
	}
}
