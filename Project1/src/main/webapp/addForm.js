function sendData() {
  let url = "http://localhost:8080";

  let justification = JSON.parse(
    document.getElementById("justification").value
  );

  let reimbursement = JSON.parse(
    document.getElementById("reimbursement").value
  );

  let gradeFormatID = JSON.parse(document.getElementById("gradeFormat").value);
  console.log(justification);
  console.log(reimbursement);
  console.log(gradeFormatID);
  let addObject = {
    //id: take care of by database
    empID: document.getElementById("employeeID").value,
    eventDate: document.getElementById("eventDate").value,
    location: document.getElementById("location").value,
    description: document.getElementById("description").value,
    eventCost: document.getElementById("eventCost").value,
    gradeFormatID,
    eventtype: document.getElementById("eventType").value,
    justification,
    submissiondate: Date.now(),
    reimbursement,
    supervisorApproval: false,
    deptHeadApproval: false,
    benefitscoordinatorApproval: false,
    status: "Pending",
    grade: "NA"
  };
  console.log(addObject);

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
  console.log("Reached Populate function");
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
        //console.log(reimbursements);

        let user = JSON.parse(rs[3]);
        //console.log(user);
        let balanceOnPage = document.getElementById("balance");
        //get user remaining balance
        balanceOnPage.innerHTML = "Remaining balance: $" + user.balance;
        //page.append(balanceOnPage);
        let userID = user.id;
        //console.log(userID);
        let employeeID = document.getElementById("employeeID");
        employeeID.setAttribute("value", userID);
        //console.log(employeeID);
        let maxCost = document.getElementById("eventCost");
        maxCost.setAttribute("max", user.balance);

        for (let i in justifications) {
          let just = justifications[i];
          let option = document.createElement("option");
          let just2 = JSON.stringify(just);
          option.setAttribute("value", just2);
          option.innerHTML = just.justification;
          justDrop.appendChild(option);
        }

        for (let i in gradeformats) {
          let gf = gradeformats[i];
          let option = document.createElement("option");
          let gf2 = JSON.stringify(gf);
          option.setAttribute("value", gf2);
          option.innerHTML = gf.gradeformat;
          gradeFormDrop.appendChild(option);
        }

        for (let i in reimbursements) {
          let r = reimbursements[i];
          let option = document.createElement("option");
          let r2 = JSON.stringify(r);
          option.setAttribute("value", r2);
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
