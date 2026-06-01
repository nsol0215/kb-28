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
  let data = { todo: '복습하기', desc: '이해가 될 떄 까지' };

  // POST 요청 : 데이터 추가
  const resp = await axios.post(BASEURL, data);
  console.log(resp.data);
};

requestAPI(); // 함수 호출
</script>
