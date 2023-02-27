---
layout: default
---

## Login

 <div>
    <input type="text" id="email" name="email" placeholder="Email" required>
    <input type="password" id="password" name="password" placeholder="Password" required>
    <button type="submit" onclick="loginForm()">Submit</button>
</div>

<p>New to YUMI?  <a href="{{site.baseurl}}/signup">Sign up here!</a></p>

<script>
    if (sessionStorage["login"]){
      location.href = "{{site.baseurl}}";
    }

    function loginForm() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        console.log(email);
        data = {email: email, password: password}
        console.log(data);

        fetch(`http://csatri1.tk/authenticate`, {
          method: "POST",
          cache: 'default',
          credentials: 'include',
          headers: {'Content-Type': "application/json"},
          body: JSON.stringify(data)})
          .then((data) => {
            console.log(data);
            if (data.status == 401) {
              alert("Invalid credentials");
            } else {
              alert("You are logged in!");
              sessionStorage.setItem("login", email);
              window.location.href = "{{site.baseurl}}";
            }
          });
      }
</script>