package com.easycoding.base.collections;

/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/21$
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 链表：
 *      单向链表、双向链表、环形链表、带哨兵节点链表
 *          单向：只有一个指针节点 指向后续节点  单向链表用作新增、修改 单向读取 key和next
 *          双向：有两个指针节点 指向上一个指针节点 指向下一个终点指针 双向链表用作查询 双向读取 prev next key NIL表示没有前驱 代表头指针
 *          环形链表: 双向链表归属链表 线性结构
 *          带哨兵节点链表：有哨兵节点不需要判断链表为空和删除第一个位置节点的情况
 *
 * */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.forEach(x-> System.out.println(x.toLowerCase()));
    }
}
