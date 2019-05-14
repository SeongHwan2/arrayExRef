package com.Test1;

import java.util.Scanner;

public class 지뢰찾기 {
	int aX = 1;
	int aY = 1;
	int bX = 1;
	int bY = 1;
	boolean result = true;
	String 응답 = "";
	int[][] 맵 = {
			{0,0,0,0,0,0,0,0,0,0},				//0=>벽
			{0,1,1,2,1,1,1,0,3,0},				//1=>이동가능
			{0,1,1,1,1,1,0,0,1,0},				//2=>지뢰
			{0,0,0,0,2,1,0,2,1,0},				//3=>골인
			{0,1,0,1,1,1,0,1,1,0},
			{0,1,1,1,1,2,0,1,2,0},
			{0,1,0,0,0,0,0,1,1,0},
			{0,1,1,2,1,1,1,0,1,0},
			{0,0,1,1,1,0,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0}
	};
	
	public boolean map(int aX,int aY, int bX, int bY) {
		
		boolean 벽 = false;
		
		for(int y = 0; y<맵.length; y++) {
			
			for(int x =0; x<맵[y].length;x++) {
				
				if(맵[aY][aX]==0) {
					aX=bX;
					aY=bY;
					벽 = true;
				}
				if(x==aX && y==aY) {
					System.out.print("◈"+"\t");
				}
				else if(맵[y][x]==0) {
					System.out.print("■"+"\t");
				}
				else if(맵[y][x]==1 || 맵[y][x]==2) {
					System.out.print("\t");
				}
				else if(맵[aY][aX]==2) {
					응답 = "사망하셨습니다.";
					result = false;
					break;
				}
				else if(맵[aY][aX]==3) {
					응답 = "축하합니다 생존하였습니다.";
					result = false;
					break;
				}
				else {
					System.out.print("골인"+"\t");
				}
				
			}
			System.out.println();
			System.out.println(응답);
		}
		return 벽;
	}
	public void consol() {
		map(1,1,1,1);
		Scanner scan = new Scanner(System.in);
		while(result) {
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
			default:
				break;
			}
			if(map(aX,aY,bX,bY)) {
					aX = bX;
					aY = bY;
			}else {	bX = aX;
					bY = aY;
			}
				
			}
		}
}
	


