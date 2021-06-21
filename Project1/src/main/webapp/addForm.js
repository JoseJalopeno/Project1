function sendData() {
  let url = "http://localhost:8080";

  let addObject = {
    eventDate: document.getElementById("eventDate").value,
    //startTime: document.getElementById("startTime").value,
    location: document.getElementById("location").value,
    description: document.getElementById("description").value,
    eventCost: document.getElementById("eventCost").value,
    gradeFormat: document.getElementById("gradeFormat").value,
    eventType: document.getElementById("eventType").value,
    justification: document.getElementById("justification").value,
    reimbursement: document.getElementById("reimbursement").value
  };

  // console.log(addObject);
  let json = JSON.stringify(addObject);
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        // console.log(xhttp.readyState);
        // console.log(xhttp.status);
        //if login is good from servlet we go to the next page
        window.location.href = url + xhttp.responseText;
        //console.log(xhttp.responseText);
      }
    }
  };
  xhttp.open("POST", url + "/Project1/controller/addForm", true);
  //send the json object back to the servlet
  xhttp.send(json);
}

function populate() {
  let url = "http://localhost:8080";
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        let r = xhttp.responseText;
      }
    }
  };
  xhttp.open("GET", url + "/Project1/controller/grabData", true);
  //send the json object back to the servlet
  xhttp.send();
}
