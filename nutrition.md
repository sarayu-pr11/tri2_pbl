## Nutrition 

<script>

function getFood(){
    let inputFood = document.getElementById("inputFood").value;
    return inputFood;
}

function findCalories(foodName) {
    result = document.getElementById("findCaloriesResult");

    // Fetch data from API
    fetch('https://csatri1.tk/api/nutrition/findCalories/"'+foodName+'"')
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = foodName + " calories: " + data.findCalories;
    })
}

</script>


<div style="background-color:#DFB379; text-align:center; vertical-align: middle; padding:40px 0; margin-top:30px">
    <w>Ingredient</w>
    <input id="inputFood" placeholder="Input Ingredient">
    <button onclick="findCalories(getFood())">Submit</button>
</div>

<div style=" text-align:center; vertical-align: middle; padding:40px 0; margin-top:30px">
    <w>Nutrition</w>
    <w id="findCaloriesResult"></w>
</div>

<style>
w { color: #eeeee4 }

// resets
s { text-decoration:none; } //strike-through
em { font-style: normal; font-weight: bold; } //italic emphasis
</style>







