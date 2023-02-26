<p id="login message">You are now signed in to YUMI.  Welcome back!</p>

<script>
    if (sessionStorage.getItem("username") != null) {
        document.getElementById("login message").innerHTML = "You are now signed in to YUMI.  Welcome back, "+sessionStorage.getItem("username")+"!";
    }

    var requestOptions = {
            method: 'GET',
            credentials: 'include',
            redirect: 'follow'
    };

    fetch("https://csatri1.tk/api/person/", requestOptions);
</script>