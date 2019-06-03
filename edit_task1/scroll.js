var tus;
window.onscroll = function() {scrollFunction()};
        function scrollFunction() {
            tus=(document.documentElement.scrollTop > 300) ? "block" : "none";
              document.getElementById("myBtn").style.display = tus; 
       
        };
$(".menu").click(function() {
      $("html, body").animate({
        scrollTop: 0
      });
    });
 jQuery(document).ready(function($) {
 
 $(".navbar-nav").scrollspy({ offset: -100 });

});