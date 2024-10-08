# [Gold II] 가장 긴 증가하는 부분 수열 2 - 12015 

[문제 링크](https://www.acmicpc.net/problem/12015) 

### 성능 요약

메모리: 121896 KB, 시간: 412 ms

### 분류

이분 탐색, 가장 긴 증가하는 부분 수열: O(n log n)

### 제출 일자

2024년 9월 4일 16:21:24

### 문제 설명

<p>수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {<strong>10</strong>, <strong>20</strong>, 10, <strong>30</strong>, 20, <strong>50</strong>} 이고, 길이는 4이다.</p>

### 입력 

 <p>첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.</p>

<p>둘째 줄에는 수열 A를 이루고 있는 A<sub>i</sub>가 주어진다. (1 ≤ A<sub>i</sub> ≤ 1,000,000)</p>

### 출력 

 <p>첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.</p>

### 풀이 과정

가장 긴 부분 수열의 길이만 구하면 되는 문제<br>
수열의 첫번째 값을 배열에 입력한다.<br>
수열에서 다음 숫자에 대해서 배열에 들어갈 위치를 이분 탐색을 통해 구함<br>
다음 숫자가 배열의 최대값보다 크다면 배열의 가장 오른쪽에 추가를 하고, 다음 숫자가 오름차순으로 정렬했을때의 위치에 해당 숫자보다 작다면 해당 숫자를 변경<br>
이러한 방식으로 진행하면 가장 긴 부분 수열의 구체적인 값은 알수 없지만 길이를 구할 수 있다.<br>
구체적인 값을 구하려면 DP를 이용