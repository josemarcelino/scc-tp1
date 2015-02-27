import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Animals {

    protected double energy;
    protected Coords Coordinates;


    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public Coords getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(Coords coordinates) {
        Coordinates = coordinates;
    }

    private void initialEnergy(int max){

        Random rand = new Random();
        int randomNum = rand.nextInt((max) + 1);
        this.energy = randomNum;

    }

    private void generateInitialCoords(){

        this.Coordinates.setRandomCoords();
    }

    public void inicialCreation(int maxEnergy){   //-> maxEnergy = 30 lobos, 7 ovelhas
        initialEnergy(maxEnergy);
        generateInitialCoords();
    }


    public void move(double matrix[][]){
        this.Coordinates.CalculateNextCoords(matrix);
    }
}
