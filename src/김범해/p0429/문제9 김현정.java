// 김현정

package p0429;

import java.util.Scanner;

public class 문제9 {
	private int Map[][] = {
			{1, 1, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 3, 1},
			{1, 0, 1, 2, 0, 1, 1},
			{1, 0, 1, 1, 0, 1, 1},
			{1, 0, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1}
	};
	
	public void Screen(int t_x, int t_y)
	{
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map[y].length; x++)
			{
				if(t_x == x && t_y == y)
				{
					System.out.print("P");
				}
				else if(Map[y][x] == 3)
				{
					System.out.print("K");
				}
				else if(Map[y][x] == 2)
				{
					System.out.print("@");
				}
				else if(Map[y][x] == 1)
				{
					System.out.print("■");
				}
				else if(Map[y][x] == 0)
				{
					System.out.print("□");
				}
			}
			System.out.println();
		}
	}
	
	public void Game()
	{
		int t_x = 0;
		int t_y = 1;
		int m_x = t_x;
		int m_y = t_y;
		
		Screen(t_x, t_y);
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			switch(sc.next().toUpperCase())
			{
				case "W":
					m_y--;
					break;
				case "D":
					m_x++;
					break;
				case "S":
					m_y++;
					break;
				case "A":
					m_x--;
					break;
			}
			
			if(Move(m_x, m_y))
			{
				t_x = m_x;
				t_y = m_y;
				
				if(t_x == 5 && t_y == 2)
				{
					Map[5][2] = 0;
				}
				else if(t_x == 3 && t_y == 3)
				{
					t_x = 0;
					t_y = 1;
					m_x = t_x;
					m_y = t_y;
				}
			}
			else
			{
				m_x = t_x;
				m_y = t_y;
			}
			
			Screen(t_x, t_y);
			
			if(t_x == 6 && t_y == 5)
			{
				System.out.println("도착");
				break;
			}
		}
		
	}
	
	public boolean Move(int m_x, int m_y)
	{
		if(Map[m_y][m_x] != 1)
		{
			return true;
		}
		
		return false;
	}
}
