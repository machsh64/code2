package day14;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-29 11:05
 * @description:
 **/
public class OCTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        System.out.println("输入括号");
        String str = scan.next();

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack1.push(str);
                    break;
                case ')':
                case ']':
                case '}':
                    stack2.push(str);
                    break;
            }
        }

        for (int i = 0; i < stack1.size(); i++) {
            if (!stack1.pop().equals(stack2.pop())) {
                System.out.println("括号不匹配");
            } else {
                System.out.println("括号匹配");
            }
        }
    }
}
