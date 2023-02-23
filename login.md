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
          var data = JSON.stringify({
            "email": email,
            "password": password
          });

          var xhr = new XMLHttpRequest();
          xhr.withCredentials = true;

          xhr.addEventListener("readystatechange", function() {
            if(this.readyState === 4) {
              console.log(this.responseText);
            }
          });

          xhr.open("POST", "https://csatri1.tk/authenticate");
          xhr.setRequestHeader("Content-Type", "application/json");

          xhr.send(data);
        }
  </script>
</html>