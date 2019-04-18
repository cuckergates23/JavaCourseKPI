package model;

import java.util.Arrays;

public class Applicant {

    private int id;
    private String firstName;
    private String patronymic;
    private String surname;
    private String address;
    private String telephoneNumber;

    private int marks[];

    public Applicant(int id, String firstName, String patronymic, String surname, String address, String telephoneNumber, int []marks) {
        this.id = id;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.marks =new int[3];
        this.marks=marks;
    }


    // setters for private variables
    public void setId (int id){
        this.id=id;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // getters for private variables
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public int[] getMarks() {
        return marks;
    }
    @Override
    public String toString(){
        String output = String.format("%30s%30s%30s%30s%30s%30s%30s",this.id,this.firstName, this.patronymic , this.surname,this.address,this.telephoneNumber, Arrays.toString(this.marks));
        return  output;
    }

}
