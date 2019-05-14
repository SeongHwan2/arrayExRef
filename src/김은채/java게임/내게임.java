package com.java게임;

import java.util.Scanner;

public class 내게임 {

	public boolean game1(int ay, int ax, int by, int bx) {
		boolean result=true;
		int [][] 맵 = {
					 {0,0,0,0,0,0,0,0},
					 {0,1,3,1,1,1,0,0},
					 {1,1,1,1,1,1,1,0},
					 {0,1,0,2,1,0,1,1},
					 {0,0,0,0,0,0,0,0}
		};
		
		for(int y=0; y < 맵.length; y++) {
			for(int x=0; x<맵[y].length; x++) {		
				if(맵[ay][ax]==0) {
					ay=by;
					ax=bx;
					result= false;
				}
				
				if(x==ax && y==ay) {
					System.out.print("♨ " + "\t");
				}
				else if(맵[y][x]==0) {
					System.out.print("■" + "\t");
				}else if(맵[y][x]==1) {
					System.out.print("□" + "\t");
				}else if(맵[y][x]==2) {
					System.out.print("▦ " + "\t");
				}else if(맵[y][x]==3) {
					System.out.print("※ " + "\t");
				}				
			}
			System.out.println();	
	  }
		return result;
	}
	
	public void game2() {
		Scanner scan = new Scanner(System.in);
		int ay=2;
		int ax=0;
		int by=2;
		int bx=0;
		game1(ay,ax,by,bx);
		while(true) {
			String input=scan.next();
			System.out.println(input.toUpperCase());
			switch(input.toUpperCase()) {
			case "W": ay--;
				break;
			case "S": ay++;
				break;
			case "A": ax--;
				break;
			case "D": ax++;
				break;
			default:
				break;
			}
			if(game1(ay,ax,by,bx)) {
				by=ay;
				bx=ax;
			}else {
				ay=by;
				ax=bx;
			}
			
			if(ay==2 && ax==2) {
				System.out.println("머리조심!을 입력하세요");	
				//String string=scan.next();
				if(scan.next().equals("머리조심!")) {
					ay=2;
					ax=3;
				}else {
					ay=2;
					ax=2;
				  }	
				game1(ay,ax,by,bx);
			}
			
			if(ay==2 && ax==3) {
				System.out.println("강사님 이름을 입력하새오");	
				String name=scan.next();
				if(name.equals("김경빈")) {
					ay=2;
					ax=4;//안돼영우에에에
				}else {
					ay=2;
					ax=0;
				  }
				game1(ay,ax,by,bx);//값입력하고 맵 보여주라고.(처음맵이 아니라 입력된 y,x가 있는 맵이니까 매개변수 있는 맵.)
			}
			
		}
	}
}