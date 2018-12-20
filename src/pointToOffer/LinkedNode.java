package pointToOffer;

/**
 * 链表节点
 */
public class LinkedNode {

    int value;

    LinkedNode next;

    public LinkedNode(int value) {
        this.value = value;
    }

    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }

}
