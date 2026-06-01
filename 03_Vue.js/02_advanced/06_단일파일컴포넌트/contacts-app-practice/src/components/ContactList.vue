<template>
  <div class="contact-list mt-3">
    <table class="table">
      <thead>
        <tr>
          <th>이름</th>
          <th>성별</th>
          <th>나이</th>
          <th>이메일</th>
          <th>Github ID</th>
          <th>관리</th>
        </tr>
      </thead>
      <tbody>
        <ContactItem
          v-for="contactItem in contactList"
          :key="contactItem.ID"
          :contactItem="contactItem"
          @delete-contact="$emit('delete-contact', $event)"
        />
      </tbody>
    </table>
  </div>
</template>

<script>
import ContactItem from './ContactItem.vue';
export default {
  name: 'ContactList',
  components: {
    ContactItem,
  },
  props: ['contactList'],
};
</script>
