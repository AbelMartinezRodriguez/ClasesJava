import java.util.ArrayList;

public class Preparation {

    private ArrayList<String> instructions;

    public Preparation() {
        this.instructions = new ArrayList<>();
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void addInstructions(String instruction) {
        this.instructions.add(instruction);
    }

    @Override
    public String toString() {
        String instructionsToPrint = "";

        for (String instruction : this.instructions) {
            instructionsToPrint += instruction + "\n";
        }
        return instructionsToPrint;
    }
}
