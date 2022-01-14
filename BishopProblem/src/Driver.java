import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String start, end;
        int maxSteps;
        BishopProblem bishops;

        System.out.print("Please enter the start coordinates: ");
        start = in.nextLine();
        System.out.print("Please enter the end coordinates: ");
        end = in.nextLine();
        System.out.print("Please enter the max number of steps: ");
        maxSteps = in.nextInt();

        bishops = new BishopProblem(start, end, maxSteps);
        if (bishops.checkPossible())
            System.out.println("A bishop can reach " + end + " from " + start + " in " + maxSteps + " steps or less.");
        else
            System.out.println("A bishop cannot reach " + end + " from " + start + " in " + maxSteps + " steps or less.");
        in.close();
    }    
}