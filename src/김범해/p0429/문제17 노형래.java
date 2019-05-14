// 노형래

package p0429;

import java.util.Scanner;

public class 문제17 {
	private int Map[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 2, 0, 0, 2, 1},
			{1, 0, 0, 2, 0, 0, 0, 2, 2, 1},
			{1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 2, 0, 0, 2, 1},
			{1, 0, 0, 2, 0, 0, 0, 2, 2, 1},
			{1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
	
	private void Screen(int t_x, int t_y)
	{
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map[y].length; x++)
			{
				if(t_x == x && t_y == y && Map[y][x] == 2)
				{
					System.out.print("x");
				}
				else if(t_x == x && t_y == y)
				{
					System.out.print("p");
				}
				else if(Map[y][x] == 2)
				{
					System.out.print("§");
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
		int t_x = 4;
		int t_y = 8;
		int m_x = t_x;
		int temp;
		
		Screen(t_x, t_y);
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			switch(sc.next().toUpperCase())
			{
				case "A":
					m_x--;
					break;
					
				case "D":
					m_x++;
					break;
					
				default:
					continue;
			}
			
			for(int x = 1; x < Map.length-1; x++) // 똥이 땅에 떨어지면 없어짐
			{
				if(Map[t_y][x] == 2)
				{
					Map[t_y][x] = 0;
				}
			}
			
			if(m_x > 0 && m_x < Map[t_y].length-1)
			{
				t_x = m_x;
				
				for(int y = Map.length-2; y > 0; y--)
				{
					for(int x = Map[y].length-2; x > 0; x--)
					{
						System.out.println(x + " " + y);
						if(Map[y-1][x] == 2)
						{
							Map[y-1][x] = 0;
							Map[y][x] = 2;
						}
					}
				}
			}
			else
			{
				m_x = t_x;
			}
			
			Screen(t_x, t_y);
			
			if(Map[t_y][t_x] == 2)
			{
				System.out.println("똥에 맞아 죽었습니다.");
				break;
			}
		}
	}
}
