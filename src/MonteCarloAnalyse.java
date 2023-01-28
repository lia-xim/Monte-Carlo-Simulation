import java.text.DecimalFormat;
import java.util.*;

public class MonteCarloAnalyse {
    public static void main(String[] args) {
        Integer startJahr = 20, endJahr = 85, jaerlicheEinzahlung = 300, jaerlicheEntnahme = 40000, instanzen = 1000;
        Double anlageHorizont = 0.0, startKapitalInput = 650000.00, startKapital, inflationsRate = 0.0, renditeKosten = 5.70, standardabweichung = 9.42, rendite, endKapital, tempEndKapital = 0.0, endKapitalMedian, lowerEnd, upperEnd;
        Jahresbericht endKapitalJahresBericht;
        DecimalFormat df = new DecimalFormat("#.###");

        List<SimulationsInstanz> simulationsInstanzList = new ArrayList<>();
        for (int i = 0; i < instanzen; i++) {
            SimulationsInstanz simulationsInstanz = new SimulationsInstanz();
            System.out.println("██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████");
            for (int j = startJahr; j <= endJahr; j++) {
                if (j != startJahr){
                    System.out.println( tempEndKapital);
                    startKapital = tempEndKapital;
                }
                else {
                    startKapital = startKapitalInput;
                }
                rendite = generateRandomNumber(renditeKosten, standardabweichung);
                endKapital = ((startKapital + jaerlicheEinzahlung) - jaerlicheEntnahme) * (1 + rendite/100);
                tempEndKapital = endKapital;
                Jahresbericht jahresbericht = new Jahresbericht(j, jaerlicheEinzahlung, rendite, startKapital, endKapital);
                simulationsInstanz.jahresberichtList.add(jahresbericht);
                System.out.println("███ Jahr: " + j + " ||| Jährliche Einzahlung: " + jaerlicheEinzahlung + " ||| Rendite: " + rendite + " ||| Startkapital: " + startKapital + " ||| Endkapital: " + endKapital + " ███");
            }
            simulationsInstanzList.add(simulationsInstanz);
        }
        Map<Double, Jahresbericht> jahresberichtMap = new HashMap<>();
        List<Double> endKapitalList = new ArrayList<>();
        simulationsInstanzList.forEach(simulationsInstanz -> {
            simulationsInstanz.jahresberichtList.forEach(jahresbericht -> {
                jahresberichtMap.put(jahresbericht.getEndKapital(), jahresbericht);
                endKapitalList.add(jahresbericht.getEndKapital());
            });
        });
        Collections.sort(endKapitalList);

        AnalyseData analyseData = analyzeData(endKapitalList, jahresberichtMap);
        analyseData.output();
    }

    public static AnalyseData analyzeData(List<Double> endKapitalList, Map<Double, Jahresbericht> jahresberichtMap) {
        AnalyseData analyseData = new AnalyseData();

        double endKapitalMedian = getMedian(endKapitalList);
        double endKapitalLowerEnd = getLowerEnd(endKapitalList);
        double endKapitalUpperEnd = getUpperEnd(endKapitalList);
        double endKapitalMax = getMax(endKapitalList);
        double endKapitalMin = getMin(endKapitalList);
        //
        // double endKapitalMiddle = getMiddle(endKapitalList);

        analyseData.setMedian(jahresberichtMap.get(endKapitalMedian));
        analyseData.setLowerEnd(jahresberichtMap.get(endKapitalLowerEnd));
        analyseData.setUpperEnd(jahresberichtMap.get(endKapitalUpperEnd));
        analyseData.setMax(jahresberichtMap.get(endKapitalMax));
        analyseData.setMin(jahresberichtMap.get(endKapitalMin));
        //analyseData.setMiddle(new Jahresbericht(middleYear(), middleInput(), middlereward(), mittlecapital(),  middleendcaptial()));

        return analyseData;
    }

    private static double getMedian(List<Double> simulationsInstanz) {
        double median;
        int tempMedian;
        if (simulationsInstanz.size() % 2 == 0){
            tempMedian = (simulationsInstanz.size() / 2 + simulationsInstanz.size() / 2 - 1) / 2;
            median = simulationsInstanz.get(tempMedian);
        }
        else{
            median = simulationsInstanz.get(simulationsInstanz.size() / 2);
        }
        return median;
    }

    private static double getLowerEnd(List<Double> simulationsInstanz) {
        double lowerEnd;
        int tempMedian;
        if (simulationsInstanz.size() % 2 == 0){
            tempMedian = ((simulationsInstanz.size() / 4) + (simulationsInstanz.size() / 4) - 1) / 2;
            lowerEnd = simulationsInstanz.get(tempMedian);
        }
        else{
            lowerEnd = simulationsInstanz.get(simulationsInstanz.size() / 4);
        }
        return lowerEnd;
    }

    private static double getUpperEnd(List<Double> simulationsInstanz) {
        double upperEnd;
        int tempMedian;
        if (simulationsInstanz.size() % 2 == 0){
            tempMedian = ((simulationsInstanz.size() / 4) * 3 + (simulationsInstanz.size() / 4) * 3 - 1) / 2;
            upperEnd = simulationsInstanz.get(tempMedian);
        }
        else{
            upperEnd = (simulationsInstanz.get(simulationsInstanz.size() / 4) * 3);
        }
        return upperEnd;
    }

    private static double getMax(List<Double> simulationsInstanz) {
        return simulationsInstanz.get(simulationsInstanz.size()-1);
    }

    private static double getMin(List<Double> simulationsInstanz) {
        return simulationsInstanz.get(0);
    }
/*
    private static double getMiddle(List<Double> simulationsInstanz) {
        double temp = 0;
        for (int i = 0; i < simulationsInstanz.size(); i++) {
            simulationsInstanz.get(i).
        }
        return temp / simulationsInstanz.size();
    }

    private static Integer getMiddleYear(List<Double> simulationsInstanz) {
        double temp = 0;
        for (Double aDouble : simulationsInstanz) {
            temp += aDouble;
        }
        return temp / simulationsInstanz.size();
    }

 */

    public static Double generateRandomNumber(Double rendite, Double abweichung) {
        Random random = new Random();
        Double min = rendite - abweichung;
        Double max = rendite + abweichung;
        Double randomNumber = min + (max - min) * random.nextDouble();
        return randomNumber;
    }
}