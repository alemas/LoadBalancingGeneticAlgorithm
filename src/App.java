import java.util.Random;
import static java.lang.Math.abs;

public class App {

    int[] load = {5,10,15,3,10,5,2,16,9,7,5,10,15,3,10,5,2,16,9,7};
    int[][] population;
    int loadCount = load.length;
    int populationCount = 10;
    int generationsLimit = 10000;
    double mutationChance = 0.1;

    public static void main(String[] args){

        new App().run();
    }

    public void run() {

        startPopulation(this.populationCount);
        int currentGen = 0;

        for (int i = 0; i < this.populationCount; i++)
            this.evaluation(i);

        this.printMatrix(this.population);

//        while(true) {
//
//        }

    }

    public void startPopulation(int size) {

        this.population = new int[this.populationCount][this.loadCount + 1];
        Random r = new Random();

        for (int i = 0; i < this.populationCount; i++) {
            for (int j = 0; j < this.loadCount; j++) {
                this.population[i][j] = r.nextInt(2);
            }
        }
    }

    public void evaluation(int pLine) {
        int result = 0;

        for (int i = 0; i < this.loadCount; i++) {
            if (this.population[pLine][i] == 0)
                result += this.load[i];
            else
                result -= this.load[i];
        }

        this.population[pLine][this.loadCount] = abs(result);
    }

    public int[][] crossover() {
        int father;
        int mother;
    }

    public int tournament() {
        Random r = new Random();
        int individualA = r.nextInt(this.populationCount);
        int individualB = r.nextInt(this.populationCount);

        if (individualA < individualB)
            return this.population[individualA][this.loadCount];

        return this.population[individualB][this.loadCount];
    }

    public void mutation() {

    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String line = "";
            for (int j = 0; j < matrix[0].length; j++) {
                line += matrix[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
