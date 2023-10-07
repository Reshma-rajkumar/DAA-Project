import java.util.PriorityQueue;

class HuffmanCode implements Comparable<HuffmanCode> {
    char sym;
    int freq;
    HuffmanCode left;	
    HuffmanCode right;

    public HuffmanCode(char sym, int freq) {
        this.sym = sym;
        this.freq = freq;
    }

    @Override
    public int compareTo(HuffmanCode other) {
        return Integer.compare(this.freq, other.freq);
    }
}

public class HuffmanCodingTime {

    public static void main(String[] args) {
        int[] inputSizes = {100, 1000, 10000, 100000, 1000000};

        for (int size : inputSizes) {
            long startTime = System.nanoTime();
            generateHuffmanCodes(size);
            long endTime = System.nanoTime();

            long elapsedNanos = endTime - startTime;

            System.out.println("\n SymbolSize (n):" + size +"\t Run Time: " + elapsedNanos + " in nanoseconds");

        }
    }

    public static void generateHuffmanCodes(int n) {
        PriorityQueue<HuffmanCode> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.offer(new HuffmanCode((char) ('A' + i), 1));
        }

        while (minHeap.size() > 1) {
            HuffmanCode left = minHeap.poll();
            HuffmanCode right = minHeap.poll();
            HuffmanCode internalNode = new HuffmanCode('\0', left.freq + right.freq);
            internalNode.left = left;
            internalNode.right = right;
            minHeap.offer(internalNode);
        }
    }
}

