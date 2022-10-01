
public class StepTracker {

    MonthData[] monthToData;
    Converter converter = new Converter();
    int targetSteps = 10000;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }

    }


    class MonthData {
        int[] days = new int[30];
        int daySum = 0;

    }

    void showSteps (int month) {
        for (int j = 0; j < monthToData[month - 1].days.length ; j++) {
            System.out.println("За месяц " + " " + month + ". " + "За день " + (j+1) + " " + "Вы прошли " + monthToData[month - 1].days[j] + " " + "шагов!") ;



        }
        System.out.println("За месяц" + " " + month + " " + " Вы прошли: " + sumSteps(month));
        converter.convert(sumSteps(month), month); // кол-во каллорий
        System.out.println("За месяц" + " " + month + " " + "среднее кол-во шагов было: " + arifmMean(sumSteps(month),month));
        System.out.println("За месяц" + " " + month + " " + "максимальное количество шагов было: " + maxStepsMonth(month));
        System.out.println("За месяц" + " " + month + " " + "цель по шагам была достигнута: " + targetStepsGet(month) + " раз." );
    }

    public void addSteps(int newTarget) {
        targetSteps = newTarget;
        System.out.println("Отлично! Новая цель: " + targetSteps + " шагов");

    }
    int maxStepsMonth (int month) {
        int maxSteps = 0;
        for (int l = 0; l < monthToData[month - 1].days.length; l++) {
            if (monthToData[month - 1].days[l] > maxSteps) {
                maxSteps = monthToData[month - 1].days[l];
            }
        }
        return maxSteps;
    }
    int arifmMean (int sumSteps, int month) {
        int arifmMean = sumSteps / monthToData[month - 1].days.length;
        return arifmMean;
    }
    int targetStepsGet (int month) {
        int daysTargetGet = 0;
        for (int h = 0; h < monthToData[month - 1].days.length; h++) {
            if (monthToData[month - 1].days[h] >= targetSteps) {
                daysTargetGet++;
            }
        }
        return daysTargetGet;
    }
    int sumSteps (int month) {
        int sumSteps = 0;
        for (int g = 0; g < monthToData[month - 1].days.length; g++ ) {
            sumSteps = sumSteps + monthToData[month - 1].days[g];
        }
        return sumSteps;
    }

}




//    int month;
//    MonthData month1 = monthToData[month];// Заполните класс самостоятельно
//
//    MonthData StepTracker(int month) {
//            return monthToData[month];
//            }


//    public void showSteps(int month) {
//        for (int i = 0; i < daySteps.length; i++) {
//            System.out.println("За месяц" + month + "день" + (i + 1) + "Вы прошли" + daySteps[i] + "шагов. И сожгли + converter каллорий!");
//
//        }
//    }

