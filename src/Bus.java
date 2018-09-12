/**
 * Created by haonantian on 12/2/16.
 */
public class Bus { // Bus class simulate bus
    private Passenger[] passengerInBus;
    private char busDirection;
    private int whichStop;
    private int size;
    private static int capacityOfBus;

    public Bus( char direction, int whichStop, int capacity){
        busDirection = direction;
        this.whichStop = whichStop;
        this.capacityOfBus = capacity;
        this.passengerInBus = new Passenger[capacity];
        size = 0;
    }
    public static void setCapacityOfBus(int number){
        capacityOfBus = number;
    }
    public static int getCapacity(){
        return capacityOfBus;
    }
    public char getBusDirection(){
        return busDirection;
    }
    public int getSize(){
        return size;
    }
    public int getWhichStop(){
        return whichStop;
    }
    public void setBusDirection(char direction){
        this.busDirection = direction;
    }
    public void setWhichStopForEast(){
        whichStop += 1;
    }
    public void setWhichStopForWest(){
        whichStop -= 1;
    }
    public void add(Passenger newPassenger){
        if (!isFull()){
            int counter = 0;
            boolean flag = true;
            while (flag){
                if (passengerInBus[counter]==null) {
                    passengerInBus[counter] = newPassenger;
                    size++;
                    flag = false;
                } else {
                    counter++;
                }
            }
        }
    }
    public boolean isFull(){
        if (size < capacityOfBus){
            return false;
        } else{
            return true;
        }
    }
    public Passenger[] drop(){
        int counter = 0;
        for (int i = 0; i < capacityOfBus; i++){
            if (passengerInBus[i]!=null){
                if (passengerInBus[i].getDestinationStop()== whichStop) {
                    counter++;
                }
            }
        }
        Passenger[] dropOffArray = new Passenger[counter];
        int counter2 = 0;
        for (int j = 0; j < capacityOfBus; j++){
            if (passengerInBus[j]!=null) {
                if (passengerInBus[j].getDestinationStop() == whichStop) {
                    dropOffArray[counter2] = passengerInBus[j];
                    passengerInBus[j] = null;
                    size--;
                    counter2++;
                }
            }
        }
        return dropOffArray;
    }
}
