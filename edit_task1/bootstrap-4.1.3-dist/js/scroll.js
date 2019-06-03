document.addEventListener("DOMContentLoaded",function() {
    var home = document.querySelectorAll('div.navbarResponsive');
        home = home[0];
window.addEventListener("scroll",function(){
        var x = pageYOffset;
        var Status = false;
        Status = (x > 10% && !Status) ? true : false;
        if(Status) {
            home.classList.add('hometora');
        }else {
               home.classList.remove('hometora');
        }

    
    })
})
var tus;
window.onscroll = function() {scrollFunction()};
        function scrollFunction() {
            tus=(document.documentElement.scrollTop > 300) ? "block" : "none";
              document.getElementById("myBtn").style.display = tus; 
        }
        document.getElementById('myBtn').addEventListener("click", function(){  
            document.documentElement.scrollTop = 0;
        });


