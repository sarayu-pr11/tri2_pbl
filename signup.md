---
layout: default
---

## Signup

 <div>
    <input type="text" id="email" name="email" placeholder="Email">
    <input type="password" id="password" name="password" required placeholder="Password">
    <input type="text" id="name" name="name" placeholder="Name">
    <input type="date" id="dob" name="dob" placeholder="MM-dd-yyyy">

    <button type="submit" onclick="formSubmit()">Submit</button>
</div>

<script type="text/javascript">
    if (sessionStorage["login"]){
      location.href = "{{site.baseurl}}";
    }

    function formSubmit() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let name = document.getElementById("name").value;
        let dob = document.getElementById("dob").value;

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        data = {email: email, password: password, name: name, dob: dob}
        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            credentials: 'include',
            redirect: 'follow',
            body: JSON.stringify(data)
        };
        fetch("https://csatri1.tk/api/person/post?email="+email+"&password="+password+"&name="+name+"&dob="+dob, requestOptions)
          .then(response => response.text())
          .then(result => {
              console.log(result);
              if (result == `${email} is created successfully.`) {
                  alert("You are now signed up on YUMI!  Redirecting to login page.");
                  window.location.href = "{{site.baseurl}}/login";
              } else {
                  alert("Invalid data.  The email may already have an associated account.  Check formatting and try again!");
              }
          })
          .catch(error => console.log('error', error));
    }
</script>