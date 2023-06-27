public class question {
    // Q --> Happy Number
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = findsquare(slow);
            fast = findsquare(findsquare(fast));
        } while (slow != fast);
        
        if(slow == 1) {
            return true;
        }
        return false;
    }

    private int findsquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans = ans + rem*rem;
            number/=10;
        }
        return ans;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // skipping left - 1 node
        ListNode prev = null;
        ListNode current = head;
        
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;
        // reversing the list between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) {
                next = next.next;
            }
        }
        
        if (last != null) {
            last.next = prev;
        }else {
            head = prev;
        }
        
        newEnd.next = current;
        return head;
        
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int l = 1;
        while (temp.next != null) {
            temp = temp.next;
            l++;
        }
        temp.next = head;
        int rot = k % l;
        int skip = l - rot;

        ListNode newEnd = head;

        for (int i = 0; i < skip - 1; i++) {
            newEnd = newEnd.next;
        }
        head = newEnd.next;
        newEnd.next = null;
        return head;
    }
    
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode mid = middleNode(head);

        ListNode hs = reverseList(mid);
        ListNode hf = head;
        
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        
        if (hf != null) {
            hf.next = null;
        }
        
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headsecond = reverseList(mid);
        ListNode re_reversehead = headsecond;
    
        while (head != null && headsecond != null) {
            if (head.val != headsecond.val) {
                break;
            }
            head = head.next;
            headsecond = headsecond.next;
    
        }
        reverseList(re_reversehead);
    
        return head == null || headsecond == null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode listpointer = list;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            listpointer.next = new ListNode(sum % 10);
            carry = sum / 10;
            listpointer = listpointer.next;
        }
        if (carry > 0) {
            listpointer.next = new ListNode(carry);
        }

        return list.next;
    }
    
}
