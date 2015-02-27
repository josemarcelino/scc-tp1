import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Sheep extends Animals {

    public Sheep() {
    }

    public Sheep(double energy, Coords coordinates) {
        super(energy, coordinates);
    }


    public void move(Map map, double matrix[][]) {
        super.move(matrix);
        Random rand = new Random();
        int randomNum = rand.nextInt((100 - 1) + 1) + 1;
        if (randomNum <= 4) {
            Sheep newSheep = new Sheep(this.energy, this.coordinates);
            map.sheepList.add(newSheep);
        }
    }
}