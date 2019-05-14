package com.java0509;

import java.util.Scanner;
public class 문제1 {

	boolean a1 = false;
	boolean a2 = false;
	int num = 3;
	int num2 = 3;
	int map1 = 4;
	int [][] 맵 = {
			{0,0,0,0,0,0,0},
			{0,1,1,0,0,map1,0},
			{0,1,1,0,3,1,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,1,2,0},
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0},
			
	};
	
public boolean t1(int aX, int aY, int bX, int bY) {
	
	boolean result = false;
	
int [][] 맵 = {
		{0,0,0,0,0,0,0,0,0,0,0,0},
		{0,1,0,0,0,1,1,1,0,0,num,0},
		{0,1,1,1,1,1,0,1,1,1,1,0},
		{0,0,0,1,0,1,0,0,0,1,0,0},
		{0,num2,0,1,0,1,0,1,0,1,1,0},
		{0,1,0,1,0,1,0,1,0,1,0,0},
		{0,1,1,1,1,1,0,1,1,1,0,0},
		{0,0,1,0,0,1,0,0,0,1,0,0},
		{0,0,1,0,1,1,1,0,1,1,1,0},
		{0,0,1,0,1,0,1,1,1,1,0,0},
		{0,0,1,1,1,0,0,0,0,1,1,0},
		{0,0,0,0,0,0,0,0,0,0,0,0},
		
		
};


for(int y = 0; y <맵.length; y++){
	for(int x = 0; x <맵[y].length; x++) {
		if(맵[aY][aX] == 0) {
			aX = bX;
			aY = bY;
			result = true;
		}
		if(y == aY && x == aX) {
			System.out.print(" ♥ ");
		}else if(맵[y][x] == 0) {
			System.out.print(" ■ ");
		}else if(맵[y][x] == 1) {
			System.out.print(" □ ");
		}else if(맵[y][x] == 3){
			System.out.print(" ♣ ");
		}
	
		if(!result) {
			if(aX == 1 && aY == 4) {
				System.out.println("냠냠");
			num2 = 1;
			a1 = true;
			
			}else if(aX == 10 && aY == 1) {
				System.out.println("냠냠2");
			num = 1;
			a2 = true;

		}
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
	t1(aY,aX,bY,bX);
	while(true) {
		String input = scan.next();
		switch (input.toUpperCase()) {
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
		
		}
		System.out.println(aY + "," + aX + "," + bY + "," + bX);
		if(t1(aX,aY,bX,bY)) {
			aX = bX;
			aY = bY;
		}else {
			bX = aX;
			bY = aY;
		}
		if(aY == 10 && aX == 10) {
			if(a1 == true || a2 == true) {
				System.out.println(" E nd");
				break;
			}else if(a1 == false || a2 == false){
				System.out.println("보물획득 실패");
				aX = 1;
				aY = 1;
		}
			if(t1(aY,aX,bY,bX) == true){
				aX = bX;
				aY = bY;
			}else {
				bX = aX;
				bY = aY;
			}
			
		}
	}
}

public boolean t3(int aX, int aY, int bX, int bY) {
	boolean result = false;
	

	
	for(int i = 0; i <맵.length; i++) {
		for(int j = 0; j<맵[i].length; j++) {	
			
			if(맵[aX][aY] == 0){
				aX = bX;
				aY = bY;
				
				result = true;
			}
			if(i == aY && j == aX) {
				System.out.print(" ♥ ");
			}else if(맵[i][j] == 1) {
				System.out.print(" □ ");
			}else if(맵[i][j] == 2) {
				System.out.print(" ㉿  ");
			}else if(맵[i][j] == 3) {
				System.out.print(" ㈜  ");
			}else {
				System.out.print(" ■ ");
			}
		}
		System.out.println();
	}

	return result;
}
public void t4() {
	Scanner scan = new Scanner(System.in);
	int aX = 1;
	int aY = 1;
	int bX = 1;
	int bY = 1;
	t3(aX,aY,bX,bY);
	while(true) {
	String input = scan.next();
	switch(input.toUpperCase()){
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

	}
	System.out.println(aY + "," + aX + "," + bY + "," + bX);
	if (t3(aX,aY,bX,bY)) {
		aX = bX;
		aY = bY;
	}else {
		bX = aX;
		bY = aY;
	}
	if(aY == 4 && aX == 5) {
		aY = 2;
		aX = 4;
	}
	else if(맵[aY][aX] == map1) {
		System.out.println(" E nd.");
		return;
	}
	}
}

}