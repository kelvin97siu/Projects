package ActivityTracker;

public class NumberConverter {
    private int aInt;
    private double aDbl;

    public NumberConverter(Object value, String type) {
        String strVal = String.valueOf(value);

        if (value == null){
            aInt = 0;
            aDbl = 0;
        } else {
            if (type == "int") {
                aInt = Integer.valueOf(strVal);
            } else if (type == "double") {
                aDbl = Double.valueOf(strVal);
            }
        }
    }

    public int getInt(){
        return aInt;
    }

    public double getDbl(){
        return aDbl;
    }
}
