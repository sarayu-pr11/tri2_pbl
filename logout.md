<p id="login message">You are now logged out of YUMI.  See you soon!</p>

<br>

<p id="countdown"><a href="{{site.baseurl}}">Redirect to homepage</a></p>

<script>
    var requestOptions = {
            method: 'GET',
            credentials: 'include',
            redirect: 'follow'
    };

    fetch("https://csatri1.tk/logout", requestOptions);

    if ("username" in sessionStorage) {
        document.getElementById("login message").innerHTML = "You are now logged out of YUMI.  See you soon, "+sessionStorage.getItem("username")+"!";
    }

    sessionStorage.removeItem ("username");

    for (let i = 5; i >=1; i++) { 
        document.getElementById("countdown").innerHTML = "Redirecting to homepage in "+i;
        
        await delay(1000);
    }

    location.href = "{{site.baseurl}}";
</script>