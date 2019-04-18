package controller;

import check.CheckInputData;
import check.IncorrectInputDataException;
import model.Applicant;

import java.util.Scanner;

public class InputService {
    Scanner scan = new Scanner(System.in);
    CheckInputData checkData =new CheckInputData();

    public Applicant getApplicantByKeyboard() throws IncorrectInputDataException{
        String input;
        int id=0;String firstName="";String patronymic="";String surname="";String address="";String telephoneNumber="";int marks[]=new int[3];
        System.out.println("Enter id:");
        input=scan.next();
        if (!checkData.isPositiveInteger(input)){
            throw new IncorrectInputDataException("Entered data is not integer");
        }
        id=Integer.parseInt(input);
        System.out.println("Enter name:");
        firstName=scan.next();
        System.out.println("Enter second name:");
        patronymic=scan.next();
        System.out.println("Enter surname:");
        surname=scan.next();
        System.out.println("Enter address:");
        address=scan.next();
        System.out.println("Enter telephone number:");
        input=scan.next();
        if (!checkData.isCorrectnumber(input)){
            throw new IncorrectInputDataException("Incorrect phone number format");
        }
        telephoneNumber=input;
        for (int j=0;j<3;j++){
            int number=j+1;
            System.out.println("Enter "+ number+" mark");
            input=scan.next();
            if (!checkData.isPositiveInteger(input)){
                throw new IncorrectInputDataException("Entered data is not integer");
            }
            marks[j]=Integer.parseInt(input);
        }
        return new Applicant(id,firstName,patronymic,surname,address,telephoneNumber,marks);
    }








}
