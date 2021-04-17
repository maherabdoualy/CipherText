import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CodeProgram {
    public static void main(String[] args){
        System.out.println("Welcome to the Cipher Program");
        menu();
}
    //==============================
    //MENU
    //================================
    public static void menu(){
         int wantToContinue = 1;
         Scanner scan = new Scanner(System.in);

        while (wantToContinue == 1) {
            System.out.println("Type 1 for Substitution");
            System.out.println("Type 2 for Shuffle");
            int choice = scan.nextInt();

            if (choice == 1) {
                methodSubstitution();
            } else if (choice == 2) {
                methodShuffle();
            } else {
                System.out.println("Invalid entry. Try again.");
                menu();
            }
            System.out.println("Do you want another message? (1) for Yes/ (0) for No ");
            int num = scan.nextInt();
            wantToContinue = num;
        }
    }

//==========================
    //METHOD FOR SUBSTITUTION
//==============================

    public static void methodSubstitution(){
        String fromFile ="";
        String toFile = "";
        String textFromFile ="";
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the shift amount for your text? ");
        int shift = scan.nextInt(); //ask shift amount
        scan.nextLine();

        SubstitutionCipher Obj = new SubstitutionCipher(shift); //creation of object type substitution
        System.out.println(Obj.cipherType()+"-shift amount= "+shift);
        System.out.println("Enter input file name");
        fromFile = scan.nextLine(); //choose input file
        System.out.println("Enter output file name");
        toFile = scan.nextLine(); // choose output file

        System.out.println("Encode (E) or Decode (D)? ");
        String EorD = scan.nextLine(); //ask what to perform on the message
        //*********END OF INPUTS FROM USER

        try //read from input file
        {
            File file = new File(fromFile);

            Scanner fileScan = new Scanner(file);
            textFromFile = fileScan.nextLine();
        }
        catch (IOException exception)
        {
            System.out.println("File not found");
            exception.printStackTrace();
        }

        String outputToFile=""; //perform modification on the message
        if (EorD.equals("E")) {
             outputToFile = Obj.encode(textFromFile);

        }
        else if (EorD.equals("D")){
            outputToFile = Obj.decode(textFromFile);
        }
        else{
            System.out.println("Nothing gets output");
        }

        try //write to file
        {
            PrintWriter output = new PrintWriter(toFile);
          output.print(outputToFile);
            output.close();
        }
        catch (IOException exception)
        {
            System.out.println("File not found");
            exception.printStackTrace();
        }

       if (EorD.equals("E")){
           System.out.println("Encoded text saved in "+ toFile);
       }
       else if (EorD.equals("D")){
           System.out.println("Decoded text saved in "+ toFile);
       }
    }

    //==========================
    //METHOD FOR SHUFFLING
//==============================


    public static void methodShuffle(){
        String fromFile ="";
        String toFile = "";
        String textFromFile ="";
        Scanner scan = new Scanner(System.in);
        System.out.println("How many times do you want to shuffle your text? ");
        int shuffle = scan.nextInt(); //ask shuffle amount
        scan.nextLine();

        ShuffleCipher Obj = new ShuffleCipher(shuffle); //creation of object type shuffle
        System.out.println(Obj.cipherType()+"-shuffle amount= "+shuffle);
        System.out.println("Enter input file name");
        fromFile = scan.nextLine(); //choose input file
        System.out.println("Enter output file name");
        toFile = scan.nextLine(); // choose output file

        System.out.println("Encode (E) or Decode (D)? ");
        String EorD = scan.nextLine(); //ask what to perform on the message
        //*********END OF INPUTS FROM USER

        try //read from input file
        {
            File file = new File(fromFile);

            Scanner fileScan = new Scanner(file);
            textFromFile = fileScan.nextLine();
        }
        catch (IOException exception)
        {
            System.out.println("File not found");
            exception.printStackTrace();
        }
        String outputToFile=""; //perform modification on the message
        if (EorD.equals("E")) {
            outputToFile = Obj.encode(textFromFile);
        }
        else if (EorD.equals("D")){
            outputToFile = Obj.decode(textFromFile);
        }

        try //write to file
        {
            PrintWriter output = new PrintWriter(toFile);
            output.print(outputToFile);
            output.close();
        }
        catch (IOException exception)
        {
            System.out.println("File not found");
            exception.printStackTrace();
        }
        if (EorD.equals("E")){
            System.out.println("Encoded text saved in "+ toFile);
        }
        else if (EorD.equals("D")){
            System.out.println("Decoded text saved in "+ toFile);

        }
    }
}
