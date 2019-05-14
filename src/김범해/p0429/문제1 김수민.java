// 김수민
package p0429;

import java.util.Scanner;

public class 문제1 {
	int[][] Map =
		{
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 0, 2, 0, 1, 2, 0, 1},
			{1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 1, 1, 0, 0, 1},
			{1, 0, 2, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 2, 1, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 0, 2, 0, 0, 2, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};
	
	public boolean StageClear()
	{
		if(Map[3][3] == 2 && Map[3][5] == 2 && Map[4][4] == 2 && Map[5][3] == 2 && Map[5][4] == 2 && Map[6][4] == 2)
			return true;
		else
			return false;
	}
	
	public boolean Stage(int[][] Map, int m_x, int m_y, int x, int y, int dir)
	{
		boolean result = true;
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(Map[m_y][m_x] == 1)
				{
					m_x = x;
					m_y = y;
					result = false;
				}
				
				if(Map[m_y][m_x] == 2)
				{
					switch(dir)
					{
						case 0:
							if(Map[m_y-1][m_x] == 1 || Map[m_y-1][m_x] == 2)
							{
								m_x = x;
								m_y = y;
								result = false;
							}
							else
							{
								Map[m_y][m_x] = 0;
								Map[m_y-1][m_x] = 2;
							}
							break;
							
						case 1:
							if(Map[m_y][m_x+1] == 1 || Map[m_y][m_x+1] == 2)
							{
								m_x = x;
								m_y = y;
								result = false;
							}
							else
							{
								Map[m_y][m_x] = 0;
								Map[m_y][m_x+1] = 2;
							}
							break;
						case 2:
							if(Map[m_y+1][m_x] == 1 || Map[m_y+1][m_x] == 2)
							{
								m_x = x;
								m_y = y;
								result = false;
							}
							else
							{
								Map[m_y][m_x] = 0;
								Map[m_y+1][m_x] = 2;
							}
							break;
						case 3:
							if(Map[m_y][m_x-1] == 1 || Map[m_y][m_x-1] == 2)
							{
								m_x = x;
								m_y = y;
								result = false;
							}
							else
							{
								Map[m_y][m_x] = 0;
								Map[m_y][m_x-1] = 2;
								System.out.println("test");
							}
							break;
					}
				}
				
				if(m_y == i && m_x == j) System.out.print("●");
				else if(Map[i][j] == 1) System.out.print("■");
				else if(Map[i][j] == 2) System.out.print("@");
				else System.out.print("□");
			}
			System.out.println();
		}
		
		return result;
	}
	
	public void Move()
	{
		
		int m_x = 1;
		int m_y = 1;
		int x = 1;
		int y = 1;
		int dir = -1;
		
		Stage(Map, m_x, m_y, x, y, 0);
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			String input = sc.next();
			
			switch(input.toUpperCase())
			{
				case "W":
					dir = 0;
					m_y--;
					break;
				case "S":
					dir = 2;
					m_y++;
					break;
				case "A":
					dir = 3;
					m_x--;
					break;
				case "D":
					dir = 1;
					m_x++;
					break;
				default:
					break;
			}
			
			if(Stage(Map, m_x, m_y, x, y, dir))
			{
				x = m_x;
				y = m_y;
			}
			else
			{
				m_x = x;
				m_y = y;
			}
			
			if(StageClear())
			{
				System.out.println("완료");
				break;
			}
		}
		
	}
}
