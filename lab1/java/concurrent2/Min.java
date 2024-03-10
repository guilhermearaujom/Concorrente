import java.util.concurrent.Semaphore;

public class Min implements Runnable{
        int[] row;
        int min;
        Min(int[] row, int min) {
                this.min = min;
                this.row = row;
        }
        @Override
        public void run(){
                int smallest = Integer.MAX_VALUE;
			for (int element : row) {
				if (element < smallest) {
					smallest = element;
                }
            }

        this.min = smallest;

        }
	
	public int getMin(){
		return min;
	}
}
