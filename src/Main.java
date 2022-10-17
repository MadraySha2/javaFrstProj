import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int inCommand = scanner.nextInt();
            if (inCommand == 1) {
                stepTracker.addSteps();
            } else if (inCommand == 2) {
                stepTracker.showSteps();
            } else if (inCommand == 3){
                stepTracker.changeTarget();

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


