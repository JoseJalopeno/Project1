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
        //console.log(r);
        //get name
        let name = r.firstName + " " + r.lastName;
        let hello = document.createElement("h1");
        hello.innerHTML = "Hello: " + name;
        page.append(hello);
        //get balance
        let forms = r.forms;
        console.log(forms);
        let balance = document.createElement("h3");
        balance.innerHTML = "Balance: $" + r.balance;
        page.append(balance);
        //get all forms
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
          "Status"
        ];
        for (let h of tHeaders) {
          let th = document.createElement("th");
          th.innerHTML = h;
          thRow.appendChild(th);
        }
        formTable.append(thRow);
        // iterate through the forms to put them on the screen

        console.log(forms);
        for (let form of forms) {
          let tr = document.createElement("tr");

          let eventDate = document.createElement("td");
          eventDate.innerHTML = form.eventDate;
          tr.appendChild(eventDate);

          let location = document.createElement("td");
          location.innerHTML = form.location;
          tr.appendChild(location);

          let description = document.createElement("td");
          description.innerHTML = form.description;
          tr.appendChild(description);

          let eventCost = document.createElement("td");
          eventCost.innerHTML = form.eventCost;
          tr.appendChild(eventCost);

          let gradeFormat = document.createElement("td");
          gradeFormat.innerHTML = form.gradeFormatID.gradeFormat;
          tr.appendChild(gradeFormat);

          let eventType = document.createElement("td");
          eventType.innerHTML = form.eventtype;
          tr.appendChild(eventType);

          let justification = document.createElement("td");
          justification.innerHTML = form.justification.justification;
          tr.appendChild(justification);

          let submissionDate = document.createElement("td");
          submissionDate.innerHTML = form.submissionDate;
          tr.appendChild(submissionDate);

          let status = document.createElement("td");
          status.innerHTML = form.status;
          tr.appendChild(status);

          formTable.appendChild(tr);
        }
        page.append(formTable);
      }
    }
  };

  xhttp.open("GET", url, true);

  xhttp.send();
}

function redirect() {
  window.location.href = "http://localhost:8080/Project1/addForm.html";
}

function reload() {
  getData();
}
