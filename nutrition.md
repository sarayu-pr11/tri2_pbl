## Nutrition 

<script>

function getFood(){
    let inputFood = document.getElementById("inputFood").value;
    return inputFood;
}

function findCalories(food) {
    result = document.getElementById("findCaloriesResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/nutrition/findCalories/"'+food+'"')
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "calories in " + food + data.findCalories;
    })
}

</script>


<div style="background-color:rgba(63, 101, 209, 0.98); text-align:center; vertical-align: middle; padding:40px 0; margin-top:30px">
    <w>Calorie Calculator</w>
    <input id="inputFood" placeholder="Input Food">
    <button onclick="findCalories(getFood())">Submit</button>
    <p id="findCaloriesResult"></p>
</div>

<style>
b { color: blue }
g { color: grey }
w { color: #eeeee4 }

// resets
s { text-decoration:none; } //strike-through
em { font-style: normal; font-weight: bold; } //italic emphasis
</style>







