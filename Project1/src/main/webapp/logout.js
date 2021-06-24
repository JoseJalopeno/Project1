function logout() {
  let url = "http://localhost:8080";

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        window.location.href = url + xhttp.responseText;
      }
    }
  };
  xhttp.open("POST", url + "/Project1/controller/logout", true);
  //send the json object back to the servlet
  xhttp.send();
}
