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
	    Thread thMin = new Thread(new Min(matrix, min, semMin), "taskMin");
	    Thread thMax = new Thread(new Max(matrix, max, semMax), "taskMax");

	    thMin.start();
	    thMax.start();
	    /*
	    try{
		    thMin.join();
	            thMax.join();
	    } catch (InterruptedException e) {
		    e.printStackTrace();
	    }
	    */
	    semMin.acquire();
	    semMax.acquire();
            System.out.printf("Max value: %d\n", max);
            System.out.printf("Min value: %d\n", min);
            
        } catch (NumberFormatException e) {
            System.out.println("The size of the matrix must be an integer.");
            System.exit(1);
        }

        
    }
}
