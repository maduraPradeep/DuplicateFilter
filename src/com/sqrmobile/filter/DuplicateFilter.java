/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqrmobile.filter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Me
 */
public class DuplicateFilter {

    /**
     * @param args the command line arguments
     *
     * This java file read input file, remove duplicates and write back result
     * into another file
     *
     * Input file and output file names can be given as argument when run the
     * class and if not provided, default will be used
     *
     */
    public static void main(String[] args) {

        try {
            //input file - if input file name given, take it otherwise default file name is "input.txt"
            File input = new File(args.length > 0 ? args[0] : "input.txt");
            //output file- if output file name given as second arg , take it else, default name "output.txt"
            File output = new File(args.length > 1 ? args[1] : "output.txt");
            output.createNewFile();
            Set<String> numbers = new HashSet<>();
            Scanner sc = new Scanner(input);
            while (sc.hasNext()) {
                numbers.add(sc.nextLine());
            }

            FileWriter fw = new FileWriter(output.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (Iterator<String> it = numbers.iterator(); it.hasNext();) {
                    bw.write(it.next() + "\n");
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(DuplicateFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
