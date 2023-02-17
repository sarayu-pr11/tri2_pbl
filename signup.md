## Signup

 <div>
    <input type="text" id="email" name="email" placeholder="Email">
    <input type="password" id="password" name="password" required placeholder="Password">
    <input type="text" id="name" name="name" placeholder="Name">
    <input type="date" id="dob" name="dob" placeholder="MM-dd-yyyy">

    <button type="submit" onclick="formSubmit()">Submit</button>
</div>

<script type="text/javascript">
    function formSubmit() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let name = document.getElementById("name").value;
        let dob = document.getElementById("dob").value;
        // console.log(email);

var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  redirect: 'follow'
};

fetch("https://csatri1.tk/api/person/post?email="+email+"&password="+password+"&name="+name+"&dob="+dob, requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
    }
</script>