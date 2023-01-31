
<h1 style=“text-align: center”>Our FRQs</h1>
<div id=“title”>
</div>
# FRQ 4
<div style=“text-align: center”>
  <input id=“numCols” type=“text” placeholder=“Number of Columns” />
  <input id=“numRows” type=“text” placeholder=“Number of Rows” />
</div>
<style>
  .button-container-div {
      text-align: center;
      height: 10vh;
      width: 45vw;
  }
</style>
<div class=“button-container-div”>
  <button class=“button” id=“refresh-button”>New</button>
 </div>
<div id=“table-container”></div>
<script>

function generate() {
    console.log("button clicked");
    fetch("https://hetvitrivedi.tk/api/lightboard/", {"method": "GET"})
    // response is a RESTful "promise" on any successful fetch
    .then(response => {
        // check for response errors
        if (response.status !== 200) {
            error("GET API response failure: " + response.status)
            return;  // api failure
        }
        // Make a cell with RGB color input
        const td = document.createElement(‘td’);
        td.style.backgroundColor = `rgb(${light.red}, ${light.green}, ${light.blue})`;
        // brightness level text color
        const brightness = (light.red * 299 + light.green * 587 + light.blue * 114) / 1000;
        if (brightness < 128) {
          td.style.color = ‘white’;
        } else {
          td.style.color = ‘black’;
        }
        // Box text style
        td.innerText = `#${light.red.toString(16).padStart(2, ‘0’)}${light.green.toString(16).padStart(2, ‘0’)}${light.blue.toString(16).padStart(2, ‘0’)}`;
        table.lastElementChild.appendChild(td);
      }
    tableContainer.appendChild(table);
    });
}

function generateSize() {
    let width = document.getElementById("inputWidth").value;
    let length = document.getElementById("inputLength").value;

    console.log("button2 clicked");
    fetch("https://hetvitrivedi.tk/api/lightboard/create/" + width + "/" + length, {"method": "GET"})
    // response is a RESTful "promise" on any successful fetch
    .then(response => {
        // check for response errors
        if (response.status !== 200) {
            error("GET API response failure: " + response.status)
            return;  // api failure
        }
        // valid response will have JSON data
        response.json().then(data => {

        console.log(data);
        //clear previous results
        document.getElementById("result").innerHTML = "";
        var board = data;

        var table = document.createElement("table");
        table.setAttribute("border", "1");
        table.setAttribute("style", "border-collapse: collapse;");
        var tableBody = document.createElement("tbody");

        for (var i = 0; i < board.lights.length; i++) {
            var row = document.createElement("tr");
            for (var j = 0; j < board.lights[i].length; j++) {
            var cell = document.createElement("td");
            var cellText = document.createTextNode(board.lights[i][j].effectTitle);
            var cellText2 = document.createTextNode(board.lights[i][j].rgb);
            // set color of cell based on rgb hex code if light is on
            if (board.lights[i][j].on) {
                cell.setAttribute("style", "background-color: " + board.lights[i][j].rgb);
            }
            cell.appendChild(cellText);
            cell.appendChild(cellText2);
            row.appendChild(cell);
            }
            tableBody.appendChild(row);
        }
        table.appendChild(tableBody);
        document.getElementById("result2").appendChild(table);
        })
        // catch fetch errors
        .catch(err => {
            error(err + " " );
        });
    })
}

</script>

### Click to generate new lightboard!

<button onclick="generate()">Generate</button>
<div id="result">
</div>

<br>
<!--<h3> Or, enter length and width for desired lightboard below </h3>  -->

<!--<input id="inputWidth" placeholder="Enter a width">
<input id="inputLength" placeholder="Enter a length">
<button onclick="generateSize()">Generate with size</button>
<div id="result2">
</div>    -->
