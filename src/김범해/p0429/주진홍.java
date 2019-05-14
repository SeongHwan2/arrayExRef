// 주진홍

package p0429;

import java.util.Scanner;

public class 문제16 {
	int Map[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
			{1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 0, 1, 0, 0, 1, 1, 0, 1},
			{1, 0, 0, 1, 1, 0, 0, 1, 0, 1},
			{1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
			{1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
	
	public void Screen(int t_x, int t_y)
	{
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map[y].length; x++)
			{
				if(t_x == x && t_y == y)
				{
					System.out.print("p");
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
	
	public void Start()
	{
		int t_x = 8;
		int t_y = 1;
		int m_x = t_x;
		int m_y = t_y;
		int e_x = 3;
		int e_y = 6;
		int Move_Cnt = 0;
		
		AStar NodeSearch = new AStar();
		int data = NodeSearch.ASearch(Map, t_x, t_y, e_x, e_y);
		
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
					continue;
			}
			
			if(CheckMove(m_x, m_y))
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
			System.out.println("[최단거리: " + data + "] " + Move_Cnt + "칸");
			
			if(t_x == e_x && t_y == e_y)
			{
				System.out.println("성공");
				break;
			}
		}
	}
	
	public boolean CheckMove(int x, int y) {
		if(Map[y][x] == 1) return false;
		
		return true;
	}
}
