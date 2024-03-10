import java.util.concurrent.Semaphore;
public class Find {
  

    public static void main(String[] args) throws InterruptedException {
	int min = 0;
        int max = 0;
	Semaphore semMax= new Semaphore(0);
	Semaphore semMin = new Semaphore(0);

        if (args.length != 1) {
            System.out.println("Use: java Main <size>");
            System.exit(1);
        }

        try {
            int size = Integer.parseInt(args[0]);
	    int[][] matrix = Matrix.generateMatrix(size);

	    
	    Min minRunnable = new Min(matrix, min, semMin);
	    Max maxRunnable = new Max(matrix, max, semMax);

	    Thread thMin = new Thread(minRunnable, "taskMin");
	    Thread thMax = new Thread(maxRunnable, "taskMax");

	    thMin.start();
	    thMax.start();

	    semMin.acquire();
	    semMax.acquire();

	    min = minRunnable.getMin();
	    max = maxRunnable.getMax();

            System.out.printf("Max value: %d\n", max);
            System.out.printf("Min value: %d\n", min);
            
        } catch (NumberFormatException e) {
            System.out.println("The size of the matrix must be an integer.");
            System.exit(1);
        }

        
    }
}
