---
title: Add Recipes
layout: default
permalink: /recipes/ 

---

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
  </head>
  <body>
    <div class="container">
      <h1 class="text-center">Add a Recipe!</h1>
      <form onsubmit="handleClick(); return false;">
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
          <input type="text" class="form-control" id="ingredients" name="ingredients" placeholder="Ingredients">
        </div>
        <div class="form-group">
          <input type="file" id="image" name="image">
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary btn-sm">Add Recipe</button>
        </div>
      </form>
    </div>
  </body>
  <style>

<style>
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
      .container
      {
        background-color: white;
      }
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
    if (window.confirm("Add your recipe to your catalogue!")) {
      window.location.href = "https://sarayu-pr11.github.io/tri2_pbl/recipecatalogue";
    }
    console.log("test");
    var requestOptions = {
      method: "POST",
      redirect: "follow",
    };

    const item = document.getElementById("object").value;
    const price = document.getElementById("price").value;
    const seller = document.getElementById("seller").value;
    const description = document.getElementById("description").value;
    const ingredients = document.getElementById("ingredients").value;
    const imageURL = document.getElementById("image").value;

    fetch(
      `https://csatri1.tk/api/recipes/create/${item}/${price}/${seller}/${description}/${ingredients}`,
      requestOptions
    );
  }
</script>

<!-- Create table to display question posts
<body>
<h1 class="text-center m-5 text-success">Saved Nutrition</h1>
     <br>
    <div class="table-responsive mx-5">
        <table class="table table-hover table-bordered border-secondary mb-5">
            <thead>
                <tr>
                    <th scope="col">Recipe Name</th>
                    <th scope="col">Price </th>
                    <th scope="col">Seller</th>
                    <th scope="col">Description</th>
                    <th scope="col">Ingredients</th>
                    <th scope="col">Image</th>
                </tr>
            </thead>
            <tbody class="table-group-divider" id="recipes">
            </tbody>
        </table>
    </div>
 	<script>
        // prepare fetch urls
        // const club_url = "http://localhost:8192/api/club";
        const discussions_url = "https://csatri1.tk/api/recipes";
        const get_url = recipestorage_url + "/";
        const recipestorageContainer = document.getElementById("recipestorage");
        // prepare fetch GET options
        const options = {
            method: 'GET', // *GET, POST, PUT, DELETE, etc.
            // mode: 'cors', // no-cors, *cors, same-origin
            cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
            // credentials: 'same-origin', // , same-origin, omit
            headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
            },
        };
        // fetch the API
        fetch(get_url, options)
            // response is a RESTful "promise" on any successful fetch
            .then(response => {
            // check for response errors
            if (response.status !== 200) {
                error('GET API response failure: ' + response.status);
                return;
            }
            // valid response will have JSON data
            response.json().then(data => {
                for (const row of data) {
                    console.log(row);
                    // columns
                    const item = document.getElementById("object").value;
                    const price = document.getElementById("price").value;
                    const seller = document.getElementById("seller").value;
                    const description = document.getElementById("description").value;
                    const ingredients = document.getElementById("ingredients").value;
                    const imageURL = document.getElementById("image").value;
                    recipes.innerHTML = row.recipes;
                    item.innerHTML = item.calories;
                    price.innerHTML = price.calories;
                    seller.innerHTML = seller.calories;
                    description.innerHTML = description.calories;
                    ingredients.innerHTML = ingredients.calories;
                    imageURL.innerHTML = imageURL.category;
                    // add all columns to the row
                    tr.appendChild(item);
                    tr.appendChild(price);
                    tr.appendChild(seller);
                    tr.appendChild(description);
                    tr.appendChild(ingredients);
                    tr.appendChild(imageURL);
                    // add row to table
                    discussionsContainer.appendChild(tr);
                }    
            })
        })
        // catch fetch errors (ie Nginx ACCESS to server blocked)
        .catch(err => {
            error(err + " " + get_url);
        });
        // Something went wrong with actions or responses
        function error(err) {
            // log as Error in console
            console.error(err);
            // append error to resultContainer
            const tr = document.createElement("tr");
            const td = document.createElement("td");
            td.innerHTML = err;
            tr.appendChild(td);
            discussionsContainer.appendChild(tr);
        }
    </script>
<body> -->