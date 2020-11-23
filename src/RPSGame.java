import javax.swing.*;
import java.util.Random;

public class RPSGame {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null ,
                "Welcome to Rock Paper Scissors Game\n\n Who Ever Scores 5 wins \n\n\n Let's Go ?",
                "Rock Paper Scissors Game ",
                JOptionPane.YES_NO_CANCEL_OPTION
                );
        // here we declare our variables
        int computer_score = 0 , user_score = 0 , rounds = 0 , count = 0  ;

       //here stars the while loop
        while (count == 0) {
            rounds++;
            // this code generates a random number between 0-3
            Random rnd = new Random();
            int random = rnd.nextInt(3);
            String computer_choice = "" , result = "";
             //assigning the values of the random to their values in string
            switch (random){
                case 0 : computer_choice = "rock"; break;
                case 1 : computer_choice = "paper";break;
                case 2 : computer_choice = "scissors";
            }


            // here we declare user's input
            String input = new String("") ;

            // showing the window
            input = JOptionPane.showInputDialog(
                    null,
                    "Round : "+ rounds + "\n\nYour Score : "+ user_score  + "\nComputer Score : "+ computer_score +"\n\n Rock, Paper or Scissors ? " ,
                    "Rock Paper Scissors Game",
                    JOptionPane.QUESTION_MESSAGE
            );


            //now we're making a new string that stores what ever the user plugged in after turning to lowercase
            String input2 = new String(input.toLowerCase());
                if ( input2.equals("rock") || input2.equals("paper") || input2.equals("scissors")){

                }
                else {
                    JOptionPane.showMessageDialog(null ,
                            "You have Entered an Invalid value ! \n Please Enter Rock , Paper or Scissors  \n NOTE : case not sensitive you can enter the way you like! ",
                            "RPS Game ",
                            JOptionPane.WARNING_MESSAGE );
                    continue;

                }


        // now to the main code (we compare values )
           switch (computer_choice){
               case "rock" :
                            if (input2.equals("paper")){
                                result = "Paper Eats Rock \nyou won this round :) ";
                                user_score++;
                            } else if (input2.equals("scissors")){
                                result = "Rock Breaks Scissors \nyou lost this round :( ";
                                computer_score++;
                            } else  {
                                result = "it's a tie ";
                            }
                break;
               case "paper" :
                           if (input2.equals("scissors")) {
                               result = "Scissors Cuts Paper\n you won this round  :) ";
                               user_score++;
                           } else if (input2.equals("rock")){
                               result = "Paper Eats Rock\n you lost this round :( ";
                               computer_score++;
                           } else   {
                               result = "it's a tie ";
                           }
               break;
               case "scissors" :
                           if (input2.equals("rock")){
                               result = "Rock Breaks Scissors \nyou won this round :) ";
                               user_score++;
                           } else if (input2.equals("paper")){
                               result = "Scissors Cuts Paper \nyou lost this round :( ";
                               computer_score++;
                           } else{
                               result = "it's a tie ";
                           }

                break;


           }

             JOptionPane.showMessageDialog(
                    null,
                    "Round : "+ rounds + "\n--------------------\n" + "\nYou chose  : " + input + "\nComputer chose : "+ computer_choice + "\n--------------------\n" + "\n" + result + "\n--------------------\n" +"\n Your Score : " + user_score + "\n Computer Score : "+ computer_score ,
                    "Rock Paper Scissors Game ",
                    JOptionPane.INFORMATION_MESSAGE
            );
            //System.out.println(" comp chose = " + computer_choice + " user chose  = "+ input2 + " computer got  = " + computer_score +" user got = "+ user_score + " result = "+ result);


            //here we decide how many rounds do someone need to win to win the game
            if (computer_score == 5 ){
                JOptionPane.showMessageDialog(
                        null,
                        "Your Score : "+ user_score + "\n Computer Score : "+ computer_score + "\nSORRY! you have lost the game :( \n Good Luck Next Time  ",
                        "RPS Game ",
                        JOptionPane.PLAIN_MESSAGE
                );
                count++;
            } else if (user_score == 5){
                JOptionPane.showMessageDialog(
                        null,
                        "Your Score : "+ user_score + "\n Computer Score : "+ computer_score + "\nCONGRATS  You Have Won The Game :) \n looking forward to play with you again :)   ",
                        "RPS Game ",
                        JOptionPane.PLAIN_MESSAGE
                );
                count++;


            }

        }

    }

}
