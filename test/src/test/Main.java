package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Long milli = System.currentTimeMillis();
		
		System.out.println("Enter 1 for start ");
		
		int second=0;
		
		int minuts=0;
		
		int hour=0;
		System.out.println("Enter 2 for pause");
		
		System.out.println("Enter 3 for end");
		
		StringBuffer sb=new StringBuffer();
		if(sc.nextInt()==1) {
			if(sc.nextInt()!=3) {
				if(sc.nextInt() == 2) {
					System.out.println(sb);
				}else {
					milli = System.currentTimeMillis();
					if(milli == 1000) {
						second++;
						milli=0L;
						
						if(second==60) {
							minuts++;
							second=0;
							if(minuts==60) {
								hour++;
								minuts=0;
							}
						}
					}
					sb.append(hour+":"+minuts+":" +second);
					System.out.println(sb);
				}
				
			}
			
		}else {
			System.out.println("please press 1 for start the timer");
		}
		
		
		
		System.out.println(milli);
	}
	

}
