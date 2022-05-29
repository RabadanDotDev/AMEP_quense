/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nosferatu.queense;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author raul
 */
public class QueEnSe {

    public static void main(String[] args) {
        K k = new K();
        TestsFuncionsK.testNouEnigma(k);
        TestsFuncionsK.testNouTaulell(k);
        TestsFuncionsK.testNouJoc(k, Boolean.TRUE);
        TestsFuncionsK.testNouJoc(k, Boolean.TRUE);
        TestsFuncionsK.testNouJoc(k, Boolean.FALSE);
        TestsFuncionsK.testEsborrarSuspesos(k);
    }
}
