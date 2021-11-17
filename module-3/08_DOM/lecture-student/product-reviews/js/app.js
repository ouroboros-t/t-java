const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  //lines 41-45 can be done in one line (51):
  let pageTitle = document.getElementById("page-title");
  //query selector is the same as CSS query selector(.notation)
  let pageTitleSpan = pageTitle.querySelector(".name");
  pageTitleSpan.innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector(".description").innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  let main = document.getElementById("main");
  //set up for-each loop for each review in the reviews array
  reviews.forEach(review => {
    //create a div that doesn't exist yet:(unique number, can't be inserted twice)
    let reviewDiv = document.createElement("div");
    //set up a class on the div and name it review:
    reviewDiv.setAttribute("class", "review");

    //call method that builds h4 and link to review objects(add reviewer, which is a property of a review object)
    addReviewer(reviewDiv, review.reviewer)

    addRating(reviewDiv, review.rating);

    addTitle(reviewDiv, review.title);

    addReview(reviewDiv, review.review);

    //insert reviewDiv as a child of the main div:
    main.insertAdjacentElement("beforeEnd", reviewDiv);
  }
  );
}

/**
 * I will create a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  //console.log(`${parent} ${name}`);
  //create h4 element here:
  let reviewerHdr = document.createElement('h4');
  reviewerHdr.innerText = name;
  parent.appendChild(reviewerHdr);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  //create ratingDiv:
  let ratingDiv = document.createElement("div");
  ratingDiv.setAttribute("class", "rating");

  //loop through so the number of stars match the rating:
  for (let i = 0; i < numberOfStars; ++i) {
    let starImg = document.createElement("img");
    starImg.setAttribute("src", "img/star.png");
    ratingDiv.appendChild(starImg);
  }
  //append to parent
  parent.appendChild(ratingDiv)
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  let reviewerTitle = document.createElement("h3");
  reviewerTitle.innerText = title;

  parent.appendChild(reviewerTitle);

}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  let reviewerReview = document.createElement("p");
  reviewerReview.innerText = review;

  parent.appendChild(reviewerReview);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
