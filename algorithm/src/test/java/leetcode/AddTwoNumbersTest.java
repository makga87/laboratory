package leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class AddTwoNumbersTest {

    @Test
    void test() {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode node = new ListNode(7);
        curr.next = node;
        curr = curr.next;

        ListNode node1 = new ListNode(0);
        curr.next = node1;
        curr = curr.next;

        ListNode node2 = new ListNode(8);
        curr.next = node2;
        curr = curr.next;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void reference() {

        Member a = new Member(1);
        Member b = a;
        System.out.println(a.id);
        System.out.println(b.id);

        Member c = new Member(3);
        b = c;

        System.out.println(a.id);
        System.out.println(b.id);
        System.out.println(c.id);

    }

    class Member {

        public int id;

        public Member(int id) {
            this.id = id;
        }
    }
}