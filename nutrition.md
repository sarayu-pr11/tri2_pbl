## Nutrition 

HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=apple"))
		.header("X-RapidAPI-Key", "f877084053msh82cfa972b631ab7p1c4893jsn442e2f514bb0")
		.header("X-RapidAPI-Host", "edamam-food-and-grocery-database.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());


<div style="background-color:rgba(63, 101, 209, 0.98); text-align:center; vertical-align: middle; padding:40px 0; margin-top:30px">
    ### <b>Ingredient</b>
    <input id="ingredient" placeholder="Input Ingredient">
    <input id="amount" placeholder="Input Amount">
    <button onclick="fetch()">Submit</button>
</div>


### <g>Nutrition</g>
<p id="Result"></p>

<style>
b { color: blue }
g { color: grey }

// resets
s { text-decoration:none; } //strike-through
em { font-style: normal; font-weight: bold; } //italic emphasis
</style>



