---
layout: default
---
 
 ## Logout

<script>
    if (sessionStorage["login"]) {
        if (confirm("Are you sure you want to log out?")) {
            var requestOptions = {
                method: 'GET',
                credentials: 'include',
                redirect: 'follow'
            };

            fetch("https://csatri1.tk/logout", requestOptions);

            alert("You are now logged out of YUMI.  See you soon, "+sessionStorage.getItem("login")+"!");
            sessionStorage.removeItem ("login");
            location.href = "{{site.baseurl}}";
        }
        
        else {
            location.href = "{{site.baseurl}}";
            alert("You are still logged in.  Redirecting to homepage!");
        } 
    }

    location.href = "{{site.baseurl}}";
</script>