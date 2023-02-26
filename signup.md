<html>
  <head>
    <title>Signup</title>
  </head>

  <body>
    <form action="javascript:formSubmit()">
        <p><label>
            <span class="email">Email:</span>
            <input type="text" id="email" name="email" placeholder="email" required>
        </label></p>
        <p><label>
            <span class="password">Password:</span>
            <input type="password" id="password" name="password" placeholder="password" required>
        </label></p>
        <p><label>
            <span class="name">Name:</span>
            <input type="text" id="name" name="name" placeholder="name" required>
        </label></p>
        <p><label>
            <span class="dob">Date Of Birth(mm-dd-yyyy):</span>
            <input type="date" id="dob" name="dob" placeholder="MM-dd-yyyy">
        </label></p>
        <p>
            <button>Sign Up</button>
        </p>
    </form>
  </body>

  <script type="text/javascript">
    function formSubmit() {
      let email = document.getElementById("email").value;
      let password = document.getElementById("password").value;
      let name = document.getElementById("name").value;
      let dob = document.getElementById("dob").value;
      // console.log(email);

      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      var raw = "";

      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      };

      fetch("https://csatri1.tk/api/person/post?email="+email+"&password="+password+"&name="+name+"&dob="+dob, requestOptions)
        .then(response => {
            if (response.status == 500) {
                const errorMsg = 'Incorrect data.  Please fill in everything correctly!';
                alert(errorMsg);
                console.log(errorMsg);
                return;
            }
            else if (!response.ok) {
                const errorMsg = 'Error: ' + response.status;
                alert(errorMsg);
                console.log(errorMsg);
                return;
            }

            location.href = "{{site.baseurl}}/signedup";
        });
    }
  </script>
</html>