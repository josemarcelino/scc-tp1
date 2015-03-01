
public class Sheep extends Animals {

    public Sheep() {
        this.energy = 0;
        this.setCoordinates(null);
    }

    public Sheep(double energy, Coords coordinates) {
        super(energy, coordinates);
    }

}