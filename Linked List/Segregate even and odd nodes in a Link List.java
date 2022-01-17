Node divide(int N, Node head){
        Node even = new Node(-1), odd = new Node(-1), etemp = even, otemp = odd;
        Node temp = head;
        while (temp != null) {
            if (temp.data % 2 == 0) {
                etemp.next = temp;
                etemp = etemp.next;
            } else {
                otemp.next = temp;
                otemp = otemp.next;
            }
            temp = temp.next;
        }
        even = even.next;
        odd = odd.next;
        Node newhead = null;
        if (even != null) {
            newhead = even;
            if (odd != null) {
                etemp.next = odd;
                otemp.next = null;
            } else
                etemp.next = null;
        } else if (odd != null) {
            newhead = odd;
            otemp.next = null;
        } else
            newhead = null;
        return newhead;
    }
