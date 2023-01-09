## Calendar
<p id="test"></p>

<script>

function getYear(){
    let inputYear = document.getElementById("inputYear").value;
    return inputYear;
}

function getYear2(){
    let inputYear2 = document.getElementById("inputYear2").value;
    return inputYear2;
}

function getYear3(){
    let inputYear2 = document.getElementById("inputYear2").value;
    return inputYear2;
}

function getYear4(){
    let inputYear2 = document.getElementById("inputYear2").value;
    return inputYear2;
}

function getYear5(){
    let inputYear2 = document.getElementById("inputYear2").value;
    return inputYear2;
}

function getMonth(){
    let inputMonth = document.getElementById("inputMonth").value;
    return inputMonth;
}

function getDay(){
    let inputDay = document.getElementById("inputDay").value;
    return inputDay;
}

function isLeapYear(year) {
    result = document.getElementById("isLeapYearResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/calendar/isLeapYear/' + year)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Is " + year + " a leap year: " + data.isLeapYear;

    })
}

function firstDayOfYear(year) {
    result = document.getElementById("firstDayOfYearResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/calendar/firstDayOfYear/' + year)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Week day of first day of " + year + ": " + data.firstDayOfYear;

    })
}

function numberOfLeapYears(year, year2) {
    result = document.getElementById("numberOfLeapYearsResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/calendar/numberOfLeapYears/' + year + '/'+ year2)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Number of leap years between  " + year + " and " + year2 + ": " + data.numberOfLeapYears;

    })
}

function dayOfYear(month, day, year) {
    result = document.getElementById("dayOfYearResult");

    // Fetch data from API
    fetch('https://sarayu.tk/api/calendar/dayOfYear/' + month + '/'+ day + '/' + year)
    .then(response => response.json())
    .then(data => {

        console.log(data);

        result.innerHTML = "Day of year of  " + month + "/" + day + "/" + "/" + year + ": " +data.dayOfYear;

    })
}


</script>

### Check if a year is a leap year (isLeapYear)
<input id="inputYear" placeholder="Input a Year">
<button onclick="isLeapYear(getYear())">Submit</button>
<p id="isLeapYearResult"></p>

### Check what day of week is the first day of the year (firstDayOfYear)
<input id="inputYear2" placeholder="Input a Year">
<button onclick="firstDayOfYear(getYear())">Submit</button>
<p id="firstDayOfYearResult"></p>

### Check number of leap years between 2 years (numberOfLeapYears)
<input id="inputYear3" placeholder="Input Year 1">
<input id="inputYear4" placeholder="Input Year 2">
<button onclick="numberOfLeapYears(getYear(), getYear2())">Submit</button>
<p id="numberOfLeapYearsResult"></p>

### Check what day of year a date is (dayOfYear)
<input id="inputMonth" placeholder="Input Month">
<input id="inputDay" placeholder="Input Day">
<input id="inputYear5" placeholder="Input Year">
<button onclick="dayOfYear(getMonth(), getDay(), getYear5())">Submit</button>
<p id="dayOfYearResult"></p>