<template>
  <div>
    <h1>{{ title }}</h1>
    <p>{{ description }}</p>
  </div>
</template>

<script>
import boardService from "@/services/BoardService.js";
export default {
  name: "card-detail",
  data() {
    return {
      title: "",
      description: "",
    };
  },
  //now that I have the data, I need to state what's going to be created?
  created() {
    //we want to user our board service to pass in board id and card id
    //pull out the individual parameters defined on the route:
    let boardID = this.$route.params.boardID;
    let cardID = this.$route.params.cardID;
    //build the promise between service and request:
    boardService.getCard(boardID, cardID).then((response) => {
      this.title = response.title;
      this.description = response.description;
    });
  },
};
</script>
