import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Animals {

    protected double energy;
    protected Coords coordinates;

    public Animals() {
    }

    public Animals(double energy, Coords coordinates) {
        this.energy = energy;
        coordinates = coordinates;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public Coords getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coords coordinates) {
        coordinates = coordinates;
    }

    private void initialEnergy(int max){

        Random rand = new Random();
        int randomNum = rand.nextInt((max) + 1);
        this.energy = randomNum;

    }

    private void generateInitialCoords(){

        this.coordinates.setRandomCoords();
    }

    public void inicialCreation(int maxEnergy){   //-> maxEnergy = 30 lobos, 7 ovelhas
        initialEnergy(maxEnergy);
        generateInitialCoords();
    }


    public void move(double matrix[][]){
        this.coordinates.CalculateNextCoords(matrix);
    }
}
