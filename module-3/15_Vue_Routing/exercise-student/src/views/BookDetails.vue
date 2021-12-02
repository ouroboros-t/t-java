<template>
<div>
    <h1>{{ book.title }}</h1>
    <img
      v-if="book.isbn"
      v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
      "
    />
    <h3 class="book-author">{{ book.author }}</h3>
    <book-details>
    <div>
</template>

<script>
import BookDetails from "@/components/BookDetails.vue";
export default {
  components: { BookDetails },
};
</script>

<style>
</style>