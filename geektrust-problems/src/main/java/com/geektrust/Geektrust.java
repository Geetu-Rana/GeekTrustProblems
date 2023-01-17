package com.geektrust;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Geektrust {
	
	public void print(Map<String, Fastag> colMap ) {
		int total_fastTagCol = 0;
		int totalDiscount = 0; 
		int total_CashColl = 0;
		int total_CashFeeColl = 0;
		Map<String,VhicleCategory> vhicleTypeMap = new HashMap<>();
		List<VhicleCategory> vList = new ArrayList<>();
		
		
		for(String key : colMap.keySet()) {
			Fastag fastag = colMap.get(key);
			total_fastTagCol +=fastag.getTotalAmtColViaFastag();
			totalDiscount += fastag.getTotaldiscount();
			total_CashColl += fastag.getTotalAmtColViaCash();
			total_CashFeeColl += fastag.getFlatFeeForCashPay();
			String vhicleType = fastag.getVehicle_type();
			//System.out.println(vhicleType);
			if(vhicleTypeMap.containsKey(vhicleType)) {
				
				VhicleCategory vCat = vhicleTypeMap.get(vhicleType);
				vCat.setTotalTollPaid(vCat.getTotalTollPaid()+fastag.getTotalAmtColViaCash()+fastag.getTotalAmtColViaFastag()+fastag.getFlatFeeForCashPay());
				vCat.setTotalvhicle(vCat.getTotalvhicle()+fastag.getNumberOfTollCharged());
				vhicleTypeMap.put(vhicleType,vCat);
			//	System.out.println(vhicleTypeMap);
			}else {
				VhicleCategory vCat = new VhicleCategory();
				//System.out.println(key);
				vCat.setVhicleCategory(vhicleType);
				vCat.setTotalTollPaid(fastag.getTotalAmtColViaCash()+fastag.getTotalAmtColViaFastag()+fastag.getFlatFeeForCashPay());
				vCat.setTotalvhicle(fastag.getNumberOfTollCharged());
				vhicleTypeMap.put(vhicleType, vCat);
				
			}
		}
		
		//Collections.sort(vhicleTypeMap);
		
		System.out.println("TOTAL_COLLECTION "+ (total_fastTagCol+total_CashColl+total_CashFeeColl) +" "+ totalDiscount);
		System.out.println("PAYMENT_SUMMARY " + total_fastTagCol +" "+ (total_CashColl+total_CashFeeColl));
		System.out.println("VEHICLE_TYPE_SUMMARY");
		for(String key : vhicleTypeMap.keySet()) {
			vList.add(vhicleTypeMap.get(key));
		}
		Collections.sort(vList,new VhicleSorting());
		for(VhicleCategory v : vList) {
			//v.getTotalTollPaid();
			System.out.println(v.getVhicleCategory()+" "+ v.getTotalvhicle());
		}
	
	}
 
	
    public static void main(String[] args)  {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("sample_input/input5.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            Map<String, Integer> balanceMap = new HashMap<>();
            Map<String, Fastag> collectionToll = new HashMap<>();
            
            while (sc.hasNextLine()) {
               String inputCommand = sc.nextLine();
               String[] arr = inputCommand.split(" ");
               //Add your code here to process input commands.
               if(arr[0].equals("FASTAG")) {
            	   if(balanceMap.containsKey(arr[1])) {
            		   balanceMap.put(arr[1], balanceMap.get(arr[1])+Integer.parseInt(arr[2].trim()));
            	   }else {
            		   balanceMap.put(arr[1], Integer.parseInt(arr[2].trim()));
            	   }
               }else if(arr[0].equals("COLLECT_TOLL")) {
            	  if(collectionToll.containsKey(arr[2])) {
            		  Fastag obj = collectionToll.get(arr[2]);
            		  obj.collectToll();
            		  obj.setNumberOfTollCharged(obj.getNumberOfTollCharged()+1);
            		  collectionToll.put(arr[2], obj);
            	  }else {
            		  
            		  Fastag obj = new Fastag();
            		  if(balanceMap.containsKey(arr[2])) {
            			//  System.out.println(arr[2]);
            			  obj.setFastagBalance(balanceMap.get(arr[2]));
            		  }
            		  obj.setVehicle_number(arr[2]);
            		  obj.setVehicle_type(arr[1]);
            		  obj.collectToll();
            		  obj.setReverseJourney(true);
            		  obj.setNumberOfTollCharged(1);
            		  collectionToll.put(arr[2], obj);
            		  
            	  }
               }else{
            	   Geektrust geek = new Geektrust();
            	   geek.print(collectionToll);
               }
   
            }
          //  System.out.println(collectionToll);
            sc.close(); // closes the scanner
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        } catch (NoVehicleTypeFound e) {
			// TODO Auto-generated catch block
        	System.out.println("No Vehicle type registered");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
