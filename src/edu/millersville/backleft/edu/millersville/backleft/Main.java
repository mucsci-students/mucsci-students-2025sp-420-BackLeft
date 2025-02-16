package edu.millersville.backleft;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        printWelcome();        
        promptDiagramSource();
        System.out.println("\n\n Input Loop Exited With No Issues :)\n\nGoodbye!");
        System.out.println("\n\n *** EXITING PROGRAM *** ");
    }

    //print basic welcome at start before user prompt main loop
    public static void printWelcome(){
        System.out.print("Welcome to Back Left UML Designer!\n\nEnter one of the available commands to get started.\n\n");
    }


    // FIRST SET OF PROMPTS to Load or Create New DIagram
    public static void promptDiagramSource(){

        Scanner userinput = new Scanner(System.in);
        System.out.print("'New'--> Create New Diagram\n'Load' --> Load Saved Diagram\n'Help' --> Show Help Menu\n'Quit' or 'Exit' to exit.\n\n");
        while (true){
            System.out.print("User :>\t");
            String command = userinput.nextLine();
            
            if (command.equals("New") || command.equals("new"))
            {
                createNewDiagram();
                break;
            }
            else if(command.equals("Load") || command.equals( "load"))
            {
                loadSavedDiagram();
                break;
            }
            else if(command.equals("Help") || command.equals("help"))
            {
                HelpMenu();
            }
            else if(command.equals("Exit") || command.equals("exit")|| command.equals("Quit") || command.equals("quit"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid command. enter 'New', 'Load', or 'Help'     (Not case sensitive)\n\n");
            }
        }
            userinput.close();


    }



    public static void loadSavedDiagram(){
        System.out.println("\n\n ** LOADING DIAGRAM FROM JSON..... (next set of prompts for diagram name, or filepath) **");    
    }

    public static void HelpMenu(){
        System.out.println("\n\n ** Help Menu **");
    }

    public static void createNewDiagram(){
        System.out.println("\n\n ** NEW DIAGRAM ENTRY POINT (next set of prompts for diagram name and blank diagram) **");
    }

}

