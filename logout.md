<p id="login message">You are now logged out of YUMI.  See you soon!</p>

<script>
    if ("username" in sessionStorage) {
        document.getElementById("login message").innerHTML = "You are now logged out of YUMI.  See you soon, "+sessionStorage.getItem("username")+"!";
    }

    sessionStorage.removeItem ("username");
</script>