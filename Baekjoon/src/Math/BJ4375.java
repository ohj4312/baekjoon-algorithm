package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ4375 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while ((input = br.readLine()) != null) {
            n = Integer.parseInt(input);
            int num = 0;
            for (int i = 1; i <= n; i++) {
                num = num * 10 + 1;
                num %= n;
                if (num == 0) {
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//새로운 접근법으로 간다!
		String input ;
		while((input = br.readLine()) != null||(input = br.readLine()) != ""){
			 BigInteger n=new BigInteger(input);
			StringBuilder one=new StringBuilder("1");
			BigInteger zero=new BigInteger("0");
			boolean flag=true;
			while(flag) {
				BigInteger num=new BigInteger(one.toString());
				if(num.divide(n).compareTo(zero) > 0 && num.remainder(n).compareTo(zero)==0) break;
				else one.append("1");
			}
			
			System.out.println(one.length());
		}
		//long num=n,cnt=1;
		/*while(flag) {
			
			long temp=num;
			
			
			while(flag) {
				num=n*cnt;
				temp=num;
				cnt++;
				
				while(temp>=0) {
					if(temp%10!=1)break;
					temp=temp/10;
					if(temp==0) flag=false; 
				}
				
				System.out.println("num : "+num+" "+temp+" cnt: "+cnt);
			}
			
		}
		
		String answer=num+"";
		
		System.out.println(answer.length());
		
		
	}
}
*/
