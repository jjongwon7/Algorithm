//package AlgoBasic1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class n_2089 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        if (n < 0) {
//            int abs = Math.abs(n);
//            String str = Integer.toBinaryString(abs);
//            char[] charArray = str.toCharArray();
//            for (int i = 0; i < str.length(); i++) {
//                if (charArray[i] == '0') {
//                    charArray[i] = '1';
//                } else {
//                    charArray[i] = '0';
//                }
//            }
//            for (int i = str.length() - 1; i >= 0; i--) {
//                charArray[i]
//            }
//        }
//    }
//
//}
