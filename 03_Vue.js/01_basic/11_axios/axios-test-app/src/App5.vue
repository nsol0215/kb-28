<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';
const BASEURL = '/api/todos';

// 전체 목록을 조회한 후 한 건씩 순차적으로 순회(반복)하면서 조회하기
const requestAPI = async () => {
  const url = '/api/todos2';
  axios
    .get(url)
    .then((response) => {
      console.log('응답 객체 : ', response);
    })
    .catch((e) => {
      console.log('에러 catch');
      if (e instanceof Error)
        console.log(e.message); // 에러 내용
      // 객체 instanceof 타입 : 객체가 특정 타입으로 만들어졌는지 확인하는 연산자
      // 맞으면 true / 아니면 false
      else console.log(e);
    });
};

requestAPI(); // 함수 호출
</script>
