import java.util.Scanner;

public class Main
{
    static int hit=0,count=0,elemNum=0,errorCount=0,errorflag=0;
    static inputCheck checker=new inputCheck();
    static int[] checkerMem=new int[100];
    public static void main(String[] args)
    {
        int[] correctLocation={0,3,6};
        Scanner scanner=new Scanner(System.in);
        guessGame test=new guessGame();
        for(int i=0;i<100;i++)
        {
            checkerMem[i]=-1;
        }

        while(hit<3)
        {
            System.out.println("Please enter the number you guessed. ");
            String input=scanner.next();
            int intInput=Integer.parseInt(input);

            if(checker.checkInt(intInput))
            {
                System.out.println("You are not allowed to enter the same number for more than one time!");
                continue;
            }

            if(errorflag==1)
            {
                continue;
            }

            test.checkResult(intInput,correctLocation);
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

    static class guessGame
    {
        void checkResult(int userGuess,int[] location)
        {
            count++;
            int flag=0;
            for(int x=0;x<3;x++)
            {
                if(location[x]==userGuess)
                {
                    System.out.println("Ship "+x+" hit!");
                    hit++;flag=1;
                    break;
                }
            }

            if(flag==0)
            {
                System.out.println("Miss!");
            }

            if(hit==3)
            {
                System.out.println("All ships down!");
            }
        }
    }

    static class inputCheck
    {
        boolean checkInt(int userInput)
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

            int addflag=0;
            for(int num=0;num<checkerMem.length;num++)
            {
                if (checkerMem[num]==userInput)
                {
                    return true;
                }

                else
                {
                    addflag=1;
                }
            }

            if(addflag==1)
            {
                checkerMem[elemNum]=userInput;
                elemNum++;
            }

            return false;
        }
    }
}
