package freds.helperlib.util.mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import freds.helperlib.util.mysql.DisplaySettings.GridStyle;
import freds.helperlib.util.text.StringUtils;

public class ResultSetDisplayer 
{
    private ResultSet resultSet;
    private DisplaySettings displaySettings;

    private ResultSetMetaData rsmd;
    private int columnCount;
    private String[] columnNames;
    private int[] longestColumnData;
    private String[] gridSet;

    public ResultSetDisplayer(ResultSet resultSet) 
    {
        this.resultSet = resultSet;
        this.displaySettings = new DisplaySettings(GridStyle.SINGLE_LINE, false);
        gridSet = displaySettings.getStyleCharSet();
    }

    public ResultSetDisplayer(ResultSet resultSet, DisplaySettings settings) 
    {
        this.resultSet = resultSet;
        this.displaySettings = settings;
        gridSet = displaySettings.getStyleCharSet();
    }

    public DisplaySettings getDisplaySettings() 
    {
        return displaySettings;
    }

    public void display() 
    {
        try 
        {
            // Initialize data
            rsmd = resultSet.getMetaData();
            columnCount = rsmd.getColumnCount();
            columnNames = new String[columnCount];
            longestColumnData = new int[columnCount];

            // Populate columnNames and longestColumnData
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = rsmd.getColumnName(i + 1);

                // Reset pointer
                resultSet.beforeFirst();

                // Get column name length
                longestColumnData[i] = rsmd.getColumnName(i + 1).length();
                // Compare length to every row data in that column
                while (resultSet.next()) {
                    int result_length = resultSet.getString(i + 1).length();

                    if (longestColumnData[i] < result_length) {
                        longestColumnData[i] = result_length;
                    }
                }
            }
            
            // Push column names text x amount to the right
            String xOffset = getXOffset();
            System.out.print(xOffset.substring(1));
            
            //Display top line
            String top = getRowSeperator(gridSet[0], gridSet[4]);
            top = gridSet[7] + top.substring(0, top.length()) + gridSet[8];
            System.out.println(top);

            // Display Column names
            System.out.print(xOffset.substring(1) + gridSet[1]);
            for (int i = 0; i < columnCount; i++) 
            {
                String data = getPaddedData(columnNames[i], i);
                if (i < columnCount - 1) 
                {
                    System.out.print(data + gridSet[1]);
                    continue;
                }
                System.out.println(data + gridSet[1]);
            }

            //Display column seperator
            String columnSeperator = xOffset.substring(1) 
            + gridSet[2] + getRowSeperator(gridSet[0], gridSet[6]) + gridSet[3];
            System.out.println(columnSeperator);
            
            //Display row data
            resultSet.beforeFirst();
            while (resultSet.next()) 
            {
                //Print xOffset
                System.out.print(xOffset.substring(1) + gridSet[1]);

                String data = new String();
                String paddedData = new String();
                for (int i = 0; i < columnCount; i++) 
                {
                    data = resultSet.getString(i+1); //i+1 because it's exclusive
                    paddedData = getPaddedData(data, i);
                    if (i < columnCount-1) 
                    {
                        paddedData = paddedData + gridSet[1];
                    }
                    System.out.print(paddedData);
                }
                System.out.print(gridSet[1]);
                System.out.println();
            }

            //Display bottom
            String bottom = xOffset.substring(1) 
            + gridSet[9] 
            + getRowSeperator(gridSet[0], gridSet[5]) 
            + gridSet[10];
            
            System.out.println(bottom);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    private String getRowSeperator(String straight, String cross)
    {
        String seperator = new String();
        String line = new String();
        int cLength = 0;
        for (int i = 0; i < columnCount; i++) 
        {   
            cLength = displaySettings.getDataLeftOffset() + longestColumnData[i] + displaySettings.getDataRightOffset();
            if (i < columnCount-1) 
            {
                line = StringUtils.fill("", 0, cLength, straight) + cross;
            }
            else
            {
                line = StringUtils.fill("", 0, cLength, straight);
            }
            seperator += line;
        }
        return seperator;
    }

    private String getXOffset()
    {
        return StringUtils.fill("", 0, displaySettings.getSetXOffset()+1);
    }

    private String getPaddedData(String data, int columnIndex)
    {
        int rightOffset = displaySettings.getDataRightOffset();
        int leftOffset = displaySettings.getDataLeftOffset();

        int extraSpace = longestColumnData[columnIndex] - data.length();

        //Fill left side with whitespace
        data = StringUtils.fill(data, 0, leftOffset);

        //Fill right side with whitespace
        data = StringUtils.fill(data, data.length()-1, extraSpace + rightOffset);

        return data;
    }
}

