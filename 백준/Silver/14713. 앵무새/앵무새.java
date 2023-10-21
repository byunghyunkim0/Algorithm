import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 앵무새의 수 n
		int n = sc.nextInt();
		// 개행 문자 처리
		sc.nextLine();
		
		// 앵무새의 문장들 저장
		List<Queue<String>> str = new ArrayList<>();
		
		for (int i = 0; i < n; i++){
			// n개의 줄의 걸쳐 앵무새가 말한 문장 s를 받는다.
			String[] s = sc.nextLine().split(" ");
			
			// queue에 s의 원소를 하나씩 넣기
			Queue<String> queue = new LinkedList<>();
			for (int j = 0; j < s.length; j++) {
				queue.add(s[j]);
			}
			
			// str에 queue를 넣기
			str.add(queue);
		}
		
		// 앵무새의 문장으로 만드는 목표 문장 l
		String[] l = sc.nextLine().split(" ");
		
		int len = 0;
		for (int i = 0; i < n; i++) {
			len += str.get(i).size();
		}
		
		if (len != l.length) {
			System.out.println("Impossible");
			return;
		}
		
		boolean flag = true;
		t :for (int i = 0; i < l.length; i++) {
			// l을 처음부터 하나씩 방문해서 str의 원소들중 맨 앞에 있는 것과 같으면 해당 원소를 pop을 진행
			for (int j = 0; j < str.size(); j++) {
				if (l[i].equals(str.get(j).peek())) {
					str.get(j).poll();
					continue t;
				}
			}
			// 이 문장을 실행한다면 문장들 중 맨 앞의 단어가 나오지 않았다는 뜻이므로 impossible를 출력하고 break;
			flag = false;
			System.out.println("Impossible");
			break;
		}
		
		// flag가 true라면 possible 출력
		if (flag) {
			System.out.println("Possible");
		}
	}
}
