import java.util.Scanner;

public class Main {
	public static int[] lotto = new int[6];;
	public static int[] number;
	public static StringBuilder sb;
	public static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			k = sc.nextInt();
			
			// 0을 받으면 종료
			if (k == 0) {
				break;
			}
			
			// k개수의 번호를 받기위해 배열을 생성
			number = new int[k];
			
			// 번호 받기
			for (int i = 0; i < k; i++) {
				number[i] = sc.nextInt();
			}
			
			// 출력정보를 받기위한 StringBuilder선언
			sb = new StringBuilder();
			
			combination(0, 0);
			
			System.out.println(sb);
		}
	}
	
	// 조합을 구하는 메서드
	public static void combination(int index, int indexLotto) {
		// 숫자 6개를 뽑았으면 StringBuilder에 정보 넣기
		if (indexLotto == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(lotto[i] + " ");
			}
			sb.append("\n");
			return;
		}
		// index가 number의 개수보다 크면 return
		if (index >= k) {
			return;
		}
		// 해당인덱스에 넣기
		lotto[indexLotto] = number[index];
		
		// 재귀
		combination(index + 1, indexLotto + 1);
		combination(index + 1, indexLotto);
	}
}
