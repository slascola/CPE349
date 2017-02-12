import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Math;
public class FactoryProblem {
	public static void main(String args[]) {
		int stations = 0;
		int[] enters = new int[2];
		int[] autoExits = new int[2];
		int[] station1, station2, timeStation1, timeStation2;
		
		 System.out.println("Enter the input file name: ");
	        Scanner input = new Scanner(System.in);
	        File inputFile = new File(input.nextLine());

	        try {
	        	input = new Scanner(inputFile);
	        }
	        catch(FileNotFoundException e) {
	            e.printStackTrace();
	        }

	        String firstLine = input.nextLine();
	        stations = Integer.parseInt(firstLine);
	        
	        String secondLine = input.nextLine();  
	        String[] strArray = secondLine.split(" ");
	        enters[0] = Integer.parseInt(strArray[0]);
	        enters[1] = Integer.parseInt(strArray[1]);
	        
	        String thirdLine = input.nextLine();  
	        String[] strArray2 = thirdLine.split(" ");
	        autoExits[0] = Integer.parseInt(strArray2[0]);
	        autoExits[1] = Integer.parseInt(strArray2[1]);
	        
	        String fourthLine = input.nextLine();
	        String[] strArray3 = fourthLine.split(" ");
	        station1 = new int[stations];
	        for (int i = 0; i < stations; i++) {
	        	station1[i] = Integer.parseInt(strArray3[i]);
	        }
	        
	        String fifthLine = input.nextLine();
	        String[] strArray4 = fifthLine.split(" ");
	        station2 = new int[stations];
	        for (int i = 0; i < stations; i++) {
	        	station2[i] = Integer.parseInt(strArray4[i]);
	        }
	        
	        String sixthLine = input.nextLine();
	        String[] strArray5 = sixthLine.split(" ");
	        timeStation1 = new int[stations - 1];
	        for (int i = 0; i < stations - 1; i++) {
	        	timeStation1[i] = Integer.parseInt(strArray5[i]);
	        }
	        
	        String seventhLine = input.nextLine();
	        String[] strArray6 = seventhLine.split(" ");
	        timeStation2 = new int[stations - 1];
	        for (int i = 0; i < stations - 1; i++) {
	        	timeStation2[i] = Integer.parseInt(strArray6[i]);
	        }
	        
//	        System.out.println("Stations: " + stations);
//	        System.out.println("Enters: " + Arrays.toString(enters));
//	        System.out.println("Exits: " + Arrays.toString(autoExits));
//	        System.out.println("Station 1: " + Arrays.toString(station1));
//	        System.out.println("Station 2: " + Arrays.toString(station2));
//	        System.out.println("Time 1: " + Arrays.toString(timeStation1));
//	        System.out.println("Time 2: " + Arrays.toString(timeStation2));
	        
	        int[][][] lines = new int[2][2][stations]; 
	        lines = assemblyLine(enters, autoExits, station1, station2, timeStation1, timeStation2);
	        printStations(lines, stations);
	        
	         
	}
	
	public static int[][][] assemblyLine(int[] enters, int[] autoExits, int[] station1,
	 int[] station2, int[] timeStation1, int[] timeStation2) {
		int time = 0;
		int numStations = station1.length;
		int[][][] lines = new int[2][2][numStations];
		int[] finalTime1 = new int[numStations];
		int[] finalTime2 = new int[numStations];
		
		finalTime1[0] = enters[0] + station1[0];
		finalTime2[0] = enters[1] + station2[0];
		
		lines[1][0][0] = 1;
		lines[1][1][0] = 1;
		
		for (int i = 1; i < numStations; i++)
		{
			if (finalTime1[i-1] + station1[i] <= finalTime2[i-1] + timeStation2[i-1] + station1[i])
			{
				finalTime1[i] = finalTime1[i-1] + station1[i];
				lines[1][0][i] = 1;
			}
			else {
				finalTime1[i] = finalTime2[i-1] + timeStation2[i-1] + station1[i];
				lines[1][0][i] = 2;
			}
//			finalTime1[i] = Math.min(finalTime1[i-1] + station1[i], finalTime2[i-1] + timeStation2[i-1] + station1[i]);
			if (finalTime2[i-1] + station2[i] <= finalTime1[i-1] + timeStation1[i-1] + station2[i]) {
				finalTime2[i] = finalTime2[i-1] + station2[i];
				lines[1][1][i] = 2;
			}
			else {
				finalTime2[i] = finalTime1[i-1] + timeStation1[i-1] + station2[i];
				lines[1][1][i] = 1;
			}
//			finalTime2[i] = Math.min(finalTime2[i-1] + station2[i], finalTime1[i-1] + timeStation1[i-1] + station2[i]);
		}
		if (finalTime1[numStations - 1] + autoExits[0] <= finalTime2[numStations - 1] + autoExits[1]) {
			time = finalTime1[numStations - 1] + autoExits[0];
			lines[0][0][0] = 1;
		}
		else {
			time = finalTime2[numStations - 1] + autoExits[1];
			lines[0][0][0] = 2;
		}
		
		
//		minTime = Math.min(finalTime1[numStations - 1] + autoExits[0], finalTime2[numStations - 1] + autoExits[1]);
		System.out.println("Fastest time is: " + time);
		System.out.println();
 		return lines;
	}
	
	private static void printStations(int[][][] lines, int stations) {
		int[] correctLines = new int[stations];
        int i = stations - 1;
        int j = 1;
        correctLines[0] = lines[0][0][0];
        while (i >= 0 && j < stations) {
        	if (correctLines[j - 1] == 1) {
        		correctLines[j] = lines[1][0][i];
        	}
        	else {
        		correctLines[j] = lines[1][1][i];
        	}
        	i--;
        	j++;
        }
        int count = 1;
        System.out.println("The optimal route is: ");
        for (int k = stations - 1; k >= 0; k--) {
        	System.out.println("station " + count + "," + " " + "line " + correctLines[k]);
        	count++;
        }
	}
	

}
