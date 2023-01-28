import java.text.DecimalFormat;

public class AnalyseData {
    private Jahresbericht median, lowerEnd, upperEnd, max, min, middle;

    public Jahresbericht getMedian() {
        return median;
    }

    public void setMedian(Jahresbericht median) {
        this.median = median;
    }

    public Jahresbericht getLowerEnd() {
        return lowerEnd;
    }

    public void setLowerEnd(Jahresbericht lowerEnd) {
        this.lowerEnd = lowerEnd;
    }

    public Jahresbericht getUpperEnd() {
        return upperEnd;
    }

    public void setUpperEnd(Jahresbericht upperEnd) {
        this.upperEnd = upperEnd;
    }

    public Jahresbericht getMax() {
        return max;
    }

    public void setMax(Jahresbericht max) {
        this.max = max;
    }

    public Jahresbericht getMin() {
        return min;
    }

    public void setMin(Jahresbericht min) {
        this.min = min;
    }

    public Jahresbericht getMiddle() {
        return middle;
    }

    public void setMiddle(Jahresbericht middle) {
        this.middle = middle;
    }

    public void output() {
        DecimalFormat df = new DecimalFormat("#.###");

        System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        System.out.println("  __  __             _               _____           _             _____ _                 _       _   _             \n" +
                " |  \\/  |           | |             / ____|         | |           / ____(_)               | |     | | (_)            \n" +
                " | \\  / | ___  _ __ | |_ ___ ______| |     __ _ _ __| | ___ _____| (___  _ _ __ ___  _   _| | __ _| |_ _  ___  _ __  \n" +
                " | |\\/| |/ _ \\| '_ \\| __/ _ \\______| |    / _` | '__| |/ _ \\______\\___ \\| | '_ ` _ \\| | | | |/ _` | __| |/ _ \\| '_ \\ \n" +
                " | |  | | (_) | | | | ||  __/      | |___| (_| | |  | | (_) |     ____) | | | | | | | |_| | | (_| | |_| | (_) | | | |\n" +
                " |_|  |_|\\___/|_| |_|\\__\\___|       \\_____\\__,_|_|  |_|\\___/     |_____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_|\n");
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        System.out.println("Minimum: " + Double.valueOf(df.format(this.min.getEndKapital()).replace(",", ".")));
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        System.out.println("Maximum: " + Double.valueOf(df.format(this.max.getEndKapital()).replace(",", ".")));
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        System.out.println("Untere 25%: " + Double.valueOf(df.format(this.lowerEnd.getEndKapital()).replace(",", ".")));
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        System.out.println("Obere 25%: " + Double.valueOf(df.format(this.upperEnd.getEndKapital()).replace(",", ".")));
        //System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        //System.out.println("Durchschnitt: " + Double.valueOf(df.format(this.middle.getEndKapital()).replace(",", ".")));
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
        System.out.println("Median: " + Double.valueOf(df.format(this.median.getEndKapital()).replace(",", ".")));
        System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
    }
}
