package com.nexidia.test;
import com.nexidia.helper.InputFileHelper;
import com.nexidia.helper.PrimeFactorHelper;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class CodingTestMainTest
{
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final String testFilePath = "/test_files/integer.txt";
    private final String nonIntFilePath = "/test_files/noninteger.txt";

    @org.junit.Before
    public void setUp() throws Exception
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
        System.setOut(null);
        System.setErr(null);
    }

    /*
    Testing if input is passed with non-file
     */
    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound()
    {
        InputFileHelper input = new InputFileHelper();
        String[] args = {"Not_a_file"};
        input.processInputFile(args);
        assertTrue("If it's not a file, program to return FileNotFoundException", true);
    }

    /*
    Testing if file is empty
     */
    @Test (expected = IOException.class)
    public void testFileEmpty()
    {
        InputFileHelper input = new InputFileHelper();
        String[] testFileName = {testFilePath};
        input.processInputFile(testFileName);
        String str = errContent.toString();
        assertTrue("If file is empty, it simply returns none", str.contains("IOException"));
    }

    /*
    Testing with an non integers
     */
    @Test
    public void testNoneNumber()
    {
        String testFile = nonIntFilePath;
        try
        {
            PrintWriter writer = new PrintWriter(testFile);
            writer.print("Hello World");
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("Error on adding a line to a file.");
            return;
        }
        InputFileHelper input = new InputFileHelper();
        String str = errContent.toString();
        assertTrue("Any non integers must return NumberFormatException", str.contains("NumberFormatException"));
    }

    /*
    Testing with integers containing valid numbers
     */
    @Test
    public void testValidNumber()
    {
        int[] numbers = new int[]{81,111,49};
        List<Integer> result = new ArrayList<>();
        PrimeFactorHelper primeFactor = new PrimeFactorHelper();
        for (Integer number:numbers)
        {
            primeFactor.calculatePrimeFactors(number);
        }
        String str = errContent.toString();
        assertEquals("Must return 3,3,3,3 for 81, 3,37 for 111", errContent.toString());
    }
}