## 지뢰찾기게임 출력하기

* 각 사각형에 표시될 숫자는, 자신을 제외한 주변 8개 사각형에 포함된 지뢰의  갯수
* 지뢰는 랜덤하게 Land에 배치되어짐 (기본값: 10개)
* 모든 사각형(100개)에 대한 숫자를 구해야함 (지뢰를 별도 flag로 표기하지 말 것)
  * flag로 표시하고자 할 때는 `private static final boolean MINE_FLAG_MODE = true;` 로 값을 변경
  * 자기자신이 지뢰이더라도, 자신을 제외한 주변 8개 셀에 포함된 지뢰의 갯수로 표현

### 출력
`MINE_FLAG_MODE = false` \
![image](https://user-images.githubusercontent.com/38197077/88314831-7ad3cc80-cd50-11ea-9d3a-8d252cad6eec.png)

`MINE_FLAG_MODE = true` \
![image](https://user-images.githubusercontent.com/38197077/88314878-8921e880-cd50-11ea-9130-8671aaa84c3e.png)

### 일관적인 지뢰 데이터 테스트

일관된 지뢰의 결과로 값을 확인하고자 할 때 Land의 생성자 3번째 파라미터에 마인 배열을 넘긴다.
```java
Land land = new Land(ROW, COL, Arrays.stream(new int[][]{
        {1, 2},
        {4, 5},
        {1, 9},
        {2, 9},
        {7, 8},
        {5, 1},
        {8, 8},
        {3, 2},
        {4, 0},
        {7, 3}
}).map(mine -> new Mine(mine[0], mine[1])).toArray(Mine[]::new));
land.render(MINE_FLAG_MODE);
```


