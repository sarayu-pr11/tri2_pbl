<html>
<head>
  <title>Your Recipes</title>
</head>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  <body>
    <div class="container">
      <h1 class="text-center">Add a Recipe</h1>
      <form onsubmit="return false;">
        <div class="form-group">
          <input type="text" class="form-control" id="object" name="object" placeholder="Object">
        </div>
        <div class="form-group">
          <input type="text" class="form-control" id="price" name="price" placeholder="Price (no decimals)">
        </div>
        <div class="form-group">
          <input type="text" class="form-control" id="seller" name="seller" placeholder="Seller">
        </div>
        <div class="form-group">
          <input type="text" class="form-control" id="description" name="description" placeholder="Description">
        </div>
        <div class="form-group">
          <input type="text" class="form-control" id="ingredients" name="category" placeholder="Ingredients">
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary btn-sm" onclick="handleClick()">Add Recipe</button>
        </div>
      </form>
    </div>

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
      window.location.href = "https://sarayu-pr11.github.io/tri2_pbl/recipes";
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
    <!-- <thead>
        <tr>
          <th>gelato</th>
          <th>10</th>
          <th>target</th>
          <th>dessert</th>
          <th></th>
        </tr>
      </thead> -->
      <thead>
        <tr>
          <th>cake</th>
          <th>7</th>
          <th>target</th>
          <th>sweet</th>
          <th>eggs</th>
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

        fetch('http://localhost:8230/api/recipes/')
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


