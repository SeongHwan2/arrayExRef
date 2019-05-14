package com.y0513;

import java.util.Scanner;

public class 노형래 {

	public static void main(String[] args) {
		노형래 no = new 노형래();
		no.move();
	}
	
	Scanner scan = new Scanner(System.in);
	
	int map[][] = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	
	int dd[][] = {
			{1,1},{2,8},{4,1},{7,1},{3,3},{6,3},{2,5},{5,5},{3,7},{6,7},{3,8},{5,8},{6,8}
	};
	
	int x, y, bY, bX;
	
	public void map(int y, int x, int bY, int bX) {
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				boolean check = true;
				for(int k = 0; k < dd.length; k++) {
					if(i == dd[k][0] && j == dd[k][1]) {
						System.out.print(" ●");
						check = false;
					}
				}if(check) {
					if(i==y && j==x) {
						System.out.print(" ㉿");
					}else if(map[i][j] == 0) {
						System.out.print(" ■");
					}else if(map[i][j] == 1) {
						System.out.print(" □");
					}	
				}
					
			}
			System.out.println();
		}
	}
				
	public void move() {
		y = 8;
		x = 4;
		bY = 8;
		bX = 4;
		map(y,x,bY,bX);
		while(true) {
			String input = scan.next();
			switch(input.toUpperCase()) {
			case "D":
				x++;
				break;
			case "A":
				x--;
				break;
			default:
				break;
			}
			boolean die = false;
			for(int i = 0; i < dd.length; i++) {
					dd[i][0] += 1; 
					
				if(dd[i][0] >= 9) {
						dd[i][0] -= 8;
				}else if(y==dd[i][0] && x==dd[i][1]) {
					die = true;
				}
				
			}
			map(y,x,bY,bX);
			if(die) {
				System.out.println("똥밟았어요!");
				break;
			}
		}
	}
}
		

				
				


