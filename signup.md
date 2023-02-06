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

        console.log(gender);
        console.log(dob);
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
data = {email: email, password: password, name: name, dob: dob}
var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  redirect: 'manual',
  body: JSON.stringify(data)
};
         fetch(
          `https://csatri1.tk/api/person/post`,requestOptions
        )
          .then(response => response.text())
  .then(result => {
    console.log(result);
    if (result == `${email} user created successfully`) {
      window.location.href = "https://csatri1.tk/login";
    } else {
      alert("Invalid credentials");
    }
  })
  .catch(error => console.log('error', error));

    }
</script>