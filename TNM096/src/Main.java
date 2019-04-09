import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] start = { 4, 1, 2, 8, 3, 5, 7, 9, 0 };

        long startTime = System.currentTimeMillis();
        //Search.search(start);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        System.out.print("Tid som kör " + duration + " milisekunder.");

    }

    //Count inversions
    static int getCount(int arr[])
    {
        int inv_count = 0;
        for (int i = 0; i < 9 - 1; i++)
            for (int j = i + 1; j < 9; j++)
                if (arr[j] > 0 && arr[i] > 0 && arr[i] > arr[j])
                    inv_count++;
        return inv_count;
    }

    // Returns true if puzzle is solvable.
    static boolean canItBeSolved(int[] puzzle)
    {
        // Count inversions
        int invCount = getCount(puzzle);

        // return true if inversion count is even.
        return (invCount % 2 == 0);
    }
}
