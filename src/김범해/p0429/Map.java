// 김범해
package p0429;

import java.util.Scanner;

public class Map {
	boolean Map(int m_x, int m_y, int x, int y)
	{
		boolean result = true;
		
		int[][][] Map = {
				{
				  { 3, 1, 8, 1, 1, 1, 1, 1, 1, 4 },
				  { 2, 0, 2, 0, 0, 0, 0, 0, 0, 2 },
				  { 2, 0, 2, 0, 3, 1, 1, 4, 0, 2 },
				  { 2, 0, 2, 0, 2, 0, 0, 2, 0, 2 },
				  { 2, 0, 0, 0, 2, 0, 0, 2, 0, 2 },
				  { 7, 1, 1, 1, 5, 0, 0, 0, 0, 2 },
				  { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
				  { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
				  { 2, -1, 0, 0, 0, 0, 0, 0, 0, 2 },
				  { 6, 1, 1, 1, 1, 1, 1, 1, 1, 5 }
				},
				{
				  { 3, 1, 1, 1, 1, 1, 1, 1, 1, 4 },
				  { 2, 0, 0, 0, 0, 0, 0, 0, -1, 2 },
				  { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
				  { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
				  { 2, 0, 0, 0, 0, 3, 1, 1, 1, 9 },
				  { 2, 0, 2, 0, 0, 2, 0, 0, 0, 2 },
				  { 2, 0, 2, 0, 0, 2, 0, 2, 0, 2 },
				  { 2, 0, 6, 1, 1, 5, 0, 2, 0, 2 },
				  { 2, 0, 0, 0, 0, 0, 0, 2, 0, 2 },
				  { 6, 1, 1, 1, 1, 1, 1, 10, 1, 5 }
				}
		};
		
		for(int i = 0; i < Map[0].length; i++)
		{
			for(int j = 0; j < Map[0][i].length; j++)
			{
				if(Map[0][m_y][m_x] > 0)
				{
					m_x = x;
					m_y = y;
					result = false;
				}
				
				if(m_y == i && m_x == j) System.out.print("0");
				else System.out.print(BitField(Map[0][i][j]));
			}
			
			int mirror_x = (Map[0].length - 1) - m_x;
			int mirror_y = (Map[0][m_x].length - 1) - m_y;
			
			for(int j = 0; j < Map[1][i].length; j++)
			{
				if(mirror_y == i && mirror_x == j) System.out.print("0");
				else System.out.print(BitField(Map[1][i][j]));
			}
			System.out.println();
		}
			//System.out.println();
		
		return result;
	}
	
	String BitField(int Value)
	{
		switch(Value)
		{
			case -1:
			return "@";
			case 1:
				return "─";
			case 2:
				return "│";
			case 3:
				return "┌";
			case 4:
				return "┐";
			case 5:
				return "┘";
			case 6:
				return "└";
			case 7:
				return "├";
			case 8:
				return "┬";
			case 9:
				return "┤";
			case 10:
				return "┴";
			case 11:
				return "┼";
			default:
				return " ";
		}
	}
	
	void Move()
	{
		int m_x = 1;
		int m_y = 1;
		int x = 1;
		int y = 1;
		
		Map(m_x, m_y, x, y);
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			String input = sc.next();
			
			switch(input.toUpperCase())
			{
				case "W":
					m_y--;
					break;
				case "S":
					m_y++;
					break;
				case "A":
					m_x--;
					break;
				case "D":
					m_x++;
					break;
				default:
					break;
			}
			
			if(Map(m_x, m_y, x, y))
			{
				x = m_x;
				y = m_y;
				
				if(m_x == 1 && m_y == 8)
				{
					System.out.println("Mirror End");
					break;
				}
			}
			else
			{
				m_x = x;
				m_y = y;
			}
		}
		
	}
}
