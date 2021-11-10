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
/*
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		LinkedList <Integer> que= new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<num; i++) {
			String input= br.readLine();
			st=new StringTokenizer(input , " ");
			String s=st.nextToken();
	
	
			
			 
			switch(s) {
			case "push":
				que.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(que.size()==0) {sb.append("-1").append("\n"); break;}
				sb.append(que.poll()).append("\n"); break;
		
			case "size":
				sb.append(que.size()).append("\n");
				break;
				
			case "empty":
				if(que.isEmpty()) sb.append("1").append("\n");
				else sb.append("0").append("\n");
				break;
				
			case "front":
				if(que.size()==0) {sb.append("-1").append("\n"); break;}
				sb.append(que.get(0)).append("\n");
				break;
				
			case "back":
				if(que.size()==0) {sb.append("-1").append("\n"); break;}
				sb.append(que.get(que.size()-1)).append("\n");
				break;
				
				
			}
		}
		System.out.println(sb);
	}
}
*/