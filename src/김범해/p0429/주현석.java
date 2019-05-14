// 주현석

package p0429;

import java.util.Scanner;

public class 문제6 {
	private int Map[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 2, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
			{1, 2, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
			{1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1},
			{1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1},
			{1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 3, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
	
	private boolean item[] = {false, false};
	
	public void Screen(int t_x, int t_y)
	{
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map.length; x++)
			{
				if(t_x == x && t_y == y)
				{
					System.out.print("P");
				}
				else if(Map[y][x] == 1)
				{
					System.out.print("■");
				}
				else if(Map[y][x] == 2)
				{
					System.out.print("K");
				}
				else if(Map[y][x] == 3)
				{
					System.out.print("@");
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
		int m_x = 1;
		int m_y = 1;
		int t_x = 1;
		int t_y = 1;
		
		Screen(t_x, t_y);
		
		Scanner sc = new Scanner(System.in);
		String Key = "";

		while(true)
		{
			Key = sc.next();
			
			switch(Key.toUpperCase())
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
				default:
					break;
			}
			
			if(Move(m_x, m_y))
			{
				t_x = m_x;
				t_y = m_y;
			}
			else
			{
				m_x = t_x;
				m_y = t_y;
			}
			
			
			if(t_x == 10 && t_y == 10)
			{
				if(item[0] != item[1])
				{
					System.out.println("보물 1개 찾아옴");
					break;
				}
				else if(item[0] == true && item[1] == true)
				{
					t_x = 1;
					t_y = 1;
					m_x = t_x;
					m_y = t_y;
					Map[1][11] = 2;
					Map[4][1] = 2;
					System.out.println("처음부터 시작");
				}
			}
			Screen(t_x, t_y);
		}
	}
	
	public boolean Move(int m_x, int m_y)
	{
		if(Map[m_y][m_x] == 2)
		{
			Map[m_y][m_x] = 0;
			System.out.println("보물을 얻었다.");
			for(int i = 0; i < item.length; i++)
			{
				if(item[i] == false)
				{
					item[i] = true;
					return true;
				}
			}
		}
		else if(Map[m_y][m_x] != 1)
		{
			return true;
		}
		
		return false;
	}
}
