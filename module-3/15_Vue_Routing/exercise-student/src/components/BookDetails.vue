<template>
  <div>
    <h1>{{ book.title }}</h1>
    <h2>{{ book.author }}</h2>
    <img
      v-if="book.isbn"
      v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
      "
    />
    <p v-if="!book.read">I have not read this book</p>
    <p v-else>I have read this book</p>
  </div>
</template>

<script>
export default {
  computed: {
    book() {
      const activeBookIsbn = this.$route.params.isbn;
      return this.$store.state.books.find((b) => {
        return b.isbn === activeBookIsbn;
      });
    },
  },
};
</script>

<style>
</style>