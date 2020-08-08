/**
 * Ontefetse Ditsele 
 * 
 * Tinder App: The Driver main class to be used by a user thats already signed in.
 * 07 August 2020.
 */
import java.util.Scanner;

public class TinderApp{

    public static void main(final String[] args){
        Scanner input = new Scanner(System.in);
        TinderSwipe swipe;
        
        System.out.println("Welcome to world of Tinder.....");
        System.out.println("Please enter your preference: [ (male or female or (B)oth ]");
        String pref = input.nextLine();
        
        System.out.println("Loading Up profiles for you....");
        swipe = new TinderSwipe(pref);
        
        String ans = ""; Profile potential;
        do{
            potential = swipe.getNext();
            if(potential == null){ break; }
           
            System.out.println(potential);
            System.out.println("What do you think of - Choose :(R)ight/ (L)eft/ (Q)uit) ");
            ans = input.nextLine();
            
            if (ans.equals("R"))
                swipe.right(); 
                
            else if (ans.equals("L")){
                continue;
            }
        }while (!ans.equals("Q"));
        input.close();   
        
        
        if(ans.equals("Q")){
            System.out.println("Signing Out ... Thank you for using Tinder");
        }
        else{
            System.out.println("Couldn't find anymore people from your preference... But here is who you choose:");
            Profile[] right = swipe.getRightSwipes();
             for (Profile p : right){
                System.out.println("\n"+p);
            }
        }
    }
 }