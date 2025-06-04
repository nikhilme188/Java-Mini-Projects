import java.util.Random;
public class RockPaperScissor {
    private static final String[] computerChoice={"Rock","Paper","Scissors"};  

    public String getComputerChoice() {
        return computerChoice[random.nextInt(computerChoice.length)];///changes 
    }
    public int getplayerScore(){
        return playerScore;
    }
    public int getcomputerScore(){
        return computerScore;
    }
    private int playerScore,computerScore;
    private final Random random;//final
    public RockPaperScissor(){
        random=new Random();
    }
    public String playRockPaperScissor(String playerChoice){
        String computerChoice = getComputerChoice();//changes
        String result;
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result="YOU WIN";
                playerScore++;
            }
            else if(playerChoice.equals("Scissors")){
                result="YOU LOSE";
                computerScore++;
            }
            else {
                result="Draw";
            }
        }
        else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissors")){
                result="YOU WIN";
                playerScore++;
            }
            else if(playerChoice.equals("Rock")){
                result="YOU LOSE";
                computerScore++;
            }
            else {
                result="Draw";
            }
        }
        else {
            if(playerChoice.equals("Rock")){
                result="YOU WIN";
                playerScore++;
            }
            else if(playerChoice.equals("Paper")){
                result="YOU LOSE";
                computerScore++;
            }
            else {
                result="Draw";
            }
        }
        return result;
    }
}

    

