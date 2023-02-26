
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
    <title>Meal Planner</title>
    <meta charset="UTF-8" />
  </head>
  <body>
    <h1 id="meal-planner">Meal Planner</h1>
    <div>
      <input placeholder ="Meal Name" type="text" id="meal-name" />
      <input placeholder ="Day" type="text" id="day" />
      <input placeholder ="Meal Type" type="text" id="meal-type" />
      <button id="add-meal">Add Meal</button>
    </div>
    <table id="meal-table">
      <thead>
        <tr>
          <th>Meal Name</th>
          <th>Day</th>
          <th>Meal Type</th>
          <th></th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    <script>
      const mealTable = document.querySelector("#meal-table tbody");
      const addMealBtn = document.querySelector("#add-meal");
      const mealNameInput = document.querySelector("#meal-name");
      const dayInput = document.querySelector("#day");
      const mealTypeInput = document.querySelector("#meal-type");
      addMealBtn.addEventListener("click", () => {
        const name = mealNameInput.value;
        const day = dayInput.value;
        const mealType = mealTypeInput.value;
        const meal = { name, day, mealType };
        fetch("https://csatri1.tk/api/planner/create/" + name + "/" + day + "/" + mealType, { method: "POST", credentials: 'include' })
          .then((res) => res.json())
          .then((data) => {
            addMealToTable(data);
            mealNameInput.value = "";
            dayInput.value = "";
            mealTypeInput.value = "";
          })
          .catch((err) => console.log(err));
      });
      function getMeals() {
        fetch("https://csatri1.tk/api/planner/", {credentials: 'include'})
          .then((res) => res.json())
          .then((data) => {
            mealTable.innerHTML = "";
            data.forEach(addMealToTable);
          })
          .catch((err) => console.log(err));
      }
      function addMealToTable(meal) {
        const row = document.createElement("tr");
        const nameCell = document.createElement("td");
        const dayCell = document.createElement("td");
        const mealTypeCell = document.createElement("td");
        const deleteCell = document.createElement("td");
        const deleteButton = document.createElement("button");
        deleteButton.innerHTML = "Delete";
        deleteButton.addEventListener("click", () => {
          deleteMeal(meal);
        });
        nameCell.textContent = meal.name;
        dayCell.textContent = meal.day;
        mealTypeCell.textContent = meal.meal;
        deleteCell.appendChild(deleteButton);
        row.appendChild(nameCell);
        row.appendChild(dayCell);
        row.appendChild(mealTypeCell);
        row.appendChild(deleteCell);
        mealTable.appendChild(row);
      }
      function deleteMeal(meal) {
        fetch(
          "https://csatri1.tk/api/planner/delete/" + meal.id,
          { method: "DELETE", credentials: 'include' }
        )
          .then(() => {
            getMeals();
          })
          .catch((err) => console.log(err));
      }
      getMeals();
    </script>
    <style>
      #meal-planner {
        text-align:center;
      }
      </style>
  </body>
</html>








