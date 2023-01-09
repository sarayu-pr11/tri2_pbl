## Check Leap Year
<p id="test"></p>

<script>

function getYear(){
    let inputYear = document.getElementById("inputYear").value;
    return inputYear;
}

function isLeapYear(yearparam) {
    
    result = document.getElementById("isLeapYearResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/calendar/isLeapYear/' + yearparam)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Check if " + yearparam + " is a leap year - " + data.isLeapYear;

    })
}

</script>

### Input a year to check if it is a leap year
<input id="inputYear" placeholder="Input a Year">
<button onclick="isLeapYear(getYear())">Submit</button>
<p id="isLeapYearResult"></p>