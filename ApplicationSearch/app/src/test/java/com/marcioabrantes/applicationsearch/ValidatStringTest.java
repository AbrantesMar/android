package com.marcioabrantes.applicationsearch;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatStringTest {
    private String[] spacesListOringin = {"you", "probably", "despite", "moon", "misspellings"};
    private String[] spacesListGeneric = {"yuo", "porbalby", "desptie", "nmoo", "mpeissngslli"};

    @Test
    public void isTest(){
        String name = "";
        for (int i = 0, count = spacesListOringin.length; i < count; i++) {
            name = ValidatString.getName(spacesListOringin[i].toCharArray(), spacesListGeneric[i].toCharArray());
            System.out.println(name);
        }
    }
}
