import java.io.*;
import java.util.*;

public class JavaEditor3 {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public void swap(int i1, int i2) {
            int temp;
            temp = data.get(i1);
            data.set(i1, data.get(i2));
            data.set(i2, temp);
        }

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) {
            data.add(val);
            upHeapify(data.size() - 1);
        }

        public void upHeapify(int index) {
            if (index == 0)
                return;

            int parent = (index - 1) / 2;
            if (data.get(index) < data.get(parent)) {
                swap(index, parent);
                upHeapify(parent);
            }
        }

        public int remove() {
            int val = peek();
            if (val == -1)
                return -1;
            swap(0, data.size() - 1);
            data.remove(data.size() - 1);
            downHeapify(0);
            return val;
        }

        public void downHeapify(int parent) {
            int minIdx = parent;
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            if (leftChild < data.size() && data.get(leftChild) < data.get(minIdx))
                minIdx = leftChild;
            if (rightChild < data.size() && data.get(rightChild) < data.get(minIdx))
                minIdx = rightChild;
            if (minIdx != parent) {
                swap(parent, minIdx);
                downHeapify(minIdx);
            }
        }

        public int peek() {
            if (data.size() != 0)
                return data.get(0);
            System.out.println("Underflow");
            return -1;
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
