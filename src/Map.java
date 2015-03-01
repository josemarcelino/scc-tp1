import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Map {

    private double grass[][];
    ArrayList<Wolf> wolfList;
    ArrayList<Sheep> sheepList;

    public Map() {
        this.grass = new double[51][51];
        this.wolfList = new ArrayList <Wolf>();
        this.sheepList = new ArrayList<Sheep>();
        initMap(100, 30, 7, 20);

        System.out.println(sheepList.get(0).getCoordinates().getCoordX() + " : " + sheepList.get(0).getCoordinates().getCoordY());
        Simulate(1);
        System.out.println(sheepList.get(0).getCoordinates().getCoordX() + " : " + sheepList.get(0).getCoordinates().getCoordY());

        System.out.println("Sheep -> " + this.sheepList.size());
        System.out.println("Wolf -> " + this.wolfList.size());


        for(int i = 0; i < 51; i++){
            for(int j=0; j < 51;j++){
                System.out.print( "--" + this.grass[i][j]);
            }
            System.out.println("");
        }

    }


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
                    this.grass[i][j] = initGrass();
                else
                    this.grass[i][j] = 0;

            }
        }

        for(int i = 0; i < numSheep ; i++){

            Sheep tempSheep = new Sheep();

            tempSheep.setCoordinates(randomCoords());
            tempSheep.setEnergy(randomEnergy(energySheep));

            this.sheepList.add(tempSheep);
        }

        for(int i = 0; i < numWolf; i++){

            Wolf tempWolf = new Wolf();

            tempWolf.setCoordinates(randomCoords());
            tempWolf.setEnergy(randomEnergy(energyWolf));

            this.wolfList.add(tempWolf);
        }

    }

    public void Simulate(int times){
        for(int i = 0; i < times; i++) {
            for (int j = 0; j < sheepList.size(); j++){
                sheepList.get(j).setCoordinates(nextCoords(sheepList.get(j).getCoordinates()));
             }

            for (int k = 0; k < wolfList.size();k++){
                wolfList.get(k).setCoordinates(nextCoords(wolfList.get(k).getCoordinates()));
            }
        }
        //feed functions go here
        //grow grass function go here
    }

    private Coords nextCoords(Coords coordinates) {
        Coords aux = new Coords(0,0);
        Random rand = new Random();
        int randomNum = rand.nextInt((8 - 1) + 1) + 1;

        if(randomNum == 1){
            aux.setCoordX(coordinates.getCoordX()-1);
        }
        else if(randomNum == 2){
            aux.setCoordY(coordinates.getCoordY()-1);
            aux.setCoordX(coordinates.getCoordX()-1);
        }

        else if(randomNum == 3){
            aux.setCoordY(coordinates.getCoordY()-1);
        }

        else if(randomNum == 4){
            aux.setCoordX(coordinates.getCoordX()-1);
            aux.setCoordY(coordinates.getCoordY() + 1);
        }

        else if(randomNum == 5){

            aux.setCoordX(coordinates.getCoordX()+1);
        }

        else if(randomNum == 6){
            aux.setCoordY(coordinates.getCoordY() + 1);
            aux.setCoordX(coordinates.getCoordX()+1);
        }

        else if(randomNum == 7){
            aux.setCoordY(coordinates.getCoordY()+1);
        }

        else {
            aux.setCoordX(coordinates.getCoordX() + 1);
            aux.setCoordY(coordinates.getCoordY()-1);
        }

        //implementar verificacao dos limites

        if(aux.getCoordX() > 51){
            aux.setCoordX(0);
        }

        else if(aux.getCoordX() < 0){
            aux.setCoordX(51);
        }

        if(aux.getCoordY() > 51){
            aux.setCoordY(0);
        }

        else if(aux.getCoordY() < 0){
            aux.setCoordY(51);
        }
        //falta verificaçao das diagonais

        return aux;
    }

    public Coords randomCoords() {
        Coords aux = new Coords(0,0);
        Random rand = new Random();

        int randomNum = rand.nextInt(51);
        aux.setCoordX(randomNum);

        randomNum = rand.nextInt(51);
        aux.setCoordY(randomNum);

        return aux;
    }

    public double randomEnergy(int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max) + 1);
        return randomNum;
    }


    private double initGrass() {
        Random rand = new Random();
        int randomNum = rand.nextInt((30 - 1) + 1) + 1;
        double aux = 1.0/30;
        return(aux*randomNum);
    }

    private void growGrass(){

        for(int i = 0; i < 51;i++){
            for(int j = 0; j<51;j++){
                this.grass[i][j] += (1/30);

                if(this.grass[i][j] > 1){
                    this.grass[i][j] = 1;
                }
            }
        }
    }

 /*   private void feedGrass(){

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

/*
    private void feedSheep(){



    } */

}
