import java.util.ArrayList;
import java.util.List;

public class Solution2 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
//        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(9);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(4);\
        addTwoNumbers2(listNode1, listNode2);

        System.out.println(addTwoNumbers2(listNode1, listNode2));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        String digit1 = getReverseInputString(l1);

        String digit2 = getReverseInputString(l2);

        int resultIntValue = Integer.valueOf(digit1) + Integer.valueOf(digit2);

        return combineArr2Node(resultIntValue);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry =0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }

        if(carry==1)
            p3.next=new ListNode(1);

        return newHead.next;
    }

    private static String getReverseInputString(ListNode l2) {
        List<Integer> list2 = new ArrayList<>();
        extractNode(l2, list2);
        StringBuilder digit2 = new StringBuilder();
        for (int i = list2.size()-1; i >= 0; i--) {
            digit2.append(list2.get(i));
        }
        return digit2.toString();
    }

    public static void extractNode(ListNode listNode, List<Integer> arr) {
        arr.add(listNode.val);
        if (listNode.next != null) {
            extractNode(listNode.next, arr);
        }
    }

    public static <T> void printList(List<T> t) {
        t.forEach(System.out::println);
    }
    public static ListNode combineArr2Node(int value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(value);
        String resultString = stringBuilder.reverse().toString();
        char[] resultChar = resultString.toCharArray();
        int currentIndex = 0;
        ListNode listNode = new ListNode(0);
        boolean isRootNull = true;
        genNode(resultChar, currentIndex,listNode,isRootNull);
        return listNode;
    }

    public static void genNode(char[] chars, int currentIndex, ListNode listNode,boolean isRootNull) {
        int length = chars.length;
        int nextindex = currentIndex + 1;
        if (length > currentIndex) {
            int value = Integer.valueOf(String.valueOf(chars[currentIndex]));
            if (isRootNull && value != 0) {
                listNode.val = value;
                isRootNull = false;
            } else {
                listNode.next = new ListNode(value);
            }
            genNode(chars,nextindex,listNode,isRootNull);
        }

    }

}
