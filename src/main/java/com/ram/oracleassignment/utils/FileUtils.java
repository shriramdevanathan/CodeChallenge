package com.ram.oracleassignment.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author shriramdevanathan
 */
public class FileUtils {

    /**
     *
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public Set<String> readFromFile(String filePath) {
        InputStream phone = null;
        try {
            phone = new FileInputStream(filePath);

            TreeSet<String> result = new TreeSet<>();

            Scanner scanner = new Scanner(phone);
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }

            return result;
        }
        catch(FileNotFoundException e ) {
            return null;
        }
    }



}
