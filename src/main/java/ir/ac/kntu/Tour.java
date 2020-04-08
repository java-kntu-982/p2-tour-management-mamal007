package ir.ac.kntu;

import java.util.Arrays;
import java.util.Scanner;

public class Tour {
    int startMonth, startDay;
    private String place, startingCity, destinationCity, vehicle;
    private int minPassengers, maxPassengers, price, travelLength;
    private String[] places;
    private int startDate;
    private String name;
    private Leader leader;

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public void set() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("choose the place from above list: ");
        setPlace(scanner.nextLine());
        System.out.print("starting city: ");
        setStartingCity(scanner.nextLine());
        System.out.print("destination city: ");
        setDestinationCity(scanner.nextLine());
        System.out.print("the vehicle (bus, airplane, train): ");
        setVehicle(scanner.nextLine());
        System.out.print("minimum number of passengers: ");
        setMinPassengers(scanner.nextInt());
        System.out.print("maximum number of passengers: ");
        setMaxPassengers(scanner.nextInt());
        System.out.print("price: ");
        setPrice(scanner.nextInt());
        System.out.print("how many days does it take? ");
        setTravelLength(scanner.nextInt());
        places = new String[travelLength];
        scanner.nextLine();
        for (int i = 0; i < travelLength; i++) {
            System.out.print("where to visit in day number " + (i + 1) + ": ");
            places[i] = scanner.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Tour {" +
                " Name = '" + printName() + '\'' +
                ", place = '" + place + '\'' +
                ", firstCity = '" + startingCity + '\'' +
                ", lastCity = '" + destinationCity + '\'' +
                ", Vehicle = '" + vehicle + '\'' +
                ", minPassengers = " + minPassengers +
                ", maxPassengers = " + maxPassengers +
                ", price = " + price +
                ", length = " + travelLength +
                ", places = " + Arrays.toString(places) +
                ", startDay = " + printDate() +
                ", leader = " + printLeader() +
                '}';
    }

    public String printName() {
        if (name != null) {
            return name;
        }
        return "not defined";
    }

    public String printLeader() {
        if (leader != null) {
            return leader.getFirstName() + " " + leader.getLastName();
        }
        return "not defined";
    }

    public String printDate() {
        if (startDay != 0) {
            if (startMonth != 0) {
                return startMonth + "/" + startDay + ", finalDay = " + (startMonth + (startDay + travelLength) / 30) + "/" + (startDay + travelLength) % 30;
            }
        }
        return "not defined";
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(String startingCity) {
        this.startingCity = startingCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getMinPassengers() {
        return minPassengers;
    }

    public void setMinPassengers(int minPassengers) {
        this.minPassengers = minPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTravelLength() {
        return travelLength;
    }

    public void setTravelLength(int travelLength) {
        this.travelLength = travelLength;
    }

    public String[] getPlaces() {
        return places;
    }

    public void setPlaces(String[] places) {
        this.places = places;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
