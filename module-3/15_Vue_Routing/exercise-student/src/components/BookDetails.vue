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
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>