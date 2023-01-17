import java.io.*;
import java.util.Scanner;

public class Geektrust {
	
	Solution solution=new Solution();
	
	public void func(String[] arr) {
		if(arr[0].equals("FASTAG")) {
     	   solution.registrFastTag(arr[1],Integer.parseInt(arr[2]));
        }
        else if(arr[0].equals("COLLECT_TOLL")) {
        	solution.collect(solution.getFast(arr[2]), solution.getVehicle(arr[1]));
        }
        else if(arr[0].equals("PRINT_COLLECTION")) {
     	   solution.PrintCollection();
        }
	}

	public static void main(String[] args) {
		
		Geektrust gt=new Geektrust();
		
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); 
            
            while (sc.hasNextLine()) {
            	
               String inputCommand = sc.nextLine();
               String [] arr=inputCommand.split(" ");
               
               gt.func(arr);
            }
            sc.close(); 
        } catch (IOException e) {}

	}

}
