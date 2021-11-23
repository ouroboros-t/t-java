<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{
      numberOfReviews
    }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? "" : "s" }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  //there can be multiple properties as comma delimited strings
  props: ["rating"],
  methods: {
    updateFilter() {
      //commit is how we get from outside the store into the store
      this.$store.commit("UPDATE_FILTER", this.rating);
    },
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews;
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    },
  },
};
</script>

