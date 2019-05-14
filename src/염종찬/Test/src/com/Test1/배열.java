package com.Test1;

import java.util.Scanner;


public class 배열 {
	
	int aX = 4;
	int aY = 8;
	int bX = 4;
	int bY = 8;
	int mX = 1;
	int mY = 1;
	int count = 1;
	
	public void consol() {
		@SuppressWarnings("resource")
		boolean n = true;
		Scanner scan = new Scanner(System.in);
		

		
		map(4,8,4,8,1,1);
		while(count < 9) {

			String input = scan.next();
			System.out.println(input.toUpperCase());
			switch(input.toUpperCase()) {
		
			case "A" :
				aX--;
				mY++;
				count++;
				break;
			case "D" :
				aX++;
				mY++;
				count++;
				break;
			default :
				break;
			}
		
		System.out.println(aY+", " + aX + ", " + bY + ", " + bX);
	
   	     if(map(aX, aY, bX, bY, mX, mY)){  //이동을 위한 호출 부분
        	 aX = bX;
    	     aY = bY;
    	     }
    	     bX = aX;
    	     bY = aY;
		}

	}



	
	
	public boolean map(int aX,int aY, int bX, int bY, int mX, int mY){
		

	boolean m = false;	
				
				int[][] 맵 = {
						{0,0,0,0,0,0,0,0,0},
						{0,1,1,1,1,1,1,1,0},
						{0,1,1,1,1,1,1,1,0},
						{0,1,1,1,1,1,1,1,0},
						{0,1,1,1,1,1,1,1,0},
						{0,1,1,1,1,1,1,1,0},
						{0,1,1,1,1,1,1,1,0},
						{0,1,1,1,1,1,1,1,0},
						{0,1,1,1,1,1,1,1,0},
						{0,0,0,0,0,0,0,0,0}
		};
		
		
		for(int i = 0; i<맵.length; i++) {
			
			for(int j = 0; j<맵[i].length; j++) {

				
				if(맵[aY][aX]== 0) {                //벽에 닿았을때 못가게 막아줌
    				aY = bY;
    			    aX = bX;
    			    m = true;
				}
			
			if (i == aY&& j == aX){                //Player 위치값
				System.out.print("★"+"\t");
			}
			else if(i == mY && j == mX) {          //방해물1 위치값
				
				if(mY == 9) {
					System.out.print("게임이 종료되었습니다.");
					break;
				}

				else {
					System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+3) && j == (mX+2)) {   //방해물2 위치값
				if(mY == 6) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+3) && j == mX) {       //방해물3 위치값
				if(mY == 6) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+6) && j == mX) {      //방해물4 위치값
			
				if(mY == 3) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+6) && j == (mX+2)) {   //방해물5 위치값
				if(mY == 3) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+1) && j == (mX+6)) {   //방해물6 위치값
				if(mY == 8) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+2) && j == (mX+6)) {   //방해물7 위치값
				if(mY == 7) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+2) && j == (mX+5)) {   //방해물8 위치값
				if(mY == 7) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+4) && j == (mX+6)) {   //방해물9 위치값
				if(mY == 5) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+5) && j == (mX+6)) {   //방해물10 위치값
				if(mY == 4) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+5) && j == (mX+5)) {   //방해물11 위치값
				if(mY == 4) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(i == (mY+4) && j == (mX+4)) {   //방해물12 위치값
				if(mY == 5) {
					System.out.print("■"+"\t");
				}
				else if((mY+4)==aY && (mX+4)==aX) {
					System.out.print("쥬금");
				}
				else {
				System.out.print("◎"+"\t");
				}
			}
			else if(i == (mY+1) && j == (mX+4)) {   //방해물13 위치값
				if(mY == 8) {
					System.out.print("■"+"\t");
				}
				else {
				System.out.print("§"+"\t");
				}
			}
			else if(맵[i][j] == 0){                 //벽 위치값
				System.out.print("■"+"\t");
			}
			
			else {
				System.out.print("\t");        //빈공간
			}
			
			}
			System.out.println();
			}
		return m;
}
}