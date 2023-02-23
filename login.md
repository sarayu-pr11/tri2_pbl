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
          myHeaders.append("Cookie", "jwt=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b2J5QGdtYWlsLmNvbSIsImV4cCI6MTY3NzE0OTMyOCwiaWF0IjoxNjc3MTMxMzI4fQ.ureEas7OUWn3EIsOEod7-IVY9ETSFh47z0unOqCZYvzZZWNdYOAt3D7pJVUb1VbyY3v5C0L0YP_fMdyvAg1QIg");

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
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
        }
  </script>
</html>