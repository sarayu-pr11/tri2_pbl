<p id="login message">You are now logged out of YUMI.  See you soon!</p>

<script>
    fetch("https://csatri1.tk/api/logout");

    if ("username" in sessionStorage) {
        document.getElementById("login message").innerHTML = "You are now logged out of YUMI.  See you soon, "+sessionStorage.getItem("username")+"!";
    }

    sessionStorage.removeItem ("username");
</script>