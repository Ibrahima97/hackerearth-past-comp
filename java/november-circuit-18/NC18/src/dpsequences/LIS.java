package dpsequences;

public class LIS {

    private static long lis(int [] array) {
        long table [] = new long[array.length];

        for (int i = 0; i < array.length ; i++) {
            table[i] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && table[i] < table[j] + 1)
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
                { 2, 5, 3, 7, 11, 8, 10, 13, 6 }
                ,{3, 10, 2, 1, 20}
                ,{3, 2}
                ,{10, 22, 9, 33, 21, 50, 41, 60, 80}
                ,{10, 22, 9, 33, 21, 50, 41, 60}
                ,{2, 3, 7, 8}
        };

        for (int [] values : matrix) {
            System.out.println(lis(values));
        }
    }
}
