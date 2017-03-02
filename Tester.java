// Arya Karnik (akarnik@calpoly.edu), Stephanie Lascola (slascola@calpoly.edu)
// 03/03/17
// Project 4

import java.util.*;

public class Tester {
	 public static void main(String args[]) {
		 int[] result_DP;
		 int[] result_greedy;
		 int[] set1 = {100, 50, 25, 10, 5, 1};
		 int[] set2 = {100, 50, 20, 15, 10, 5, 3, 2, 1};
		 int[] set3 = {64, 32, 16, 8, 4, 2, 1};
		 int[] set4 = {100, 50, 25, 10, 1};
		 int[] set5 = {66, 35, 27, 18, 10, 1};
		 int count = 0;
		 
		 System.out.println("Testing change_DP and change_greedy algorithms");
		 result_DP = new int[6];
		 result_greedy = new int[6];
		 for (int i = 1; i <= 200; i++) {
			 result_DP = ChangeMaker.change_DP(i, set1);
			 result_greedy = ChangeMaker.change_greedy(i, set1);
			 
			 for (int j = 0; j < 6; j++) {
				 if (result_DP[j] == result_greedy[j]) {
					 count+=result_DP[j];
				 }
			 }
		 }
		
		 System.out.println("Testing set1: " + count + " matches in 200 tests");
		 
		 count = 0;
		 result_DP = new int[9];
		 result_greedy = new int[9];
		 for (int i = 1; i <= 200; i++) {
			 result_DP = ChangeMaker.change_DP(i, set2);
			 result_greedy = ChangeMaker.change_greedy(i, set2);
			 
			 for (int j = 0; j < 9; j++) {
				 if (result_DP[j] == result_greedy[j]) {
					 count+=result_DP[j];
				 }
			 }
		 }
		 System.out.println("Testing set2: " + count + " matches in 200 tests");
		 
		 count = 0;
		 result_DP = new int[7];
		 result_greedy = new int[7];
		 for (int i = 1; i <= 200; i++) {
			 result_DP = ChangeMaker.change_DP(i, set3);
			 result_greedy = ChangeMaker.change_greedy(i, set3);
			 
			 for (int j = 0; j < 7; j++) {
				 if (result_DP[j] == result_greedy[j]) {
					 count+=result_DP[j];
				 }
			 }
		 }
		 System.out.println("Testing set3: " + count + " matches in 200 tests");
		 
		 count = 0;
		 result_DP = new int[5];
		 result_greedy = new int[5];
		 for (int i = 1; i <= 200; i++) {
			 result_DP = ChangeMaker.change_DP(i, set4);
			 result_greedy = ChangeMaker.change_greedy(i, set4);
			 
			 for (int j = 0; j < 5; j++) {
				 if (result_DP[j] == result_greedy[j]) {
					 count+=result_DP[j];
				 }
			 }
		 }
		 System.out.println("Testing set4: " + count + " matches in 200 tests");
		 
		 count = 0;
		 result_DP = new int[6];
		 result_greedy = new int[6];
		 for (int i = 1; i <= 200; i++) {
			 result_DP = ChangeMaker.change_DP(i, set5);
			 result_greedy = ChangeMaker.change_greedy(i, set5);
			 
			 for (int j = 0; j < 6; j++) {
				 if (result_DP[j] == result_greedy[j]) {
					 count+=result_DP[j];
				 }
			 }
		 }
		 System.out.println("Testing set5: " + count + " matches in 200 tests");
	 }
}
	 
