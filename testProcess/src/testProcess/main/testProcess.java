package testProcess.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testProcess {

	public static void main(String[] args) throws ParseException {
//	      try {
//
//	         // create a new array of 2 strings
//	         String[] cmdArray = new String[2];
//
//	         // first argument is the program we want to open
//	         cmdArray[0] = "notepad.exe";
//
//	         // second argument is a txt file we want to open with notepad
//	         cmdArray[1] = "C:/Users/Arkadiusz/Desktop/example.txt";
//
//	         // print a message
//	         System.out.println("Executing notepad.exe and opening example.txt");
//
//	         // create a process and execute cmdArray and currect environment
//	         Process process = Runtime.getRuntime().exec(cmdArray,null);
//
//	         // print another message
//	         System.out.println("example.txt should now open.");
//	      } catch (Exception ex) {
//	         ex.printStackTrace();
//	      }
		
		Date simpleDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(dateFormat.format(simpleDate));
		
	   }
}
