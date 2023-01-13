## Person.

<button onclick="Person()">Enter data</button>

<!-- <p> Person: <p id="answer"> </p> -->

<div id="result">
</div>

<script>
  
  function Person() {
    let personId = prompt("Enter a person id");
    const urlStart = "https://sarayu.tk/api/person/";
    const url = urlStart + personId;

    fetch(url)
      .then(res => res.json())
      .then(data => {
        console.log(data);
        console.log(typeof data);
        console.log(JSON.stringify(data))

        document.getElementById("result).innerHTML = JSON.stringify(data);

        // var result = document.getElementById("result");
        // // for (var i = 0; i < data.length; i++) {
        // //   result.appendChild(document.createTextNode(data));
        // // }
        // // document.getElementById("answer").innerHTML = data.name;

        // for (var prop in data) {
        //   if (Object.prototype.hasOwnProperty.call(data, prop)) {
        //     result.appendChild(document.createTextNode(data.prop));
        //   }
        // }
      })
      
}
</script>

<style> 
button {
	width: 120px;
	height: 40px;
	font-size: 15px;
	background-color: #43B4E5;
	color: #fff;
	border: none;
	cursor: pointer;
}

</style>