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

    public void Simulate(int times){
        for(int i = 0; i < times; i++) {
            for (int j = 0; j < sheepList.size(); j++){
                sheepList.get(j).move(this.grass);
             }

            for (int k = 0; k < wolfList.size();k++){
                wolfList.get(k).move(this.grass);
            }
        }

        //feed functions go here
        //grow grass function go here
    }

    private void growGrass(){


    }

    private void feedGrass(){

        for(int i = 0; i < sheepList.size();i++){

            if(this.grass[sheepList.get(i).getCoordinates().getCoordX()][sheepList.get(i).getCoordinates().getCoordY()] > 0){
                ArrayList<Sheep> tempSheepList = new ArrayList<Sheep>();
                for(int j = 0; j < sheepList.size(); j++) {
                    if (sheepList.get(j).getCoordinates().getCoordX() == sheepList.get(i).getCoordinates().getCoordX() && sheepList.get(j).getCoordinates().getCoordY() == sheepList.get(i).getCoordinates().getCoordY()) {
                        tempSheepList.add(sheepList.get(j));
                    }
                }
                double amount = this.grass[sheepList.get(i).getCoordinates().getCoordX()][sheepList.get(i).getCoordinates().getCoordY()] / tempSheepList.size();
                this.grass[sheepList.get(i).getCoordinates().getCoordX()][sheepList.get(i).getCoordinates().getCoordY()] = 0;
                for(int k = 0; k < tempSheepList.size(); k++){
                    tempSheepList.get(k).feed(amount);
                }
            }

        }

    }


    private void feedSheep(){



    }

}
