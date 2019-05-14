// 조은별

package p0429;

import java.util.Scanner;

public class 문제18 {
	
	private int block_x_pos = 4;
	private int block_y_pos = 1;
	private int Map[][] =
		{
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};
	
	private int block[][][] =
			{
				{ // ㄱ 모양
					{block_x_pos, block_x_pos + 1, block_x_pos + 2, block_x_pos + 2},
					{block_y_pos, block_y_pos, block_y_pos, block_y_pos + 1}
				},
				{ // ㄴ 모양
					{block_x_pos, block_x_pos, block_x_pos + 1, block_x_pos + 2},
					{block_y_pos, block_y_pos + 1, block_y_pos + 1, block_y_pos + 1}
				},
				{ // ㅁ 모양
					{block_x_pos, block_x_pos + 1, block_x_pos, block_x_pos + 1},
					{block_y_pos, block_y_pos, block_y_pos + 1, block_y_pos + 1}
				},
			};
	
	private int[][][] copy_block = deepCopy(block);

	private void Screen(int type)
	{
		int block_size = block[type][0].length;
		boolean paint_check;
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map[y].length; x++)
			{
				paint_check = true;
				for(int b_x = 0; b_x < block_size; b_x++)
				{
					if(copy_block[type][0][b_x] == x && copy_block[type][1][b_x] == y)
					{
						System.out.print("@");
						paint_check = false;
					}
				}
				
				if(paint_check)
				{
					if(Map[y][x] == 2)
					{
						System.out.print("@");
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
			}
			System.out.println();
		}
	}
	
	public void Start()
	{
		int type = 0;
		int dir = 0;
		int dir_type = 0;
		int Move_type = 0;
		int right = 3;
		boolean rotation = true;
		boolean end = false;
		
		Screen(type);
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			switch(sc.next().toUpperCase())
			{
				case "W":
					Move_type = 0;
					break;
					
				case "D":
					Move_type = 1;					
					break;
					
				case "S":
					Move_type = 2;
					break;
					
				case "A":
					Move_type = 3;
					break;
					
				default:
					Move_type = -1;
					continue;
			}
			
			if(Move_type == 0) // 블럭 돌리기 sin회전 알고리즘은 2x2에서 사용 // 돌리기 약간의 에러가있음
			{
				rotation = true;
				dir_type++;
				if(dir_type == 4) dir_type = 0;
				int dir_x_pos= copy_block[type][0][right];
				int dir_y_pos = copy_block[type][1][right];
				
				if(type == 0)
				{
					System.out.println(type + " " + dir_type);
					int[][][] dir_block = {
							{ // 0 기본
								{dir_x_pos, dir_x_pos - 1, dir_x_pos + 1, dir_x_pos + 1},
								{dir_y_pos, dir_y_pos, dir_y_pos, dir_y_pos + 1}
							},
							{ // 1
								{dir_x_pos, dir_x_pos, dir_x_pos, dir_x_pos - 1},
								{dir_y_pos, dir_y_pos - 1, dir_y_pos + 1, dir_y_pos + 1}
							},
							{ // 2
								{dir_x_pos, dir_x_pos + 1, dir_x_pos - 1, dir_x_pos - 1},
								{dir_y_pos - 1, dir_y_pos - 1, dir_y_pos - 2, dir_y_pos - 1}
							},
							{ // 3
								{dir_x_pos, dir_x_pos , dir_x_pos, dir_x_pos + 1},
								{dir_y_pos, dir_y_pos - 1, dir_y_pos + 1, dir_y_pos - 1}
							},
						};
					
					for(int i = 0; i < dir_block[dir_type][0].length; i++)
					{
						if(Map[dir_block[dir_type][1][i]][dir_block[dir_type][0][i]] >= 1)
						{
							rotation = false;
							break;
						}
					}
					
					if(rotation)
					{
						for(int i = 0; i < copy_block[type][0].length; i++)
						{
							copy_block[type][0][i] = dir_block[dir_type][0][i];
							copy_block[type][1][i] = dir_block[dir_type][1][i];
						}
					}
				}
			}
			
			if(CheckMove(type, Move_type)) // 블럭 이동
			{
				set_block_pos(type, Move_type);
				if(CheckBlock(copy_block, type))
				{
					for(int i = 0; i < copy_block[type][0].length; i++)
					{
						Map[copy_block[type][1][i]][copy_block[type][0][i]] = 2;
					}
					
					type++;
					if(type == 3) type = 0;
					
					copy_block = null; // 블럭 초기화
					copy_block = deepCopy(block);
					
					for(int i = 0; i < copy_block[type][0].length; i++)
					{
						if(Map[copy_block[type][1][i]][copy_block[type][0][i]] >= 2)
						{
							end = true;
						}
					}
					
					if(end)
					{
						System.out.println("죽음");
						break;
					}
				}
			}
			
			Del_Line();
			Screen(type);
		}
	}
	
	private void Del_Line() // 한줄이 꽉차면 없애버려야함
	{
		int lv = 0;
		int lv_count = 0;
		for(int y = Map.length-2; y > 0; y--)
		{
			for(int x = Map[y].length-2; x > 0; x--)
			{
				if(Map[y][x] == 2)
				{
					lv_count++;
				}
			}
			
			if(lv_count == 8)
			{
				for(int d_x = 1; d_x < Map[y].length-1 ; d_x++)
				{
					if(Map[y][d_x] == 2) // 블럭 지우기
					{
						Map[y][d_x] = 0;
					}
				}
				
				y++;// 블럭 지우기에 성공하면 y값을 땡겨와야함
				
				// 없어진 블럭을 위에서 당겨옴
				for(int d_y = Map.length-2; d_y > 0; d_y--)
				{
					for(int d_x = Map[0].length-2; d_x > 0; d_x--)
					{
						if(Map[d_y-1][d_x] == 2 && Map[d_y][d_x] == 0) // 블럭 땡겨오기
						{
							Map[d_y][d_x] = 2;
							Map[d_y-1][d_x] = 0;
						}
					}
				}
			}
			
			lv_count = 0;
		}
	}
	
	public int[][][] deepCopy(int[][][] array)
	{
		if(array == null) return null;
		
		int[][][] copy = new int[block.length][block[0].length][block[0][0].length];
		
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				System.arraycopy(array[i][j], 0, copy[i][j], 0, array[i][j].length);
			}
		}
		
		return copy;
	}
	
	private boolean CheckMove(int type, int Move_type) // 블럭이 들어갈수있는지 체크
	{
		if(Move_type == 0) return false;
		
		for(int i = 0; i < copy_block[type][0].length; i++)
		{
			if(Move_type == 1) // 우
			{
				if(Map[copy_block[type][1][i]][copy_block[type][0][i] + 1] >= 1)
				{
					return false;
				}
			}
			else if(Move_type == 3) // 좌
			{
				if(Map[copy_block[type][1][i]][copy_block[type][0][i] - 1] >= 1)
				{
					return false;
				}
			}
			else if(Move_type == 2) // 좌
			{
				if(Map[copy_block[type][1][i] + 1][copy_block[type][0][i]] >= 1)
				{
					return false;
				}
			}
		}

		return true;
	}
	
	private boolean CheckBlock(int[][][] block, int type) // 블럭이 마지막 위치인지 확인
	{
		for(int i = 0; i < block[type][0].length; i++)
		{
			if(Map[block[type][1][i] + 1][block[type][0][i]] >= 1)
			{
				return true;
			}
		}
		return false;
	}
	
	private void set_block_pos(int type, int Move_type) // 블럭 이동
	{
		for(int i = 0; i < copy_block[type][0].length; i++)
		{
			if(Move_type == 1) // 우
			{
				copy_block[type][0][i] += 1;
			}
			else if(Move_type == 3) // 좌
			{
				copy_block[type][0][i] -= 1;
			}
			else if(Move_type == 2) // 아래
			{
				copy_block[type][1][i] += 1;
			}
		}
	}
}