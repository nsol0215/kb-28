/* ###const

- 상수를 선언하는 키워드
- SCOPE는 let과 동일
- 값을 변경할 수 없으나,
  객체나 배열의 경우 내부 속성은 변경 가능
  
*/

// p1이 참조하는 메모리 주소가 바뀌는 것이므로
// 에러 발생함.

const p1 = { name: 'john', age: 20 };
p1 = { name: 'lee', age: 25 };

console.log(p1); // TypeError: Assignment to constant variable.
