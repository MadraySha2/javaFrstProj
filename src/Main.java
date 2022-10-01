import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int inCommand = scanner.nextInt();
            if (inCommand == 1) {
                System.out.println("Выберите месяц: 1-янв - 12-дек");
                int month = scanner.nextInt();
                System.out.println("За какой день вы хотите ввести шаги?");
                int day = scanner.nextInt();
                System.out.println("Сколько шагов Вы прошли?");
                int stepsNew = scanner.nextInt();
                stepTracker.monthToData[month - 1].days[day - 1] = stepsNew;
                System.out.println("Отлично! Ваши шаги записаны.");
                if (stepsNew < stepTracker.targetSteps) {
                    System.out.println("Отлично! до Вашей цели осталось еще" + " " + (stepTracker.targetSteps - stepsNew) + " " + "шагов.");
                }


            } else if (inCommand == 2) {
                System.out.println("Выберите месяц: 1-янв - 12-дек");
                int month = scanner.nextInt();
                stepTracker.showSteps(month);

            } else if (inCommand == 3) {
                System.out.println("Цель по шагам: " + stepTracker.targetSteps + "." + "Хотите внести новую цель? 1-Да 0-Нет");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    System.out.println("Введите новую цель:");
                    int newTarget = scanner.nextInt();
                    if (newTarget > 0) {
                        stepTracker.addSteps(newTarget);
                    } else {
                        System.out.println("Цель не может быть меньше нуля, попробуйте ввести цель повторно!");
                    }
                } else if (answer == 0) {
                    System.out.println("Хорошо, осталась старая цель: " + stepTracker.targetSteps);
                } else {
                    System.out.println("Введена некорректная комманда. Попробуйте еще раз!");
                }
            } else if (inCommand == 0) {
                System.out.println("Спасибо за использование!");
                break;
            } else {
                System.out.println("Пожалуйста, введите корректную команду от 0 до 3");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести шаги за определенный день");
        System.out.println("2 - Посмотреть статистику по количеству шагов");
        System.out.println("3 - Изменить цель по кол-ву шагов");
        System.out.println("0 - Выход");
    }
}


