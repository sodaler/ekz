document.addEventListener('DOMContentLoaded', function () {
    var weatherContainer = document.getElementById('weather-container');
    var apiUrl = 'https://vm.nathoro.ru/weather?lattitude=54.3&longitude=48.4';
    fetch(apiUrl)
        .then(function (response) { return response.json(); })
        .then(function (data) {
        console.log('Полученные данные:', data);
        if (!data || !Array.isArray(data)) {
            throw new Error('Неверный формат данных');
        }
        data.forEach(function (forecast) {
            // Проверка наличия необходимых данных
            if (!forecast.date || typeof forecast.temperature === 'undefined') {
                console.error('Некорректные данные прогноза:', forecast);
                return;
            }
            // Преобразуем дату в удобочитаемый формат
            var date = new Date(forecast.date);
            var dateString = date.toLocaleDateString('ru-RU', { day: '2-digit', month: '2-digit', year: 'numeric' });
            // Форматируем температуру
            var temperature = "".concat(forecast.temperature.toFixed(1), "\u00B0C");
            // Форматируем направление и скорость ветра
            var wind = "\u0412\u0435\u0442\u0435\u0440: ".concat(forecast.windDirection, ", ").concat(forecast.windSpeed.toFixed(1), " \u043C/\u0441");
            // Форматируем влажность
            var humidity = "\u0412\u043B\u0430\u0436\u043D\u043E\u0441\u0442\u044C: ".concat(forecast.humidity.toFixed(1), "%");
            // Создаем карточку прогноза
            var card = document.createElement('div');
            card.className = 'weather-card';
            var dateElement = document.createElement('h3');
            dateElement.textContent = dateString;
            var tempElement = document.createElement('p');
            tempElement.textContent = "\u0422\u0435\u043C\u043F\u0435\u0440\u0430\u0442\u0443\u0440\u0430: ".concat(temperature);
            var windElement = document.createElement('p');
            windElement.textContent = wind;
            var humidityElement = document.createElement('p');
            humidityElement.textContent = humidity;
            card.appendChild(dateElement);
            card.appendChild(tempElement);
            card.appendChild(windElement);
            card.appendChild(humidityElement);
            weatherContainer.appendChild(card);
        });
    })
        .catch(function (error) { return console.error('Ошибка при получении данных:', error); });
});
