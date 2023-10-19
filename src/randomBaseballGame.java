import java.util.Random;
import java.util.Scanner;

public class randomBaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] computerNumbers = generateRandomNumbers();
        int[] userNumbers;
        int attempts = 0;

        System.out.println("컴퓨터가 숫자를 정했습니다. 게임을 시작합니다.");

        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");
            userNumbers = getThreeDigitNumber(scanner);
            attempts++;

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (userNumbers[i] == computerNumbers[i]) {
                    strikes++;
                } else if (containsNumber(computerNumbers, userNumbers[i])) {
                    balls++;
                }
            }

            if (strikes == 3) {
                System.out.println("축하합니다! 숫자를 모두 맞췄습니다.");
                System.out.println("시도 횟수: " + attempts);
                break;
            } else {
                System.out.println("스트라이크: " + strikes + ", 볼: " + balls);
            }
        }

        scanner.close();
    }

    private static int[] generateRandomNumbers() {
        Random random = new Random();
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(10);
        }
        return numbers;
    }

    private static int[] getThreeDigitNumber(Scanner scanner) {
        int[] numbers = new int[3];
        String input = scanner.nextLine();

        while (input.length() != 3 || !input.matches("[0-9]+")) {
            System.out.print("세 자리 숫자를 다시 입력하세요: ");
            input = scanner.nextLine();
        }

        for (int i = 0; i < 3; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }

        return numbers;
    }

    private static boolean containsNumber(int[] numbers, int target) {
        for (int num : numbers) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
