<html>
<head>
  <title>Your Recipes</title>
</head>
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