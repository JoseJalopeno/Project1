function editForm() {
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
        let eventDate = document.getElementById("eventDate");
        eventDate.defaultValue = form.eventDate;
        let location = document.getElementById("location");
        location.defaultValue = form.location;
        let description = document.getElementById("description");
        description.defaultValue = form.description;
        let eventCost = document.getElementById("eventCost");
        eventCost.defaultValue = form.eventCost;
        // let gradeFormat = document.getElementById("gradeFormat");
        // gradeFormat.defaultSelected = form.gradeFormat;
        let eventtype = document.getElementById("eventType");
        eventtype.defaultValue = form.eventtype;
        // let justification = document.getElementById("justification");
        // justification.defaultSelected = form.justification;
        // let reimbursement = document.getElementById("reimbursement");
        // reimbursement.defaultSelected = form.reimbursement;
        let grade = document.getElementById("grade");
        grade.defaultValue = form.grade;
      }
    }
  };
  xhttp.open("GET", url + "/Project1/controller/editForm", true);

  xhttp.send();
}

function populate() {
  // console.log("Reached Populate function");
  let url = "http://localhost:8080";

  let justDrop = document.getElementById("justification");
  let gradeFormDrop = document.getElementById("gradeFormat");
  let reimburseDrop = document.getElementById("reimbursement");
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        let r = xhttp.responseText;
        let rs = JSON.parse(r);

        let justifications = JSON.parse(rs[0]);
        //console.log(justifications);
        let gradeformats = JSON.parse(rs[1]);
        //console.log(gradeformats);
        let reimbursements = JSON.parse(rs[2]);

        for (let i in justifications) {
          let just = justifications[i];
          let option = document.createElement("option");
          option.setAttribute("value", just.id);
          option.innerHTML = just.justification;
          justDrop.appendChild(option);
        }

        for (let i in gradeformats) {
          let gf = gradeformats[i];
          let option = document.createElement("option");
          //let gf2 = JSON.stringify(gf);
          option.setAttribute("value", gf.id);
          option.innerHTML = gf.gradeformat;
          gradeFormDrop.appendChild(option);
        }

        for (let i in reimbursements) {
          let r = reimbursements[i];
          let option = document.createElement("option");
          //let r2 = JSON.stringify(r);
          option.setAttribute("value", r.id);
          option.setAttribute("percent", r.percent);
          option.innerHTML = r.reimbursement + ": " + r.percent * 100 + "%";
          reimburseDrop.appendChild(option);
        }
      }
    }
  };
  xhttp.open("GET", url + "/Project1/controller/grabData", true);
  //send the json object back to the servlet
  xhttp.send();
}

function updateForm() {
  let url = "http://localhost:8080";

  let updateObject = {
    formid: document.getElementById("formid").value,
    eventDate: document.getElementById("eventDate").value,
    location: document.getElementById("location").value,
    description: document.getElementById("description").value,
    eventCost: document.getElementById("eventCost").value,
    gradeformat: document.getElementById("gradeFormat").value,
    eventtype: document.getElementById("eventType").value,
    justification: document.getElementById("justification").value,
    reimbursement: document.getElementById("reimbursement").value,
    grade: document.getElementById("grade").value
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
  xhttp.open("POST", url + "/Project1/controller/updateForm", true);
  //send the json object back to the servlet
  xhttp.send(json);
}
