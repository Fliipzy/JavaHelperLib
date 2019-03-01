package freds.helperlib.util.mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import freds.helperlib.util.text.StringUtils;

public class ResultSetDisplayer 
{
    private ResultSet resultSet;
    private DisplaySettings displaySettings;

    public ResultSetDisplayer(ResultSet resultSet) 
    {
        this.resultSet = resultSet;
        this.displaySettings = new DisplaySettings();
    }

    public ResultSetDisplayer(ResultSet resultSet, DisplaySettings settings) 
    {
        this.resultSet = resultSet;
        this.displaySettings = settings;
    }

    public DisplaySettings getDisplaySettings() 
    {
        return displaySettings;
    }

    public void display() 
    {
        ResultSetMetaData rsmd;
        int columnCount;
        String[] columnNames;
        int[] longestColumnData;

        try 
        {
            //Initialize data
            rsmd = resultSet.getMetaData();
            columnCount = rsmd.getColumnCount();
            columnNames = new String[columnCount];
            longestColumnData = new int[columnCount];

            //Populate columnNames and longestColumnData
            for (int i = 0; i < columnCount; i++) 
            {
                columnNames[i] = rsmd.getColumnName(i+1);

                //Reset pointer
                resultSet.beforeFirst();

                //Get column name length
                longestColumnData[i] = rsmd.getColumnName(i+1).length();
                //Compare length to every row data in that column
                while (resultSet.next()) 
                {
                    int result_length = resultSet.getString(i+1).length();

                    if (longestColumnData[i] < result_length) 
                    {
                        longestColumnData[i] = result_length;
                    }
                }
            }

            //Push column names text x amount to the right
            pushXOffset();

            //Display Column names
            for (int i = 0; i < columnCount; i++) 
            {
                System.out.println();
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        
    }

    private void pushXOffset()
    {
        System.out.print(StringUtils.fill("", 0, displaySettings.getSetXOffset()));
    }


    class DisplaySettings
    {
        public static final int STANDARD_VALUE_SPACE_OFFSET = 1;

        private boolean useColumnGrid = true;
        private boolean useRowGrid = false;

        private int dataXOffset;
        private int setXOffset;

        public DisplaySettings() 
        {
            this.dataXOffset = STANDARD_VALUE_SPACE_OFFSET;
        }

        public DisplaySettings(boolean useColumnGrid, boolean useRowGrid, int dataXOffset, int setXOffset) 
        {
            this.useColumnGrid = useColumnGrid;
            this.useRowGrid = useRowGrid;
            this.dataXOffset = dataXOffset;
            this.setXOffset = setXOffset;
        }

        public boolean getUseColumnGrid() 
        {
            return useColumnGrid;
        }

        public boolean getUseRowGrid() 
        {
            return useRowGrid;
        }

        public int getDataXOffset() 
        {
            return dataXOffset;
        }

        public int getSetXOffset() 
        {
            return setXOffset;
        }
    }
}