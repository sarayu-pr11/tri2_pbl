
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>


<script>

function getFoodName(){
    let inputFood = document.getElementById("inputFood").value;
    return inputFood;
}

function findCalories(foodName) {
    result = document.getElementById("findCaloriesResult");

    // Fetch data from API
    fetch('https://csatri1.tk/api/nutrition/findCalories/"'+foodName+'"', {credentials: 'include'})
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
    <button onclick="findCalories(getFoodName())">Submit</button>
</div>

<div style=" text-align:center; vertical-align: middle; padding:10px; margin-top:30px">
    <w id="findCaloriesResult"></w>
</div>

<style>
w { color: #eeeee4 }
</style>






<html>
  <head>
    <title>Saved Nutrition</title>
    <meta charset="UTF-8" />
  </head>
  <body>
    <h1 id="saved-nutrition">Saved Nutrition</h1>
    <div>
      <input placeholder ="Food" type="text" id="food" />
      <input placeholder ="Calories" type="text" id="calories" />
      <input placeholder ="Category" type="text" id="category" />
      <button id="add-food">Save</button>
    </div>
    <table id="food-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Food</th>
          <th>Calories</th>
          <th>Category</th>
          <th></th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    <div>
      <input placeholder ="Food ID" type="text" id="id" />
      <button id="delete-food">Delete</button>
    </div>
    <script>
      const cors = require('cors');
      const express = require('express');
      const app = express();
      app.use(cors({
        origin: '*',
        methods: 'GET,PUT,POST,DELETE',
        allowedHeaders: 'Content-Type',
      }));  
      //
      const foodTable = document.querySelector("#food-table tbody");
      const addFoodBtn = document.querySelector("#add-food");
      const deleteFoodBtn = document.querySelector("#delete-food");      //
      const idInput = document.querySelector("#id");      //
      const foodInput = document.querySelector("#food");
      const caloriesInput = document.querySelector("#calories");
      const categoryInput = document.querySelector("#category");
      addFoodBtn.addEventListener("click", () => {
        const food = foodInput.value;
        const calories = caloriesInput.value;
        const category = categoryInput.value;
        const item = { id, food, calories, category };
        fetch("https://csatri1.tk/api/nut/create/" + food + "/" + calories + "/" + category, { method: "POST", credentials: 'include' })
          .then((res) => res.json())
          .then((data) => {
            addFoodToTable(data);
            foodInput.value = "";
            caloriesInput.value = 0;
            categoryInput.value = "";
          })
          .catch((err) => console.log(err));
          window.location.reload()
      });
      deleteFoodBtn.addEventListener("click", () => {
        const id = idInput.value;
        console.log(id);
        //const item = { id, food, calories, category };
        fetch(
          "https://csatri1.tk/api/nut/delete/" + id,
          { method: "DELETE" , credentials: 'include'}
        )
          //.then((res) => res.json())
          //.then(() => {
            //getFood();
            //idInput.value = 0;
          //})
          //.catch((err) => console.log(err));
          //window.location.reload()
          console.log("here");
      });
      function getFood() {
        fetch("https://csatri1.tk/api/nut/", {credentials: 'include'})
          .then((res) => res.json())
          .then((data) => {
            foodTable.innerHTML = "";
            data.forEach(addFoodToTable);
          })
          .catch((err) => console.log(err));
      }
      function addFoodToTable(item) {
        const row = document.createElement("tr");
        const idCell = document.createElement("td");
        const foodCell = document.createElement("td");
        const caloriesCell = document.createElement("td");
        const categoryCell = document.createElement("td");
        //const deleteCell = document.createElement("td");
        //const deleteButton = document.createElement("button");
        //deleteButton.innerHTML = "Delete";
        //deleteButton.addEventListener("click", () => {
          //deleteFood(item);
        //});
        idCell.textContent = item.id;
        foodCell.textContent = item.food;
        caloriesCell.textContent = item.calories;
        categoryCell.textContent = item.category;  
        //deleteCell.appendChild(deleteButton);
        row.appendChild(idCell);
        row.appendChild(foodCell);
        row.appendChild(caloriesCell);
        row.appendChild(categoryCell);
        //row.appendChild(deleteCell);
        foodTable.appendChild(row);
      }
      function deleteFood(item) {
        fetch(
          "https://csatri1.tk/api/nut/delete/" + item.id,
          { method: "DELETE", credentials: 'include' }
        )
          .then(() => {
            getFood();
          })
          .catch((err) => console.log(err));
          window.location.reload()
      }
      getFood();
    </script>
    <style>
      #saved-nutrition {
        text-align:center;
      }
      </style>
  </body>
</html>















