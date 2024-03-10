import java.util.concurrent.Semaphore;
public class Max implements Runnable{
        int[] row;
        int max;
        Max(int[] row, int max) {
                this.max = max;
                this.row = row;
        }
        @Override
        public void run(){
                int largest = Integer.MIN_VALUE;
                        for (int element : row) {
                                if (element > largest) {
                                        largest = element;
                }
            }

        this.max = largest;

        }
	public int getMax(){
		return this.max;
	}

}

