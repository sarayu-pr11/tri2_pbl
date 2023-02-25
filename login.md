<html>
  <head>
    <title>Login</title>
  </head>

  <body>

    <form action="javascript:loginForm()">
        <p><label>
            <span class="email">Email:</span>
            <input type="text" id="email" name="email" placeholder="email" required>
        </label></p>
        <p><label>
            <span class="password">Password:</span>
            <input type="password" id="password" name="password" placeholder="password" required>
        </label></p>
        <p>
            <button>Log in</button>
        </p>
    </form>

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
            credentials: 'include',
            redirect: 'follow'
          };

          fetch("https://csatri1.tk/authenticate", requestOptions)
            .then(response => {
                if (response.status == 401) {
                    const errorMsg = 'Incorrect credentials';
                    alert(errorMsg);
                    console.log(errorMsg);
                    return;
                }
                else if (!response.ok) {
                    const errorMsg = 'Login error: ' + response.status;
                    console.log(errorMsg);
                    return;
                }

                sessionStorage.setItem("username", email);
                window.location.href = "{{site.baseurl}}/loggedin";
            });
        }
  </script>
</html>