package AlgoBasic1;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class n_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();

        for(int i=0; i<str.length(); i++)
            lstack.push(str.charAt(i));

        for(int i=0; i<M; i++) {
            str = br.readLine();
            switch (str.charAt(0)) {
                case 'P':
                    lstack.push(str.charAt(2));
                    break;
                case 'D':
                    if(!rstack.isEmpty())
                        lstack.push(rstack.pop());
                    break;
                case 'L':
                    if(!lstack.isEmpty())
                        rstack.push(lstack.pop());
                    break;
                case 'B':
                    if(!lstack.isEmpty()) {
                        lstack.pop();
                    }
            }
        }
        while(!lstack.isEmpty())
            rstack.push(lstack.pop());

        while(!rstack.isEmpty())
            bw.write(rstack.pop());

        bw.flush();
        bw.close();
    }
}