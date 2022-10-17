public class Converter {
    double distanceByStep = 0.75;
    double calloriesInStep = 50;
    double convertDist (int sumSteps) {
        return sumSteps * distanceByStep / 1000;
    }
    double convertCallor (int sumSteps) {
        return sumSteps * calloriesInStep / 1000;
    }
}
