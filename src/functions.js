function getRandomInt(number) {
    return Math.floor(Math.random() * number + 1)
}

function getCurrentWeather(city) {
    // var apiKey = $secrets.get("api_key", "token not found");
    var response = $http.get("https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=90c0df81026b8a90146290524c5ce6d2&units=${units}&lang=${lang}", {
        timeout: 15000,
        query: {
            city: city,
            // APPID: apiKey,
            units: "metric",
            lang: "ru"
        }
    });
    
    if (!response.isOk || !response.data) {
        return false;
    }
    
    var weather = {};
    weather.temp = response.data.main.temp;
    weather.description = response.data.weather[0].description;
    return weather;
}

getCurrentWeather('Tyumen')

