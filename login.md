<html>
  <head>
    <title>Login</title>
  </head>

  <body>
    <div>
        <input type="text" id="email" name="email" placeholder="Email" required>
        <input type="password" id="password" name="password" placeholder="Password" required>
        <button type="submit" onclick="loginForm()">Submit</button>
    </div>
    <p>New to YUMI?  <a href="{{site.baseurl}}/signup">Sign up here!</a></p>
  </body>

  <script>
      function loginForm() {
          let email = document.getElementById("email").value;
          let password = document.getElementById("password").value;

          var myHeaders = new Headers();
          myHeaders.append("Content-Type", "application/json");

          var raw = JSON.stringify({
            "email": email,
            "password": password
          });

          var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
          };

          fetch("https://csatri1.tk/authenticate", requestOptions)
              .then(response => {
              if (!response.ok) {
                  const errorMsg = 'Login error: ' + response.status;
                  console.log(errorMsg);
                  return;
              }
              window.location.href = "{{site.baseurl}}/loggedin";
        }
  </script>
</html>