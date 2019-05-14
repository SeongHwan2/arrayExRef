package com.y0513;

import java.util.Scanner;

public class 이강미 {

	public static void main(String[] args) {
		이강미 강미 = new 이강미();
		강미.move();
	}
	int map[][] = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,2,0,0,1,1,0,1,0},
			{0,1,1,2,0,1,0,1,1,0},
			{0,1,1,0,2,1,1,0,1,0},
			{0,1,1,0,1,2,0,0,1,0},
			{0,1,0,1,1,0,2,0,1,0},
			{0,1,0,1,0,0,1,2,1,0},
			{0,1,1,1,1,1,1,0,1,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	int x, y, bY, bX;
	int count = 0;
	public boolean map(int y, int x, int bY, int bX) {
		
		boolean check = false;
		if(map[y][x] == 0) {
			check = true;
			return check;
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(i==y && j==x) {
					System.out.print(" ㉿");
				}else {
					if(map[i][j] == 0) {
						System.out.print(" ■");
					}else if(map[i][j] == 2) {
							System.out.print(" ♥");
					}else if(map[i][j] == 1) {
						System.out.print(" □");
					}
				}
					
			}
			System.out.println();
		}
		return check;
		
	}
	public void move() {
		Scanner scan = new Scanner(System.in);
		 y = 1;
		 x = 1;
		 bY = 1; 
		 bX = 1;
		map(y,x,bY,bX);
		
		while(true) {
			String input = scan.next();
			switch(input.toUpperCase()) {
			case "W":
				y--;
				break;
			case "S":
				y++;
				break;
			case "A":
				x--;
				break;
			case "D":
				x++;
				break;
			default:
				break;
			}
			
			if(map(y,x,bY,bX)) {
				y = bY;
				x = bX;
				
			}else {
				bY = y;
				bX = x;
			}
			
			if(map[y][x] ==2) {
				map[y][x] = 1;
				count++;
			}else if (y==8 && x== 8 && count == 6) {
				break;
			}else if(y==8 && x == 8){
				System.out.println("하트를 다 먹고 오세요");
			}
//			map(y,x,bY,bX);
//			System.out.println(count);
		}
	}
}
