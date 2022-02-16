import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSCD437RegExMethods
{ 
      
	public static void easySSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      boolean res = false;

      Pattern p = Pattern.compile("[0-9-_]");
      Matcher m = p.matcher(str);
      res = m.find();
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());   				
	}// end easySSN
   
   
   public static void mediumEasySSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
     				
	}// end mediumEasySSN
   
   
   public static void newSSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      
				
	}// end newSSN


   public static void phonePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
        
	}// end phoneNumber


	public static void emailPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      

	}// end email
   
   
	public static void namePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      
   
	}// end name
	
   
   public static void datePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
         
      

	}// end date
	
   
   public static void addressPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      

	}// end address
	
   
   public static void cityStateZipPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}//end cityStateZip
	
   
   public static void militaryTimePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end militaryTime
	
   
   public static void moneyPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end money
	
   
   public static void urlPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end URL
	
   
   public static void passwordPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end password
	
   
   public static void oddIonPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end oddIon

}// end class
