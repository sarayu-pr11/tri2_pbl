## Nutrition 

<script>

function getNutrition(foodName) {
    result = document.getElementById("getNutritionResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/nutrition/findCalories/"'+food+'"')
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = foodName + " calories: " + data.getNutrition;

    })
}

</script>


<div style="background-color:rgba(63, 101, 209, 0.98); text-align:center; vertical-align: middle; padding:40px 0; margin-top:30px">
    <w>Ingredient</w>
    <input id="ingredient" placeholder="Input Ingredient">
    <input id="amount" placeholder="Input Amount">
    <button onclick="fetch()">Submit</button>
</div>

<div style="background-color:rgba(63, 101, 209, 0.98); text-align:center; vertical-align: middle; padding:40px 0; margin-top:30px">
    <w>Nutrition</w>
    <p id="Result"></p>
</div>

<style>
b { color: blue }
g { color: grey }
w { color: #eeeee4 }

// resets
s { text-decoration:none; } //strike-through
em { font-style: normal; font-weight: bold; } //italic emphasis
</style>







