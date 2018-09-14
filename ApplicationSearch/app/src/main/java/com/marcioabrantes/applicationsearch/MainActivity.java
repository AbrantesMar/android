package com.marcioabrantes.applicationsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private char[] spaces = {'&','3','2'};
            //you, yuo -> true
            //probably, porbalby -> true
            //despite, desptie -> true
            //moon, nmoo -> false
            //misspellings, mpeissngslli -> false
    private String[] spacesListOringin = {"you", "probably", "despite", "moon", "misspellings"};
    private String[] spacesListGeneric = {"yuo", "porbalby", "desptie", "nmoo", "mpeissngslli"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String v = getWithSpaces(new char[]{'U','s','e','r',' ', 'i','s',' ','n','o','t', ' ', 'a','l','l','o','w','e','d'});
        String name = "";
        for (int i = 0, count = spacesListOringin.length; i < count; i++) {
            name = getName(spacesListOringin[0].toCharArray(), spacesListGeneric[0].toCharArray());
            System.out.println(name);
        }
    }

    private String getWithSpaces(char[] description) {
        int auxCountSpace = 0;
        char[] auxDescription;

        for (char chact: description) {
            if (chact == ' ') auxCountSpace += 1;
        }

        auxDescription = new char[description.length + (auxCountSpace * 2)];
        for(int i = 0, j = 0, count = auxDescription.length; i < count; i++, j++){
            if(description[j] == ' '){
                for (int k = 0, countSpace = spaces.length; k < countSpace; k++, i++)
                    auxDescription[i] = spaces[k];
                i--;
            }else auxDescription[i] = description[j];
        }

        System.out.println("texto do espaco em branco");
        StringBuilder textFormed = new StringBuilder();
        for(char a : auxDescription)
            textFormed.append(a);
        System.out.println(textFormed.toString());
        return textFormed.toString();
    }

    private String getName(char[] oringin, char[] generic){
        if(oringin[0] != generic[0])
            return null;
        char[] auxWeightOringin = new char[3];
        char[] auxWeightGeneric = new char[3];

        measureWeight(oringin, generic, auxWeightOringin, auxWeightGeneric);

        if(isValid(auxWeightOringin)){
            return oringin.toString();
        }

        return null;

    }

    private void measureWeight(char[] oringin, char[] generic, char[] auxWeightOringin, char[] auxWeightGeneric){
        int countWeight = 0;
        for (int i = 0, count = oringin.length; i < count && countWeight <= 3; i++){
            if (oringin[i] != generic[i]){
                auxWeightOringin[countWeight] = oringin[i];
                auxWeightGeneric[countWeight] = generic[i];
                countWeight++;
            }
        }
        if(countWeight >= 3){
            return;
        }
        validatWeight(auxWeightOringin, auxWeightGeneric);
    }

    private void validatWeight(char[] auxWeightOringin, char[] auxWeightGeneric){
        for (int i = 0, count = auxWeightOringin.length; i < count; i++){
            for (int j = 0, countG = auxWeightGeneric.length; j < countG; j++) {
                if(auxWeightOringin[i] == auxWeightGeneric[j]){
                    auxWeightOringin[i] = ' ';
                    auxWeightGeneric[j] = ' ';
                }
            }
        }
    }

    private boolean isValid(char[] auxOringin){
        for (char aux:
             auxOringin) {
            if(aux != ' '){
                return false;
            }
        }
        return true;
    }
}
