package QueueAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue=new LinkedList<>();
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st= null;
		for(int t=0;t<n;t++) {
			st=new StringTokenizer(br.readLine()," ");
			String txt=st.nextToken();
			if(txt.equals("push")) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}else if(txt.equals("pop")) {
				if(queue.isEmpty()) System.out.println(-1);
				else{
					int temp=queue.poll();
					System.out.println(temp);
				}
			}else if(txt.equals("size")) {
				System.out.println(queue.size());
			}else if(txt.equals("empty")) {
				if(queue.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}else if(txt.equals("front")) {
				if(queue.isEmpty()) System.out.println(-1);
				else{
					int temp=queue.peek();
					System.out.println(temp);
				}
			}else if(txt.equals("back")) {
					Queue<Integer> queue2=new LinkedList<>(queue);
					int temp=-1;
					while(!queue2.isEmpty()) {
						temp=queue2.poll();
					}
					System.out.println(temp);
			}
		}
	}
}
