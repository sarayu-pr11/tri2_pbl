<html>
  <head>
    <title>Meal Planner</title>
  </head>
  <body>
    <button id="deleteBtn">Delete Meal</button>
    <table id="meal-table">
      <thead>
          <th></th>
          <th>Breakfast</th>
          <th>Snack</th>
          <th>Lunch</th>
          <th>Snack</th>
          <th>Dinner</th>
      </thead>
        <tr>
          <td>Monday</td>
          <td class="meal-cell" data-day="Monday" data-meal="Breakfast"></td>
          <td class="meal-cell" data-day="Monday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Monday" data-meal="Lunch"></td>
          <td class="meal-cell" data-day="Monday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Monday" data-meal="Dinner"></td>
        </tr>
        <tr>
          <td>Tuesday</td>
          <td class="meal-cell" data-day="Tuesday" data-meal="Breakfast"></td>
          <td class="meal-cell" data-day="Tuesday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Tuesday" data-meal="Lunch"></td>
          <td class="meal-cell" data-day="Tuesday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Tuesday" data-meal="Dinner"></td>
        </tr>
        <tr>
        <td>Wednesday</td>
        <td class="meal-cell" data-day="Wednesday" data-meal="Breakfast"></td>
        <td class="meal-cell" data-day="Wednesday" data-meal="Snack"></td>
        <td class="meal-cell" data-day="Wednesday" data-meal="Lunch"></td>
        <td class="meal-cell" data-day="Wednesday" data-meal="Snack"></td>
        <td class="meal-cell" data-day="Wednesday" data-meal="Dinner"></td>
        </tr>
        <tr>
          <td>Thursday</td>
          <td class="meal-cell" data-day="Thursday" data-meal="Breakfast"></td>
          <td class="meal-cell" data-day="Thursday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Thursday" data-meal="Lunch"></td>
          <td class="meal-cell" data-day="Thursday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Thursday" data-meal="Dinner"></td>
        </tr>
        <tr>
        <td>Friday</td>
        <td class="meal-cell" data-day="Friday" data-meal="Breakfast"></td>
        <td class="meal-cell" data-day="Friday" data-meal="Snack"></td>
        <td class="meal-cell" data-day="Friday" data-meal="Lunch"></td>
        <td class="meal-cell" data-day="Friday" data-meal="Snack"></td>
        <td class="meal-cell" data-day="Friday" data-meal="Dinner"></td>
        </tr>
        <tr>
          <td>Saturday</td>
          <td class="meal-cell" data-day="Saturday" data-meal="Breakfast"></td>
          <td class="meal-cell" data-day="Saturday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Saturday" data-meal="Lunch"></td>
          <td class="meal-cell" data-day="Saturday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Saturday" data-meal="Dinner"></td>
        </tr>
        <tr>
          <td>Sunday</td>
          <td class="meal-cell" data-day="Sunday" data-meal="Breakfast"></td>
          <td class="meal-cell" data-day="Sunday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Sunday" data-meal="Lunch"></td>
          <td class="meal-cell" data-day="Sunday" data-meal="Snack"></td>
          <td class="meal-cell" data-day="Sunday" data-meal="Dinner"></td>
        </tr>
        <!-- Add rows for the rest of the week -->
    </table>
    <script>
      const mealTable = document.querySelector("#meal-table");
      mealTable.addEventListener("click", async (event) => {
        if (!event.target.classList.contains("meal-cell")) {
          return;
        }
        const day = event.target.dataset.day;
        const meal = event.target.dataset.meal;
        const name = prompt("Enter meal name:");
        const description = prompt("Enter meal description:");
        if (!name || !description) {
          return;
        }
        const response = await fetch("https://csatri1.tk/meals", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ name, description, day, meal }),
        });
        if (!response.ok) {
          alert("Failed to add meal. Please try again later.");
          return;
        }
        event.target.textContent = name;
      });
        const deleteBtn = document.getElementById("deleteBtn");
        deleteBtn.addEventListener("click", function() {
        const dayType = prompt("Enter the day of the meal to delete:");
        const mealType = prompt("Enter the meal to delete:");
        if (!dayType || !mealType) {
          return;
        }
        const endpoint = `https://csatri1.tk/meals/${dayType}/${mealType}`;
        fetch(endpoint, {
          method: "DELETE"
        })
          .then(response => {
            if (!response.ok) {
              throw new Error("Failed to delete meal");
            }
            return response.json();
          })
          .then(data => {
            console.log(data);
            alert("Meal deleted successfully");
          })
          .catch(error => {
            console.error(error);
            alert("Failed to delete meal");
          });
      });    
    </script>
  </body>

  <style>
    table {
  border-collapse: collapse;
}
th, td {
  border: 1px solid black;
  padding: 8px;
}

  </style>
</html>
