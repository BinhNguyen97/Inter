import axios from 'axios';

export const restService = {
	login
}


function login(username, password, success, failure) {
    axios({
      url: `http://localhost:8080/Book/login?username=${username}&password=${password}`,
      method: "POST",
    }).then(r => { success(r.data) },
    r => { failure(r.message) })
}
