import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ratio {

    /**
     * https://www.hackerearth.com/challenge/competitive/november-circuits-18/algorithm/ratio-d0549bb2/
     * */

    private static class Pair {
        private String type; long quantity;
        Pair(String type, long quantity) {
            this.type = type;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(reader.readLine().trim());
            while (cases > 0) {
                int q = Integer.parseInt(reader.readLine().trim());
                Pair [] pairs = new Pair[q];
                for (int i = 0; i < q ; i++) {
                    StringTokenizer tk = new StringTokenizer(reader.readLine().trim(), " ");
                    long quantity = Long.parseLong(tk.nextToken());
                    String type = tk.nextToken();
                    pairs[i] = new Pair(type, quantity);
                }
                long acc = 0;
                boolean flag = true;
                for (int i = 0; i < q-1 ; i++) {
                    if (pairs[i].quantity > 0 && pairs[i+1].quantity > 0) {
                        if (!pairs[i].type.equals(pairs[i+1].type)) {
                            flag = false;
                            pairs[i+1].quantity -= Math.min(pairs[i].quantity, pairs[i+1].quantity);
                            acc++;
                        }
                        else {
                            pairs[i+1].quantity += pairs[i].quantity;
                        }
                    }
                }
                System.out.println(flag ? pairs[q-1].quantity : acc);
                cases--;
            }
        } catch (IOException ignored) {}
    }
}
