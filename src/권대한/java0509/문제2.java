package com.java0509;

import java.util.Scanner;

public class 문제2 {

	int Count = 0;

	int [][] 맵 = {
			{0,0,0,0,0,0,0},
			{0,1,1,1,1,1,0},
			{0,1,0,3,0,1,0},
			{0,1,1,0,1,1,0},
			{0,0,1,1,1,0,0},
			{0,0,0,0,1,1,0},
			{0,0,0,0,0,0,0},			
	};
	public boolean game(int aX, int aY, int bX, int bY) {
	
		boolean result = false;

		
		for(int i = 0; i <맵.length; i++) {
			for(int j = 0; j < 맵[i].length; j++) {


		if(i == aY && j == aX) {
			System.out.print(" ♥ ");
		}		
		else if(맵[i][j] == 1) {
			System.out.print(" □ ");
		}
		else if(맵[i][j] == 3) {
			System.out.print(" ♠ ");

		}else { 
			System.out.print(" ■ ");
		}
		
	}
			System.out.println();
		}
		return result;
	}

	public void game_s(){
		Scanner scan = new Scanner(System.in);
		boolean result;
		int aX = 1;
		int aY = 1;
		int bX = 1;
		int bY = 1;
		game(aX,aY,bX,bY);
			
		while(true) {
			String input = scan.next();
			Count++;
			switch(input.toUpperCase()){
			case "W":
				aY--;
				break;
			case "S":
				aY++;
				break;
			case "A":
				aX--;
				break;
			case "D":
				aX++;
				break;

				
			}
			System.out.println(aX + "," + aY + ","+ bX + "," + bY);
			if(game(aX,aY,bX,bY)) {
				aX = bX;
				aY = bY;
			} else {
				bX = aX;
				bY = aY;
			}
			if(맵[aX][aY] == 0) {
				aY = bY;
				aX = bX;

			result = true;

			}
			else if(aX == 3 && aY == 2) {
				aY = 1;
				aX = 1;
				bY = 1;
				bX = 1;
				System.out.println(" 첨부터 다시 ");
				Count = 0;
			result = true;
			}
			if((aX == 5 && aY == 5) && Count == 8) {
				System.out.println("최단거리로 이동 하였습니다. 이동 횟수 : " + Count);
				break;
			}else if((aX == 5 && aY == 5) && Count > 8){
				System.out.println("최단거리로 이동하지 못했습니다. 이동 횟수 : " + Count);
			}
		}
	}
}

