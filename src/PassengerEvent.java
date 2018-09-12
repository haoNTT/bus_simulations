/**
 * Created by haonantian on 12/2/16.
 */
public class PassengerEvent implements Event{ // PassengerEvent class simulate the arrivals of passengers
    private int currentStop;
    private char direction;
    static int interval;

    public PassengerEvent(int currentStop){
        this.currentStop = currentStop;
    }
    public static void setInterval(int chosenInterval){
        interval = chosenInterval;
    }
    public static int getInterval(){
        return interval;
    }
    public int randomInterval(int low, int high){
        return (int)Math.floor((high-low)*Math.random() + low +0.5);
    }
    public double chooseInterval(){
        int result = randomInterval(1,100);
        if (result>=1 && result <=10){
            return interval+0.75*interval;
        } else if (result >= 11 && result<=25){
            return interval+0.50*interval;
        } else if (result>=26 && result<=45){
            return interval+0.20*interval;
        } else if (result>=46 && result<=55){
            return interval;
        } else if (result>=56 && result<=75){
            return interval-0.20*interval;
        } else if (result>= 76 && result<=90){
            return interval-0.50*interval;
        } else{
            return interval-0.75*interval;
        }
    }
    public int chooseDestination(int currentStop){
        int result = randomInterval(1,13);
        if(currentStop<=7 && currentStop>=2){
            while (result==currentStop){
                result = randomInterval(1,13);
            }
            if (result>7){
                this.direction = 'e';
                if (result==8 || result==9){
                    return 8;
                } else if (result==10 || result==11){
                    return 9;
                } else {
                    return 10;
                }
            } else if (result == 1){
                this.direction = 'w';
                return result;
            } else if (result <currentStop){
                this.direction = 'w';
                return result;
            } else {
                this.direction = 'e';
                return result;
            }
        } else if (currentStop == 8) {
            while (result == 8 || result == 9) {
                result = randomInterval(1, 13);
            }
            if (result > currentStop) {
                this.direction = 'e';
                if (result == 10 || result == 11) {
                    return 9;
                } else {
                    return 10;
                }
            } else {
                this.direction = 'w';
                return result;
            }
        } else if (currentStop == 9) {
            while (result == 10 || result == 11) {
                result = randomInterval(1, 13);
            }
            if (result > currentStop) {
                this.direction = 'e';
                return 10;
            } else {
                this.direction = 'w';
                if (result == 8 || result == 9) {
                    return 8;
                } else {
                    return result;
                }
            }
        } else if (currentStop == 1) {
            this.direction = 'e';
            while (result == currentStop) {
                result = randomInterval(1, 13);
            }
            if (result<=7){
                return result;
            } else if (result==8 || result==9){
                return 8;
            } else if (result==10 || result==11){
                return 9;
            } else {
                return 10;
            }
        } else {
            this.direction = 'w';
            while (result==12 || result==13){
                result = randomInterval(1,13);
            }
            if (result<=7){
                return result;
            } else if (result==8 || result==9){
                return 8;
            } else {
                return 9;
            }
        }
    }
    public char getDirection(){
        return direction;
    }
    public void run(){
        if(currentStop == 1){
            int dest = chooseDestination(1);
            Stop.passengerQueue[0].add(new Passenger(BusSim.agenda.getCurrentTime(),dest,'e'));
            Stat.updateTotalPassengers(1);
            Stat.updateMaxQueue();
            Stat.updateTotalWaitingLength();
            Stat.updatePeopleInStop();
            Stat.setLastUpdateTime(BusSim.agenda.getCurrentTime());
            BusSim.agenda.add(new PassengerEvent(1),chooseInterval());
        } else if (currentStop>=2 && currentStop<=7){
            int dest = chooseDestination(currentStop);
            if (getDirection() =='e'){
                Stop.passengerQueue[2*currentStop-2].add(new Passenger(BusSim.agenda.getCurrentTime(),dest,direction));
                Stat.updateTotalPassengers(1);
                Stat.updateMaxQueue();
                Stat.updateTotalWaitingLength();
                Stat.updatePeopleInStop();
                Stat.setLastUpdateTime(BusSim.agenda.getCurrentTime());
                BusSim.agenda.add(new PassengerEvent(currentStop),chooseInterval());
            } else{
                Stop.passengerQueue[2*currentStop-1].add(new Passenger(BusSim.agenda.getCurrentTime(),dest,direction));
                Stat.updateTotalPassengers(1);
                Stat.updateMaxQueue();
                Stat.updateTotalWaitingLength();
                Stat.updatePeopleInStop();
                Stat.setLastUpdateTime(BusSim.agenda.getCurrentTime());
                BusSim.agenda.add(new PassengerEvent(currentStop),chooseInterval());
            }
        } else if (currentStop==8 || currentStop==9){
            int dest = chooseDestination(currentStop);
            if (getDirection() == 'e'){
                Stop.passengerQueue[2*currentStop-2].add(new Passenger(BusSim.agenda.getCurrentTime(),dest,direction));
                Stat.updateTotalPassengers(1);
                Stat.updateMaxQueue();
                Stat.updateTotalWaitingLength();
                Stat.updatePeopleInStop();
                Stat.setLastUpdateTime(BusSim.agenda.getCurrentTime());
                BusSim.agenda.add(new PassengerEvent(currentStop),chooseInterval()-30);
            } else {
                Stop.passengerQueue[2*currentStop-1].add(new Passenger(BusSim.agenda.getCurrentTime(),dest,direction));
                Stat.updateTotalPassengers(1);
                Stat.updateMaxQueue();
                Stat.updateTotalWaitingLength();
                Stat.updatePeopleInStop();
                Stat.setLastUpdateTime(BusSim.agenda.getCurrentTime());
                BusSim.agenda.add(new PassengerEvent(currentStop),chooseInterval()-30);
            }
        } else {
            int dest = chooseDestination(10);
            Stop.passengerQueue[2*currentStop-1].add(new Passenger(BusSim.agenda.getCurrentTime(),dest,direction));
            Stat.updateTotalPassengers(1);
            Stat.updateMaxQueue();
            Stat.updateTotalWaitingLength();
            Stat.updatePeopleInStop();
            Stat.setLastUpdateTime(BusSim.agenda.getCurrentTime());
            BusSim.agenda.add(new PassengerEvent(10),chooseInterval()-30);
        }
    }
}
