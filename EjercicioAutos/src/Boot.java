import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;

public class Boot {

    private ArrayList<Car> cars;

    public Boot() {
        this.cars = new ArrayList<>();
    }

    public static void main(String[] args) {

        Boot main = new Boot();
        main.readFile("Marcas_y_modelos.txt");
        main.writeFile("BuenosAiresTrafficAccidentData.txt");
    }

    public void readFile(String fileName){
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(fileName));
            String lineReadFromFile = bufferReader.readLine();
            Boolean isFirst = true;
            while (lineReadFromFile != null) {

                if(isFirst){
                    lineReadFromFile = bufferReader.readLine();
                    isFirst = false;
                    continue;
                }

                String[] carFields = lineReadFromFile.split("\t");
                Car readCar = new Car(carFields[0],carFields[1], Integer.parseInt(carFields[2]));
                cars.add(readCar);
                System.out.println(lineReadFromFile);

                lineReadFromFile = bufferReader.readLine();
            }
            bufferReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error: there is no file\n");
        } catch (IOException ex) {
            System.out.println("Error: cant read the file\n");
        }
    }

    public void writeFile(String filename){

        Path archivo = Paths.get(filename);

        String init = "The cars saved are the next ones:\n";
        cars.sort(Comparator.comparing(Car::getModel));
        cars.sort(Comparator.comparing(Car::getBrand));

        for (Car car : this.cars) {
            System.out.println(car);
            init += car + "\n";
        }

        try {
            Files.write(archivo, init.getBytes(), StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error: while creating the file\n");
            e.printStackTrace();
        }

    }
}
