<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

/** try - catch - finally
 * try{ } : 예외가 발생할 가능성이 있는 코드
 * catch(e){ } : 예외 발생 시 수행할 코드
 * finally {} : 마지막에 무조건 수행
 */

// 에러 처리 예제
const requestAPI = async () => {
  try {
    // 에러 발생 시 즉시 종료 후 catch문으로 이동
    const url = '/api/todos2';
    let response = await axios.get(url);
    console.log('응답 객체 : ', response);
  } catch (e) {
    console.log('에러 발생 시에만 수행');
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  } finally {
    // 무조건 수행
    console.log('finally는 무조건 수행');
  }
};

requestAPI(); // 함수 호출
</script>
