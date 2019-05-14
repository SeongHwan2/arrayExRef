package com.java게임;

import java.util.Scanner;
			
			public class 강미 {
			
			int[][] 맵 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,2,0,0,1,1,0,1,0},
			{0,1,1,2,0,1,0,1,1,0},
			{0,1,1,0,2,1,1,0,1,0},
			{0,1,1,0,1,2,0,1,1,0},
			{0,1,0,1,1,0,2,1,1,0},
			{0,1,0,1,0,0,1,2,1,0},
			{0,1,1,1,1,1,1,0,3,0},
			{0,0,0,0,0,0,0,0,0,0},
			};
			
			public boolean t1(int aX, int aY, int bX, int bY) {
			boolean result = false;
			
			for(int y = 0; y < 맵.length; y++) { 
			for(int x = 0; x < 맵[y].length; x++) {
			
			if(맵[aY][aX] == 0) {
			aY = bY; 
			aX = bX; 
			result = true;
			}
			
			
			
			
			
			if(y == aY && x == aX) {
			System.out.print("㉿" + "\t");
			}else if(맵[y][x] == 1) {
			System.out.print("□" + "\t");
			}else if(맵[y][x] == 2) {
			System.out.print("♥" + "\t");
			}else if(맵[y][x] == 3) {
			System.out.print("♡" + "\t");
			}else {
			System.out.print("■" + "\t");
			}
			
			
			}
			
			System.out.println();
			
			}
			return result;
			
			}
			
			public void t2() {
			Scanner scan = new Scanner(System.in);
			int aX = 1;
			int aY = 1;
			int bX = 1;
			int bY = 1;
			t1(aX,aY,bX,bY); 
			
			while(true) {	
			String input = scan.next();
			System.out.println(input.toUpperCase());
			int count = 0;
			
			switch(input.toUpperCase()) {
			case "W": 
			aY--;
			break;
			case "S": 
			aY++;
			break;
			case "A": 
			aX--;
			break;
			case "D": 
			aX++;
			break;
			default:
			break;
			}
			
			if(t1(aX,aY,bX,bY)) { 
			aX = bX;	
			aY = bY;	
			}else {
			bX = aX;
			bY = aY;
			}
			
			if(맵[aY][aX]==2) {
				맵[aY][aX] = 1;//대각선 하트있는자리가 1로 바뀐다. ay8자리는 도착이기때문에 아니라고 설정
				}
			
			for(int i = 0; i < 맵.length; i++) {//맵돌려.하트 조건때문에.
			for(int j = 0; j < 맵[i].length; j++) {
			if(맵[i][j] == 2) {
			count++;
			
			//for로 한 번씩 도는데 for로 다 돌면 처음엔 6-5-4-3-.. 좌표가 2인 카운트 변수는 처음엔 하트 수만큼.++는 for돌때 하나씩 수 감소.
			//근데 2가 1로 바뀔때마다 2 즉 카운트가 줄어들어.
			//for문으로 맵을 다 도니까 그 때 하트는 처음 하트갯수. 계속 for이 도는데 하트를 먹으면 맵(하트=2)이바뀌니까 먹는대로 줄어들어.
			System.out.println(count);
			}
			}
			}
			
			if(aY == 8 && aX == 8 && count == 0) {
			break;//카운트는 남은 하투 갯수.
			}
			
			}
			}
			
			}
