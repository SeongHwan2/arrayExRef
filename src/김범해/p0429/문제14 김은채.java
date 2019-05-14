// 김은채

package p0429;

import java.util.Scanner;

public class 문제14 {
	private int Map[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 2, 0, 0, 0, 1, 1},
			{0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 3, 0, 1, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1}
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
				else if(Map[y][x] == 2 || Map[y][x] == 3)
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
		int t_y = 2;
		int m_x = t_x;
		int m_y = t_y;
		
		boolean sw;
		String result = "";
		
		Screen(t_x, t_y);
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			sw = false;
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
				default:
					sw = true;
					break;
			}
			
			if(sw)
			{
				continue;
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
			
			Screen(t_x, t_y);
			
			if(t_x == 7 && t_y == 3)
			{
				System.out.println("끝");
				break;
			}
			else if(Map[m_y-1][m_x] == 2)
			{
				while(true)
				{
					System.out.println("머리조심 입력");
					result = sc.next();
					if(result.equals("머리조심"))
					{
						System.out.println("정답 이동하세요");
						break;
					}
					else
					{
						System.out.println("틀렸습니다.");
					}
				}
			}
			else if(Map[m_y+1][m_x] == 3)
			{
				Screen(t_x, t_y);
				while(true)
				{
					System.out.println("강사님 이름 입력");
					result = sc.next();
					if(result.equals("김경빈"))
					{
						System.out.println("정답 이동하세요");
						break;
					}
					else
					{
						System.out.println("틀렸습니다.");
					}
				}
			}
		}
	}
	
	public boolean Move(int m_x, int m_y)
	{
		if(Map[m_y][m_x] == 0)
		{
			return true;
		}
		return false;
	}
}
