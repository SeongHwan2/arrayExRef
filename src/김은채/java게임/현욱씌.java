package com.java게임;

import java.util.Scanner;

public class 현욱씌 {//풀다말았어용..
	  int map[][] = {
	 			    {8,7,6,5,4,3,1,9,2},
	 				{5,4,3,2,1,9,7,6,8},
	 				{2,1,9,8,7,6,4,3,5},
	 				{1,9,8,7,6,5,3,2,4},
	 				{4,3,2,1,9,8,6,5,7},
	 				{7,6,5,4,3,2,9,8,1},
	 				{3,2,1,9,8,7,5,4,6},
	 				{6,5,4,3,2,1,8,7,9},
	 				{9,8,7,6,5,4,2,1,3}
	 	};
	  int map문제 [][] = {
				{8,0,6,0,0,3,0,9,0},
				{0,4,0,0,1,0,0,6,8},
				{2,0,0,8,7,0,0,0,5},
				{1,0,8,0,0,5,0,2,0},
				{0,3,0,1,0,0,0,5,0},
				{7,0,5,0,3,0,9,0,0},
				{0,2,1,0,0,7,0,4,0},
				{6,0,0,0,2,0,8,0,0},
				{0,8,7,6,0,4,0,0,3}
			};
	 	
	 	public boolean 스도쿠출력() {
	 		boolean result = true;
	 		for(int y=0; y<map.length; y++) {
	 			for(int x=0; x<map[y].length; x++) {
	 				System.out.print(map[y][x]);
	 			}
	 			System.out.println();
	 		}
	 		System.out.println();
	 		for(int i=0; i<map문제.length; i++) {
	 			for(int j=0; j<map문제[i].length; j++) {
	 					if(map문제[i][j]==0) {
 					System.out.print("○");
	 					}else{System.out.print(map문제[i][j]);
	 				}
 					
// 					if(ans==map[y][x]) {
// 			 			System.out.println("정답입니다.다음으로 넘어가세요");
 			 		}
	 			System.out.println();
	 			}
	 		
	 		return result;
	 	}

	 	Scanner sc=new Scanner(System.in);
	 	
	 	public boolean 스도쿠입력() {
	 		boolean result=true;
	 		
	 			스도쿠출력();
	 			int a=0;
	 			int b=0;
	 			int ans=0;
	 			System.out.println("행을 입력하시오");
	 			a = sc.nextInt();
	 			System.out.println("열을 입력하시오");
	 			b = sc.nextInt();
	 			System.out.println("값을 입력하시오");
	 			ans = sc.nextInt();
	 		
	 			if(ans==map[a][b]) {
	 				return result;
	 			}
	 			
 				 }

	 	}
