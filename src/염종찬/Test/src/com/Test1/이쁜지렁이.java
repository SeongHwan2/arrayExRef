package com.Test1;

import java.util.Scanner;

public class 이쁜지렁이 {
	
	int aX = 1;									//플레이어 위치 전역변수 선언
	int aY = 1;
	int bX = 1;
	int bY = 1;
	boolean result = false;						
	boolean 게임종료 = true;						//게임종료용 변수 선언
	String 호출 = "";							//시스템 메세지 출력용 변수 선언
	boolean 꼬리1 = false;						//꼬리1 플래그 선언
	boolean 꼬리2 = false;						//꼬리2 플래그 선언
	boolean 꼬리3 = false;						//꼬리3 플래그 선언
	boolean 꼬리4 = false;						//꼬리4 플래그 선언
	boolean 꼬리5 = false;						//꼬리5 플래그 선언
	boolean 꼬리6 = false;						//꼬리6 플래그 선언
	boolean 꼬리7 = false;						//꼬리7 플래그 선언
	int tX1 =1;									//꼬리 위치 변수
	int tY1 =1;
	int tX2 =1;
	int tY2 =1;
	int tX3 =1;
	int tY3 =1;
	int tX4 =1;
	int tY4 =1;
	int tX5 =1;
	int tY5 =1;
	int tX6 =1;
	int tY6 =1;
	int tX7 =1;
	int tY7 =1;
	int count = 0;								//꼬리 갯수
	int[][] map = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,2,0}
	};
	int[][] 꼬리 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,3,1,1,1,0},
			{0,1,3,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,2,0}
	};
		
	public boolean 맵(int aX, int aY, int bX, int bY) {
		
		boolean 벽막기 = false;
		
		for(int y = 0; y<map.length; y++) {
			
			for(int x = 0; x<map[y].length; x++) {
				
				if(map[aY][aX] == 0) {
				aY=bY;
				aX=bX;
				호출 = "벽입니다.";
				벽막기 = true;
				}
				if(꼬리2 == true) {
					꼬리[tY3][tX3] = 1;
					tY3 = tY2;						
					tX3 = tX2;
					tY2 = tY1;						
					tX2 = tX1;
					꼬리[tY2][tX2] = 3;
					꼬리[tY3][tX3] = 3;
					
				}
				if(꼬리1 == true && 꼬리[aY][aX] == 3) {
					꼬리[aY][aX] = 1;
					if(꼬리2 == false) {
						꼬리2 = true;
						count++;
						호출 = "꼬리를 "+ count +"개 획득 하셨습니다.";
					}
				}
				if(꼬리1 == true) {
					꼬리[tY1][tX1] = 1;
					tY1 = bY;						//꼬리1의 위치값에 플레이어 이전위치 적용
					tX1 = bX;
					꼬리[tY1][tX1] = 3;
				}
				if(꼬리[aY][aX] == 3) {
					꼬리[aY][aX] = 1;
					if(꼬리1 == false) {
						꼬리1 = true;
						count++;
						호출 = "꼬리를 "+ count +"개 획득 하셨습니다.";
					}
				}
				
				if(aX == x && aY == y) {
					System.out.print("㉿"+"\t");	
				}else if(map[y][x] == 1 && 꼬리[y][x] == 3) {
						System.out.print("⊙"+"\t");
				}else if(map[y][x] == 1) {
					System.out.print("□"+"\t");	
				}else if(map[y][x] == 2){
					System.out.print("골"+"\t");
				}else {
					System.out.print("■"+"\t");
				}
				
			}System.out.println();
		}System.out.println(호출);
			호출 = "";
		return 벽막기;
	
	}
	
	public void consol() {
		Scanner scan = new Scanner(System.in);
		맵(1,1,1,1);
		while(게임종료) {
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
			if(맵(aX,aY,bX,bY)) {
				aX=bX;
				aY=bY;
			}else {
				bX=aX;
				bY=aY;
			}
		}
	}
	
}
