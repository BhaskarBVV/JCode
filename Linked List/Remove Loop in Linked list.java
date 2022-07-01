public static void removeLoop(Node head) 
    {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) 
            {
                fast = head;
                if (slow == head) 
                {
                    while (fast.next != slow)
                        fast = fast.next;
                    fast.next = null;
                    return;
                }
                
                else 
                {
                    while (slow.next != fast.next) 
                    {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    slow.next = null;
                    return;
                }
            } 
            
        }
    }
