package com.java게임;

import java.util.Scanner;

public class 대환옵 {
			int [][]맵 = {
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
					{1, 0, 0, 3, 0, 0, 0, 1, 2, 1},
					{1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
					{1, 1, 1, 1, 3, 0, 1, 3, 0, 1},
					{1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
					{1, 0, 0, 0, 0, 3, 1, 0, 3, 1},
					{1, 0, 1, 1, 1, 1, 1, 0, 0, 1},
					{1, 0, 0, 3, 0, 0, 0, 1, 0, 1},
					{1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
					};
			
		public boolean 대환옵출력(int ay, int ax, int by, int bx) {
			boolean result = true;
			
		for(int y=0; y<맵.length; y++) {
			for(int x=0; x<맵[y].length; x++) {
				
				if(맵[ay][ax]==1) {
					ay = by;
					ax = bx;
					result=false;
				}
			if(y==ay && x==ax) {
				System.out.print("＠" + "\t");
			}
			else if(맵[y][x]==1) {
				System.out.print("●" + "\t");
			}else if(맵[y][x]==0) {
				System.out.print("○"+ "\t");
			}else if(맵[y][x]==2) {
				System.out.print("※"+ "\t");
			}else if(맵[y][x]==3) {
				System.out.print("*"+ "\t");
			}

			}System.out.println();
		}
		return result;
		}

		public void 대환옵실행() {
			Scanner scan = new Scanner(System.in);
			
			int ay=1;
			int ax=1;
			int by=1;
			int bx=1;
			대환옵출력(ay, ax, by, bx);
			
			while(true) {
				String input = scan.next();
				switch(input.toUpperCase()) {
				case "A": ax--;
					break;
				case "D": ax++;
					break;
				case "W": ay--;
					break;
				case "S": ay++;
					break;
				default:
					break;
				}
				
				if(맵[ay][ax]==3) {
					
					System.out.println("죽음");
					대환옵출력(ay, ax, by, bx);
					break;
					
				}else if(맵[ay][ax]==2){
					System.out.println("도착");
					대환옵출력(ay, ax, by, bx);
					break;
				}
				if(대환옵출력(ay, ax, by, bx)) {
					by = ay;
					bx = ax;
				}else {
					ay=by;
					ax=bx;
				}

				//순서가 앞이냐 뒤냐는 앞에 놓으면 현재좌표랑 예전좌표비교해서 일단 값을 출력하자나. 이프문뒤에 출력메소드 넣었으니까.
				//그니까 출력을 앞에 놓으면 일단 출력이 되고 다른 조건 동작이 되는거고. 조건 동작이 앞에 있음 출력 전에 그냥 동작이 끝나고 출력이 안되는거임.
				
				
				
				
			}
		
		 }
		}

