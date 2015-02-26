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



    public void setRandomCoords(){
        Random rand = new Random();
        int randomNum = rand.nextInt(51);

        this.coordX = randomNum;

        randomNum = rand.nextInt(51);

        this.coordY = randomNum;
    }
    void CalculateNextCoords(int matriz[][]){

        Random rand = new Random();
        int randomNum = rand.nextInt((8 - 1) + 1) + 1;

       if(randomNum == 1){
           this.coordX--;
       }
       else if(randomNum == 2){
            this.coordY--;
            this.coordX--;
        }

       else if(randomNum == 3){
            this.coordY--;
       }

       else if(randomNum == 4){
           this.coordX--;
           this.coordY++;
       }

       else if(randomNum == 5){

           this.coordX++;
       }

       else if(randomNum == 6){
           this.coordY++;
           this.coordX++;
       }

       else if(randomNum == 7){
           this.coordY++;
       }

       else {
           this.coordX++;
           this.coordY--;
       }


        //implementar verificacao dos limites




       if(this.coordX > matriz.length){
           this.coordX = 0;
       }

       else if(coordX < 0){

           this.coordX = matriz.length;

       }

       if(this.coordY > matriz[0].length){
           this.coordY = 0;
       }

       else if(this.coordY < 0){
           this.coordY = matriz[0].length;
       }

        //falta verificaçao das diagonais





    }
}
