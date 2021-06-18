function checkLogin() {
  let url = "http://localhost:8080";
  //get username and password from form
  let loginObject = {
    username: document.getElementById("username").value,
    password: document.getElementById("password").value
  };
  //convert to a json object
  console.log(loginObject);
  let json = JSON.stringify(loginObject);
  console.log(json);
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        console.log(xhttp.readyState);
        console.log(xhttp.status);
        //if login is good from servlet we go to the next page
        window.location.href = url + xhttp.responseText;
        //console.log(xhttp.responseText);
      } else if (xhttp.status == 500) {
        let pErr = document.getElementById("error");
        pErr.innerHTML = "Username/Password does not exist";
      }
    }
  };
  xhttp.open("POST", url + "/Project1/controller/login", true);
  //send the json object back to the servlet
  xhttp.send(json);
}
