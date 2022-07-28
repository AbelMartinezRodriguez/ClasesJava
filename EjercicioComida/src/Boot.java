import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Boot implements TxtFunctionality {

    private ArrayList<Ingredient> ingredients;
    private Preparation preparation;

    public Boot() {
        this.ingredients = new ArrayList<>();
        this.preparation = new Preparation();
    }

    public static void main(String[] args) {

        Boot main = new Boot();

        main.generateOutput("Paella.txt");
    }

    @Override
    public void generateOutput(String fileName) {

        generateIngredients();
        generatePreparation();

        Path ingredientsTxtPath = Paths.get("Ingredientes" + fileName);
        Path preparationTxtPath = Paths.get("Preparacion" + fileName);
        String initialTxtIngredients = "Los ingredientes son lo siguiente:\n";
        String initialTxtPreparatioon = "La preparacion del plato es la siguiente:\n";

        for (Ingredient ingredient : this.ingredients) {
            initialTxtIngredients += ingredient;
        }

        initialTxtPreparatioon += this.preparation;

        createFile(ingredientsTxtPath, initialTxtIngredients);
        createFile(preparationTxtPath, initialTxtPreparatioon);

    }

    private void createFile(Path filepath, String initialTxt){

        try {
            Files.write(filepath, initialTxt.getBytes(), StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error: while creating the file\n");
            e.printStackTrace();
        }
    }

    public void generateIngredients() {

        String allIngredientsInOneString =
                "Arroz bomba 1500 g\n" + "Pollo de corral 1\n" + "Conejo 0.5\n"
                        + "Judía verde plana 500 g\n" + "Garrofó 500 g\n"
                        + "Alcachofa (opcional) 500 g\n"
                        + "Aceite de oliva virgen extra\n" + "Pimentón dulce\n"
                        + "Tomate triturado\n" + "Azafrán\n"
                        + "Romero fresco\n" + "Sal";

        for (String ingredientName : allIngredientsInOneString.split("\n")) {
            System.out.println(ingredientName);
            Ingredient ingredientRead = new Ingredient(ingredientName);
            this.ingredients.add(ingredientRead);
        }

    }

    public void generatePreparation() {

        String allInstructionInOneString =
                "Dificultad: Media\n" + "Tiempo total 1 h 25 m\n"
                        + "Elaboración 10 m\n" + "Cocción 1 h 15 m\n"
                        + "Reposo 5 m";


        for (String instruction : allInstructionInOneString.split("\n")) {
            System.out.println(instruction);
            this.preparation.addInstructions(instruction);
        }

    }

}
