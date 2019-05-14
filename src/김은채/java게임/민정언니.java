package com.java게임;

import java.util.Scanner;

public class 민정언니 {
	int [][] 맵= {  {0,0,0,0,0,0},
		       {1,1,1,1,0,1},
	           {1,0,0,1,0,1},
		       {1,1,0,1,0,1},
	           {0,2,1,1,1,1},
	           {0,0,0,0,0,0}
};
	public boolean 민정언니game(int ay, int ax, int by, int bx) {
		boolean result=true;
	
	
	for(int y=0; y< 맵.length; y++) {
		for(int x=0; x<맵[y].length; x++) {
			
			if(맵[ay][ax]==0) {
				ay=by;
				ax=bx;
				result=false;
			}
			if(x==ax && y==ay) {
				System.out.print("☆"+"\t");
			}
			else if(맵[y][x]==0) {
				System.out.print("●"+"\t");
			}else if(맵[y][x]==1) {
				System.out.print("○"+"\t");
			}else if(맵[y][x]==2) {
				System.out.print("＠"+"\t");
			}
		}
		System.out.println();
	}
	return result;
}

	public void 민정언니game2() {
		Scanner scan= new Scanner(System.in);
		int ay=3;
		int ax=0;
		int by=3;
		int bx=0;
		민정언니game(ay, ax, by,  bx);
		while(true) {
			String input= scan.next();
			System.out.println(input.toUpperCase());
			
			
			switch(input.toUpperCase()) {
			case "W" : ay--;
				break;
			case "S" : ay++;
				break;
			case "A" : ax--;
				break;
			case "D" : ax++;
				break;
			default:
				break;
		
		}

		if(민정언니game(ay, ax, by, bx)) {
			by=ay;
			bx=ax;
		}else {
			ay=by;
			ax=bx;
		  }
		if(맵[ay][ax]==2) {
			System.out.println("처음으로 돌아갑니다");
			ay=3;
			ax=0;
			by=3;
			bx=0;
			민정언니game2();
			
	}else if(ay==1 && ax==5) {
		System.out.println("도착");
		break;
	}	
			}
			if(ay==1 && ax==3){
				ay = ay+2;
				
			}
			
		}
	
	}


