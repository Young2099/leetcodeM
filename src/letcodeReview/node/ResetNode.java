package letcodeReview.node;

public class ResetNode {
    public static void main(String[] args) {
        Node node3 = new Node(4, null);
        Node node2 = new Node(3, node3);
        Node node1 = new Node(2, node2);
        Node node = new Node(1, node1);
//        while (node != null){
//            System.out.println(node.val);
//            node = node.next;
//        }
        Node newNode = new ResetNode().resetNode1(node);
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    private Node resetNode(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node pre = resetNode(node.next);
        node.next.next = node;
        node.next = null;

        return pre;
    }

    private Node resetNode1(Node head) {
        if (head == null) {
            return null;
        }
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
