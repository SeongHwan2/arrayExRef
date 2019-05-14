// 구기준

package p0429;

import java.util.Scanner;

public class 문제15 {
	private int Map[][] = {
			{1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 2, 1, 0, 1},
			{1, 0, 0, 1, 0, 0, 1},
			{1, 1, 0, 0, 0, 1, 1},
			{1, 1, 1, 1, 0, 0, 1},
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
	
	public void Start()
	{
		AStar NodeSearch = new AStar();
		int t_x = 1;
		int t_y = 1;
		int e_x = 5;
		int e_y = 5;
		int m_x = t_x;
		int m_y = t_y;
		int Move_Cnt = 0;
		boolean ReStart = false;
		
		int data = NodeSearch.ASearch(Map, t_x, t_y, e_x, e_y);
		
		boolean def = false;
		
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
					
				default:
					def = true;
					break;
			}
			
			if(def)
			{
				continue;
			}

			if(Move(m_x, m_y))
			{
				Move_Cnt++;
				t_x = m_x;
				t_y = m_y;
			}
			else
			{
				m_x = t_x;
				m_y = t_y;
			}
			
			Screen(t_x, t_y);
			System.out.println("[최단거리: " + data + "] " + Move_Cnt + "칸 이동");
			if(t_x == e_x && t_y == e_y)
			{
				if(data == Move_Cnt)
				{
					break;
				}

				ReStart = true;
			}
			else if(Map[t_y][t_x] == 2)
			{
				ReStart = true;
			}
			
			if(ReStart == true)
			{
				t_x = 1;
				t_y = 1;
				m_x = t_x;
				m_y = t_y;
				Move_Cnt = 0;
				Screen(t_x, t_y);
				ReStart = false;
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
