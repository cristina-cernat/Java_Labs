package Lab_1;
public class Optional_1 {

    public static void DFS(boolean[][] matrix, int position, boolean[] visited) {

        if(!visited[position]) {
            visited[position] = true;
            System.out.print(position + 1 + " ");
            for(int i = 0; i < matrix.length; i++) {
                if(matrix[position][i] && !visited[i]) {
                    DFS(matrix, i, visited);
                }
            }
        }

    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int n;

        if (args.length != 1) throw new IllegalArgumentException("One integer argument required");
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The argument is not integer");
        }

        n = Integer.parseInt(args[0]);
        boolean[][] matrix = new boolean[n][n];     // my matrix

        // Generate matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (i != j) {
                    if (!matrix[i][j]) {
                        boolean element = Math.random() < 0.5;
                        matrix[i][j] = element;
                        matrix[j][i] = element;
                    }
                } else matrix[i][i] = false;
        }

        // Connected graph or not
        boolean isConnected;
        boolean [] visited = new boolean[matrix.length];

        int componentSum = 0;
        for(int i = 0; i < matrix.length; i++) {
            if(!visited[i]) {
                System.out.println("Component: ");
                DFS(matrix,i,visited);
                ++componentSum;
            }
        }

        isConnected = componentSum == 1;

        if(isConnected)
            System.out.println("\nThe graph is connected");
        else
            System.out.println("\nThe graph is NOT connected");

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        if (n < 30000) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j]){
                        System.out.print("\u26AB" + " ");
                    }
                    else {
                        System.out.print("\u26AA" + " ");
                    }

                }
                System.out.println();
            }
        }
        else {
            System.out.println(totalTime);
        }
    }
}