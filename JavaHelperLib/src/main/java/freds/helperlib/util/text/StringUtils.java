package freds.helperlib.util.text;

public final class StringUtils 
{
    private StringUtils() {}

    public static String fill(String str, int s_index, int length)
    {
        return fill(str, s_index, length, " ");
    }
    public static String fill(String str, int s_index, int length, String fill_s)
    {
        String fill = new String(new char[length]).replaceAll("\0", fill_s);

        if (str == "" || str == null) 
        {
            return fill;        
        }
        return insertString(str, fill, s_index);
    }

    public static String insertString(String original, String into, int s_index)
    {
        String result = new String();

        if (s_index < 0 || s_index > original.length()-1) 
        {
            throw new NullPointerException("s_index must be between 0 and String length");
        }

        //If s_index is equal to the length of the original string. return into appended to original
        if (s_index == original.length()-1 && original.length() > 1) 
        {
            return original + into;
        }

        for (int i = 0; i < original.length(); i++) 
        {
            if (i == s_index) 
            {
                result += into;
            }
            result += original.charAt(i);
        }
        return result;
    }

    public static String reverse(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }
}