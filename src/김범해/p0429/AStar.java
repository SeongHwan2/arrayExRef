package p0429;

import java.util.ArrayList;
import java.util.List;

public class AStar { // A* Algorithm 대각선 이동 제외
	
	public int ASearch(int Map[][], int s_x, int s_y, int e_x, int e_y)
	{
		if(!CheckMap(Map, e_x, e_y))
		{
			System.out.println("탐색 목표가 막힌 구간임");
			return 0;
		}
		
		List<Node> OpenList = new ArrayList<Node>(); // 열림목록
		List<Node> CloseList = new ArrayList<Node>(); // 닫힘목록
		
		int F = 0; // G + H;
		int G = 0; // 이동 방향 수평은 10
		int H = (Math.abs(s_x - e_x) + Math.abs(s_y - e_y)) * 10;
		Node Start_Node = new Node(null, s_x, s_y, F, G, H);
		
		for(int i = s_y - 1; i <= s_y + 1; i++) // 시작 위치 주변 탐색
		{
			for(int j = s_x - 1; j <= s_x + 1; j++)
			{
				if(i == s_y && j == s_x) // 자기자신은 제외
				{
					continue;
				}
				
				if(CheckMap(Map, j, i))
				{
					if((Math.abs(j - s_x) + Math.abs(i - s_y)) == 1) // 수평은 1, 대각선은 2
					{
						G = 10;
					}
					else
					{
						G = 14;
					}
					
					H = (Math.abs(j - e_x) + Math.abs(i - e_y)) * 10;
					OpenList.add(new Node(Start_Node, j , i, H+G, G, H));
				}
			}
		}

		while(true)
		{
			int f_x = 9999;
			int O_Index = 0;
			Node Now_Node = null;
			Node newNode = null;
			
			for(int i = OpenList.size()-1; -1 < i; i--) // 가장 비용이 낮은것을 선택 (마지막 노드부터 탐색)
			{
				if(f_x > OpenList.get(i).F)
				{
					f_x = OpenList.get(i).F;
					O_Index = i;
					Now_Node = OpenList.get(i);
				}
			}
			
			boolean check = true;
			boolean check_end = false;
			for(int y = Now_Node.y - 1; y <= Now_Node.y + 1; y++) // 시작 위치 주변 탐색
			{
				for(int x = Now_Node.x - 1; x <= Now_Node.x + 1; x++)
				{	
					if(CheckMap(Map, x, y) && !CheckNode(Now_Node, CloseList))
					{
						if((Math.abs(x - s_x) + Math.abs(y - s_y)) == 1) // 수평은 1, 대각선은 2
						{
							G = 10;
						}
						else
						{
							if(!CheckMap(Map, x, Now_Node.y) || !CheckMap(Map, Now_Node.x, y))
							{
								continue;
							}
							
							G = 14;
						}
						
						H = (Math.abs(x - e_x) + Math.abs(y - e_y)) * 10;
						
						newNode = new Node(Now_Node, x , y, H+G, G, H);
						for(int i = 0; i < OpenList.size(); i++)
						{
							if(OpenList.get(i).x == x && OpenList.get(i).y == y)
							{
								if(OpenList.get(i).G > G)
								{
									if((Math.abs(newNode.x - Now_Node.x) + Math.abs(newNode.y - Now_Node.y)) == 1)
									{
										newNode.G = 10;
									}
									else
									{
										newNode.G = 14;
									}
									
									newNode.F = H+G;
									
									OpenList.set(i, newNode);
									check = false;
								}
							}
						}
						
						if(check = true)
						{
							OpenList.add(newNode);
						}
						
						if(x == e_x && y == e_y)
						{
							check_end = true;
						}
					}
				}
			}
			
			OpenList.remove(O_Index);
			CloseList.add(Now_Node);
			if(OpenList.size() == 0 || check_end)
			{
				CloseList.add(newNode);
				break;
			}
		}
		
		boolean check = false;
		for(int y = 0; y < Map.length; y++)
		{
			for(int x = 0; x < Map[y].length; x++)
			{
				check = true;
				if(NodePaint(CloseList.get(CloseList.size()-1), x, y) > 0)
				{
					check = false;
				}
				
				if(check)
				{
					if(Map[y][x] == 1)
						System.out.print("■");
					else
						System.out.print("□");
				}
			}
			System.out.println();
		}
		
		int cnt = NodeCnt(CloseList.get(CloseList.size()-1), 0);
		System.out.println("최단거리 : " + cnt + "칸");
		return cnt;
	}
	
	public int NodeCnt(Node p, int cnt)
	{
		if(p.Parent_Node == null)
			return cnt;
		
		cnt++;
		return NodeCnt(p.Parent_Node, cnt);
	}
	
	public int NodePaint(Node p, int x, int y)
	{
		if(p.Parent_Node == null)
		{
			return 0;
		}
		
		if(p.x == x && p.y == y)
		{
			System.out.print("@");
			return 1;
		}
		
		return NodePaint(p.Parent_Node, x, y);
	}
	
	public boolean CheckNode(Node p, List<Node> pList)
	{
		for(int i = 0; i < pList.size(); i++)
		{
			if(p.x == pList.get(i).x && p.y == pList.get(i).y)
			{
				return true;
			}
		}
		
		return false;
	}
		
	public boolean CheckMap(int Map[][], int x, int y)
	{
		if(Map[y][x] != 1)
		{
			return true;
		}
		
		return false;
	}
	
	public class Node {
		Node Parent_Node;
		public int x = 0;
		public int y = 0;
		public int F = 0;
		public int G = 0;
		public int H = 0;
		
		public Node(Node Parent_Node, int x, int y, int F, int G, int H) {
			this.Parent_Node = Parent_Node;
			this.x = x;
			this.y = y;
			this.F = F;
			this.G = G;
			this.H = H;
		}
	}

}
