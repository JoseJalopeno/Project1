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
        let userInfo = JSON.parse(r[3]);
        console.log(justifications);
        console.log(gradeformats);
        console.log(userInfo);
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
        //populate a table with the headers
        for (let h of tHeaders) {
          let th = document.createElement("th");
          th.innerHTML = h;
          thRow.appendChild(th);
        }
        formTable.append(thRow);
        // iterate through the forms to put them on the screen
        let forms = userInfo.forms;
        //console.log(forms);
        for (let form of forms) {
          let tr = document.createElement("tr");
          //event date and time
          let eventDate = document.createElement("td");
          eventDate.innerHTML = form.eventDate;
          tr.appendChild(eventDate);
          //location
          let location = document.createElement("td");
          location.innerHTML = form.location;
          tr.appendChild(location);
          //description
          let description = document.createElement("td");
          description.innerHTML = form.description;
          tr.appendChild(description);
          //cost of event (this might need to be eventCost * reimbursement percent)
          let eventCost = document.createElement("td");
          eventCost.innerHTML = form.eventCost;
          tr.appendChild(eventCost);
          // grade format
          let gradeFormat = document.createElement("td");
          let y;
          for (f of gradeformats) {
            if (f.id == userInfo.forms.gradeformat) {
              y = f.name;
            }
          }
          gradeFormat.innerHTML = y;
          tr.appendChild(gradeFormat);
          //event type
          let eventType = document.createElement("td");
          eventType.innerHTML = form.eventtype;
          tr.appendChild(eventType);
          //justification
          let justification = document.createElement("td");
          let x;
          for (j of justifications) {
            if (j.id == userInfo.forms.justification) {
              x = j.name;
            }
          }
          justification.innerHTML = x;
          tr.appendChild(justification);
          //submission date
          let submissionDate = document.createElement("td");
          submissionDate.innerHTML = form.submissionDate;
          tr.appendChild(submissionDate);
          //status (poending, approved, denied)
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
