document.addEventListener('DOMContentLoaded', function() {
    const weatherContainer = document.getElementById('weather-container');
    const apiUrl = 'https://vm.nathoro.ru/weather?lattitude=54.3&longitude=48.4';

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            console.log('Полученные данные:', data);
            if (!data || !Array.isArray(data)) {
                throw new Error('Неверный формат данных');
            }

            data.forEach(forecast => {
                // Проверка наличия необходимых данных
                if (!forecast.date || typeof forecast.temperature === 'undefined') {
                    console.error('Некорректные данные прогноза:', forecast);
                    return;
                }

                // Преобразуем дату в удобочитаемый формат
                const date = new Date(forecast.date);
                const dateString = date.toLocaleDateString('ru-RU', { day: '2-digit', month: '2-digit', year: 'numeric' });

                // Форматируем температуру
                const temperature = `${forecast.temperature.toFixed(1)}°C`;

                // Форматируем направление и скорость ветра
                const wind = `Ветер: ${forecast.windDirection}, ${forecast.windSpeed.toFixed(1)} м/с`;

                // Форматируем влажность
                const humidity = `Влажность: ${forecast.humidity.toFixed(1)}%`;

                // Создаем карточку прогноза
                const card = document.createElement('div');
                card.className = 'weather-card';

                const dateElement = document.createElement('h3');
                dateElement.textContent = dateString;

                const tempElement = document.createElement('p');
                tempElement.textContent = `Температура: ${temperature}`;

                const windElement = document.createElement('p');
                windElement.textContent = wind;

                const humidityElement = document.createElement('p');
                humidityElement.textContent = humidity;

                card.appendChild(dateElement);
                card.appendChild(tempElement);
                card.appendChild(windElement);
                card.appendChild(humidityElement);

                weatherContainer.appendChild(card);
            });
        })
        .catch(error => console.error('Ошибка при получении данных:', error));
});
