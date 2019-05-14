package com.Test1;

import java.util.Scanner;

public class 길열기 {
	//전역선언           (변수,맵(배열))
	
	//전역변수 선언
	int aX = 0;              	//플레이어 현재 X축 위치
	int aY = 1;					//플레이어 현재 Y축 위치
	int bX = 0;					//플레이어 이전 X축 위치
	int bY = 1;					//플레이어 이전 Y축 위치
	boolean result = true;		//반복문 종료용 객체 선언
	boolean 함정 = false;			//함정 발동을 위한 변수 선언
	String 응답 = "";				//메세지 출력용 변수 선언
	//전역 배열 선언(맵)
	int map[][] = {
			{0,0,0,0,0,0,0},
			{1,1,1,1,1,1,0},
			{0,1,0,0,0,3,0},
			{0,1,0,4,1,0,0},
			{0,1,0,0,1,0,0},
			{0,1,2,1,1,1,5},
			{0,0,0,0,0,0,0}
	};
	public boolean 맵(int aX, int aY, int bX, int bY) {	//맵 출력을 위한 메서드
		
		boolean 오류 = false;
		
		for(int y = 0; y<map.length; y++) {			//반복문 맵 Y축 출력
			
			for(int x = 0; x<map[y].length; x++) {  //반복문 맵 X축 출력
				
				if(map[aY][aX] == 2) {				//플에이어 위치에 따른 상호 작용
					응답 ="스위치를 먼저 누르고 와주세요";
					aX=bX;
					aY=bY;
					오류 = true;
				}
				if(map[aY][aX] == 0) {
					응답 ="벽입니다. 정신 차리세요!";
					aX=bX;
					aY=bY;
					오류 = true;
				}
				if(map[aY][aX] == 3) {
					map[aY][aX] = 1;
					응답 ="스위치가 작동하여 벽이 열립니다.";
					map[5][2] = 1;
				}
				if(map[aY][aX] == 4) {
					응답 ="함정을 밟아 처음으로 돌아갑니다.";
					함정 = true;
				}
				if(map[aY][aX] == 5) {
					응답 ="축하합니다. 탈출에 성공하였습니다.";
					result = false;
				}
				
				
				if(y == aY && x == aX) {			//플레이어 포인터 위치
					System.out.print("♤"+"\t");
				}else if(map[y][x]==2) {			//스위치 벽 위치
					System.out.print("◆"+"\t");
				}else if(map[y][x]==1) {
					System.out.print("□"+"\t");		//이동가능위치
				}else if(map[y][x]==3) {
					System.out.print("※"+"\t");		//스위치 위치
				}else if(map[y][x]==4) {
					System.out.print("◇"+"\t");		//재시작 위치
				}else if(map[y][x]==5) {
					System.out.print("골"+"\t");		//종료 지점
				}else {
					System.out.print("■"+"\t");		//벽 위치
				}
				
			}System.out.println();					//출력
		}
			System.out.println(응답);	
			응답 = "";
		return 오류;
	}
	public void consol() {							//플레이어 조종 메서드
		맵(0,1,0,1);									//맵 호출
		Scanner scan = new Scanner(System.in);		//스캐너 작동
		while(result) {								//위치 상호작용 반복문
			String input = scan.next();				//스캔값 input 적용
		switch(input.toUpperCase()) {					//input값 
		
		case "W" :									//플레이어위치 상호작용
			aY--;
			break;
		case "S" :
			aY++;
			break;
		case "D" :
			aX++;
			break;
		case "A" :
			aX--;
			break;
		default :
			break;
		}
		System.out.println(aY+", " + aX + ", " + bY + ", " + bX);
		if(맵(aX,aY,bX,bY)) {					//map이 true 값일 경우 발동
			aX=bX;								//플레이어 위치 이전값 저장
			aY=bY;								//플레이어 위치 이전값 저장
		}else if(함정==true){						//함정 위치 도착시 상호작용
			aX=0;
			aY=1;
			bX=0;
			bY=1;
			함정 = false;
		}else {
			bX=aX;								//플레이어 위치 현재값 기록
			bY=aY;								//플레이어 위치 현재값 기록
		}
			
		}
		
		}
	}

