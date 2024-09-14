# [Gold I] 구간 합 구하기 - 2042 

[문제 링크](https://www.acmicpc.net/problem/2042) 

### 성능 요약

메모리: 117332 KB, 시간: 472 ms

### 분류

세그먼트 트리, 자료 구조

### 제출 일자

2024년 9월 10일 13:37:04

### 문제 설명

<p>어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.</p>

### 입력 

 <p>첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.</p>

<p>입력으로 주어지는 모든 수는 -2<sup>63</sup>보다 크거나 같고, 2<sup>63</sup>-1보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 단, 정답은 -2<sup>63</sup>보다 크거나 같고, 2<sup>63</sup>-1보다 작거나 같은 정수이다.</p>

### 풀이 과정

구간 합을 구하기 위해서 누적합을 이용하여 구하는 방법이 있다<br>
누적합을 이용하여 구간 합을 구할 때 일부의 숫자가 변경되고 구간합을 구하려면 해당 숫자부터 끝까지 다시 구간합을 구해야한다.<br>
이 방식으로 구간합을 구하면 <code>O(NM)</code>이라는 시간 복잡도를 가지게 된다.<br>
이를 빠른 시간안에 해결하기위해서 세그먼트 트리를 사용<br>
세그먼트 트리는 완전 이진트리로 만들고 리프 노드에 모든 배열의 수를 저장한다.<br>
그리고 부모 노드에는 2개의 자식 노드의 합을 구해 저장한다.<br>
이 방식으로 저장하고 만약 한개의 숫자를 변경시키고 구간 합을 구하면 <code>O(log(N))</code>의 시간복잡도를 가지게된다.

세그먼트 트리 구현<br>
```java
static long init(int start, int end, int node) {
    if (start == end) {
        return tree[node] = arr[start];
    }
    int mid = (start + end) / 2;
    return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
}
```
start와 end가 같다는 의미는 해당 node의 위치가 리프 노드라는 의미이다.<br>
init 함수에서 재귀방식을 사용해서 리프 노드부터 루트 노드까지의 합들을 구한다.
```java
static void Update(int start, int end, int node, int idx, long dif) {
    if (start <= idx && idx <= end) {
        tree[node] += dif;
    } else {
        return;
    }
    if (start == end) {
        return;
    }
    int mid = (start + end) / 2;
    Update(start, mid, node * 2, idx, dif);
    Update(mid + 1, end, node * 2 + 1, idx, dif);
}
```
Update 함수는 해당 수열[idx]에서 dif만큼 값을 변경을 시키는 함수이다.<br>
idx와 연관된 node들의 대해서 dif를 더해 tree를 갱신시킨다<br>
```java
static long Sum(int start, int end, int node, int idxStart, int idxEnd) {
    if (idxEnd < start || idxStart > end) {
        return 0;
    }
    if (idxStart <= start && end <= idxEnd) {
        return tree[node];
    }
    int mid = (start + end) / 2;
    return Sum(start, mid, node * 2, idxStart, idxEnd) + Sum(mid + 1, end, node * 2 + 1, idxStart, idxEnd);
}
```
Sum함수는 범위 idxStart와 idxEnd 사이의 값에 해당하는 node들의 값을 더해서 만든다.<br>
범위에 맞는다면 리프노드까지 들어가는게 아니라 부모노드를 통해서 해당 리프노드의 합을 구한다.<br>