import java.util.Random;

/**
 * Created by pedro on 26-02-2015.
 */
public class Coords {

    private int coordX;
    private int coordY;

    public Coords(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }



    void CalculateNextCoords(int matriz[][]){

        Random rand = new Random();
        int randomNum = rand.nextInt((8 - 1) + 1) + 1;

       if(randomNum == 1){
           this.coordY--;
       }
       else if(randomNum == 2){
            this.coordY--;
            this.coordX--;
        }

       else if(randomNum == 3){
            this.coordX--;
       }

       else if(randomNum == 4){
           this.coordX--;
           this.coordY++;
       }

       else if(randomNum == 5){

           this.coordY++;
       }

       else if(randomNum == 6){
           this.coordY++;
           this.coordX++;
       }

       else if(randomNum == 7){
           this.coordX++;
       }

       else {
           this.coordX++;
           this.coordY--;
       }


        //implementar verificacao dos limites






    }
}
