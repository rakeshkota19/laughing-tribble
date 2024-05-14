/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node ptr = head;
        Node pre = head;
        Node newHead = null;

        while (ptr != null) {
            Node nn = new Node(ptr.val);
            nn.next = ptr.next;
            ptr.next = nn;
            ptr = nn.next;
        }

        ptr = head;
        Node nxt;

        while (ptr != null) {

            nxt = ptr.next;
            if (ptr.random != null)
                nxt.random = ptr.random.next;
            else
                nxt.random = null;

            ptr = ptr.next.next;
        }
        
        ptr = head;
        newHead = new Node(0);
        Node nn = newHead;
        while (ptr != null) {
            newHead.next = ptr.next;
            newHead = newHead.next;

            ptr.next = ptr.next.next;
            ptr = ptr.next;
        }

        return nn.next;
    }
}