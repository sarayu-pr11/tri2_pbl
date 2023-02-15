
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

<img id ="pic" src="/assets/images/calories.png" alt="calories" style="width:280px;height:297px;">

<style>
    #pic{
        position:absolute;
        left: 300px;
    }
</style>

<div id="container" style=">
    <w>Ingredient</w>
    <input id="inputFood" placeholder="Input Ingredient">
    <button onclick="findCalories(getFood())">Submit</button>
</div>

<div style=" text-align:center; vertical-align: middle; padding:10px 0; margin-top:30px">
    <w>One serving of </w>
    <w id="findCaloriesResult"></w>
</div>

<style>
w { color: #eeeee4 }

#container{
    background-color:#DFB379; 
    text-align:center; 
    vertical-align: middle; 
    padding:40px 0; 
    margin-top:30px
    border-radius: 8px;
}
</style>







