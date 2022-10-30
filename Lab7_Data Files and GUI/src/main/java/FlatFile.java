package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlatFile {

    private String readFileName;
    private String outputFileName;

    /**
     * @Description read a CSV file line by line
     * @param fileName
     */
    public List<String> readFile(String fileName) {

        // handle user input writing file name case
        String filePath = "";
        if(fileName.contains(".csv")){
            filePath = fileName;
        } else {
            filePath = fileName + ".csv";
        }

        // create array to store reading data
        String line = "";
        List<String> dataArray = new ArrayList<>();

        try{
            // parse a CSV file into BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // read line by line and store in dataArray
            while ((line = br.readLine()) != null) {
                dataArray.add(line);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }

    /**
     * @Description write the first 3 fields to csv file line by line
     * @param fileName
     * @param dataArray
     */
    public void writeFile(String fileName, List<String> dataArray) {

        // handle user input with .csv case and write to relative directory
        String filePath;
        if (fileName.contains(".csv")) {
            filePath = fileName;
        } else {
            filePath = fileName + ".csv";
        }

        try{
            FileWriter fw = new FileWriter(filePath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            StringBuilder stringBuilder = new StringBuilder();

            for(String line: dataArray) {
                // write only the first three fields
                String[] values = line.split(",");

                // clear stringBuilder
                stringBuilder.setLength(0);
                for(int j = 0; j < 3; j++) {
                    stringBuilder.append(values[j]);
                    if( j != 2) { // the last one value doesn't need a comma
                        stringBuilder.append(",");
                    }
                }

                // write line by line into output csv file
                pw.println(stringBuilder);
            }
            pw.flush();
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description set the name of csv file to be read
     * @param readFileName
     */
    public void setReadFileName(String readFileName){
        this.readFileName = readFileName;
    }

    /**
     * @return get the name of csv file to be read
     */
    public String getReadFileName(){
        return readFileName;
    }

    /**
     * @Description set output csv file name
     * @param outputFileName
     */
    public void setOutputFileName(String outputFileName){
        this.outputFileName = outputFileName;
    }

    /**
     * @return output csv file name
     */
    public String getOutputFileName(){
        return outputFileName;
    }

}
