import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingIntervals {

    private static long solver(long [] values, long t) {
        int limit = values.length;
        long acc = 0;
        for (int i = 0; i < limit-1 ; i++) {
            if(values[i] <= t) {
                for (int j = i; j <limit-1; j++) {
                    long min = values[i];
                    for (int k = i+1; k < j+1 ; k++) {
                        if (min > values[k])
                            min = values[k];
                    }
                    if (min + values[i] + values[j] <= t)
                        acc++;
                }
            }
        }
        return acc;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tk.nextToken());
            long k = Long.parseLong(tk.nextToken());
            long [] values = new long[n];
            tk = new StringTokenizer(reader.readLine(), " ");
            for (int i = 0; tk.hasMoreTokens() ; i++) {
                values[i] = Long.parseLong(tk.nextToken());
            }

            System.out.println(solver(values, k));

        } catch (IOException ignored) {}
    }
}
