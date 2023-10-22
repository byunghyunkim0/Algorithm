import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 리스트의 크기
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		// 데이터 받기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 스택 자료 구조 선언
		Stack<Integer> stack = new Stack<>();
		
		// 결과를 저장할 배열
		int[] result = new int[n];
		
		// 뒤에서 부터 탐색
		for (int i = n - 1; i >= 0; i--) {
			// stack가 비어있으면 -1을 저장하고 stack에 수를 넣은 다음에 다음으로 넘어감
			if (stack.isEmpty()) {
				result[i] = -1;
				stack.push(arr[i]);
				continue;
			}
			
			// stack에 숫자가 들어있으면 peek와 현재 숫자와 비교해서 peek가 크다면 현재 숫자의 인덱스에 peek를 넣는다.
			if (arr[i] < stack.peek()) {
				result[i] = stack.peek();
			} else {
				// stack의 peek가 작다면 큰 수가 나올때까지 pop, 비어있으면 그만.
				while (!stack.isEmpty() && arr[i] >= stack.peek()) {
					stack.pop();
				}
				
				// 만약 stack이 비어있다면 해당 arr[i]보다 큰 숫자가 없는것이므로 -1을 저장
				if (stack.isEmpty()) {
					result[i] = -1;
				} else {
					// stack에 뭔가 있다면 arr[i] < stack.peek() 이므로 stack.peek()를 저장
					result[i] = stack.peek();
				}
			}
			// 끝나면 넣기
			stack.push(arr[i]);
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int num : result) {
			sb.append(num +" ");
		}
		System.out.println(sb);
	}
}
