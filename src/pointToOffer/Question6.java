package pointToOffer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Question6 {

    //methond1：迭代
    public static void recursive(LinkedNode head) {
        if(head != null) {
            if(head.next != null) {
                recursive(head.next);
            }
            System.out.println(head.value);
        }
    }

    //method2：利用栈
    public static void stack(LinkedNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.value);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
