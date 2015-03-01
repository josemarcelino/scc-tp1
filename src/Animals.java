import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Animals {

    protected double energy;
    protected Coords coordinates;

    public Animals() {
        this.energy = 0;
        this.coordinates = new Coords(0,0);
    }

    public Animals(double energy, Coords coordinates) {
        this.energy = energy;
        this.coordinates = coordinates;
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
        this.coordinates = coordinates;
    }

}
