import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:3000"
});

export default {
    //http requests go here:
    //this is where promises are made.
    //http.get
    //in the future: name these better:
    getTopics() {
        return http.get('/topics');
    },
    getTopic(topicId) {
        return http.get(`/topics/${topicId}`);
    }



}