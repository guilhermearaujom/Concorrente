import java.util.concurrent.Semaphore;
public class Max implements Runnable{
        int[][] matrix;
        int max;
	Semaphore sem;
        Max(int[][] matrix, int max, Semaphore sem ) {
		this.sem = sem;
                this.max = max;
                this.matrix = matrix;
        }
        @Override
        public void run(){
                int largest = Integer.MIN_VALUE;
                for (int[] row : matrix) {
                        for (int element : row) {
                                if (element > largest) {
                                        largest = element;
                }
            }
        }


        this.max = largest;
	sem.release();
	

        }
	public int getMax(){
		return this.max;
	}

}

