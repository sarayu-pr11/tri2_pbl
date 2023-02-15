
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
    fetch('https://csatri1.tk/api/nutrition/findCalories/"'+foodName+'"')
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







<input id="search" placeholder="Search">
<button onclick="search()">Search</button>
<select id="filter">
	<option>Filter by...</option>
	<option>food</option>
	<option>category</option>
</select>

<input id="food" placeholder="Food">
<input id="calories" placeholder="Calories">
<input id="category" placeholder="Category">
<button onclick="post()">Post</button>


<!-- Create table to display question posts -->
<body>
<h1 class="text-center m-5 text-success">Saved Nutrition</h1>
     <br>
    <div class="table-responsive mx-5">
        <table class="table table-hover table-bordered border-secondary mb-5">
            <thead>
                <tr>
                    <th scope="col">Food</th>
                    <th scope="col">Calories</th>
                    <th scope="col">Category</th>
                </tr>
            </thead>
            <tbody class="table-group-divider" id="foods">
            </tbody>
        </table>
    </div>
 	<script>
        // prepare fetch urls
        // const club_url = "http://localhost:8192/api/club";
        const nut_url = "https://csatri1.tk/api/nut";
        const get_url = nut_url + "/";
        const nutContainer = document.getElementById("nut");
        // prepare fetch GET options
        const options = {
            method: 'GET', // *GET, POST, PUT, DELETE, etc.
            // mode: 'cors', // no-cors, *cors, same-origin
            cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
            // credentials: 'same-origin', // include, same-origin, omit
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
                    const tr = document.createElement("tr");
                    const food = document.createElement("td");
                    const calories = document.createElement("td");
                    const category = document.createElement("td");
                    food.innerHTML = row.food;
                    calories.innerHTML = row.calories;
                    category.innerHTML = row.category;
                    // add all columns to the row
                    tr.appendChild(food);
                    tr.appendChild(calories);
                    tr.appendChild(category);
                    // add row to table
                    nutContainer.appendChild(tr);
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
            nutContainer.appendChild(tr);
        }
    </script>
<body>







<html>
    <head>
        <style>
            .role {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1 class="text-center m-5 text-success">Saved Nutrition</h1>
        <br>
        <div class="table-responsive mx-5">
            <table class="table table-hover table-bordered border-secondary mb-5">
                <thead>
                    <tr>
                        <th scope="col">Food</th>
                        <th scope="col">Calories</th>
                        <th scope="col">Category</th>
                        <input id="food" placeholder="Enter Food">
                        <input id="calories" placeholder="Enter Calories">
                        <input id="category" placeholder="Enter Category">
                        <button onclick="createFood()">Submit</button>
                        <br>
                        <!-- Update and delete -->
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody class="table-group-divider" id="foods">
                </tbody>
            </table>
        </div>
        <script>
            // prepare fetch urls
            // const club_url = "http://localhost:8192/api/club";
            const nut_url = "https://csatri1.tk/api/nut";
            const get_url = nut_url + "/";
            const nutContainer = document.getElementById("foods");
            // prepare fetch GET options
            const options = {
                method: 'GET', // *GET, POST, PUT, DELETE, etc.
                // mode: 'cors', // no-cors, *cors, same-origin
                cache: 'default', // *default, no-cache, reload, force-cache, only-if-cached
                // credentials: 'same-origin', // include, same-origin, omit
                headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
                },
            };
            const post_options = {...options, method: 'POST'}; // clones and replaces method
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
                        const tr = document.createElement("tr");
                        const food = document.createElement("td");
                        const calories = document.createElement("td");
                        const category = document.createElement("td");
                        food.innerHTML = row.food;
                        calories.innerHTML = row.calories;
                        category.innerHTML = row.category;
                        // add all columns to the row
                        tr.appendChild(food);
                        tr.appendChild(calories);
                        tr.appendChild(category);
                        // add row to table
                        nutContainer.appendChild(tr);
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
                nutContainer.appendChild(tr);
            }
        </script>
    </body>
</html>

