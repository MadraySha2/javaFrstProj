import java.util.Scanner;
public class StepTracker {
    MonthData[] monthToData;
    Converter converter = new Converter();
    int targetSteps = 10000;
    Scanner scanner = new Scanner(System.in);

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }

    }
    class MonthData {
        int[] days = new int[30];
    }

    void addSteps() {
        System.out.println("Выберите месяц: 1-янв - 12-дек");
        int month = scanner.nextInt();
        if (month< 1 || month > 12) {
            System.out.println("Пожалуйста, введите корректный номер месяца: от 1 до 12");
        } else {
            System.out.println("За какой день вы хотите ввести шаги?");
            int day = scanner.nextInt();
            if (day < 0 || day > 30) {
                System.out.println("Необходимо указать корректный день (от 1 до 30)! ");
            }else {
                System.out.println("Сколько шагов Вы прошли?");
                int stepsNew = scanner.nextInt();
                if (stepsNew >= 0) {
                    monthToData[month - 1].days[day - 1] = stepsNew;
                    System.out.println("Отлично! Ваши шаги записаны.");
                    if (stepsNew < targetSteps) {
                        System.out.println("Отлично! до Вашей цели осталось еще" + " " + (targetSteps - stepsNew) + " " + "шагов.");
                    }
                } else {
                    System.out.println("Колличество шагов не может быть меньше нуля!");}}
        }

    }
    void showSteps() {
        System.out.println("Выберите месяц: 1-янв - 12-дек");
        int month = scanner.nextInt();
        if (month< 1 || month > 12) {
            System.out.println("Пожалуйста, введите корректный номер месяца: от 1 до 12");

        } else {
            System.out.println("В месяце " + month + ":");
            for (int i = 0; i < monthToData[month - 1].days.length; i++) {
                System.out.println("За день " + (i + 1) + " Вы прошли " + monthToData[month - 1].days[i] + " шагов!");
            }
            System.out.println("В месяце " + month + ":");
            System.out.println("Всего вы прошли: " + sumSteps(month) + " шагов");
            System.out.println("Вы потратили: " + converter.convertCallor(sumSteps(month)) + " киллокаллорий");
            System.out.println("И прошли дистанцию в " + converter.convertDist(sumSteps(month)) + " киллометров");
            System.out.println("Среднее кол-во шагов было: " + arifmMean(sumSteps(month), month));
            System.out.println("Максимальное количество шагов за день было: " + countMax(month));
            System.out.println("Лучшая серия была: " + targetStepsGet(month) + " дней подряд");
        }
    }

    public void changeTarget() {
        System.out.println("Цель по шагам: " + targetSteps + "." + "Хотите внести новую цель? 1-Да 0-Нет");
        int answer = scanner.nextInt();
        if (answer == 1) {
            System.out.println("Введите новую цель:");
            int newTarget = scanner.nextInt();
            if (newTarget > 0) {
                targetSteps = newTarget;
                System.out.println("Отлично! Новая цель: " + targetSteps + " шагов");
            } else {
                System.out.println("Цель не может быть меньше нуля, попробуйте ввести цель повторно!");
            }
        } else if (answer == 0) {
            System.out.println("Хорошо, осталась старая цель: " + targetSteps);
        } else {
            System.out.println("Введена некорректная комманда. Попробуйте еще раз!");
        }

    }

    int countMax(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] > maxSteps) {
                maxSteps = monthToData[month - 1].days[i];
            }
        }
        return maxSteps;
    }

    int arifmMean(int sumSteps, int month) {
        return sumSteps / monthToData[month - 1].days.length;
    }

    int targetStepsGet(int month) {
        int daysTargetGet = 0;
        int bestStreak = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[month - 1].days[i] > targetSteps) {
                 daysTargetGet++;
               for (int l = 0; l <= 30; l++)
               {
                   if (bestStreak < daysTargetGet) {
                       bestStreak = daysTargetGet;

                   }
                }
            }
            else {daysTargetGet = 0;}
        }
        return bestStreak;
    }

        int sumSteps (int month){
            int sumSteps = 0;
            for (int i = 0; i < monthToData[month - 1].days.length; i++) {
                sumSteps = sumSteps + monthToData[month - 1].days[i];
            }
            return sumSteps;
        }

    }






