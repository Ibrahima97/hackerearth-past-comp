package dpsequences;

public class LDS {
    private static long lds(int [] array) {
        long table [] = new long[array.length];

        for (int i = 0; i < array.length ; i++) {
            table[i] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j] && table[i] < table[j] + 1)
                    table[i] = table[j] + 1;
            }
        }
        long max =  1;
        for (int i = 0; i < table.length ; i++) {
            if (max < table[i])
                max = table[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int [][] matrix = {
                { 15, 27, 14, 38, 63, 55, 46, 65, 85 }
                ,{50, 3, 10, 7, 40, 80}
        };

        for (int [] values : matrix) {
            System.out.println(lds(values));
        }
    }
}
