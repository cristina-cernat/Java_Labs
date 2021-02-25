package Lab_1;
public class Optional_1 {

    public static void main(String[] args) {

        int n;
        boolean isConnected;
        if (args.length != 1) throw new IllegalArgumentException("One integer argument required");
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The argument is not integer");
        }

        n = Integer.parseInt(args[0]);
        boolean[][] matrix = new boolean[n][n];

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

//        static void DFS(int position, ) {
//
//        }
    }
}