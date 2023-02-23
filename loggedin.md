<p id="login message">You are now signed in to YUMI.  Welcome back!</p>

<script>
    if (sessionStorage.getItem("username") != null) {
        document.getElementById("login message").innerHTML = "You are now signed in to YUMI.  Welcome back, "+sessionStorage.getItem("username")+"!";
    }

    fetch("https://csatri1.tk/api/person/");
</script>