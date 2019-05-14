package com.java0509;

import java.util.Scanner;

public class 문제4 {
	int count = 0;
	int Map[][] = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,2,0,0,1,1,0,1,0},
			{0,1,1,2,0,1,0,1,1,0},
			{0,1,1,0,2,1,1,0,1,0},
			{0,1,1,0,1,2,0,1,1,0},
			{0,1,0,1,1,0,2,1,1,0},
			{0,1,0,1,0,0,1,2,1,0},
			{0,1,1,1,1,1,1,0,1,0},
			{0,0,0,0,0,0,0,0,0,0},	
	};
	
	public void game_s() {
		Scanner scan = new Scanner(System.in);		
		int aX =1;
		int aY =1;
		int bX =1;
		int bY =1;
		
		game(aX,aY,bX,bY);
		while(true) {
			String input = scan.next();
			switch(input.toUpperCase()) {
			case "W" :
				aY--;
				break;
			case "S" :
				aY++;
				break;	
			case "A" :
				aX--;
				break;
			case "D" :
				aX++;
				break;
			default :
				break;
			}
			
			System.out.println(aX + "," + aY + "," + bX + "," + bY);
			if(game(aX,aY,bX,bY)) {
				aX = bX;
				aY = bY;
			}else {
				bX = aX;
				bY = aY;
			}
			


			
			if((aX == 8 && aY == 8) && count == 6) {
				System.out.println(" E nd . 먹은 횟수 : " + count); 
				break;
			}
			else if ((aX == 8 && aY == 8) && count < 6) {
				System.out.println(" 다시. 안돼. 먹은 횟수 : " + count);
			
			}
		}
	}
	
	public boolean game(int aX, int aY, int bX, int bY) {
		boolean result = false;
		
		for(int i = 0; i < Map.length; i++) {
			for(int j = 0; j < Map[i].length; j++) {
				
				if(Map[aY][aX] == 0) {
					aX = bX;
					aY = bY;
					result = true;
				}
				else if(Map[aY][aX] == 2) {
					System.out.println("하트 적립");	
					count++;
					Map[aX][aY] = 1;
								
				}
				if(i == aY && j == aX) {
					System.out.print(" ♠ ");
				}else if(Map[i][j] == 1) {
					System.out.print(" □ ");
				}else if(Map[i][j] == 2){
					System.out.print(" ♥ ");
				}else if(Map[i][j] == 3) {
					System.out.print(" ♣ ");
				}else if(Map[i][j] == 0){
					System.out.print(" ■ ");
				}
			}
			System.out.println();
		}
		return result;
	}
}

