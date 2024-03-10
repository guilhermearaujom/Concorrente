import java.util.concurrent.Semaphore;

public class Min implements Runnable{
	Semaphore sem;
        int[][] matrix;
        int min;
        Min(int[][] matrix, int min, Semaphore sem) {
		this.sem = sem;
                this.min = min;
                this.matrix = matrix;
        }
        @Override
        public void run(){
                int smallest = Integer.MAX_VALUE;
                for (int[] row : matrix) {
                        for (int element : row) {
                                if (element < smallest) {
                                        smallest = element;
                }
            }
        }

        this.min = smallest;
	sem.release();

        }
	
	public int getMin(){
		return min;
	}
}
