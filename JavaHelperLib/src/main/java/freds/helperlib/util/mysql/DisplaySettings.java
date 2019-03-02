package freds.helperlib.util.mysql;

public class DisplaySettings
{
    public static final int STANDARD_VALUE_SPACE_OFFSET = 1;
    public static final char[] GRID_CHAR_SET = {'─','│','├','┤','┬','┴','┼'};

    private boolean useColumnGrid = true;
    private boolean useRowGrid = false;

    private int dataLeftOffset = STANDARD_VALUE_SPACE_OFFSET;
    private int dataRightOffset = STANDARD_VALUE_SPACE_OFFSET;
    private int setXOffset = 0;

    public DisplaySettings() {}

    public DisplaySettings(boolean useColumnGrid, boolean useRowGrid, int dataLeftOffset, int dataRightOffset, int setXOffset) 
    {
        this.useColumnGrid = useColumnGrid;
        this.useRowGrid = useRowGrid;
        this.dataLeftOffset = dataLeftOffset;
        this.dataRightOffset = dataRightOffset;
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

    public int getDataLeftOffset() 
    {
        return dataLeftOffset;
    }

    public int getDataRightOffset()
    {
        return dataRightOffset;
    }

    public int getSetXOffset() 
    {
        return setXOffset;
    }
}