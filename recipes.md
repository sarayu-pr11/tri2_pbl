
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>







<html>
  <head>
    <title>My Recipes</title>
    <meta charset="UTF-8" />
  </head>
  <body>
    <h1 id="saved-recipes">My Recipes</h1>
    <div>
      <input placeholder ="Name" type="text" id="name" />
      <input placeholder ="Price" type="text" id="price" />
      <input placeholder ="Seller" type="text" id="seller" />
      <input placeholder ="Description" type="text" id="description" />
      <input placeholder ="Ingredients" type="text" id="ingredients" />

  <button id="add-food">Save</button>
    </div>
    <table id="food-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Price</th>
          <th>Seller</th>
          <th>Description</th>
          <th>Ingredients</th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    <div>
      <input placeholder ="Food ID" type="text" id="id" />
      <button id="delete-food">Delete</button>
    </div>
    <script> 
      const foodTable = document.querySelector("#food-table tbody");
      const addFoodBtn = document.querySelector("#add-food");
      const deleteFoodBtn = document.querySelector("#delete-food");      //
      const idInput = document.querySelector("#id");      //
      const nameInput = document.querySelector("#name");
      const priceInput = document.querySelector("#price");
      const sellerInput = document.querySelector("#seller");
      const descriptionInput = document.querySelector("#description");
      const ingredientsInput = document.querySelector("#ingredients");
      addFoodBtn.addEventListener("click", () => {
        const name = nameInput.value;
        const price = priceInput.value;
        const seller = sellerInput.value;
        const description = descriptionInput.value;
        const ingredients = ingredientsInput.value;
        const item = { id, name, price, seller, description, ingredients };
        fetch("https://csatri1.tk/api/recipes/create/" + name + "/" + price + "/" + seller + "/" + description + "/" + ingredients, { method: "POST", credentials: 'include' })
          .then((res) => res.json())
          .then((data) => {
            addFoodToTable(data);
            nameInput.value = "";
            priceInput.value = 0;
            sellerInput.value = "";
            descriptionInput.value = "";
            ingredientsInput.value = "";
          })
          .catch((err) => console.log(err));
          window.location.reload()
      });
      deleteFoodBtn.addEventListener("click", () => {
        const id = idInput.value;
        console.log(id);
        //const item = { id, food, calories, category };
        fetch(
          "https://csatri1.tk/api/recipes/delete/" + id,
          { method: "DELETE" , credentials: 'include'}
        )
          //.then((res) => res.json())
          .then(() => {
            getFood();
            //idInput.value = 0;
          })
          .catch((err) => console.log(err));
          console.log("here")
      });
      function getFood() {
        fetch("https://csatri1.tk/api/recipes/", {credentials: 'include'})
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
        const nameCell = document.createElement("td");
        const priceCell = document.createElement("td");
        const sellerCell = document.createElement("td");
        const descriptionCell = document.createElement("td");
        const ingredientsCell = document.createElement("td");
        //const deleteCell = document.createElement("td");
        //const deleteButton = document.createElement("button");
        //deleteButton.innerHTML = "Delete";
        //deleteButton.addEventListener("click", () => {
          //deleteFood(item);
        //});
        idCell.textContent = item.id;
        nameCell.textContent = item.name;
        priceCell.textContent = item.price;
        sellerCell.textContent = item.seller;
        descriptionCell.textContent = item.description;
        ingredientsCell.textContent = item.ingredients;  
        //deleteCell.appendChild(deleteButton);
        row.appendChild(idCell);
        row.appendChild(nameCell);
        row.appendChild(priceCell);
        row.appendChild(sellerCell);
        row.appendChild(descriptionCell);
        row.appendChild(ingredientsCell);
        //row.appendChild(deleteCell);
        foodTable.appendChild(row);
      }
      function deleteFood(id) {
        fetch(
          "https://csatri1.tk/api/recipes/delete/" + id,
          { method: "DELETE", credentials: 'include' }
        )
          .then(() => {
            getFood();
          })
          .catch((err) => console.log(err));
          //window.location.reload()
      }
      getFood();
    </script>
    <style>
      #saved-recipes {
        text-align:center;
      }
      #food-table, th, td {
        border: 1px solid;
      }
      </style>
  </body>
</html>