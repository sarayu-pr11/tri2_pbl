---
title: Recipe Catalogue
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
      <h1 class="text-center">Recipe Catalogue</h1>
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
          <button type="submit" class="btn btn-primary btn-sm">Add Listing</button>
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
      window.location.href = "https://sarayu-pr11.github.io/tri2_pbl/recipes";
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