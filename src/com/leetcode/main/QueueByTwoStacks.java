package com.leetcode.main;

import java.util.Stack;

/**
 * @author gongshiyun
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *              思路:
 *              1.stack1作为入队列,stack2作为出队列
 *              2.pop:当stack2为空时,stack1全部出栈到stack2,stack2再出栈顶部元素
 * @date 2018/7/19
 */
public class QueueByTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("队列为空");
        }

        if (stack2.empty()) {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
