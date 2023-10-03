import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 동전의 종류
		int[] coins = {500, 100, 50, 10, 5, 1};
		
		// 지불할 돈
		int price = 1000 - sc.nextInt();
		
		// 잔돈의 개수
		int count = 0;
		
		for (int coin : coins) {
			count += price / coin;
			price = price % coin;
		}
		
		System.out.println(count);
	}
}
