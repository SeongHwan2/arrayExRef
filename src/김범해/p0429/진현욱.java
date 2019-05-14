// 진현욱

package p0429;

import java.util.Scanner;

public class 문제7 {
	private int Map[][] = {
//			{8, 7, 6, 5, 4, 3, 1, 9, 2},
//			{5, 4, 3, 2, 1, 9, 7, 6, 8},
//			{2, 1, 9, 8, 7, 6, 4, 3, 5},
//			{1, 9, 8, 7, 6, 5, 3, 2, 4},
//			{4, 3, 2, 1, 9, 8, 6, 5, 7},
//			{7, 6, 5, 4, 3, 2, 9, 8, 1},
//			{3, 2, 1, 9, 8, 7, 5, 4, 6},
//			{6, 5, 4, 3, 2, 1, 8, 7, 9},
//			{9, 8, 7, 6, 5, 4, 2, 1, 3},
			{8, 0, 6, 0, 0, 3, 0, 9, 0},
			{0, 4, 0, 0, 1, 0, 0, 6, 8},
			{2, 0, 0, 8, 7, 0, 0, 0, 5},
			{1, 0, 8, 0, 0, 5, 0, 2, 0},
			{0, 3, 0, 1, 0, 0, 0, 5, 0},
			{7, 0, 5, 0, 3, 0, 9, 0, 0},
			{0, 2, 1, 0, 0, 7, 0, 4, 0},
			{6, 0, 0, 0, 2, 0, 8, 0, 0},
			{0, 8, 7, 6, 0, 4, 0, 0, 3},
	};
	
	public void Screen()
	{
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map.length; x++)
			{
				System.out.print(Map[y][x] + " ");
			}
			System.out.println();
		}
	}
	
	public void Game()
	{
		Screen();
		
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int result = 0;
		
		int line1 = 0;
		int line2 = 0;
		
		int cnt = 0;
		while(true)
		{
			System.out.println("x, y  좌표 입력 (제출은 -1 입력)");
			x = sc.nextInt();
			
			if(x == -1) // 정답 체크
			{
				for(int i = 0; i < Map.length; i++)
				{
					for(int j = 0; j < Map[i].length; j++)
					{
						line1 += Map[i][j];
						line2 += Map[j][i];
						if(line1 == 45)
						{
							cnt++;
						}
						
						if(line2 == 45)
						{
							cnt++;
						}
					}
					line1 = 0;
					line2 = 0;
				}

				if(cnt == Map.length*2)
				{
					System.out.println("정답입니다.");
					break;
				}
				
				cnt = 0;
				System.out.println("틀렸습니다.");
			}
			else
			{
				y = sc.nextInt();
				
				System.out.println("변경할 값은? ");
				result = sc.nextInt();
				
				Map[y][x] = result;
				result = 0;
			}
			Screen();
		}
	}
}
