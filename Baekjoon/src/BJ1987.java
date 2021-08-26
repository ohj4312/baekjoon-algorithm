

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ1987 {
	private static int cnt=0,max=0;
	private static char[][] arr;
	private static Set<Character> set;	
	private static int[] dx= {-1,1,0,0}; //상하좌우
	private static int[] dy= {0,0,-1,1}; //상하좌우
	public static void main(String[] args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str," ");
		
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		arr=new char[r][c];
		for(int i=0;i<r;i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		set=new HashSet<>();
		
		setMove(0, 0);
		//출력
		System.out.println(max);
		
	}
	
	private static void setMove(int x,int y) {
		set.add(arr[x][y]);
		cnt++;
		//System.out.println("X : "+x+" Y : "+y+"/ add : "+arr[x][y]+" cnt : "+cnt);
		int tempx=x,tempy=y;
		for(int i=0;i<4;i++) {
			if(i==3) { //네방향을 모두 검사할때
				if(max < cnt)
					max = cnt;			
			}
			
			if(x+dx[i]>=arr.length||y+dy[i]>=arr[0].length||x+dx[i]<0||y+dy[i]<0) continue;
			tempx=x+dx[i];
			tempy=y+dy[i];
			//이것이 나의 가지치기
			if(set.contains(arr[tempx][tempy])) {
				continue;
			}
			setMove(tempx,tempy);
			if(set.contains(arr[tempx][tempy])) {
				set.remove(arr[tempx][tempy]);
				cnt--;
			}
		}
		
	}
}
