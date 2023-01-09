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

        result.innerHTML = "Check if " + yearparam + " is a leap year : " + data.isLeapYear;

    })
}

function firstDayOfYear(yearparam) {
    result = document.getElementById("firstDayOfYearResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/calendar/firstDayOfYear/' + yearparam)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Check what week day first day of " + yearparam + " is : " + data.firstDayOfYear;

    })
}


</script>

### Check if a year is a leap year
### (isLeapYear)
<input id="inputYear" placeholder="Input a Year">
<button onclick="isLeapYear(getYear())">Submit</button>
<p id="isLeapYearResult"></p>

### Check what day of week is the first day of the year
### (firstDayOfYear)
<input id="inputYear" placeholder="Input a Year">
<button onclick="firstDayOfYear(getYear())">Submit</button>
<p id="firstDayOfYearResult"></p>