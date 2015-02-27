import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Map {

    private double grass[][];
    ArrayList<Wolf> wolfList;
    ArrayList<Sheep> sheepList;



    public double[][] getGrass() {
        return grass;
    }

    public void setGrass(double[][] grass) {

        this.grass = grass;
        wolfList = new ArrayList<Wolf>();
        sheepList = new ArrayList<Sheep>();
    }

    private void initMap(int numSheep, int numWolf,int energySheep, int energyWolf){

        Random rand = new Random();
        int randomNum;

        for(int i = 0; i < grass.length; i++){
            for(int j = 0; j < grass[0].length; j++){

                randomNum = rand.nextInt((100 - 1) + 1) + 1;
                if(randomNum <= 50 )
                    this.grass[i][j] = 1;
                else
                    this.grass[i][j] = 0;

            }
        }

        for(int i = 0; i < numSheep ; i++){

            Sheep tempSheep = new Sheep();
            tempSheep.inicialCreation(energySheep);
            this.sheepList.add(tempSheep);
        }

        for(int i = 0; i < numWolf; i++){

            Wolf tempWolf = new Wolf();
            tempWolf.inicialCreation(energyWolf);
            this.wolfList.add(tempWolf);
        }

    }

}
