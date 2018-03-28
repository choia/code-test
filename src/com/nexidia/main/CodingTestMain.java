package com.nexidia.main;
import com.nexidia.helper.InputFileHelper;

/**
 * Nexidia Coding Test
 * 1. Take path to a file as a commandline argument that contains one integer per line.
 * 2. For each integer in the file, output console a comma-delimited list of integer's prime factors.
 *    The list of integers on each line should multiply to the result of input integer
 * 3. Include unit tests for the code.
 */

public class CodingTestMain
{
    /**
     * Main method, InputFileHelper class is instantiated.
     * @param args
     */

    public static void main(String[] args)
    {
        InputFileHelper input = new InputFileHelper();
        input.processInputFile(args);
    }
}
