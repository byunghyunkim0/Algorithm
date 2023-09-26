import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	// 걸리는 시간의 최소값
	public static int time;
	// 사람들이 기다리는 시간
	public static List<Integer> waitA;
	public static List<Integer> waitB;
	// 사람들의 위치 정보를 저장
	public static List<int[]> list;
	// 계단의 위치정보
	public static List<int[]> s;
	// map의 정보
	public static int[][] map;
	public static int n;
	
	// 어떤 계단으로 갈지 저장
	public static boolean[] choice;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TEST = sc.nextInt();
		
		for (int testCase = 1; testCase <= TEST; testCase++) {
			n = sc.nextInt();
			
			// 위치에 대한 정보 받을 리스트
			list = new ArrayList<>();
			
			// 계단 위치에 대한 정보
			s = new ArrayList<>();
			
			// 데이터 받기
			map = new int[n][n];
			
			// 결과를 출력할 time변수 초기화, 최소값을 찾기위해서 maxvalue로 설정
			time = Integer.MAX_VALUE;
			// 데이터를 받으면서 사람의 위치와 계단의 위치를 받는다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						list.add(new int[] {i, j});
					} else if (map[i][j] > 1) {
						s.add(new int[] {i, j});
					}
				}
			}
			choice = new boolean[list.size()];
			
			powerset(0);
			
			System.out.println("#" + testCase + " " + time);
		}
	}
	
	public static void powerset(int idx) {
		if (idx == list.size()) {
			waitA = new ArrayList<>();
			waitB = new ArrayList<>();
			// 뽑는 횟수가 사람들의 수와 같으면 종료
			for (int i = 0; i < list.size(); i++) {
				if (choice[i]) {
					// waitA에 해당 사람의 위치와 계단 위치의 거리를 저장
					waitA.add(Math.abs(list.get(i)[0] - s.get(0)[0]) + Math.abs(list.get(i)[1] - s.get(0)[1]));
				} else {
					// waitB에 해당 사람의 위치와 계단 위치의 거리를 저장
					waitB.add(Math.abs(list.get(i)[0] - s.get(1)[0]) + Math.abs(list.get(i)[1] - s.get(1)[1]));
				}
			}
			// 계단에 대한 연산을 처리하기위해서 오름차순으로 정렬
			Collections.sort(waitA);
			Collections.sort(waitB);
			
			// waitA에 대해서 각각의 사람이 들어갔다가 계단을 나오는데 걸리는 시간을 dp로 저장
			for (int i = 0; i < waitA.size(); i++) {
				if (i < 3) {
					// 3번째 사람까지는 도착하고 바로 들어갈수있다.
					waitA.set(i, waitA.get(i) + map[s.get(0)[0]][s.get(0)[1]] + 1);
				} else {
					// 4번째 사람부터는 1번째 사람이 나오고 나서야 들어갈수있다.
					// -3번째 사람이 내려간 시간과 한 사람이 도착한 시간이 같거나 도착한 시간이 길다면
					if (waitA.get(i - 3) <= waitA.get(i)){
						waitA.set(i, Math.max(waitA.get(i) + map[s.get(0)[0]][s.get(0)[1]] + 1, waitA.get(i - 3) + map[s.get(0)[0]][s.get(0)[1]] + 1));
					} else {
						waitA.set(i, Math.max(waitA.get(i) + map[s.get(0)[0]][s.get(0)[1]] + 1, waitA.get(i - 3) + map[s.get(0)[0]][s.get(0)[1]] + 1) - 1);
					}
				}
			}
			
			for (int i = 0; i < waitB.size(); i++) {
				if (i < 3) {
					waitB.set(i, waitB.get(i) + map[s.get(1)[0]][s.get(1)[1]] + 1);
				} else {
					// 4번째 사람부터는 1번째 사람이 나오고 나서야 들어갈수있다.
					// -3번째 사람이 내려간 시간과 한 사람이 도착한 시간이 같거나 도착한 시간이 길다면
					if (waitB.get(i - 3) <= waitB.get(i)){
						waitB.set(i, Math.max(waitB.get(i) + map[s.get(1)[0]][s.get(1)[1]] + 1, waitB.get(i - 3) + map[s.get(1)[0]][s.get(1)[1]] + 1));
					} else {
						waitB.set(i, Math.max(waitB.get(i) + map[s.get(1)[0]][s.get(1)[1]] + 1, waitB.get(i - 3) + map[s.get(1)[0]][s.get(1)[1]] + 1) - 1);
					}
				}
			}
			
			// a계단과 b계단중 시간이 많이 걸리는 것을 저장
			int r = 0;
			// a계단과 b계단 중 이용하는 사람이 있는지 없는지 판단
			if (waitA.isEmpty()) {
				r = waitB.get(waitB.size() - 1);
			} else if (waitB.isEmpty()) {
				r = waitA.get(waitA.size() - 1);
			} else {
				r = Math.max(waitA.get(waitA.size() - 1), waitB.get(waitB.size() - 1));
			}
			
			// time의 값을 계속 갱신해나간다.
			time = Math.min(r, time);
			return;
		}
		
		// 부분집합을 구하기위한 재귀
		choice[idx] = false;
		powerset(idx + 1);
		
		choice[idx] = true;
		powerset(idx + 1);
	}
}
