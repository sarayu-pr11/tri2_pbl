## Nutrition 

HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=apple"))
		.header("X-RapidAPI-Key", "f877084053msh82cfa972b631ab7p1c4893jsn442e2f514bb0")
		.header("X-RapidAPI-Host", "edamam-food-and-grocery-database.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());

### <b>Ingredient</b>
<input id="ingredient" placeholder="Input Ingredient">
<input id="amount" placeholder="Input Amount">
<button onclick="fetch()">Submit</button>

### <g>Nutrition</b>
<p id="Result"></p>

<style>
b { color: blue }
g { color: grey }
</style>