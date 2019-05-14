// 김민정
package p0429;

import java.util.Scanner;

public class 문제2 {
	int[][] Map = { { 1, 1, 1, 1, 1, 1 }, 
					{ 0, 0, 0, 3, 1, 0 },
					{ 0, 1, 1, 0, 1, 0 }, 
					{ 0, 0, 1, 0, 1, 0 },
					{ 1, 2, 0, 0, 0, 0 }, 
					{ 1, 1, 1, 1, 1, 1 }
	};

	boolean Stage(int m_x, int m_y, int x, int y) {
		boolean result = true;

		for (int i = 0; i < Map.length; i++) {
			for (int j = 0; j < Map[i].length; j++) {
				if (m_x < 0 || m_x > 5 || Map[m_y][m_x] == 1) {
					m_x = x;
					m_y = y;
					result = false;
				}

				if (i == m_y && j == m_x)
					System.out.print("p");
				else if (Map[i][j] == 1)
					System.out.print("■");
				else
					System.out.print("□");
			}
			System.out.println();
		}

		return result;
	}

	public void Move() {
		Scanner sc = new Scanner(System.in);
		int m_x = 0;
		int m_y = 3;
		int x = 0;
		int y = 3;

		int ex = 1;
		int ey = 5;
		Stage(m_x, m_y, x, y);

		while (true) {
			String input = sc.next();
			switch (input.toUpperCase()) {
			case "W": // 위
				m_y--;
				break;
			case "S": // 아래
				m_y++;
				break;
			case "A": // 왼
				m_x--;
				break;
			case "D": // 오른
				m_x++;
				break;
			default:
				break;
			}

			if (Stage(m_x, m_y, x, y)) {
				x = m_x;
				y = m_y;

				if (m_x == 5 && m_y == 1) {
					System.out.println("도착");
					break;
				} else if (Map[y][x] == 2) {
					x = 0;
					y = 3;
					m_x = 0;
					m_y = 3;

					Stage(m_x, m_y, x, y);
				} else if (Map[y][x] == 3) {
					y += 2;
					m_y += 2;

					Stage(m_x, m_y, x, y);
				}
			} else {
				m_x = x;
				m_y = y;
			}
		}

//	sc.close();
	}
}