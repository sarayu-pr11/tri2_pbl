
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>



<html>
  <head>
    <title>My Recipes</title>
    <meta charset="UTF-8" />
  </head>
  <body>
    <h1 id="saved-nutrition">My Recipes</h1>
    <div>
      <input placeholder ="Name" type="text" id="name" />
      <input placeholder ="Price" type="text" id="price" />
      <input placeholder ="Seller" type="text" id="seller" />
      <input placeholder ="Description" type="text" id="description" />
      <input placeholder ="Ingredients" type="text" id="ingredients" />

  <button id="add-food">Add Recipe!</button>
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
        fetch("https://csatri1.tk/api/recipes/create/" + name + "/" + price + "/" + seller + "/" + description + "/" + ingredients,  { method: "POST", credentials: 'include' })
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
      #saved-nutrition {
        text-align:center;
      }
      </style>
  </body>
</html>

  </body>
<style>
.dropdown{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
}
.form-group
      {
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      .form-control
      {
        transition: width .2s, height, .2s;
        border-radius: 20px;
        border-color: #383F51;
      }
      .form-control:hover, .form-select
      {
        box-shadow: 5px 5px 5px #75768077;
      }
      input
      {
        transition: width .2s, height, .2s;
        border-radius: 20px;
        border-color: #383F51;
      }
      input:hover
      {
        box-shadow: 5px 5px 5px #75768077;
      }
      /* .container
      {
        background-color: white;
        padding: 16px;
        width: 50%;
        margin: auto;
        border-radius: 20px;;
      } */
      .btn
      {
        font-size: 18px;
        border-radius: 20px;
        background-color: #383F51;
        transition: width .2s, height, .2s;
      }
      .btn:hover
      {
        background-color: #3C4F76;
        box-shadow: 5px 5px 5px #75768077;
      }
  </style>
</html>


<script>
  function handleClick() {
    if (window.confirm("Click OK to add your recipe!")) {
      location.href = "https://sarayu-pr11.github.io/tri2_pbl/recipes";
    }
    var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");
	
	const item = document.getElementById("object").value;
    const price = document.getElementById("price").value;
    const seller = document.getElementById("seller").value;
    const description = document.getElementById("description").value;
    const ingredients = document.getElementById("ingredients").value;

	var raw = JSON.stringify({
	  "name": item,
	  "price": price,
	  "seller": seller,
	  "description": description,
      "ingredients": ingredients,
	});

	var requestOptions = {
	  method: 'POST',
	  headers: myHeaders,
    credentials: 'include',
	  body: raw,
	  redirect: 'follow'
	};

	fetch("http://csatri1.tk/api/recipes/create", requestOptions)
	  .then(response => response.text())
	  .then(result => console.log(result))
	  .catch(error => console.log('error', error));
	  }
</script>


<body>
  <table id="recipeTable">
    <thead>
      <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Seller</th>
        <th>Description</th>
        <th>Ingredients</th>
      </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
<style>
    #recipeTable {
  border-collapse: collapse;
}
th, td {
  border: 1px solid black;
  padding: 8px;
}
  </style>

  <script>
    const tableBody = document.querySelector('#recipeTable tbody');

        fetch('https://csatri1.tk/api/recipes/')
        .then(response => response.json())
        .then(data => {
         data.forEach(item => {
      const row = tableBody.insertRow();
      const nameCell = row.insertCell(0);
      const priceCell = row.insertCell(1);
      const sellerCell = row.insertCell(2);
      const descriptionCell = row.insertCell(3);
      const ingredientsCell = row.insertCell(4);

      nameCell.innerText = item.name;
      priceCell.innerText = item.price;
      sellerCell.innerText = item.seller;
      descriptionCell.innerText = item.description;
      ingredientsCell.innerText = item.ingredients;
    });
  })
  .catch(error => console.error(error));

  </script>
</body>
</html>


