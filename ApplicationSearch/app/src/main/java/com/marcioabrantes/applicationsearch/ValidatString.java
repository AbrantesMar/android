package com.marcioabrantes.applicationsearch;

public class ValidatString {

    public static String getName(char[] oringin, char[] generic){
        if(oringin[0] != generic[0])
            return null;
        char[] auxWeightOringin = new char[3];
        char[] auxWeightGeneric = new char[3];
        StringBuilder oringinBuilder = new StringBuilder();

        measureWeight(oringin, generic, auxWeightOringin, auxWeightGeneric);

        if(isValid(auxWeightOringin)){
            for(int i = 0, count = oringin.length; i < count; i++)
                oringinBuilder.append(oringin.toString());
            return oringinBuilder.toString();
        }
        return "Valor invalido";

    }

    private static void measureWeight(char[] oringin, char[] generic, char[] auxWeightOringin, char[] auxWeightGeneric){
        int countWeight = 0;
        for (int i = 0, count = oringin.length; i < count && countWeight <= 2; i++){
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

    private static void validatWeight(char[] auxWeightOringin, char[] auxWeightGeneric){
        for (int i = 0, count = auxWeightOringin.length; i < count; i++){
            for (int j = 0, countG = auxWeightGeneric.length; j < countG; j++) {
                if(auxWeightOringin[i] == auxWeightGeneric[j]){
                    auxWeightOringin[i] = ' ';
                    auxWeightGeneric[j] = ' ';
                }
            }
        }
    }

    private static boolean isValid(char[] auxOringin){
        for (char aux:
                auxOringin) {
            if(aux != ' '){
                return false;
            }
        }
        return true;
    }
}
