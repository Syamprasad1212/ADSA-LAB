import java.util.*;

class SumOfSubsets {

    int n;                
    int[] weights;         
    int[] x;              
    int target;          

    SumOfSubsets(int n, int[] weights, int target) {

        this.n = n;
        this.weights = weights;
        this.target = target;

        x = new int[n];   
    }

    void subset(int sum, int k) {
       

        if (sum == target) {
           

            System.out.print("Subset found: ");

            for (int i = 0; i < k; i++) {

                if (x[i] == 1)
                 
                    System.out.print(weights[i] + " ");
            }

            System.out.println();
            return;
        }

        if (k == n || sum > target)
         
            return;

        x[k] = 1;

        subset(sum + weights[k], k + 1);
        

        x[k] = 0;
     

        subset(sum, k + 1);
       
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] weights = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++)
            weights[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        SumOfSubsets obj =
                new SumOfSubsets(n, weights, target);

        System.out.println("\nSubsets with given sum are:\n");

        obj.subset(0, 0);
      
    }
}
