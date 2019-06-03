 $(document).ready(function() {
            showWeather();
            $(".btn-change").on("click", function() {
                changeTemp();
            });
        });
     
        function showWeather() {
           var address = $('#place').val();

                    $.getJSON("https://api.openweathermap.org/data/2.5/weather?q="+address+"&APPID=236968e78972ab2769a056ec61741baf&callback=?", function(a) {
                        var city = "";
                        var wind = "";
                        var description = "";
                        var temperature = "";
                        var iconUrl = "";
                        var humidity="";           
                        city += a.name + " <br> " + a.sys.country;
                        wind += "Speed: " + a.wind.speed + "km/h <br> Degree: " + a.wind.deg;
                        description += a.weather[0].main + "<br> " + a.weather[0].description;
                        temperature += Math.round(a.main.temp - 273.15) + "°C";
                        humidity+="<br> Humidity: "+Math.round(a.main.humidity)+"%";
                        iconUrl += "http://openweathermap.org/img/w/" + a.weather[0].icon + ".png";
                        changeBackground(a);
                        $("#nameCity").html(city);
                        $("#windInfo").html(wind);
                        $("#weatherDescription").html(description);
                        $("#temperature").html(temperature);
                        $("#humiditytoday").html(humidity);
                        $("#weatherIcon").attr("src", iconUrl);
                        
                    });
                
            }
                
            
        function changeTemp() {
            var temp = $("#temperature").text();
            var unit = temp.slice(temp.length - 2, temp.length);
            var digit = parseInt(temp.slice(0, temp.length - 2));
            if (unit == "°C") {
                temp = (Math.round(digit*1.8 + 32)) + "°F";
            } else if (unit == "°F") {
                temp = (Math.round((digit - 32)/1.8)) + "°C";
            } else {
                console.error("Error");
            }
            $("#temperature").html(temp);
        }
        function changeBackground(a) {
            if (a.weather[0].main == "Clouds") {
                $("body").css("background-image", 'url("img/may.gif")');
            } else if (a.weather[0].main == "Rain") {
                $("body").css("background-image", 'url("img/rain.gif")');
            } else if (a.weather[0].main == "Snow") {
                $("body").css("background-image", 'url("img/snow1.jpg")');
            }else if (a.weather[0].main == "Thunderstorm") {
                $("body").css("background-image", 'url("img/set.jpg")');
            }  
            else if (a.weather[0].main == "Sunny") {
                $("body").css("background-image", 'url("img/sunny1.jpg")');
            }  


            else {
                $("body").css("background-image", 'url("img/sunny1.jpg")');
            }
        }