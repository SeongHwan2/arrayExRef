package com.java0509;

import java.util.Scanner;

public class 문제3 {

	boolean a1 = false;
	
	int jump = 2;
	int c = 3;
	
	int [][] 맵 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,1,1,1,1,1,0},
			{0,1,0,1,0,0,1,0,1,0},
			{0,1,0,jump,0,1,1,0,1,0},
			{0,1,0,0,0,1,1,0,1,0},
			{0,1,0,1,0,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,0,0,1,0,0,1,0},
			{0,1,1,0,0,1,1,1,c,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	public boolean game(int aX, int aY, int bX, int bY) {

		boolean result = false;
		


	
	for(int i = 0; i < 맵.length; i++) {
		for(int j = 0; j< 맵[i].length; j++) {
			if(맵[aY][aX] == 0) {
				aX = bX;
				aY = bY;
				result = true;
			}
			if(i == aY && j == aX) {
				System.out.print(" ♥ ");
			}else if(맵[i][j] == 0) {
				System.out.print(" ■ ");
			}else if(맵[i][j] == 1) {
				System.out.print(" □ ");
			}else if(맵[i][j] == c) {
				System.out.print(" ♣ ");
			}else {
				System.out.print(" ♠ ");
			}
		}
			
		System.out.println();
	}
	return result;
	}
	public void game_s() {
		Scanner scan = new Scanner(System.in);
		int aX = 1;
		int aY = 1;
		int bX = 1;
		int bY = 1;
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
		}
		System.out.println(aX + "," + aY + "," + bX + "," + bY);
		if(game(aX,aY,bX,bY)) {
			aX = bX;
			aY = bY;
		}else {
			bX = aX;
			bY = aY;
		}
		if(aX == 3 && aY == 3) {
			System.out.println("문이열림");
			aX = 1;
			aY = 1;
			bX = 1;
			bY = 1;
			jump = 1;
			a1 = true;
		}
		if(맵[aX][aY] == c) {
			if(a1 == true) {
				System.out.println(" E nd !");
				return;
			} else if(a1 == false) {
				System.out.println(" 문이 열리지 않앗습니다. 다시 ");
				aX = 1;
				aY = 1;
			}
		}
		}
	}
	
}
