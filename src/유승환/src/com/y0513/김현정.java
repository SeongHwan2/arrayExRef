package com.y0513;

import java.util.Scanner;

public class 김현정 {
	
			int[][] map = {
					{0,0,0,0,0,0,0},
					{1,1,1,1,1,1,0},
					{0,1,0,0,0,1,0},
					{0,1,0,1,1,0,0},
					{0,1,0,0,1,0,0},
					{0,1,0,1,1,1,1},
					{0,0,0,0,0,0,0},
			};
	
			
	public boolean map(int y, int x, int bY, int bX) {
		boolean check = false;
		if(x < 0 || x > 6 ||map[y][x] == 0) {
			check = true;
			return check;
		}
		if(y == 3 && x == 3) {
			y = 1;
			x = 0;
			bY = 1;
			bX = 0;
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(i == y && j == x) {
					System.out.print(" ㉿ \t");
				}else if(map[i][j] == 0) {
					 if(y==2 && x==5) {
						 map[5][2] = 1;
				}
					System.out.print(" ■ \t");
				}else if(map[i][j] == 1) {
					
					System.out.print(" □ \t");
				}
			}
			System.out.println();
		}
		return check;
	}
	
	public void move() {
		int y = 1;
		int x = 0;
		int bY = 1;
		int bX = 0;
		map(y,x,bY,bX);
		Scanner scan = new Scanner(System.in);
		
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
//				map(y,x,bY,bX);
			}else {
				bY = y;
				bX = x;
			}
			
			if(y == 3 && x == 3) {
				y = 1;
				x = 0;
				bY = 1;
				bX = 0;
			}else if(y == 5 && x == 6) {
				System.out.println("끝");
				break;
			}
		}
	}
	public void start() {
		move();
	}
}
	

