package freds.helperlib.util.mysql;

public class DisplaySettings
{
    private static final String[] SINGLE_CHAR_SET = {"─", "│", "├", "┤", "┬", "┴", "┼", "┌", "┐", "└", "┘"};
    private static final String[] DOUBLE_CHAR_SET = {"═", "║", "╠", "╣", "╦", "╩", "╬", "╔", "╗", "╚", "╝"};

    private GridStyle style;

    private boolean useColumnGrid = true;
    private boolean useRowGrid = false;

    private int dataLeftOffset = 1;
    private int dataRightOffset = 1;
    private int setXOffset = 0;

    public DisplaySettings(GridStyle style, boolean useRowGrid) 
    {
        this.style = style;
        this.useRowGrid = useRowGrid;
    }

    public DisplaySettings(GridStyle style, boolean useRowGrid, int dataLeftOffset, int dataRightOffset) 
    {
        this.style = style;
        this.useRowGrid = useRowGrid;
        this.dataLeftOffset = dataLeftOffset;
        this.dataRightOffset = dataRightOffset;
    }

    public DisplaySettings(GridStyle style, boolean useRowGrid, int dataLeftOffset, int dataRightOffset, int setXOffset) 
    {
        this.style = style;
        this.useRowGrid = useRowGrid;
        this.dataLeftOffset = dataLeftOffset;
        this.dataRightOffset = dataRightOffset;
        this.setXOffset = setXOffset;
    }

    public String[] getStyleCharSet()
    {
        return style == GridStyle.SINGLE_LINE ? SINGLE_CHAR_SET : DOUBLE_CHAR_SET;
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

    public enum GridStyle
    {
        SINGLE_LINE,
        DOUBLE_LINE
    }
}