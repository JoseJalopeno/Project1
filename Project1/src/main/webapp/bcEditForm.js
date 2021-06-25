function bcEditForm() {
  let url = "http://localhost:8080";

  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        let r = xhttp.responseText;
        let form = JSON.parse(r);
        console.log(form);
        let formid = document.getElementById("formid");
        formid.setAttribute("value", form.id);
        let eventCost = document.getElementById("eventCost");
        eventCost.defaultValue = form.eventCost;
      }
    }
  };
  xhttp.open("GET", url + "/Project1/controller/bcEditForm", true);

  xhttp.send();
}

function updateForm() {
  let url = "http://localhost:8080";

  let updateObject = {
    formid: document.getElementById("formid").value,
    eventCost: document.getElementById("eventCost").value,
    reason: document.getElementById("reason").value
  };
  let json = JSON.stringify(updateObject);
  console.log(json);
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        window.location.href = url + xhttp.responseText;
      }
    }
  };
  xhttp.open("POST", url + "/Project1/controller/bcUpdateForm", true);
  //send the json object back to the servlet
  xhttp.send(json);
}
