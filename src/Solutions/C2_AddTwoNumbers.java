package Solutions;
public class C2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solNode = new ListNode();
        ListNode returnNode = solNode;
        while (l1.next != null || l2.next != null) {
            solNode.val += l1.val + l2.val;
            if (solNode.val >= 10) {
                solNode.val -= 10;
                solNode.next.val += 1;
            }
            solNode = solNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        int val1, val2 = 0;
        return returnNode;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

