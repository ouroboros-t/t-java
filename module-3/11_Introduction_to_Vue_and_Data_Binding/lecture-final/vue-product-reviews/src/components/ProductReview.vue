<template>
    <div class="main">
      <h2>Product Reviews for {{ name }}</h2>
      <p class="description">{{ description }}</p>

        <div class="well-display">
            <div class="well">
                <span class="amount">{{ averageStarRating }}</span>
                Average Rating
            </div>
            <div class="well">
                <span class="amount">{{ numOneStarReviews }}</span>
                1 Star Review
            </div>
            <div class="well">
                <span class="amount"><!-- data binding goes here --></span>
                2 Star Review
            </div>
            <div class="well">
                <span class="amount"><!-- data binding goes here --></span>
                3 Star Review
            </div>
            <div class="well">
                <span class="amount"><!-- data binding goes here --></span>
                4 Star Review
            </div>
            <div class="well">
                <span class="amount"><!-- data binding goes here --></span>
                5 Star Review
            </div>
        </div>

      <div class="review" v-for="review in reviews" v-bind:key="review.id"
        v-bind:class="{ 'favorited': review.favorited === 'yes',
            'hated': review.favorited === 'no' }">
          <h4>{{ review.reviewer }}</h4>
          <div class="rating">
              <img src="../assets/star.png" v-bind:title="review.rating + 'Star Rating'"
              class="ratingStar" v-for="n in review.rating" v-bind:key="n" />
        </div>
        <h3>{{ review.title}}</h3>
        <p>{{ review.review}}</p>
        <p>Favorite? <input type="text" v-model="review.favorited"/></p>
        </div>
    </div>
</template>

<script>
export default {
    name: 'product-review',
    data() {
        return {
            name: "Cigar Party For Dummies",
            description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
            reviews : [
                {
                    id: 1001,
                    reviewer: 'Malcolm Gladwell',
                    title: 'What a book!',
                    review:
                    "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
                    rating: 3
                },
                {
                    id: 1002,
                    reviewer: 'Tim Ferriss',
                    title: 'Had a cigar party started in less than 4 hours.',
                    review:
                    "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
                    rating: 4
                },
                {
                    id: 1003,
                    reviewer: 'Ramit Sethi',
                    title: 'What every new entrepreneurs needs. A door stop.',
                    review:
                    "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
                    rating: 1
                },
                {
                    id: 1004,
                    reviewer: 'Gary Vaynerchuk',
                    title: 'And I thought I could write',
                    review:
                    "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
                    rating: 3
                }
            ]
        }
    },
    computed: {
        averageStarRating() {
            //return this.reviews.length;
            let totalStars = this.reviews.reduce((runningSum, curReview) => runningSum + curReview.rating, 0);
            return totalStars / this.reviews.length;
        },
        numOneStarReviews() {
            return this.reviews.filter(review => review.rating === 1).length;
        }
    }
}
</script>

<style scoped>
    div.main {
        margin: 1rem 0;
    }

    div.main div.well-display {
    display: flex;
    justify-content: space-around;
}
div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}
div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}
div.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}
div.main div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}
div.main div.review div.rating img {
    height: 100%;
}
div.main div.review p {
    margin: 20px;
}
div.main div.review h3 {
    display: inline-block;
}
div.main div.review h4 {
    font-size: 1rem;
}
div.main div.review.favorited {
    background-color: lightyellow;
}
div.main div.review.hated {
    background-color: red;
}
</style>