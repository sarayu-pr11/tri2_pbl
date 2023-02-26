
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>


<script>

function getFood(){
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
    <button onclick="findCalories(getFood())">Submit</button>
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
    <h1>Saved Nutrition</h1>
    <div>
      <label for="food-name">Food:</label>
      <input type="text" id="food-name" />
      <label for="calories">Calories:</label>
      <input type="text" id="calories" />
      <label for="category">Category:</label>
      <input type="text" id="category" />
      <button id="save">Save</button>
    </div>
    <table id="nut-table">
      <thead>
        <tr>
          <th>Food</th>
          <th>Calories</th>
          <th>Category</th>
          <th></th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    <script>
      const foodTable = document.querySelector("#food-table tbody");
      const addFoodBtn = document.querySelector("#add-food");
      const foodNameInput = document.querySelector("#food-name");
      const caloriesInput = document.querySelector("#calories");
      const categoryInput = document.querySelector("#category");
      addFoodBtn.addEventListener("click", () => {
        const name = foodNameInput.value;
        const calories = caloriesInput.value;
        const category = categoryInput.value;
        const food = { name, calories, category };
        fetch("https://csatri1.tk/api/nut/create/" + name + "/" + calories + "/" + category, { method: "POST", credentials: 'include' })
          .then((res) => res.json())
          .then((data) => {
            addFoodToTable(data);
            foodNameInput.value = "";
            caloriesInput.value = ;
            categoryTypeInput.value = "";
          })
          .catch((err) => console.log(err));
      });
      function getMeals() {
        fetch("https://csatri1.tk/api/nut/", {credentials: 'include'})
          .then((res) => res.json())
          .then((data) => {
            foodTable.innerHTML = "";
            data.forEach(addFoodToTable);
          })
          .catch((err) => console.log(err));
      }
      function addMealToTable(meal) {
        const row = document.createElement("tr");
        const nameCell = document.createElement("td");
        const caloriesCell = document.createElement("td");
        const categoryCell = document.createElement("td");
        const deleteCell = document.createElement("td");
        const deleteButton = document.createElement("button");
        deleteButton.innerHTML = "Delete";
        deleteButton.addEventListener("click", () => {
          deleteFood(food);
        });
        nameCell.textContent = food.name;
        caloriesCell.textContent = food.calories;
        categoryCell.textContent = food.category;
        deleteCell.appendChild(deleteButton);
        row.appendChild(nameCell);
        row.appendChild(caloriesCell);
        row.appendChild(mealTypeCell);
        row.appendChild(categoryCell);
        foodTable.appendChild(row);
      }
      function deleteFood(food) {
        fetch(
          "https://csatri1.tk/api/nut/delete/" + food.id,
          { method: "DELETE", credentials: 'include' }
        )
          .then(() => {
            getMeals();
          })
          .catch((err) => console.log(err));
      }
      getMeals();
    </script>
  </body>
</html>
