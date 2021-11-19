const myApp = new Vue({

    data() {
        return {
            message: "Yay! It's Friday!",
            firstName: "Tay",
            planets: [
                'Mercury', 'Venus', 'Earth'
            ],
            showDescription: false
        }
    }

});

//mount our data onto the page:
myApp.$mount('#myApp');
//now, our div that we labeled "my app" has access to Vue capabilities

