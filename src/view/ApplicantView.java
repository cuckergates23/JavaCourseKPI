package view;

import model.Applicant;

public class ApplicantView {

    public String showMarksInfo(int[]marks){
        String out="";
        for(int i=0;i<marks.length;i++){
            out=out+String.valueOf(marks[i]);
        }
        return out;
    }

    public void showInfo(Applicant[] applicant){
        String header = String.format("%30s%30s%30s%30s%30s%30s%30s","Id","First name","Patronymic","Surname","Address","Telephone nember","Marks");
        System.out.println(header);
        for (int i=0;i<applicant.length;i++){
            if (applicant[i]!=null) {
                String output=String.format("%30s%30s%30s%30s%30s%30s%30s",applicant[i].getId(), applicant[i].getFirstName() , applicant[i].getPatronymic(),applicant[i].getSurname(),applicant[i].getAddress(), applicant[i].getTelephoneNumber(),showMarksInfo(applicant[i].getMarks()));
                System.out.println(output);
            }
        }
    }
    public void printMenu(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("1. Fill applicants list by default");
        System.out.println("2. Display list of applicants ");
        System.out.println("3. Fill applicants list by keyboard");
        System.out.println("4. Get list of applicants with low marks");
        System.out.println("5. Get list of applicants with average mark higher then entered");
        System.out.println("6. Add applicant");
        System.out.println("7. Exit");
        System.out.println("------------------------------------------------------------------");
    }

    public void showMessage(String msg){
        System.out.println(msg);
    }
}
