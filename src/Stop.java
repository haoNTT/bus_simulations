/**
 * Created by haonantian on 12/2/16.
 */
public class Stop { // Stop class represent bus stops
    static PQ2<Passenger>[] passengerQueue = new PQ2[20];

    static boolean isEmpty(int number){
        if (passengerQueue[number].isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
