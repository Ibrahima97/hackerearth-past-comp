import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdditionErrors {

    /**
     * https://www.hackerearth.com/challenge/competitive/november-circuits-18/algorithm/addition-errors-68e27044/
     * DONE
     * */


    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int cases = Integer.parseInt(reader.readLine());
            while (cases>0) {

                long a = Long.parseLong(reader.readLine());
                long b = Long.parseLong(reader.readLine());

                if (a+b < 10)
                    System.out.println(0);
                else {
                    long d = 1, acc = 0, ca = a, cb = b;
                    while (a > 0 || b > 0) {
                        acc += (a + b) % 10 * d;
                        a/=10;
                        b/=10;
                        d *= 10;
                    }
                    System.out.println(ca+cb-acc);
                }
                cases--;
            }

        } catch (IOException ignored) {}
    }
}
