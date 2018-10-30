import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    static int hit=0,count=0,errorCount=0,errorflag=0;
    static inputCheck checker=new inputCheck();
    static ArrayList<String> locationCells=new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);

        String[] correctLocation={"0","3","6"};
        locationCells.addAll(Arrays.asList(correctLocation));

        while(hit<3)
        {
            System.out.println("Please enter the number you guessed. ");
            String input=scanner.next();
            if(checker.checkInput(Integer.parseInt(input)))
            {
                continue;
            }

            int index=locationCells.indexOf(input);
            if(index>=0)
            {
                count++;hit++;
                System.out.println("Ship "+hit+" Hit!");
                locationCells.remove(index);
            }
            else
            {
                count++;
                System.out.println("Miss! No ship there, at least for now.");
            }
        }

        if(errorCount<3)
        {
            System.out.println("It takes you only "+count+" times and all ships were destroyed, congratulation!");
        }
        if(errorCount>=3)
        {
            System.out.println("It takes you "+count+" times and "+errorCount+" error(s) to take all ships down, loser.");
        }
    }

    static class inputCheck
    {
        boolean checkInput(int userInput)
        {
            errorflag=0;
            if(userInput>7||userInput<0)
            {
                errorCount++;
                errorflag=1;
            }
            if((userInput>7||userInput<0)&&errorCount<3)                                                       
            {
                System.out.println("Please enter a number between 0 and 7.");
            }
            if((userInput>7||userInput<0)&&errorCount>=3)
            {
                System.out.println("ENTER A NUMBER BETWEEN ZERO AND SEVEN!");
            }

            return errorflag==1;
        }
    }
}
