import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailSearch{

  public static void main(String[] args){
	  String[] arr = {"test@gmail.com", "abc@gmail.com", "myemail@yahoo.com", "newemail@yahoo.com", "newemail@orkut.com"};
	  ArrayList resarr = new ArrayList<String>();
	  String str = takeInput();
	  
	  for(String email: arr) {
		  if(str==email || email.indexOf(str)!=-1) {
			  resarr.add(email);
		  }
	  }
	  
	  if(resarr.size()!=0) {
		  System.out.println("Your searched emails are : ");
		  System.out.println(resarr);
	  }else {
		  System.out.println("No email found for your serach. Try again.");
	  }
  }

  private static String takeInput(){
    Scanner scan = new Scanner(System.in);
	System.out.print("Enter the email : ");
    String str = scan.nextLine();
    if(validate(str)){
    	scan.close();
    	return str;
    }else{
      System.out.println("Invalid Email Address. Enter email again.");
      return takeInput();
    }
  }

  private static boolean validate(String str){
    String regex = "^(.+)@(.+)$";
    Pattern pattrn = Pattern.compile(regex);
    Matcher match = pattrn.matcher(str);
	  return match.matches();
  }

}