// 염종찬

package p0429;

import java.util.Scanner;

public class 문제8 {
	private int Map[][] = {
			{0, 0, 0, 0, 0, 0},	
			{0, 0, 0, 0, 0, 0},	
			{0, 0, 0, 1, 0, 0},	
			{0, 0, 1, 1, 1, 0},	
			{0, 0, 0, 1, 0, 0},	
			{0, 0, 0, 0, 0, 0}
	};
	
	public void Screen(int t_x, int t_y)
	{
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map[y].length; x++)
			{
				if(t_x == x && t_y == y)
				{
					System.out.print("●");
				}
				else if(Map[y][x] == 1)
				{
					System.out.print("■");
				}
				else
				{
					System.out.print("□");
				}
			}
			System.out.println();
		}
	}
	
	public void Game()
	{
		int t_x = 5;
		int t_y = 0;
		int m_x = t_x;
		int m_y = t_y;
		boolean e = false;
		
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
					
				case "E":
					e = true;
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
			
			if(e == true && m_x == 3 && m_y == 3)
			{
				System.out.println("명중");
				break;
			}
			else
			{
				e = false;
			}
				
			Screen(t_x, t_y);
		}
	}
	
	public boolean Move(int t_x, int t_y)
	{
		if(t_x > 5 || t_x < 0 || t_y > 5 || t_y < 0)
		{
			return false;
		}
		
		return true;
	}
}
