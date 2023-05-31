package AlgoBasic1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//public class n_1918 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        Stack<Character> stack = new Stack<Character>();
//        ArrayList<Character> arrayList = new ArrayList<>();
//        int stackSize = 0;
//        int priority = 0;
//        for (char c : str.toCharArray()) {
//            // 알파벳이 들어온 경우
//            if (Character.isAlphabetic(c)) {
//                arrayList.add(c);
//            }
//            // 기호가 들어온 경우
//            else {
//                // 여는 괄호가 들어온 경우
//                if (c == '(') {
//                    stackSize = stack.size();
//                }
//                // 닫는 괄호가 들어온 경우
//                else if (c == ')') {
//                    for()
//                }
//                // 연산자가 들어온 경우
//                else {
//                    stack.push(c);
//                    if (c == '+' || c == '-') {
//                        priority = -1;
//                    } else if (c == '*' || c == '/') {
//                    }
//                }
//            }
//
//        }
//        // 스택에 남아있는 것들은 모두 후위로
//        if (!stack.isEmpty()) {
//            arrayList.add(stack.pop());
//        }
//        System.out.println(arrayList);
//    }
//}
