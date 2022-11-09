package com.blueJ.chapter07.weblogAnalyzer;

public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    //The daily access counts.
    private int[] dailyCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Analyze the daily access data from the log file.
     */
    public void analyzeDailyData(){
        while(reader.hasNext()){
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dailyCounts[day]++;

        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    public int numberOfHourlyAccesses(){
        int total = 0;
        for(int i = 0; i < hourCounts.length; i++){
            total += hourCounts[i];
        }
        return total;
    }

    public int numberOfDailyAccesses(){
        int total = 0;
        for(int i = 0; i < dailyCounts.length; i++){
            total += dailyCounts[i];
        }
        return total;
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
