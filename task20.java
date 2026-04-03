import java.util.Scanner;
public class task20 {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("input roman letters: ");
        romaninputcheck roman=new romaninputcheck(sc.nextLine());
        boolean check=false;
        
        while(true)
        {
            if(roman.checksize()==false)
            {
                System.out.print("error it must be between 1 to 15 letters try again: ");
                roman=new romaninputcheck(sc.nextLine());
                continue;
            }
            if(roman.checkletters()==false)
            {
                System.out.print("error you input wrong letters try again: ");
                roman=new romaninputcheck(sc.nextLine());
                continue;
            }
            break;
        }

        System.out.println("numbers: "+roman.getletters());
        roman.explain();

        roman.printtheresult();

        sc.close();
    }
        
}
