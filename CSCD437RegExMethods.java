import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSCD437RegExMethods
{ 
      
	final private static String easySSNRegex = "[0-9-_]{9}",
								mediumEasySSNRegex = "[0-9]{3}[\\s-]?[0-9]+[\\s-]?[0-9]{4}",
								emailRegex = "[0-9a-zA-Z]*[.]?@[0-9a-z]+[.]{1}+[0-9a-z]+"; //Try Binding...
	
	private static boolean checkRegex(final String str, final String regex){
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(str);
      return m.find();
   }
	
	private static boolean checkNewSSNPatternRules(final String str) {
		/*
		 * 
		 * Rules:
		 * No 666 as the stating values
		 * No 000 as the starting values
		 * No 00 in 4-5
		 * No 0000 at the end
		 */
		
		//dashes or space can appear on position 
		if(!Character.isDigit(str.charAt(3)) && str.charAt(3) != str.charAt(6))
			return false;
		
		return !str.substring(0, 2).equals("666") && !str.substring(0, 2).equals("000") 
				&& !str.substring(3,4).equals("44") && !str.substring(4).equals("0000");
	}
	
	private static boolean isValidDate(final String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		try {
			sdf.parse(str);
			return true; //Check Again
		}catch(Exception e) {
			return false;
		}
	}
	
	private static boolean isValidPassword(final String str) {
		for(int i = 0; i < str.length() - 3; i++) {
			if(checkRegex(str.substring(i, i+3),"[a-z]{3}"))
				return false;
		}
		return true;
			
	}
	
	private static boolean isUSState(final String str) {
		int lastSpace = str.lastIndexOf(" ");
		String state = str.substring(lastSpace - 2, lastSpace);
		return checkRegex(state,"(AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY)");
		
		
	}
   
   public static void easySSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
      boolean res = false;

      res = checkRegex(str,easySSNRegex);
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());   				
	}// end easySSN
   
   
   public static void mediumEasySSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      res = checkRegex(str,mediumEasySSNRegex);
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
     				
	}// end mediumEasySSN
   
   
   public static void newSSNPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"(\\d{5}[\\s-]\\d{4}|\\d{9}|\\d{3}[\\s-]\\d{2}[\\s-]\\d{4})") && checkNewSSNPatternRules(str);
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      
				
	}// end newSSN


   public static void phonePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      res = checkRegex(str,"(\\+1\\s)?(\\d{3}-?\\d{3}-?\\d{4}|\\d{9})"); //Rework.
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
        
	}// end phoneNumber


	public static void emailPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,emailRegex);
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      

	}// end email
   
   
	public static void namePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      res = checkRegex(str,"(([A-Z]|m')\\w+([- ]|[^- ])\\w+,\\s)((m'|\\w)\\w+([- ]|[^- ])\\w+)(,\\s(\\w+[- ]?\\w+|\\w))?");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      
   
	}// end name
	
   
   public static void datePattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"(([\\d]{2}|\\d)(/|.|-)){2}[\\d]{4}") && isValidDate(str.replaceAll("[-.]","/"));
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
         
      

	}// end date
	
   
   public static void addressPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;

      res = checkRegex(str,"(\\d+|\\d+[-]\\d+)\\s(([A-Z][a-z]+|[A-Z]+|[a-z]+)\\s)+");
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());
         
      

	}// end address
	
   
   public static void cityStateZipPattern(final String str, final PrintStream fout)
	{
      //States must be hard coded.
	   if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"[A-Za-z\\s]+(\\s|,\\s)[A-Z]{2}\\s\\d{5}") && isUSState(str);
      
      
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
      
      res = checkRegex(str,"-?\\$(\\d{1,3},)(\\d{3},){0,}(\\d{3})+\\.\\d{2}");
      
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end money
	
   
   public static void urlPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
         
      boolean res = false;
      
      res = checkRegex(str,"^(http://|https://)?(?!.*--)([0-9a-z_-]{2,}\\.){2}([a-z_-]{2,})(/[0-9a-z_-]{2,}){0,}");
      
      fout.printf("The string %s is %s %s\n\n", str, res == true ? "a valid" : "NOT a valid", new CSCD437RegExMethods(){}.getClass().getEnclosingMethod().getName());

	}// end URL
	
   
   public static void passwordPattern(final String str, final PrintStream fout)
	{
      if(str == null || str.isEmpty())
         throw new IllegalArgumentException("Bad str Parameter to the method");
         
      boolean res = false;
      
      res = checkRegex(str,"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W)(?=\\S+$).{10}$") && isValidPassword(str);
      
      
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
