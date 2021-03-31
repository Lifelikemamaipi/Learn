package 算法;

/**
 *
 *
 * @author ：Good_M
 * @date ：Created in 2020 2020/10/22 23:18
 */
public class 找到链表倒数第N个元素 {
    public static void main(String[] args) {
        int[] inputs = {5,3,7,2,4,1,9,6,8};
        Node head = buildLinkList(inputs);
        Node node = findNthFromEnd(head,2);
        System.out.println("链表倒数第3个元素是：" + node.data);
    }


    /**
     * 类似双游标
     * 整体思路，先将第n个元素，然后将当前头节点作为结果
     * 然后每次判断下一个元素是否为空，若为空则输出当前res
     *
     *
     * @param head 头结点
     * @param n 倒数第n个元素
     * @return 要查找的节点
     */
    public static Node findNthFromEnd(Node head, int n){
        if (null == head) {
            return null;
        }
        Node res = head;
        //把p2指针移动到正数第n个结点
        for(int i=1; ; i++){
            //将当前节点的下一个节点赋值给当前节点，达到后移效果
            head = head.next;
            //先将查询位置移到第n个位置
            if (i < n) {
                if (null == head) {
                    throw new IllegalArgumentException("参数n超出链表长度！");
                }
                continue;
            }
            //判断是否都链表尾部
            if (null == head) {
                break;
            }
            //没到尾部，将结果指向当前节点的下一节点
            res = res.next;
        }
        return res;
    }


    //快速创建链表
    private static Node buildLinkList(int[] array){
        Node head = new Node(array[0]);
        Node p = head;
        for(int i=1; i<array.length; i++){
            p.next = new Node(array[i]);
            p = p.next;
        }
        return head;
    }

    //链表节点
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
