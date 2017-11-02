package visitthecities;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class VisitTheCities {
    public static void main(String[] args) {
        
        /* Generate random number */
        System.out.println("Welcome to the City Tracking Application!"); // Welcome text
        
        Random randomGenerator = new Random(); // Create random number generator object.
        int rand = randomGenerator.nextInt(10) + 1; // Generates random number between 1 and 10 inclusive.
        System.out.println("The random number generated is " + rand + ". \n"); // Display randomly generated number.
        
        
        /* Stores user's inputs */
        Scanner sc = new Scanner(System.in);
        Queue queueOfCities = new Queue(rand); // Create queue to store user's input
        ArrayList listOfCities = new ArrayList();
        for (int i=0; i<rand; i++) // number of input is based on the value of random number. Minimum of 1 input, maximum of 10 inputs.
        {
            System.out.print("Enter the name of city #" + (i+1) + ": "); // Store input into user's queue.
            String input = sc.nextLine();
            queueOfCities.enqueue(input);
            listOfCities.add(input);
        }
        
        
        /* List out all cities */
        System.out.println();
        System.out.println("List of cities visited:"); // List out cities one by one
        for (int i=0; i<rand; i++)
        {
            System.out.println((i+1)+". " + (String)queueOfCities.dequeue());
        }
        
        
        /* Finds out the number of unique cities */
        int numOfUniqueCities=0;
        for (int i=0; i<listOfCities.size(); i++) //compare first element with...
        {
            boolean isDistinct = true;
            for (int j=0; j<listOfCities.size(); j++) // the second element and the rest one-by-one
            {
                String first = (String)listOfCities.get(i);
                String second = (String)listOfCities.get(j);
                if (first.equalsIgnoreCase(second) && i!=j) // if first element equals to one of the elements in the array, then isDistinct becomes false
                {
                    isDistinct = false;
                    break; // in which case, we can break out of the inner loop knowing that this element is not distinct
                }
            }
            if (isDistinct) // if it isDistinct, then numOfUniqueCities adds one.
            {
                numOfUniqueCities++;
            }
        }
        System.out.println("\nThe number of unique cities: " + numOfUniqueCities);
        
    }
}
