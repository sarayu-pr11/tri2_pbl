
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

        result.innerHTML = "calories in one serving of " + foodName + ": " + data.findCalories + " cal";
    })
}

</script>



<div style="background-color: #DFB379; text-align: center; vertical-align: middle; padding: 40px; margin-top: 30px; border-radius: 10px;">
    <w>Ingredient</w>
    <input id="inputFood" placeholder="Input Food">
    <button onclick="findCalories(getFood())">Submit</button>
</div>

<div style=" text-align:center; vertical-align: middle; padding:10px; margin-top:30px">
    <w id="findCaloriesResult"></w>
</div>

<style>
w { color: #eeeee4 }

</style>







