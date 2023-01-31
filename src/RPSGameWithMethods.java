import javax.swing.*;
import java.util.Random;

public class RPSGameWithMethods {
    public static void main(String[] args){
        welcome();
        combine();

    }
    public static void welcome(){
        JOptionPane.showMessageDialog(null ,
                "Welcome to Rock Paper Scissors Game\n\n Who Ever Scores 5 wins \n\n\n Let's Go ?",
                "Rock Paper Scissors Game ",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static String  compChoice(){
        Random rnd = new Random();
        int random = rnd.nextInt(3);
        //System.out.println(random);
        String computer_choice;
        //assigning the values of the random to their values in string
        if (random == 0){
            computer_choice = "rock";
            return computer_choice;
        }
        else if (random == 1){
            computer_choice = "paper";
            return computer_choice;
        }
        else {
            computer_choice = "scissors";
            return computer_choice;
        }

    }
    public static String userChoice(){
        // here we declare user's input
        String input ;

        // showing the window
        input = JOptionPane.showInputDialog(
                null,
                "Rock, Paper or Scissors ? " ,
                "Rock Paper Scissors Game",
                JOptionPane.QUESTION_MESSAGE
        );
        return input.toLowerCase() ;
    }
    public static boolean isValid(String input){
        if ( input.equals("rock") || input.equals("paper") || input.equals("scissors")){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null ,
                    "You have Entered an Invalid value ! \n Please Enter Rock , Paper or Scissors  \n NOTE : case not sensitive you can enter the way you like! ",
                    "RPS Game ",
                    JOptionPane.WARNING_MESSAGE );
            return false;
        }
    }
    public static String compare(String comp_input , String user_input) {
        String result="";
        /*this method compares computer's choice and user's choice and produces the result*/
        switch (comp_input) {
            case "rock":
                if (user_input.equals("paper")) {
                    result = "win";
                    return result;
                } else if (user_input.equals("scissors")) {
                    result = "lost";
                    return result;
                }
                break;
            case "paper":
                if (user_input.equals("scissors")) {
                    result = "win";
                    return result;
                } else if (user_input.equals("rock")) {
                    result = "lost";
                    return result;
                }
                break;
            case "scissors":
                if (user_input.equals("rock")) {
                    result = "win";
                    return result;
                } else if (user_input.equals("paper")) {
                    result = "lost";
                    return result;
                }
                break;
        }
        return result;
    }
    public static void combine(){
        //this this the method that combines every thing together with loop
        int round = 0 , counter = 0 , comp_score =  0, user_score = 0 ;
        String msg;
        while (counter == 0 ){
            round++;
            // 1. making sure the user has entered a valid value
            String comp_input = compChoice();
            String user_input = userChoice();
            if (!isValid(user_input)){
                continue;
            }
            // 2. combining the methods to declare the winner
            switch (compare(comp_input, user_input)) {
                case "win" -> {
                    user_score++;
                    msg = "you won this round ";
                }
                case "lost" -> {
                    comp_score++;
                    msg = "you lost this round ";
                }
                default -> msg = "it's a tie ";
            }
            JOptionPane.showMessageDialog(
                    null,
                    "Round : "+ round + "\n-----------\n" + "\nYou chose  : " + user_input + "\nComputer chose : "+ comp_input + "\n-----------\n" + "\n" + msg + "\n------------\n" +"\n Your Score : " + user_score + "\n Computer Score : "+ comp_score ,
                    "Rock Paper Scissors Game ",
                    JOptionPane.INFORMATION_MESSAGE );
            if (comp_score == 5 ){
                JOptionPane.showMessageDialog(
                        null,
                        "Your Score : "+ user_score + "\n Computer Score : "+ comp_score + "\nSORRY! you have lost the game :( \n Good Luck Next Time  ",
                        "RPS Game ",
                        JOptionPane.PLAIN_MESSAGE
                );
                counter++;
            } else if (user_score == 5) {
                JOptionPane.showMessageDialog(
                        null,
                        "Your Score : " + user_score + "\n Computer Score : " + comp_score + "\nCONGRATS  You Have Won The Game :) \n looking forward to play with you again :)   ",
                        "RPS Game ",
                        JOptionPane.PLAIN_MESSAGE
                );
                counter++;

            }

        }
    }

}
