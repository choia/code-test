package com.nexidia.helper;
import com.nexidia.main.CodingTestMain;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InputFileHelper
{
    private final static Logger LOGGER = Logger.getLogger(CodingTestMain.class.getName());

    /**
     * Method takes in a file, loops through each line, and convert each line from string to integer.
     * integer then passed into primeFactor method for the calculation and is returned to display outputs to console.
     * System outputs message to the user if there are any errors, Log is displayed at INFO level for simple
     * log message.
     * @param inputFile
     */

    public void processInputFile(String[] inputFile)
    {
        if (inputFile.length == 0)
        {
            System.out.println("There were no commandline arguments passed.");
            LOGGER.log(Level.INFO, "IOException: argument missing an input." );
            System.exit(1);
        }
        else {
            try {
                PrimeFactorHelper primeFactor = new PrimeFactorHelper();

                for (String sourceFile : inputFile)
                {
                    FileReader fileReader = new FileReader(sourceFile);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    while (true)
                    {
                        int items = 0;
                        String line = bufferedReader.readLine();

                        try
                        {
                            if (line == null)
                            {
                                break;
                            }
                            items = Integer.parseInt(line);
                        }
                        catch (NumberFormatException e)
                        {
                            LOGGER.log(Level.INFO, "NumberFormatException: error reading line in the file." +
                                    "Line may contains null or non integers" );
                            continue;
                        }

                        primeFactor.displayPrimeFactors(primeFactor.calculatePrimeFactors(items), items);
                    }
                }
            }

            catch (IOException e)
            {
                System.out.println("Please check the file and the path.");
                LOGGER.log(Level.INFO, "IOException: path to the file is not present." );
            }
        }
    }
}
