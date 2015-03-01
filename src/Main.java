import java.io.FileNotFoundException;

/**
 * Created by josemarcelino on 2/26/15.
 */

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        Map mainMap = new Map();
        mainMap.Simulate(50);

        System.out.println("Finish . . .");
    }
}
