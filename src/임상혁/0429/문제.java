package com.java0429;


import java.util.Scanner;


public class 문제 {
	private int Map[][] = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 0, 2, 0, 0, 0, 4, 4, 4, 1 },
			{ 1, 0, 2, 0, 3, 0, 0, 0, 4, 1 }, 
			{ 1, 0, 2, 0, 3, 0, 5, 0, 0, 1 }, 
			{ 1, 0, 2, 0, 3, 0, 5, 0, 0, 1 },
			{ 1, 0, 2, 0, 3, 0, 5, 0, 0, 1 }, 
			{ 1, 0, 2, 0, 3, 0, 5, 0, 0, 1 }, 
			{ 1, 0, 2, 0, 3, 0, 5, 5, 0, 1 },
			{ 1, 0, 0, 0, 3, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 }
			};

	public void Screen(int aX, int aY) {
		for (int y = 0; y < Map.length; y++) {
			for (int x = 0; x < Map[y].length; x++) {
				if (aX == x && aY == y) {
					System.out.print("@");
				} else if (Map[y][x] == 1) {
					System.out.print("■ ");
				} else if (Map[y][x] == 2) {
					System.out.print("▤");
				} else if (Map[y][x] == 3) {
					System.out.print("▥");
				} else if (Map[y][x] == 4) {
					System.out.print("▨");
				} else if (Map[y][x] == 5) {
					System.out.print("▧");
				} else if (Map[y][x] == 0) {
					System.out.print("□");
				}
			}
			System.out.println();
		}
	}

	public void 게임() {

		int aX = 1;
		int aY = 1;
		int bX = 1;
		int bY = 1;

		Screen(aX, aY);

		Scanner sc = new Scanner(System.in);

		while (true) {
			switch (sc.next().toUpperCase()) {
			case "W":
				bY--;
				break;
			case "D":
				bX++;
				break;
			case "S":
				bY++;
				break;
			case "A":
				bX--;
				break;
			default:
				break;
			}

			if (Move(bX, bY)) {
				aX = bX;
				aY = bY;
			} else {
				bX = aX;
				bY = aY;
			}

			Screen(aX, aY);

			if (aX == 8 && aY == 9) {
				System.out.println("게임 끝");
				break;
			}
		}
	}

	public boolean Move(int bX, int bY) {
		if (Map[bY][bX] == 0) {
			return true;
		}
		return false;
	}
}