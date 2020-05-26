import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        SquareCalculator squareCalculator = new SquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(7831);
        Future<Integer> future2 = squareCalculator.calculate(2567);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(String.format("future1 is %s and future2 is %s", future1.isDone() ? "done" : "not done",
                    future2.isDone() ? "done" : "not done"));
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);
        squareCalculator.shutdown();
    }

}