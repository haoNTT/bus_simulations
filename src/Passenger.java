/**
 * Created by haonantian on 12/2/16.
 */
public class Passenger { // Passenger class simulate passengers
    private double arrivalTime;
    private int destinationStop;
    private char direction;

    public Passenger(double arrivalTime, int destinationStop, char direction){
        this.arrivalTime = arrivalTime;
        this.destinationStop = destinationStop;
        this.direction = direction;
    }
    public int getDestinationStop(){
        return destinationStop;
    }
    public double getArrivalTime(){
        return arrivalTime;
    }
    public char getDirection(){
        return direction;
    }
}
