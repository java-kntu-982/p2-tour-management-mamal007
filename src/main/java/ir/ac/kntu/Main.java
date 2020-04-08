package ir.ac.kntu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import ir.ac.kntu.maputil.MapUtil;
import net.sf.saxon.style.XSLOutput;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static int calcDate(int month, int day) {
        if (month >= 1 && month <= 6) {
            return (month-1)*31 + day;
        }
        if (month >= 7 && month <= 11) {
            return 186 + (month - 7)*30 + day;
        }
        if (month == 12) {
            return 336 + day;
        }
        return 0;
    }
    public static void main(String[] args) {
        Tour[] tourType = new Tour[1000];
        Tour[] tours = new Tour[1000];
        Leader[] leaders = new Leader[1000];
        int leaderIndex = 0, tourIndex = 0, typeIndex = 0;
        Set<String> places = new HashSet<>();
        int key = 100;
        Scanner scanner = new Scanner(System.in);
        while (key != 0) {
            System.out.println("_____Welcome To Tour Management System_____");
            System.out.println("1. Leaders");
            System.out.println("2. Tours");
            System.out.println("3. Places");
            System.out.println("4. Maps");
            System.out.println("0. exit");
            System.out.println("Make Your Choice: ");
            key = scanner.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            if (key == 1) {
                System.out.println("1. Print Leaders");
                System.out.println("2. Add a Leader");
                System.out.println("3. Delete a Leader");
                System.out.println("4. Edit a Leader");
                System.out.println("5. Search for a Leader");
                System.out.println("6. Back To Main Menu");
                System.out.println("Make Your Choice: ");
                key = scanner.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                if (key == 1) {
                    for (int i = 0; i < leaderIndex; i++) {
                        System.out.println(leaders[i]);
                    }
                    key = 100;
                }
                if (key == 4) {
                    scanner.nextLine();
                    System.out.print("enter the first name: ");
                    String first = scanner.nextLine();
                    System.out.print("enter the last name: ");
                    String last = scanner.nextLine();
                    for (int i = 0; i < leaderIndex; i++) {
                        if (leaders[i].getFirstName().equals(first)) {
                            if (leaders[i].getLastName().equals(last)) {
                                leaders[i].set();
                                System.out.print("how many places does he/she know? ");
                                int j = scanner.nextByte();
                                scanner.nextLine();
                                for (int k = 0; k < j; k++) {
                                    System.out.println(places.toString());
                                    System.out.println("choose from above list");
                                    System.out.print((i+1)+". ");
                                    leaders[leaderIndex].getPlaces()[i] = scanner.nextLine();
                                }
                                break;
                            }
                        }
                        if (i == leaderIndex-1) {
                            System.out.println("Not Found!");
                        }
                    }
                    key = 100;
                }
                if (key == 2) {
                    scanner.nextLine();
                    leaders[leaderIndex] = new Leader();
                    leaders[leaderIndex].set();
                    System.out.print("how many places does he/she know? ");
                    int j = scanner.nextByte();
                    scanner.nextLine();
                    for (int i = 0; i < j; i++) {
                        System.out.println(places.toString());
                        System.out.println("choose from above list");
                        System.out.print((i+1)+". ");
                        leaders[leaderIndex].getPlaces()[i] = scanner.nextLine();
                    }
                    leaderIndex++;
                    key = 100;
                }
                if (key == 3) {
                    scanner.nextLine();
                    System.out.print("enter the first name: ");
                    String first = scanner.nextLine();
                    System.out.print("enter the last name: ");
                    String last = scanner.nextLine();
                    for (int i = 0; i < leaderIndex; i++) {
                        if (leaders[i].getFirstName().equals(first)) {
                            if (leaders[i].getLastName().equals(last)) {
                                for (int j = i; j < leaderIndex; j++) {
                                    leaders[j] = leaders[j + 1];
                                }
                                System.out.println("\n\nDeleted successful!");
                                leaderIndex--;
                                break;
                            }
                        }
                        if (i == leaderIndex-1) {
                            System.out.println("Not Found!");
                        }
                    }
                    key = 100;
                }
                if (key == 6) {
                    key = 100;
                }
                if (key == 5) {
                    System.out.println("1. By Firstname");
                    System.out.println("2. By Lastname");
                    System.out.println("3. By Place");
                    System.out.println("4. By Age");
                    System.out.println("Make Your Choice: ");
                    key = scanner.nextInt();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    if (key == 1) {
                        scanner.nextLine();
                        System.out.print("enter the first name: ");
                        String first = scanner.nextLine();
                        int flag = 0;
                        for (int i = 0; i < leaderIndex; i++) {
                            if (leaders[i].getFirstName().equals(first)) {
                                System.out.println(leaders[i]);
                                flag++;
                            }
                            if (flag == 0 && i == leaderIndex-1) {
                                System.out.println("Not Found!");
                            }
                        }
                        key = 100;
                    }
                    if (key == 2) {
                        scanner.nextLine();
                        System.out.print("enter the last name: ");
                        String first = scanner.nextLine();
                        int flag = 0;
                        for (int i = 0; i < leaderIndex; i++) {
                            if (leaders[i].getLastName().equals(first)) {
                                System.out.println(leaders[i]);
                                flag++;
                            }
                            if (flag == 0 && i == leaderIndex-1) {
                                System.out.println("Not Found!");
                            }
                        }
                        key = 100;
                    }
                    if (key == 3) {
                        scanner.nextLine();
                        System.out.println(places.toString());
                        System.out.print("enter the place from above list: ");
                        String place = scanner.nextLine();
                        int flag = 0;
                        for (int i = 0; i < leaderIndex; i++) {
                            for (int j = 0; leaders[i].getPlaces()[j] != null; j++) {
                                if (leaders[i].getPlaces()[j].equals(place)) {
                                    System.out.println(leaders[i]);
                                    flag++;
                                    break;
                                }
                            }
                            if (i == leaderIndex-1 && flag == 0){
                                System.out.println("Not Found!");
                            }
                        }
                        key = 100;
                    }
                    if (key == 4) {
                        System.out.println("1. x");
                        System.out.println("2. x <");
                        System.out.println("3. x >");
                        System.out.println("4. x < < y");
                        System.out.println("Make Your Choice: ");
                        key = scanner.nextInt();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        if (key == 4) {
                            scanner.nextLine();
                            System.out.print("enter x: ");
                            int x = scanner.nextInt();
                            System.out.print("enter y: ");
                            int y = scanner.nextInt();
                            int flag = 0;
                            for (int i = 0; i < leaderIndex; i++) {
                                if (leaders[i].getAge() > x && leaders[i].getAge() < y) {
                                    System.out.println(leaders[i]);
                                    flag++;
                                }
                                if (i == leaderIndex-1 && flag == 0){
                                    System.out.println("Not Found!");
                                }
                            }
                            key = 100;
                        }
                        else {
                            scanner.nextLine();
                            System.out.print("enter x: ");
                            int x = scanner.nextInt();
                            int flag = 0;
                            if (key == 1) {
                                for (int i = 0; i < leaderIndex; i++) {
                                    if (leaders[i].getAge() == x) {
                                        System.out.println(leaders[i]);
                                        flag++;
                                    }
                                    if (i == leaderIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                            if (key == 2) {
                                for (int i = 0; i < leaderIndex; i++) {
                                    if (leaders[i].getAge() < x) {
                                        System.out.println(leaders[i]);
                                        flag++;
                                    }
                                    if (i == leaderIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                            if (key == 3) {
                                for (int i = 0; i < leaderIndex; i++) {
                                    if (leaders[i].getAge() > x) {
                                        System.out.println(leaders[i]);
                                    }
                                }
                                key = 100;
                            }
                        }
                    }
                }
            }
            if (key == 2) {
                System.out.println("1. Print Tours By Type");
                System.out.println("2. Print Tours");
                System.out.println("3. Add a Tour Type");
                System.out.println("4. Add a Tour");
                System.out.println("5. Edit a Tour Type");
                System.out.println("6. Edit a Tour");
                System.out.println("7. Delete a Tour");
                System.out.println("8. Search a Tour By Type");
                System.out.println("9. Search a Tour");
                System.out.println("10. Back To Main Menu");
                System.out.print("Make Your Choice: ");
                key = scanner.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                if (key == 10) {
                    key = 100;
                }
                if (key == 1){
                    for (int i = 0; i < typeIndex; i++) {
                        System.out.println(tourType[i]);
                    }
                    key = 100;
                }
                if (key == 2){
                    for (int i = 0; i < tourIndex; i++) {
                        System.out.println(tours[i]);
                    }
                    key = 100;
                }
                if (key == 3) {
                    scanner.nextLine();
                    tourType[typeIndex] = new Tour();
                    System.out.println(places.toString());
                    tourType[typeIndex].set();
                    typeIndex++;
                    key = 100;
                }
                if (key == 4) {
                    scanner.nextLine();
                    tours[tourIndex] = new Tour();
                    for (int i = 0; i < typeIndex; i++) {
                        System.out.println((i+1)+". "+tourType[i].getPlace());
                    }
                    System.out.print("choose the type of tour from above list: ");
                    int index = scanner.nextInt();
                    index--;
                    tours[tourIndex].setPlace(tourType[index].getPlace());
                    tours[tourIndex].setPrice(tourType[index].getPrice());
                    tours[tourIndex].setMaxPassengers(tourType[index].getMaxPassengers());
                    tours[tourIndex].setMinPassengers(tourType[index].getMinPassengers());
                    tours[tourIndex].setTravelLength(tourType[index].getTravelLength());
                    tours[tourIndex].setPlaces(tourType[index].getPlaces());
                    tours[tourIndex].setDestinationCity(tourType[index].getDestinationCity());
                    tours[tourIndex].setVehicle(tourType[index].getVehicle());
                    tours[tourIndex].setStartingCity(tourType[index].getStartingCity());
                    int flag = 1;
                    for (int i = 0; i < tourIndex; i++) {
                        if (tourType[index].getPlace().equals(tours[i].getPlace())) {
                            flag++;
                        }
                    }
                    tours[tourIndex].setName(tourType[index].getPlace()+" "+flag);
                    System.out.println("enter the starting date:");
                    System.out.print("month: ");
                    int month = scanner.nextInt();
                    System.out.print("day: ");
                    int day = scanner.nextInt();
                    tours[tourIndex].setStartMonth(month);
                    tours[tourIndex].setStartDay(day);
                    tours[tourIndex].setStartDate(calcDate(month,day));
                    flag = 0;
                    for (int i = 0; i < leaderIndex; i++) {
                        for (int j = 0; leaders[i].getPlaces()[j] != null; j++) {
                            if (leaders[i].getPlaces()[j].equals(tourType[index].getPlace())) {
                                if (leaders[i].getTourIndex() == 0) {
                                    System.out.println(i+". "+leaders[i]);
                                    flag++;
                                    break;
                                }
                                else {
                                    for (int k = 0; leaders[i].getTours()[k] != null; k++) {
                                        if (leaders[i].getTours()[k].getStartDate() > tours[tourIndex].getStartDate() + tours[tourIndex].getTravelLength() - 1 || tours[tourIndex].getStartDate() > leaders[i].getTours()[k].getStartDate() + leaders[i].getTours()[k].getTravelLength() - 1) {
                                            System.out.println(i + ". " + leaders[i]);
                                            flag++;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (flag == 0) {
                        System.out.println("no available leader");
                        key = 100;
                    }
                    else {
                        System.out.print("choose leader from above list: ");
                        int i = scanner.nextInt();
                        tours[tourIndex].setLeader(leaders[i]);
                        leaders[i].setTour(tours[tourIndex]);
                        tourIndex++;
                        System.out.println("well done");
                        key = 100;
                    }
                }
                if (key == 5) {
                    scanner.nextLine();
                    for (int i = 0; i < typeIndex; i++) {
                        System.out.println(i+". "+tourType[i].getPlace());
                    }
                    System.out.print("choose the tour type: ");
                    int index = scanner.nextInt();
                    Tour tour = new Tour();
                    System.out.println(places.toString());
                    tour.set();
                    tourType[index] = tour;
                    key = 100;
                }
                if (key == 6) {
                    scanner.nextLine();
                    for (int i = 0; i < tourIndex; i++) {
                        System.out.println(i+". "+tours[i].getName());
                    }
                    System.out.print("choose the tour: ");
                    int ind = scanner.nextInt();
                    Tour tour = new Tour();
                    for (int i = 0; i < typeIndex; i++) {
                        System.out.println(i+". "+tourType[i].getPlace());
                    }
                    System.out.print("choose the type of tour from above list: ");
                    int index = scanner.nextInt();
                    tour.setPlace(tourType[index].getPlace());
                    tour.setPrice(tourType[index].getPrice());
                    tour.setMaxPassengers(tourType[index].getMaxPassengers());
                    tour.setMinPassengers(tourType[index].getMinPassengers());
                    tour.setTravelLength(tourType[index].getTravelLength());
                    tour.setPlaces(tourType[index].getPlaces());
                    tour.setDestinationCity(tourType[index].getDestinationCity());
                    tour.setVehicle(tourType[index].getVehicle());
                    tour.setStartingCity(tourType[index].getStartingCity());
                    int flag = 1;
                    for (int i = 0; i < tourIndex; i++) {
                        if (tourType[index].getPlace().equals(tour.getPlace())) {
                            flag++;
                        }
                    }
                    tour.setName(tourType[index].getPlace()+" "+flag);
                    System.out.println("enter the starting date:");
                    System.out.print("month: ");
                    int month = scanner.nextInt();
                    System.out.print("day: ");
                    int day = scanner.nextInt();
                    tour.setStartMonth(month);
                    tour.setStartDay(day);
                    tour.setStartDate(calcDate(month,day));
                    flag = 0;
                    for (int i = 0; i < leaderIndex; i++) {
                        for (int j = 0; leaders[i].getPlaces()[j] != null; j++) {
                            if (leaders[i].getPlaces()[j].equals(tourType[index].getPlace())) {
                                if (leaders[i].getTourIndex() == 0) {
                                    System.out.println(i+". "+leaders[i]);
                                    flag++;
                                    break;
                                }
                                for (int k = 0; leaders[i].getTours()[k] != null; k++) {
                                    if (leaders[i].getTours()[k].getStartDate() > tour.getStartDate()+tour.getTravelLength()-1 || tour.getStartDate() > leaders[i].getTours()[k].getStartDate()+leaders[i].getTours()[k].getTravelLength()-1) {
                                        System.out.println(i+". "+leaders[i]);
                                        flag++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (flag == 0) {
                        System.out.println("no available leader");
                        key = 100;
                    }
                    else {
                        System.out.print("choose leader from above list: ");
                        int i = scanner.nextInt();
                        tour.setLeader(leaders[i]);
                        leaders[i].setTour(tour);
                        tours[ind] = tour;
                        System.out.println("well done");
                        key = 100;
                    }
                }
                if (key == 7) {
                    scanner.nextLine();
                    for (int i = 0; i < tourIndex; i++) {
                        System.out.println(i+". "+tours[i].getName());
                    }
                    System.out.print("choose the tour: ");
                    int index = scanner.nextInt();
                    for (int i = 0; i < 99; i++) {
                        System.out.println("1");
                        if (tours[index].getLeader().getTours()[i].getName().equals(tours[index].getName())) {
                            System.out.println("2");
                            for (int j = i; j < 99; j++) {
                                tours[index].getLeader().getTours()[j] = tours[index].getLeader().getTours()[j+1];
                                tours[index].getLeader().setTourIndex(tours[index].getLeader().getTourIndex()-1);
                            }
                            break;
                        }
                    }
                    for (int i = index; i < tourIndex-1; i++) {
                        tours[i] = tours[i+1];
                    }
                    tourIndex--;
                    key = 100;
                }
                if (key == 8) {
                    System.out.println("1. search by length");
                    System.out.println("2. search by visiting place");
                    System.out.println("3. search by place");
                    System.out.println("4. search by max and min number of passengers");
                    System.out.println("5. search by price");
                    System.out.print("Make Your Choice: ");
                    key = scanner.nextInt();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    if (key == 1) {
                        System.out.print("enter the length: ");
                        int length = scanner.nextInt();
                        for (int i = 0; i < typeIndex; i++) {
                            if (tourType[i].getTravelLength() == length) {
                                System.out.println(tourType[i]);
                            }
                        }
                        key = 100;
                    }
                    if (key == 2) {
                        scanner.nextLine();
                        System.out.print("enter the visiting place: ");
                        String string = scanner.nextLine();
                        for (int i = 0; i < typeIndex; i++) {
                            for (int k = 0; k < tourType[i].getTravelLength(); k++){
                                if (tourType[i].getPlaces()[k].equals(string)) {
                                    System.out.println(tourType[i]);
                                    break;
                                }
                            }
                        }
                        key = 100;
                    }
                    if (key == 3) {
                        scanner.nextLine();
                        System.out.println(places.toString());
                        System.out.print("choose place from above list: ");
                        String string = scanner.nextLine();
                        for (int i = 0; i < typeIndex; i++) {
                            if (tourType[i].getPlace().equals(string)) {
                                System.out.println(tourType[i]);
                            }
                        }
                        key = 100;
                    }
                    if (key == 4) {
                        scanner.nextLine();
                        System.out.print("enter the max number: ");
                        int max = scanner.nextInt();
                        System.out.print("enter the min number: ");
                        int min = scanner.nextInt();
                        for (int i = 0; i < typeIndex; i++) {
                            if (tourType[i].getMaxPassengers() == max && tourType[i].getMinPassengers() == min) {
                                System.out.println(tourType[i]);
                            }
                        }
                        key = 100;
                    }
                    if (key == 5) {
                        System.out.println("1. x");
                        System.out.println("2. x <");
                        System.out.println("3. x >");
                        System.out.println("4. x < < y");
                        System.out.println("Make Your Choice: ");
                        key = scanner.nextInt();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        if (key == 4) {
                            scanner.nextLine();
                            System.out.print("enter x: ");
                            int x = scanner.nextInt();
                            System.out.print("enter y: ");
                            int y = scanner.nextInt();
                            int flag = 0;
                            for (int i = 0; i < typeIndex; i++) {
                                if (tourType[i].getPrice() > x && tourType[i].getPrice() < y) {
                                    System.out.println(tourType[i]);
                                    flag++;
                                }
                                if (i == typeIndex-1 && flag == 0){
                                    System.out.println("Not Found!");
                                }
                            }
                            key = 100;
                        }
                        else {
                            scanner.nextLine();
                            System.out.print("enter x: ");
                            int x = scanner.nextInt();
                            int flag = 0;
                            if (key == 1) {
                                for (int i = 0; i < typeIndex; i++) {
                                    if (tourType[i].getPrice() == x) {
                                        System.out.println(tourType[i]);
                                        flag++;
                                    }
                                    if (i == typeIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                            if (key == 2) {
                                for (int i = 0; i < typeIndex; i++) {
                                    if (tourType[i].getPrice() < x) {
                                        System.out.println(tourType[i]);
                                        flag++;
                                    }
                                    if (i == typeIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                            if (key == 3) {
                                for (int i = 0; i < typeIndex; i++) {
                                    if (tourType[i].getPrice() > x) {
                                        System.out.println(tourType[i]);
                                        flag++;
                                    }
                                    if (i == typeIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                        }
                    }
                }
                if (key == 9) {
                    System.out.println("1. search by length");
                    System.out.println("2. search by visiting place");
                    System.out.println("3. search by place");
                    System.out.println("4. search by max and min number of passengers");
                    System.out.println("5. search by price");
                    System.out.println("6. search by leader");
                    System.out.println("7. search by date");
                    System.out.print("Make Your Choice: ");
                    key = scanner.nextInt();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    if (key == 1) {
                        System.out.print("enter the length: ");
                        int length = scanner.nextInt();
                        for (int i = 0; i < tourIndex; i++) {
                            if (tours[i].getTravelLength() == length) {
                                System.out.println(tours[i]);
                            }
                        }
                        key = 100;
                    }
                    if (key == 2) {
                        scanner.nextLine();
                        System.out.print("enter the visiting place: ");
                        String string = scanner.nextLine();
                        for (int i = 0; i < tourIndex; i++) {
                            for (int k = 0; k < tours[i].getTravelLength(); k++){
                                if (tours[i].getPlaces()[k].equals(string)) {
                                    System.out.println(tours[i]);
                                    break;
                                }
                            }
                        }
                        key = 100;
                    }
                    if (key == 3) {
                        scanner.nextLine();
                        System.out.println(places.toString());
                        System.out.print("choose place from above list: ");
                        String string = scanner.nextLine();
                        for (int i = 0; i < tourIndex; i++) {
                            if (tours[i].getPlace().equals(string)) {
                                System.out.println(tours[i]);
                            }
                        }
                        key = 100;
                    }
                    if (key == 4) {
                        scanner.nextLine();
                        System.out.print("enter the max number: ");
                        int max = scanner.nextInt();
                        System.out.print("enter the min number: ");
                        int min = scanner.nextInt();
                        for (int i = 0; i < tourIndex; i++) {
                            if (tours[i].getMaxPassengers() == max && tours[i].getMinPassengers() == min) {
                                System.out.println(tours[i]);
                            }
                        }
                        key = 100;
                    }
                    if (key == 5) {
                        System.out.println("1. x");
                        System.out.println("2. x <");
                        System.out.println("3. x >");
                        System.out.println("4. x < < y");
                        System.out.println("Make Your Choice: ");
                        key = scanner.nextInt();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        if (key == 4) {
                            scanner.nextLine();
                            System.out.print("enter x: ");
                            int x = scanner.nextInt();
                            System.out.print("enter y: ");
                            int y = scanner.nextInt();
                            int flag = 0;
                            for (int i = 0; i < tourIndex; i++) {
                                if (tours[i].getPrice() > x && tours[i].getPrice() < y) {
                                    System.out.println(tours[i]);
                                    flag++;
                                }
                                if (i == tourIndex-1 && flag == 0){
                                    System.out.println("Not Found!");
                                }
                            }
                            key = 100;
                        }
                        else {
                            scanner.nextLine();
                            System.out.print("enter x: ");
                            int x = scanner.nextInt();
                            int flag = 0;
                            if (key == 1) {
                                for (int i = 0; i < tourIndex; i++) {
                                    if (tours[i].getPrice() == x) {
                                        System.out.println(tours[i]);
                                        flag++;
                                    }
                                    if (i == tourIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                            if (key == 2) {
                                for (int i = 0; i < tourIndex; i++) {
                                    if (tours[i].getPrice() < x) {
                                        System.out.println(tours[i]);
                                        flag++;
                                    }
                                    if (i == tourIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                            if (key == 3) {
                                for (int i = 0; i < tourIndex; i++) {
                                    if (tours[i].getPrice() > x) {
                                        System.out.println(tours[i]);
                                        flag++;
                                    }
                                    if (i == tourIndex-1 && flag == 0){
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                        }
                    }
                    if (key == 6) {
                        scanner.nextLine();
                        for (int i = 0; i < leaderIndex; i++) {
                            System.out.println(i+". "+leaders[i].getFirstName()+" "+leaders[i].getLastName());
                        }
                        System.out.print("choose the leader: ");
                        int index = scanner.nextInt();
                        for (int i = 0; leaders[index].getTours()[i] != null; i++) {
                            System.out.println(leaders[index].getTours()[i]);
                        }
                        key = 100;
                    }
                    if (key == 7) {
                        scanner.nextLine();
                        System.out.println("1. after x");
                        System.out.println("2. before x");
                        System.out.println("3. after x and before y");
                        System.out.println("Make Your Choice: ");
                        key = scanner.nextInt();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        if (key == 3) {
                            scanner.nextLine();
                            System.out.print("enter the start month: ");
                            int startMonth = scanner.nextInt();
                            System.out.print("enter the start day: ");
                            int startDay = scanner.nextInt();
                            System.out.print("enter the finish month: ");
                            int finishMonth = scanner.nextInt();
                            System.out.print("enter the finish day: ");
                            int finishDay = scanner.nextInt();
                            int x = calcDate(startMonth,startDay);
                            int y = calcDate(finishMonth,finishDay);
                            int flag = 0;
                            for (int i = 0; i < tourIndex; i++) {
                                if (tours[i].getStartDate() > x && tours[i].getStartDate() < y) {
                                    System.out.println(tours[i]);
                                    flag++;
                                }
                                if (i == tourIndex-1 && flag == 0){
                                    System.out.println("Not Found!");
                                }
                            }
                            key = 100;
                        }
                        else {
                            scanner.nextLine();
                            System.out.print("enter the month: ");
                            int startMonth = scanner.nextInt();
                            System.out.print("enter the day: ");
                            int startDay = scanner.nextInt();
                            int x = calcDate(startMonth,startDay);
                            int flag = 0;
                            if (key == 1) {
                                for (int i = 0; i < tourIndex; i++) {
                                    if (tours[i].getStartDate() < x) {
                                        System.out.println(tours[i]);
                                        flag++;
                                    }
                                    if (i == tourIndex - 1 && flag == 0) {
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                            if (key == 2) {
                                for (int i = 0; i < tourIndex; i++) {
                                    if (tours[i].getStartDate() > x) {
                                        System.out.println(tours[i]);
                                        flag++;
                                    }
                                    if (i == tourIndex - 1 && flag == 0) {
                                        System.out.println("Not Found!");
                                    }
                                }
                                key = 100;
                            }
                        }
                    }
                }
            }
            if (key == 3) {
                System.out.println("1. Print All Places");
                System.out.println("2. Add a Place");
                System.out.println("3. Edit a Place");
                System.out.println("4. Delete a Place");
                System.out.println("Make Your Choice: ");
                key = scanner.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                if (key == 1) {
                    System.out.println(places.toString());
                    key = 100;
                }
                if (key == 2) {
                    scanner.nextLine();
                    System.out.print("enter the name: ");
                    String name = scanner.nextLine();
                    if (places.contains(name)) {
                        System.out.println("This Is Repetitive!");
                    }else {
                        places.add(name);
                    }
                    key = 100;
                }
                if (key == 3) {
                    scanner.nextLine();
                    System.out.println(places.toString());
                    System.out.print("enter the name: ");
                    String name = scanner.nextLine();
                    if (places.contains(name)) {
                        places.remove(name);
                        System.out.println("enter the new name: ");
                        places.add(scanner.nextLine());
                    }else {
                        System.out.println("Not Found!");
                    }
                    key = 100;
                }
                if (key == 4) {
                    scanner.nextLine();
                    System.out.println(places.toString());
                    System.out.print("enter the name: ");
                    String name = scanner.nextLine();
                    if (places.contains(name)) {
                        places.remove(name);
                        System.out.println("Deleted Successful!");
                    }else {
                        System.out.println("Not Found!");
                    }
                    key = 100;
                }
            }
            if (key == 4) {
                System.out.println("1. show the start point of a tour");
                System.out.println("2. show the destination of a tour");
                System.out.println("3. show the start point and destination of a tour");
                System.out.println("4. show places in an external tour");
                System.out.println("5. show a country or city");
                System.out.println("6. show two cities");
                System.out.println("7. back to main menu");
                System.out.println("Make Your Choice: ");
                key = scanner.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                if (key == 7) {
                    key = 100;
                }
                if (key == 1) {
                    scanner.nextLine();
                    for (int i = 0; i < tourIndex; i++) {
                        System.out.println(i+". "+ tours[i].getName());
                    }
                    key = 100;
                    System.out.print("choose from above list: ");
                    int index = scanner.nextInt();
                    MapUtil.showMap(tours[index].getStartingCity());
                }
                if (key == 2) {
                    scanner.nextLine();
                    for (int i = 0; i < tourIndex; i++) {
                        System.out.println(i+". "+ tours[i].getName());
                    }
                    key = 100;
                    System.out.print("choose from above list: ");
                    int index = scanner.nextInt();
                    MapUtil.showMap(tours[index].getDestinationCity());
                }
                if (key == 3) {
                    scanner.nextLine();
                    for (int i = 0; i < tourIndex; i++) {
                        System.out.println(i+". "+ tours[i].getName());
                    }
                    key = 100;
                    System.out.print("choose from above list: ");
                    int index = scanner.nextInt();
                    MapUtil.showMap(tours[index].getStartingCity());
                    MapUtil.showMap(tours[index].getDestinationCity());
                }
                if (key == 4) {
                    scanner.nextLine();
                    for (int i = 0; i < tourIndex; i++) {
                        System.out.println(i+". "+ tours[i].getName());
                    }
                    key = 100;
                    System.out.print("choose from above list: ");
                    int index = scanner.nextInt();
                    for (int i = 0; i < tours[index].getTravelLength(); i++) {
                        MapUtil.showMap(tours[index].getPlaces()[i]);
                    }
                }
                if (key == 5) {
                    scanner.nextLine();
                    System.out.print("enter the name: ");
                    String string = scanner.nextLine();
                    MapUtil.showMap(string);
                    key = 100;
                }
                if (key == 6) {
                    scanner.nextLine();
                    System.out.print("enter the name of the first city: ");
                    String string1 = scanner.nextLine();
                    System.out.print("enter the name of the second city: ");
                    String string2 = scanner.nextLine();
                    MapUtil.showMap(string1,string2);
                    key = 100;
                }
            }
        }
    }
}
