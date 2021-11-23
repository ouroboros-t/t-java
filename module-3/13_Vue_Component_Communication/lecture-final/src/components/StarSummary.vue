<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
    {{ msg }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating", "msg"],
  methods: {
    updateFilter() {
      this.$store.commit("UPDATE_FILTER", this.rating);
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews;
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>

