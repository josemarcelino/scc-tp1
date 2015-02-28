import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Wolf extends Animals {

    public Wolf() {
    }

    public Wolf(double energy, Coords coordinates) {
        super(energy, coordinates);
    }


    public void move(Map map, double matrix[][]){
        super.move(matrix);
        Random rand = new Random();
        int randomNum = rand.nextInt((100 - 1) + 1) + 1;
        if(randomNum <= 5){
            Wolf newWolf = new Wolf(this.energy , this.coordinates);
            map.wolfList.add(newWolf);


        }

    }
}
