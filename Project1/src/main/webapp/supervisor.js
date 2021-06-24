function getData() {
  let url = "http://localhost:8080/Project1/controller/supervisor";

  let page = document.getElementById("page");
  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        //returns info about the user, this page will allow user to add a new reimbursement form
        //and allow them to look at all of their forms submitted
        let r = xhttp.responseText;
        let rs = JSON.parse(r);
        // get the names of each object
        let justifications = JSON.parse(rs[0]);
        let gradeformats = JSON.parse(rs[1]);
        let reimbursements = JSON.parse(rs[2]);
        let unapprovedForms = JSON.parse(rs[3]);
        let userInfo = JSON.parse(rs[4]);
        let employees = JSON.parse(rs[5]);
        //console.log(unapprovedForms);
        //get name
        let name = userInfo.firstName + " " + userInfo.lastName;
        let hello = document.createElement("h1");
        hello.innerHTML = "Hello: " + name;
        page.append(hello);

        //get balance
        let balance = document.createElement("h3");
        balance.innerHTML = "Balance: $" + userInfo.balance;
        page.append(balance);
        //get all forms from user
        let formTable = document.createElement("table");
        //create table header row
        let thRow = document.createElement("tr");
        let tHeaders = [
          "Employee Name",
          "Event Date",
          "Location",
          "Description",
          "Event Cost",
          "Grade Format",
          "Event Type",
          "Justification",
          "Submission Date",
          "Status",
          "Supervisor Approval",
          "Dept. Head Approval",
          "Benefits Coordinator Approval",
          "Grade",
          "Action"
        ];
        //populate a table with the headers
        for (let h of tHeaders) {
          let th = document.createElement("th");
          th.innerHTML = h;
          thRow.appendChild(th);
        }
        formTable.append(thRow);
        //get the forms to put them on screen
        let forms = unapprovedForms;
        for (let form of forms) {
          let tr = document.createElement("tr");
          //employee name on form
          let tdemployeeName = document.createElement("td");
          let empNameTemp;
          for (let i in employees) {
            if (employees[i].id == form.empID) {
              empNameTemp =
                employees[i].firstName + " " + employees[i].lastName;
            }
          }
          tdemployeeName.innerHTML = empNameTemp;
          tr.appendChild(tdemployeeName);
          //event date and time
          let tdeventDate = document.createElement("td");
          tdeventDate.innerHTML = form.eventDate;
          tr.appendChild(tdeventDate);
          //location
          let tdlocation = document.createElement("td");
          tdlocation.innerHTML = form.location;
          tr.appendChild(tdlocation);
          //description
          let tddescription = document.createElement("td");
          tddescription.innerHTML = form.description;
          tr.appendChild(tddescription);
          //cost of event (this might need to be eventCost * reimbursement percent)
          let tdeventCost = document.createElement("td");
          tdeventCost.innerHTML = "$" + form.eventCost;
          tr.appendChild(tdeventCost);
          // grade format
          let tdgradeFormat = document.createElement("td");
          let gfTemp;
          for (let i in gradeformats) {
            // console.log("GradeFormats[i]: " + gradeformats[i].id);
            // console.log("form.gradeformat: " + form.gradeformat);
            if (gradeformats[i].id == form.gradeformat) {
              gfTemp = gradeformats[i].gradeformat;
            }
          }
          tdgradeFormat.innerHTML = gfTemp;
          tr.appendChild(tdgradeFormat);
          //event type
          let tdeventType = document.createElement("td");
          tdeventType.innerHTML = form.eventtype;
          tr.appendChild(tdeventType);
          //justification
          let tdjustification = document.createElement("td");
          let jTemp;
          for (let i in justifications) {
            if (justifications[i].id == form.justification) {
              jTemp = justifications[i].justification;
            }
          }
          tdjustification.innerHTML = jTemp;
          tr.appendChild(tdjustification);
          //submission date
          let tdsubmissionDate = document.createElement("td");
          tdsubmissionDate.innerHTML = form.submissionDate;
          tr.appendChild(tdsubmissionDate);
          //status (poending, approved, denied)
          let tdstatus = document.createElement("td");
          tdstatus.innerHTML = form.status;
          tr.appendChild(tdstatus);
          //supervisorapproval
          let tdsupervisorapproval = document.createElement("td");
          tdsupervisorapproval.innerHTML = form.supervisorApproval;
          tr.appendChild(tdsupervisorapproval);
          //depthead approval
          let tddeptheadapproval = document.createElement("td");
          tddeptheadapproval.innerHTML = form.deptHeadApproval;
          tr.appendChild(tddeptheadapproval);
          //supervisorapproval
          let tdbcapproval = document.createElement("td");
          tdbcapproval.innerHTML = form.BCApproval;
          tr.appendChild(tdbcapproval);
          //grade
          let tdgrade = document.createElement("td");
          tdgrade.innerHTML = form.grade;
          tr.appendChild(tdgrade);
          // create new td for select
          let tdSelect = document.createElement("td");
          //action - create select
          let tdactionSelect = document.createElement("select");
          tdactionSelect.setAttribute("id", "action");
          // approve
          let tdactionApprove = document.createElement("option");
          tdactionApprove.setAttribute("value", "Approve");
          tdactionApprove.innerHTML = "Approve";
          tdactionSelect.appendChild(tdactionApprove);
          // request more info
          let tdactionRequest = document.createElement("option");
          tdactionRequest.setAttribute("value", "Request");
          tdactionRequest.innerHTML = "Request more info";
          tdactionSelect.appendChild(tdactionRequest);
          // deny request
          let tdactionDeny = document.createElement("option");
          tdactionDeny.setAttribute("value", "Deny");
          tdactionDeny.innerHTML = "Deny";
          tdactionSelect.appendChild(tdactionDeny);
          // attach select to td
          tdSelect.appendChild(tdactionSelect);
          tr.appendChild(tdSelect);
          // create a new button that will send the action to backend
          let tdButton = document.createElement("td");
          let button = document.createElement("button");
          button.setAttribute("onclick", "sendAction(" + form.id + ")");
          button.innerHTML = "Send";
          //attach button to td
          tdButton.appendChild(button);
          tr.appendChild(tdButton);

          //add the row to the table
          formTable.appendChild(tr);
        }
        page.append(formTable);
      }
    }
  };

  xhttp.open("POST", url, true);

  xhttp.send();
}

function redirect() {
  window.location.href = "http://localhost:8080/Project1/addForm.html";
}

function sendAction(formId) {
  let url = "http://localhost:8080";

  let sendObj = {
    action: document.getElementById("action").value,
    formid: formId
  };
  console.log(sendObj);
  let json = JSON.stringify(sendObj);
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        window.location.href = url + xhttp.responseText;
      }
    }
  };

  xhttp.open("POST", url + "/Project1/controller/supervisorApproval", true);

  xhttp.send(json);
}
