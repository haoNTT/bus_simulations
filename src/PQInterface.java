/**
 * Created by haonantian on 12/2/16.
 */
public interface PQInterface {
    void add(Event newEvent, double time);
    Event remove();
    boolean isEmpty();
    double getCurrentTime();
}// This interface is quoted from lecture notes
