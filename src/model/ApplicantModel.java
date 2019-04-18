package model;


import check.CheckInputData;
import check.IncorrectInputDataException;
import controller.InputService;

import java.util.Scanner;

public class ApplicantModel {

    public Applicant[] applicantList=new Applicant[10];
    Scanner scan = new Scanner(System.in);
    CheckInputData checkData =new CheckInputData();
    InputService inputService = new InputService();


    public void FillApplicantsByKeyboard() throws IncorrectInputDataException {
        for (int i=0;i<10;i++){
            applicantList[i]=inputService.getApplicantByKeyboard();
        }
    }
    public void FillApplicantsByDefault(){
        applicantList[0]=new Applicant(0,"Dmytro","Andreevich","Skorohodov","Kyiv","+380675601948",new int[]{5, 5, 5});
        applicantList[1]=new Applicant(1,"Ivan","Ivanovich","Ivanov","Kyiv","+380675601948",new int[]{4, 4, 4});
        applicantList[2]=new Applicant(2,"Petr","Petrovich","Petrov","Kyiv","+380675601948",new int[]{4, 3, 2});
        applicantList[3]=new Applicant(3,"John","Johnovich","Johnov","Kyiv","+380675601948",new int[]{1, 1, 1});
        applicantList[4]=new Applicant(4,"Alexandr","Alexandrovich","Alexandrov","Kyiv","+380675601948",new int[]{5, 5, 5});
        applicantList[5]=new Applicant(5,"Alexey","Alexeevich","Alexeev","Kyiv","+380675601948",new int[]{3, 3, 3});
        applicantList[6]=new Applicant(6,"James","Jsmesovich","Jameson","Kyiv","+380675601948",new int[]{4, 3,3 });
        applicantList[7]=new Applicant(7,"Boris","Borisovich","Borisov","Kyiv","+380675601948",new int[]{5, 5, 5});
        applicantList[8]=new Applicant(8,"Andrey","Andreevich","Andreev","Kyiv","+380675601948",new int[]{2, 3, 1});
        applicantList[9]=new Applicant(9,"Victor","Victorovich","Victorov","Kyiv","+380675601948",new int[]{5, 5, 5});
    }
    private boolean hasLowMark(int[]marks){
        for (int i=0;i<marks.length;i++){
            if (marks[i]<3){
                return true;
            }
        }
        return false;
    }

    public Applicant[] getStudentsWithDeficientMarks(){
        int losersAmount=0;
        for(Applicant applicant:applicantList){
            if (applicant!=null) {
                if (hasLowMark(applicant.getMarks()))
                    losersAmount++;
            }
        }
        Applicant[] losers=new Applicant[losersAmount];
        int i=0;
        for(Applicant applicant:applicantList){
            if (applicant!=null) {
                if (hasLowMark(applicant.getMarks())) {
                    losers[i] = applicant;
                    i++;
                }
            }
        }
        return losers;
    }

    private double getAverageMark(int[]marks){
        double sum=0;
        for (int i=0;i<marks.length;i++){
            sum+=marks[i];
        }
        return sum/marks.length;
    }

    public Applicant[] getStudentsWithHigherAverageMark() throws IncorrectInputDataException {
        System.out.println("Enter average mark:");

        String input = scan.nextLine();
        if(!checkData.isPositiveInteger(input)){
            throw new IncorrectInputDataException("Entered data is not integer");
        }

        int averageMark=Integer.parseInt(input);
        int studentsAmount=0;
        for (Applicant applicant:applicantList){
            if (applicant!=null) {
                if (getAverageMark(applicant.getMarks()) > averageMark)
                    studentsAmount++;
            }
        }
        Applicant[] students=new Applicant[studentsAmount];
        int i=0;
        for(Applicant applicant:applicantList){
            if (applicant!=null) {
                if (getAverageMark(applicant.getMarks()) > averageMark) {
                    students[i] = applicant;
                    i++;
                }
            }
        }
        return students;
    }

    public int defineEmptyPosition(){ // if there are place for one more object in array
        int index=-1;
        for (int i=0;i<applicantList.length;i++){
            if (applicantList[i]==null){
                index=i;
                i=applicantList.length;
            }
        }
        return index;
    }

    public void addApplicant()
    {
        if (defineEmptyPosition()==-1){
            System.out.println("Array with applicants is full!");
        }
        else  {
            try {
                applicantList[defineEmptyPosition()]=inputService.getApplicantByKeyboard();
            }
            catch (IncorrectInputDataException ex){
                System.out.println(ex.getMessage());
            }

            System.out.println("Continue add applicants? y/n");
            String answer=scan.next();
            if (answer.equals("y")){
                addApplicant();
            }
        }
    }
}
