function getData() {
  let url = "http://localhost:8080/Project1/controller/homepage";

  let page = document.getElementById("page");
  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = () => {
    if (xhttp.readyState == 4) {
      if (xhttp.status == 200) {
        //returns info about the user, this page will allow user to add a new reimbursement form
        //and allow them to look at all of their forms submitted
        let r = xhttp.responseText;
        r = JSON.parse(r);
        // get the names of each object
        let justifications = JSON.parse(r[0]);
        let gradeformats = JSON.parse(r[1]);
        let reimbursements = JSON.parse(r[2]);
        let userInfo = JSON.parse(r[3]);
        // console.log(justifications);
        // console.log(gradeformats);
        console.log(reimbursements);
        console.log(userInfo);
        //get name
        let name = userInfo.firstName + " " + userInfo.lastName;
        let hello = document.createElement("h1");
        hello.innerHTML = "Hello: " + name;
        page.append(hello);
        let forms = userInfo.forms;
        //get balance
        let balance = document.createElement("h3");
        // let used = 0;
        // let tempPercent;
        // for (let x of forms) {
        //   //grab the reimbursement percent
        //   for (let i in reimbursements) {
        //     if (reimbursements[i].id == x.reimbursement) {
        //       // console.log("Reimbursement id and form reimbursement: " + reimbursements[i].id + " " + x.reimbursement);
        //       tempPercent = reimbursements[i].percent;
        //     }
        //   }
        //   // console.log(tempPercent);
        //   used += x.eventCost * tempPercent * 1;
        //   // console.log(used);
        // }
        balance.innerHTML = "Balance: $" + userInfo.balance;
        page.append(balance);
        // let newBalance = userInfo.balance - used;
        // json = JSON.stringify(newBalance);
        // console.log(json);
        //get all forms from user
        let formTable = document.createElement("table");
        //create table header row
        let thRow = document.createElement("tr");
        let tHeaders = [
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
          "Grade"
        ];
        //populate a table with the headers
        for (let h of tHeaders) {
          let th = document.createElement("th");
          th.innerHTML = h;
          thRow.appendChild(th);
        }
        formTable.append(thRow);
        // iterate through the forms to put them on the screen

        //console.log(forms);
        for (let form of forms) {
          let tr = document.createElement("tr");
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
