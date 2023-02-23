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

          var settings = {
            "url": "https://csatri1.tk/authenticate",
            "method": "POST",
            "timeout": 0,
            "headers": {
              "Content-Type": "application/json"
            },
            "data": JSON.stringify({
              "email": email,
              "password": password
            }),
          };

          $.ajax(settings).done(function (response) {
            console.log(response);
          });
        }
  </script>
</html>