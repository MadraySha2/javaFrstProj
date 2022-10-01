public class Converter {
    double distanceByStep = 75; // сантиметров
    double calloriesInStep = 50;// каллорий в шаге
    void convert (int sumSteps, int month) {
       double distance = sumSteps * distanceByStep / 100000;
       double callories = sumSteps * calloriesInStep / 1000;
        System.out.println("За месяц" + " " + month + " " + "Вы потратили: " + callories + "киллокаллорий" + " и прошли дистанцию в " + distance + " киллометров" );
    }

}
