import {useEffect, useState} from "react";

const useFetchData = () => {
    const [data, setData] = useState();

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('https://api.open-meteo.com/v1/forecast?latitude=54.3282&longitude=48.3866&hourly=temperature_2m')
                const fetchedData = await response.json()

                const hourly = fetchedData.hourly;
                const timeData = hourly.time.map(t => new Date(t));
                const temperatureData = hourly.temperature_2m;

                const dateFormatter = new Intl.DateTimeFormat('ru-Ru', {
                    weekday: 'long',
                    year: 'numeric',
                    month: 'long',
                    day: 'numeric',
                    hour: 'numeric',
                    minute: 'numeric'
                });

                const weatherData = timeData.map((time, index) => ({
                    time: dateFormatter.format(time),
                    temperature: temperatureData[index]
                }));

                setData(weatherData)
                console.log(weatherData)
            } catch (error) {
                console.error("Error:", error)
            }
        }
        fetchData();
    }, [])
    return data;
}

export default useFetchData;