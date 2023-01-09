## Calculator
### Click calculate and input an expression

<button onclick="calculator()">Calculate</button>

<p> Answer: <p id="answer"> </p>



<script>
  
  function calculator() {
    let expression = prompt("Enter a problem")
    const urlStart = "https://sarayu.tk/api/calculator/";
    const url = urlStart + expression;

    console.log(url); 

    fetch(url)
      .then(res => res.json())
      .then(data => {
        console.log(data);
        
        document.getElementById("answer").innerHTML = data.result; 
      
      })
      
}
</script>
