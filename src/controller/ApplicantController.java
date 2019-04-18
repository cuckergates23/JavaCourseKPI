package controller;

import check.*;
import model.ApplicantModel;
import view.ApplicantView;

import java.util.Scanner;
public class ApplicantController {

    ApplicantModel model =new ApplicantModel();
    ApplicantView view =new ApplicantView();
    Scanner scan = new Scanner(System.in);
    CheckInputData checkData =new CheckInputData();


    public void startApp(){
            try {
                menu();
            } catch (IncorrectInputDataException ex) {
                view.showMessage(ex.getMessage());
                startApp();
            }
    }

    public void menu() throws IncorrectInputDataException {
        String choise;
        do {
            view.printMenu();
            String input=scan.nextLine();
            if (!checkData.isCorrectMenuParagraph(input)){
                throw new IncorrectInputDataException("Incorrect menu paragraph");
            }
            choise=input;
            switch(choise){
                case "1":{
                    model.FillApplicantsByDefault();
                    break;
                }
                case "2":{
                    view.showInfo(model.applicantList);
                    break;
                }
                case "3":{
                    try {
                        model.FillApplicantsByKeyboard();
                    }
                    catch (IncorrectInputDataException ex){
                        view.showMessage(ex.getMessage());
                    }
                    break;
                }
                case "4":{
                    view.showInfo(model.getStudentsWithDeficientMarks());
                    break;
                }
                case "5":{
                    try {
                        view.showInfo(model.getStudentsWithHigherAverageMark());
                    }
                    catch (IncorrectInputDataException ex){
                        view.showMessage(ex.getMessage());
                    }
                    break;
                }
                case "6":{
                    model.addApplicant();
                    break;
                }
            }
        }while(choise.equals("7")!=true);
    }


}
