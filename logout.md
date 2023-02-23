<p id="login message">You are now logged out of YUMI.  See you soon!</p>

<script>
    if (sessionStorage.getItem("username") != null) {
        document.getElementById("login message").innerHTML = "You are now logged out of YUMI.  See you soon, "+sessionStorage.getItem("username")+"!";
    }

    sessionStorage.setItem("username", null);
</script>