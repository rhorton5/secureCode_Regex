//Ryley Horton
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSCD437RegExMethods
{ 	
	private static boolean checkRegex(final String str, final String regex){
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(str);
      return m.matches();
   }
	
	private static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	private static boolean isValidDate(final String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(str);
			String [] data = str.split("[-/]");
			int month = Integer.parseInt(data[0]);
			int day = Integer.parseInt(data[1]);
			int year = Integer.parseInt(data[2]);
			boolean leapYear = isLeapYear(year);
			if(month == 2 && day > 29 && leapYear)
				return false;
			else if(month == 2 && day > 28 && !leapYear)
				return false;
			return month <= 12; //There probably is a better approach to this, but found difficulty using regex to solve this portion of the dates regexs.
		}catch(Exception e) {
			return false;
		}
	}
	
	private static boolean isValidPassword(final String str) {
		for(int i = 0; i < str.length() - 4; i++) {
			String value = (str.substring(i,i+1).matches("[^0-9a-zA-Z]")) ? "\\" + str.substring(i,i+1) : str.substring(i,i+1);
			if(checkRegex(str.substring(i, i+4),value + "{4}"))
				return false;
		}
		return true;
			
	}
	
	private static boolean isValidStreetBuilding(final String str) {
		return checkRegex(
				str.substring(
						str.lastIndexOf(' ')).toLowerCase().trim(),
				"rd|st|blvd|ave|road|street|boulevard|avenue|drive|lane|court|place|terrace|way"
				); //lowercase versions of the word used to minimize the number of values that needs to be looked for.
	}
	
	private static boolean isUSState(final String str) {
		int lastSpace = str.lastIndexOf(" ");
		String state = str.substring(lastSpace - 2, lastSpace);
		return checkRegex(
				state,
				"(AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY)"
		);
	}
   
   public static void easySSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      boolean res = false;

      res = checkRegex(str,"([\\s\\-]{0,}\\d[\\s\\-]{0,}){9}");
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());   				
	}// end easySSN
   
   
   public static void mediumEasySSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      res = checkRegex(str,"[0-9]{3}[\\s-]?[0-9]{2}[\\s-]?[0-9]{4}");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
     				
	}// end mediumEasySSN
   
   
   public static void newSSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"(?!9|666|000|.{3,5}00|.{4,7}0000)(\\d{5}[\\s-]\\d{4}|\\d{9}|\\d{3}[\\s-]\\d{2}[\\s-]\\d{4})");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      
				
	}// end newSSN


   public static void phonePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      res = checkRegex(str,"^(\\+1\\s)?(\\d{3}|\\(\\d{3}\\))[-\\s]?\\d{3}[-]?\\d{4}");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
        
	}// end phoneNumber


	public static void emailPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"(?!.*@@.*|.*@.*@)[a-zA-Z0-9]+([!#$%&'*+-\\/=?^_`{|}~.][a-zA-Z0-9]+){0,}[a-zA-Z0-9]?\\@([a-zA-Z]+\\.){1,}(gov|com|edu|org|net)");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      

	}// end email
   
   
	public static void namePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      res = checkRegex(str,"(([a-zA-Z]+[-\\s']?[a-zA-Z]+)+,\\s){1,2}(([a-zA-Z]+[-\\s']?)+)");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      
   
	}// end name
	
   
   public static void datePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"([01]?[0-9]\\/[0-2]?[0-9]\\/\\d{4}|[01]?[0-9]-[0-2]?[0-9]-\\d{4})") && isValidDate(str.replaceAll("[-.]","/"));
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
         
      

	}// end date
	
   
   public static void addressPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      res = checkRegex(str,"^(?!^[0-9]+\\s[0-9][0-9])([0-9]+\\s{0,}-\\s{0,}[0-9]+|[0-9]+)\\s([\\w][a-zA-Z]+\\s)+[A-Z-a-z]+") && isValidStreetBuilding(str);
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      

	}// end address
	
   
   public static void cityStateZipPattern(final String str, final PrintStream fout)
	{
      //States must be hard coded.
	   if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"(?!.*\\s\\s.*)(\\w+|\\w+\\s)+,?\\s?[A-Z]{2}\\s\\d{5}") && isUSState(str);
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}//end cityStateZip
	
   
   public static void militaryTimePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"([0-1][\\d]|[2][0-3]):[0-5]\\d:[0-5]\\d");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end militaryTime
	
   
   public static void moneyPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"-?\\$((\\d{1,3},)(\\d{3},){0,}(\\d{3})+\\.\\d{2}|\\d{1,3}.\\d{2})");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end money
	
   
   public static void urlPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      res = checkRegex(str,"^(http[s]?:\\/\\/|HTTP[S]?:\\/\\/)?(?!.*--)([0-9a-z_-]{2,}\\.){2,}([a-z_-]{2,})(\\/[0-9a-z_-]{2,}){0,}");
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end URL
	
   
   public static void passwordPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9])(?!\\s+$).{10,}") && isValidPassword(str);
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end password
	
   
   public static void oddIonPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      res = str.length() % 2 == 1 && checkRegex(str,"[a-zA-Z]*ion$");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end oddIon
   

}// end class
