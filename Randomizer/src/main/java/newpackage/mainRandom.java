
package newpackage;

import java.util.*;

public class mainRandom 
{
    public static Random rand = new Random();
    public static Scanner in = new Scanner (System.in);

    public static List<String> peopleList = new ArrayList<String>();
    public static List<Integer> numberList = new ArrayList<Integer>(); 
    public static List<Integer> randomList = new ArrayList<Integer>();

    public static int userMenu()
    {
        System.out.println("Please choose an option: "
                + "\n1) add person to list"
                + "\n2) run Randomizer"
                + "\n3) run final output"
                + "\n4) Exit"
                + "\n");
        int option = in.nextInt();
        
        return option;
    }
    
    public static void userOption(int choice)
    {
        switch(choice)
        {
            case 1:
                addUser();
                System.out.println("####################################################\n");
                userOption(userMenu());
                break;
                
            case 2:
                addRandom();
                System.out.println("####################################################\n");
                userOption(userMenu());
                break;
                
            case 3:
                finalRandom();
                break;
                
            default:
                System.exit(0);
        }
    }
    
    public static void addUser()
    {
        System.out.println("Enter first name: \n");
        String name = in.next();
        peopleList.add(name);
    }
    
    public static void addRandom()
    {   
        int randNum = rand.nextInt(101);
        
        for (int i = 0; i < randomList.size(); i++)
        {
            if (randNum == randomList.get(i))
            {
                randNum = rand.nextInt(101);
            }
        }
        
        System.out.println(peopleList.get(peopleList.size()-1) + "'s random number is " + randNum);
        
        numberList.add(randNum);
        randomList.add(randNum);
    }

    public static void finalRandom()
    {
        for (int i = 0; i < peopleList.size(); i++)
        {
            System.out.println(peopleList.get(i) + "'s number is " + numberList.get(i));
        }
        
        System.out.println("The final random number is: " + rand.nextInt(101));
    }
    public static void main(String args[])
    {
        int userChoice = userMenu();
        
        userOption(userChoice);
    }
}
