package ir.ac.kntu;

import java.util.Scanner;


public class Leader {
    private String firstName;
    private String lastName;
    private String nationalCode;
    private int day, month, year, age;
    private String hiringDate;
    private String maritalStatue;
    private String[] places = new String[100];
    private Tour[] tours = new Tour[100];
    private int tourIndex = 0;

    public int getTourIndex() {
        return tourIndex;
    }

    public void setTourIndex(int tourIndex) {
        this.tourIndex = tourIndex;
    }

    public Tour[] getTours() {
        return tours;
    }

    public void setTour(Tour tour) {
        this.tours[tourIndex] = tour;
        tourIndex++;
    }

    @Override
    public String toString() {
        return "Leader = {" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", nationalCode = '" + nationalCode + '\'' +
                ", birthDate = '" + year + "/" + month + "/" + day + '\'' +
                ", hiringDate = '" + hiringDate + '\'' +
                ", maritalStatue = '" + maritalStatue + '\'' +
                ", places = " + printPlace() +
                '}';
    }

    public String printPlace() {
        String a = "";
        for (int i = 0; places[i] != null; i++) {
            a += (places[i] + ", ");
        }
        return a;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void set() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the first name: ");
        setFirstName(scanner.nextLine());
        System.out.print("enter the last name: ");
        setLastName(scanner.nextLine());
        System.out.print("enter the national code: ");
        setNationalCode(scanner.nextLine());
        System.out.println("enter the birth date: ");
        System.out.print("year: ");
        setYear(scanner.nextInt());
        System.out.print("month: ");
        setMonth(scanner.nextInt());
        System.out.print("day: ");
        setDay(scanner.nextInt());
        setAge(1399 - getYear());
        scanner.nextLine();
        System.out.print("enter the hiring date in this form yyyy/mm/dd: ");
        setHiringDate(scanner.nextLine());
        System.out.print("enter the martial statue (single or married): ");
        setMaritalStatue(scanner.nextLine());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getMaritalStatue() {
        return maritalStatue;
    }

    public void setMaritalStatue(String maritalStatue) {
        this.maritalStatue = maritalStatue;
    }

    public String[] getPlaces() {
        return places;
    }

    public void setPlaces(String[] places) {
        this.places = places;
    }
}
