<template>
  <div>
    <h1>{{ title }}</h1>
    <p>{{ description }}</p>
  </div>
</template>

<script>
import boardService from '@/services/BoardService.js';

export default {
  name: "card-detail",
  data() {
    return {
      title: '',
      description: ''
    }
  },
  created() {
    let boardID = this.$route.params.boardID;
    let cardID = this.$route.params.cardID;
    boardService.getCard(boardID, cardID).then(response =>
    {
      this.title = response.title;
      this.description = response.description;
    });
  }
};
</script>
