package com.marcioabrantes.applicationsearch;

import android.content.SyncStatusObserver;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.ConsoleMessage;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    private char[] spaces = {'&','3','2'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String v = getWithSpaces(new char[]{'U','s','e','r',' ', 'i','s',' ','n','o','t', ' ', 'a','l','l','o','w','e','d'});
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

    private String getName(char[] oringin,char[] generic){
        char[] auxWeightOringin = new char[3];
        char[] auxWeightGeneric = new char[3];
        int countWeight = 0;

        for (int i = 0, count = oringin.length; i < count; i++){
            if(countWeight >= 3)
                break;
            if (oringin[i] != generic[i]){
                auxWeightOringin[0] = oringin[i];
                auxWeightGeneric[0] = generic[i];
                countWeight++;
            }
        }

        return null;

    }
}
