# bus_simulations
This is a Java project designed to simulate the operations of Green Line Trail in Twin Cities area with predefined different volume of passengers flows and bus types. The goal for this project is to find the most fuel-efficient way for the bus operations such that the largest amount of passengers can arrive at their destinations within certain period of time.

Generally, this projects can be divided into four parts. The first part is the objects in this problem such as buses, passengers and stations along the bus route. The second part is for the events in this problem. Since the this bus system is dynamic, everything is changing as the moving forward. Therefore, there are lots of events during the process such as buses arrive at stations or passengers start waiting at stations. The third part is a schedule on which the events happening or are going to happen will be properly recorded. The last part is to gather necessary information.

Specifically in this program, several Java classes are established to simulate the behavior of buses, passengers, and bus stations. The Bus class specifies the size of the bus, the number of passengers currently in the bus and current status of the bus (arrived at a bus station or on the way between). Passenger class record the status of the passenger (in a bus, at a station or arrived) and how long has  he/she spent on his/her travel. Station class records the status of a station (if bus at the station or not) and the total number of passengers currently waiting at the station.

Besides, two classes named PassengerEvent and BusEvent are established to simulate the events when buses arrive at certain stations or passengers start waiting at certain stations. A class called BusSim whose instances contain variable of priority queue type to represent the schedule. In order words, this schedule also play the role of the engine to push the whole system move forward. Finally, a class denoted by name Stat has been set up to gather and modify necessary information so that useful results can be displayed after the termination of the program.

One thing to note is that the passengers are generated in a random format. Which means the interval for the next passenger to be created is random and the to manipulate the flow of passengers is equal to change the interval of new passengers arrivals. This is how this program controls the volumn of passengers flows. For a passenger whio arrived at their destinations, they are popped from the queue but their records will be kept. The other variables of this program are controlled manually through changing the variables in Stat class. 

After the execution of this project, several conclusions can be made which are:

1.When the bus size is fixed, as the number of bus increase, the average travel time as well as the passenger miles per gallon both decrease. However, the average travel time decrease dramatically at the beginning but much smaller when the number of bus is really large. The change of passenger miles per gallon has similar pattern except that the decrease doesn’t suddenly slow sown.

2.When the passengers arrive interval increases, in other words when the load of the system decreases, the system still operate in the similar manner as described in point 1.

3.When extend the total simulation time, the system still operate in a similar manner, except that when the bus size is chosen, if the number of bus is really small for instance if there is only 1 bus, then when the simulation time increases, both the average travel time as well as the passengers miles per gallon will have a remarkable increase as the time extends. However when the number of bus is really large than such increase tends to fade away.

4.Given two types of capacity of buses 40 and 60, when average travel time is similar, smaller bus tends to have higher passenger miles per gallon.

The detail report can be found in the above documentations which includes tables of essentail statistics.

Enjoy cloning and running the program!
