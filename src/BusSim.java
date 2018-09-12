/**
 * Created by haonantian on 12/2/16.
 */
public class BusSim { // BusSim class generates an agenda to record all event during simulation time
    static PQ agenda = new PQ();

    public static void setUpPassengerQueue(){
        for (int i = 0; i < 20; i++){
            Stop.passengerQueue[i] = new PQ2();
        }
    }
    public static void main(String[] args) { // if you don't want certain buses simply comment out it.
        setUpPassengerQueue();
        int interval = 120;
        PassengerEvent.setInterval(120);
        int capacity = 40;
        Bus.setCapacityOfBus(40);
        Stat.setCapacityBus();
        Stat.setMPG();
        int howManyBuses = 6;
        Stat.setTotalBus(6);
        BusSim.agenda.add(new PassengerEvent(1), 0);
        BusSim.agenda.add(new PassengerEvent(2), 0);
        BusSim.agenda.add(new PassengerEvent(3), 0);
        BusSim.agenda.add(new PassengerEvent(4), 0);
        BusSim.agenda.add(new PassengerEvent(5), 0);
        BusSim.agenda.add(new PassengerEvent(6), 0);
        BusSim.agenda.add(new PassengerEvent(7), 0);
        BusSim.agenda.add(new PassengerEvent(8), 0);
        BusSim.agenda.add(new PassengerEvent(9), 0);
        BusSim.agenda.add(new PassengerEvent(10), 0);
        Bus bus1 = new Bus('e', 1, capacity);
        Bus bus2 = new Bus('e', 2, capacity);
        Bus bus3 = new Bus('e', 3, capacity);
        Bus bus4 = new Bus('e', 4, capacity);
        Bus bus5 = new Bus('e', 5, capacity);
        Bus bus6 = new Bus('e', 6, capacity);
        Bus bus7 = new Bus('e', 7, capacity);
        Bus bus8 = new Bus('e', 8, capacity);
        Bus bus9 = new Bus('e', 9, capacity);
        Bus bus10 = new Bus('w', 10, capacity);
        Bus bus11 = new Bus('w', 9, capacity);
        Bus bus12 = new Bus('w', 8, capacity);
        Bus bus13 = new Bus('w', 7, capacity);
        Bus bus14 = new Bus('w', 6, capacity);
        Bus bus15 = new Bus('w', 5, capacity);
        Bus bus16 = new Bus('w', 4, capacity);
        Bus bus17 = new Bus('w', 3, capacity);
        Bus bus18 = new Bus('w', 2, capacity);
        BusSim.agenda.add(new BusEvent(1, bus1), 0);
        //BusSim.agenda.add(new BusEvent(2,bus2),0);
        //BusSim.agenda.add(new BusEvent(3,bus3),0);
        BusSim.agenda.add(new BusEvent(4,bus4),0);
        //BusSim.agenda.add(new BusEvent(5,bus5),0);
        //BusSim.agenda.add(new BusEvent(6,bus6),0);
        BusSim.agenda.add(new BusEvent(7, bus7), 0);
        //BusSim.agenda.add(new BusEvent(8,bus8),0);
        //BusSim.agenda.add(new BusEvent(9,bus9),0);
        BusSim.agenda.add(new BusEvent(10,bus10),0);
        //BusSim.agenda.add(new BusEvent(9,bus11),0);
        //BusSim.agenda.add(new BusEvent(8,bus12),0);
        BusSim.agenda.add(new BusEvent(7, bus13), 0);
        //BusSim.agenda.add(new BusEvent(6,bus14),0);
        //BusSim.agenda.add(new BusEvent(5,bus15),0);
        BusSim.agenda.add(new BusEvent(4,bus16),0);
        //BusSim.agenda.add(new BusEvent(3,bus17),0);
        //BusSim.agenda.add(new BusEvent(2,bus18),0);
        while (agenda.getCurrentTime() <= 20000) {
            agenda.remove().run();
        }
        Stat.averageWaitingInStop();
        Stat.setAverageBusPeople();
        Stat.setAverageTravel();
        Stat.setPMPG();
        Stat.display();
    }
} // All works are done by Haonan Tian
