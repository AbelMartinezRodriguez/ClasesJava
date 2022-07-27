import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Develop {

    ArrayList<String> jokes;
    Scanner scan;
    String userName;

    public Develop(Scanner scan) {
        this.scan = scan;
        this.jokes = new ArrayList<>();
        this.jokes.add("What do you call an ant who fights crime? A vigilANTe!");
        this.jokes.add("What does a storm cloud wear under his raincoat? Thunderwear.");
        this.jokes.add("What is fast, loud and crunchy? A rocket chip.");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        Develop botExecution = new Develop(scanner);
        botExecution.startBot();
        scanner.close();

    }

    public void askFeeling() {

        while (true) {
            System.out.println(userName + " How are you feeling today?");
            String userMood = scan.nextLine();

            switch (userMood) {
                case "Happy":
                    System.out.println("Congratulations!!\n");
                    return;

                case "Sad":
                    Random randomizer = new Random();
                    System.out.println(jokes.get(randomizer.nextInt(jokes.size())) + "\n");
                    return;

                case "Nervous":
                    System.out.println("You should take a deep breath and try to calm yourself.\n");
                    return;

                default:
                    System.out.println("Sorry I dont understand this emotion. try again.\n");
                    break;
            }
        }

    }

    public void startBot() {

        System.out.println("**** Welcome to the MoodBot ****\n");
        System.out.println("Insert your name: ");
        userName = this.scan.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Hello " + userName + " today is " + formato.format(new Date()) + "\n");
        askFeeling();
        System.out.println("Goodbye " + userName + " Have a good day.");

    }
}
