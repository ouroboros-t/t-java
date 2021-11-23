<template>
  <div>
    <form v-on:submit.prevent="addNewBook" class="new-book-form">
      <label for="title-input">Title:</label>
      <input type="text" class="title-input" v-model="newBook.title" />
      <label for="author-input">Author:</label>
      <input type="text" class="author-input" v-model="newBook.author" />
      <label for="isbn-input">ISBN:</label>
      <input type="text" class="isbn-input" v-model="newBook.isbn" />
      <input type="submit" value="Submit" />
    </form>
  </div>
</template>

<script>
export default {
  name: "new-book-form",
  data() {
    return {
      newBook: {
        read: false,
      },
    };
  },
  methods: {
    addNewBook() {
      this.$store.commit("ADD_NEW_BOOK", this.newBook);
    },
  },
};
</script>