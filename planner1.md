<html>
  <head>
    <title>Meal Planner</title>
    <meta charset="UTF-8" />
  </head>
  <body>
    <h1 id="meal-planner">Meal Planner</h1>
    <div>
      <input placeholder ="Meal Name" type="text" id="meal-name" />
      <select id="day">
        <option value="Monday">Monday</option>
        <option value="Tuesday">Tuesday</option>
        <option value="Wednesday">Wednesday</option>
        <option value="Thursday">Thursday</option>
        <option value="Friday">Friday</option>
        <option value="Saturday">Saturday</option>
        <option value="Sunday">Sunday</option>
      </select>
      <select id="meal-type">
        <option value="Breakfast">Breakfast</option>
        <option value="Lunch">Lunch</option>
        <option value="Dinner">Dinner</option>
      </select>
      <button id="add-meal">Add Meal</button>
    </div>
    <table id="meal-table">
      <thead>
        <tr>
          <th>Day</th>
          <th>Breakfast</th>
          <th>Lunch</th>
          <th>Dinner</th>
        </tr>
      </thead>
      <tbody>
      </tbody>
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
        fetch("https://csatri1.tk/api/planner/create/" + name + "/" + day + "/" + mealType, { method: "POST" })
          .then((res) => res.json())
          .then((data) => {
            addMealToTable(data);
            mealNameInput.value = "";
            dayInput.value = "";
            mealTypeInput.value = "";
          })
          .catch((err) => console.log(err));
          setTimeout(() => {
        window.location.reload();
      }, 1000);
      });
      function getMeals() {
        fetch("https://csatri1.tk/api/planner/")
          .then((res) => res.json())
          .then((data) => {
            mealTable.innerHTML = "";
            const days = {};
            data.forEach(meal => {
              if (!days[meal.day]) {
                days[meal.day] = {};
              }
              days[meal.day][meal.meal] = meal.name;
            });
            Object.keys(days).forEach(day => {
              const row = document.createElement("tr");
              const dayCell = document.createElement("th");
              dayCell.textContent = day;
              row.appendChild(dayCell);
              ["Breakfast", "Lunch", "Dinner"].forEach(mealType => {
                const mealName = days[day][mealType];
                const mealCell = document.createElement("td");
                mealCell.textContent = mealName ? mealName : "";
                row.appendChild(mealCell);
              });
              mealTable.appendChild(row);
            });
          })
          .catch((err) => console.log(err));
      }
      function addMealToTable(meal) {
        const row = document.createElement("tr");
        const nameCell = document.createElement("td")
        nameCell.textContent = meal.name;
        const dayCell = document.createElement("td");
        dayCell.textContent = meal.day;
        const mealTypeCell = document.createElement("td");
        mealTypeCell.textContent = meal.mealType;
        const deleteCell = document.createElement("td");
        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete";
        deleteBtn.addEventListener("click", () => {
        deleteMeal(meal.id);
        mealTable.removeChild(row);
        });
        deleteCell.appendChild(deleteBtn);
        row.appendChild(nameCell);
        row.appendChild(dayCell);
        row.appendChild(mealTypeCell);
        row.appendChild(deleteCell);
        mealTable.appendChild(row);
      }
        function deleteMeal(id) {
    fetch("https://csatri1.tk/api/planner/delete/" + id, { method: "DELETE" })
      .catch((err) => console.log(err));
  }
  getMeals();
</script>
