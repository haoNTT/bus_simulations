/**
 * Created by haonantian on 12/2/16.
 */
public class BusEvent implements Event { // BusEvent class simulate arrivals of buses at bus stops
    private Bus theBus;
    private int currentStop;

    public BusEvent(int currentStop, Bus newBus){
        this.theBus = newBus;
        this.currentStop = currentStop;
    }
    public void run(){
        Passenger[] dropOffPassengers = theBus.drop();
        int numberOfDropOff = dropOffPassengers.length;
        Stat.updateTotalOnBus();
        Stat.updateMaxTravelTime(dropOffPassengers);
        Stat.updateTotalTraveledPassengers(numberOfDropOff);
        Stat.updateTotalTravelTime(dropOffPassengers);
        int added = 0;
        int howManyToAdd = 0;
        if (theBus.getBusDirection() == 'e'){
            int queueLength = Stop.passengerQueue[2*currentStop-2].getNumberOfEntries();
            int emptySpace = Bus.getCapacity() - theBus.getSize();
            if (queueLength <= emptySpace){
                howManyToAdd = queueLength;
            } else {
                howManyToAdd = emptySpace;
            }
        } else {
            int queueLength = Stop.passengerQueue[2*currentStop-1].getNumberOfEntries();
            int emptySpace = Bus.getCapacity() - theBus.getSize();
            if (queueLength <= emptySpace){
                howManyToAdd = queueLength;
            } else {
                howManyToAdd = emptySpace;
            }
        }
        Passenger[] willBeAddPassengers = new Passenger[howManyToAdd];
        int counterForPassengers = 0;
        if (theBus.getBusDirection() == 'e'){
            while (counterForPassengers < howManyToAdd){
                willBeAddPassengers[counterForPassengers] = (Passenger)Stop.passengerQueue[2*currentStop-2].getNodeAt(counterForPassengers).getData();
                counterForPassengers++;
            }
        } else{
            while (counterForPassengers < howManyToAdd){
                willBeAddPassengers[counterForPassengers] = (Passenger)Stop.passengerQueue[2*currentStop-1].getNodeAt(counterForPassengers).getData();
                counterForPassengers++;
            }
        }
        Stat.updateMaxWaiting(willBeAddPassengers);
        if (theBus.getBusDirection()=='e'){
            while (!Stop.isEmpty(2*currentStop-2) && !theBus.isFull()){
                theBus.add(Stop.passengerQueue[2*currentStop-2].remove());
                added++;
            }
        } else {
            while (!Stop.isEmpty(2*currentStop-1) && !theBus.isFull()){
                theBus.add(Stop.passengerQueue[2*currentStop-1].remove());
                added++;
            }
        }
        Stat.updatePeopleOnBus(added-numberOfDropOff);
        Stat.setLastUpdateTimeForBus(BusSim.agenda.getCurrentTime());
        int totalTime = numberOfDropOff*2 + added*3;
        int timeToUse;
        if (totalTime > 15){
            timeToUse = 180 + totalTime;
        } else {
            timeToUse = 195;
        }
        if (theBus.getBusDirection() == 'e' && currentStop>=1 && currentStop<=8){
            theBus.setWhichStopForEast();
            BusSim.agenda.add(new BusEvent(currentStop+1,theBus),timeToUse);
        } else if (theBus.getBusDirection() == 'e' && currentStop==9){
            theBus.setBusDirection('w');
            theBus.setWhichStopForEast();
            BusSim.agenda.add(new BusEvent(currentStop+1,theBus),timeToUse);
        } else if (theBus.getBusDirection() == 'w' && currentStop>=3 && currentStop<=10){
            theBus.setWhichStopForWest();
            BusSim.agenda.add(new BusEvent(currentStop-1,theBus),timeToUse);
        } else {
            theBus.setBusDirection('e');
            theBus.setWhichStopForWest();
            BusSim.agenda.add(new BusEvent(currentStop-1,theBus),timeToUse);
        }
    }
}
