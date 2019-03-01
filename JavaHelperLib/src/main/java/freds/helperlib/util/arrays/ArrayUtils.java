package freds.helperlib.util.arrays;

public final class ArrayUtils 
{
    private ArrayUtils() {}

    @SuppressWarnings("unchecked")
    public static <T extends Number> T sum(T[] arr) 
    {
        if (arr[0].getClass() == Integer.class) {
            Integer sum = 0;
            for (Integer n : (Integer[]) arr) {
                sum += n;
            }
            return (T) sum;
        }
        if (arr[0].getClass() == Double.class) {
            Double sum = 0d;
            for (Double n : (Double[]) arr) {
                sum += n;
            }
            return (T) sum;
        }
        if (arr[0].getClass() == Float.class) {
            Float sum = 0f;
            for (Float n : (Float[]) arr) {
                sum += n;
            }
            return (T) sum;
        }
        if (arr[0].getClass() == Long.class) {
            Long sum = 0l;
            for (Long n : (Long[]) arr) {
                sum += n;
            }
            return (T) sum;
        }
        if (arr[0].getClass() == Short.class) {
            Short sum = 0;
            for (Short n : (Short[]) arr) {             
                sum = (short)(sum + n);
            }    
            return (T)sum;
        }
        else
        {
            return null;
        }
    }

}
