public class SizeCalculator {

    public static String[] sizeName = {"B", "Kb", "Mb", "Gb", "Tb"};
    public static String[] sizeName2 = {"B", "K", "M", "G", "T"};

    public static String getHumanReadableSize(long size) {
        if (size == 0){
            return "0";
        }
        int power =  (int) (Math.log(size) / Math.log(1024));
        double value = ((double)size) / Math.pow(1024., power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue + sizeName[power];
    }

    public static long getSizeFromHumanReadable(String size) {
        double value = Double.valueOf(size.replaceAll("[^0-9]", ""));
        double result = 0;
        for (int i = 0; i < sizeName.length; i++) {
            if (size.contains(sizeName[i]) || size.contains(sizeName2[i])) {
                result = (value * Math.pow(1024, i));
                return (long) result;
            }
        }
        return (long) result;
    }
}
