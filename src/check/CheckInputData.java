package check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInputData {

    public boolean isPositiveInteger(String str){
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public boolean isCorrectnumber(String number){   // check if number is in coreect Ukrainian telephone format
        Pattern pattern =Pattern.compile("^((\\+?380)([0-9]{9}))$");
        Matcher matcher =pattern.matcher(number);
        if (matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isCorrectMenuParagraph(String input){
        for (char c : input.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        if (Integer.parseInt(input)<1||Integer.parseInt(input)>7){
            return false;
        }
        return true;
    }
}
