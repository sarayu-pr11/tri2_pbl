## Login

 <div>
    <input type="text" id="email" name="email" placeholder="Email" required>
    <input type="password" id="password" name="password" placeholder="Password" required>
    <button type="submit" onclick="loginForm()">Submit</button>
</div>

<script>
    function loginForm() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        console.log(email);
        data = {email: email, password: password}
        console.log(data);

        fetch(
          `http://csatri1.tk/authenticate`, {method: "POST", mode:'no-cors', cache: 'default', credentials: 'same-origin', headers: {'Content-Type': "application/json"}, body: JSON.stringify(data)})
          .then((data) => {
            console.log(data);
            if (data.status == 401) {
              alert("Invalid credentials");
            } else {
              alert("You are logged in!");
              window.location.href = "{{site.baseurl}}/";
            }
          });
      }
</script>