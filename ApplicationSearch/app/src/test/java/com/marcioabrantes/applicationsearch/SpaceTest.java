package com.marcioabrantes.applicationsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {
    @Test
    public void replaceStringTest() throws Exception {
        char[] array = new char[]
                {'U','s','e','r',' ','i','s',' ','n','o','t',' ','a','l','l','o','w','e','d',' ',' ',' ',' ',' ',' '};
        char[] expectedArray = new char[]
                {'U','s','e','r','&', '3', '2','i','s','&', '3', '2','n','o','t','&', '3', '2','a','l','l','o','w','e','d'};

        int realLength = 19;

        SpaceClass.replaceWhiteSpace(array, realLength);
        assertArrayEquals(expectedArray, array);
    }


}
