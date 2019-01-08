import java.util.ArrayList;
import java.util.List;

public class Solution2 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(8);
//        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(0);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers1(listNode1, listNode2));
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
        ListNode listNode = null;
        genNode(resultChar, currentIndex,listNode);
        return listNode;
    }

    public static void genNode(char[] chars, int currentIndex, ListNode listNode) {
        int length = chars.length;
        int nextindex = currentIndex + 1;
        if (length > currentIndex) {
            int value = Integer.valueOf(String.valueOf(chars[currentIndex]));
            if (value != 0 && listNode == null) {
               listNode = new ListNode(value);
            }else {
                listNode.next = new ListNode(value);
            }
            genNode(chars,nextindex,listNode.next);
        }
    }

}
