import java.util.concurrent.Semaphore;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Find {
  

    public static void main(String[] args) throws InterruptedException {
	int min = Integer.MAX_VALUE;;
        int max = Integer.MIN_VALUE;
	List<Thread> threads = new ArrayList<>();
	List<Min> minRunnables = new ArrayList<>();
	List<Max> maxRunnables = new ArrayList<>();

        if (args.length != 1) {
            System.out.println("Use: java Main <size>");
            System.exit(1);
	}

        try {
            int size = Integer.parseInt(args[0]);
	    int[][] matrix = Matrix.generateMatrix(size);

	    for (int[] row : matrix) {
		   Min minRunnable = new Min(row, min);
		   Max maxRunnable = new Max(row, max);
		   Thread thMin = new Thread(minRunnable, "taskMin");
		   Thread thMax = new Thread(maxRunnable, "taskMax");

		   maxRunnables.add(maxRunnable);
		   minRunnables.add(minRunnable);
		   threads.add(thMin);
		   threads.add(thMax);

		   thMin.start();
		   thMax.start();
	    
	    }
	    
	    for(Thread thread : threads) {
		    try {
			    thread.join();
		    } catch (InterruptedException e) {
			    e.printStackTrace();
            }
	    }

	    for(Min elemento : minRunnables){
		    if(elemento.getMin() < min){
			    min = elemento.getMin();
		    }

	    }
	     for(Max elemento : maxRunnables){
                    if(elemento.getMax() > max){
                            max = elemento.getMax();
                    }

            }
            System.out.printf("Max value: %d\n", max);
            System.out.printf("Min value: %d\n", min);
            
        } catch (NumberFormatException e) {
            System.out.println("The size of the matrix must be an integer.");
            System.exit(1);
        }

        
    }
}
