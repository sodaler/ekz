import { useEffect, useState } from 'react'

interface WeatherData {
  time: string
  temperature: number
}

const useFetchData = (): WeatherData[] | undefined => {
  const [data, setData] = useState<WeatherData[] | undefined>()

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('https://api.open-meteo.com/v1/forecast?latitude=54.3282&longitude=48.3866&hourly=temperature_2m')
        const fetchedData = await response.json()

        const hourly = fetchedData.hourly
        const timeData: Date[] = hourly.time.map((t: string) => new Date(t))
        const temperatureData: number[] = hourly.temperature_2m

        const dateFormatter = new Intl.DateTimeFormat('ru-Ru', {
          weekday: 'long',
          year: 'numeric',
          month: 'long',
          day: 'numeric',
          hour: 'numeric',
          minute: 'numeric',
        })

        const weatherData: WeatherData[] = timeData.map((time: Date, index: number) => ({
          time: dateFormatter.format(time),
          temperature: temperatureData[index],
        }))

        setData(weatherData)
        console.log(weatherData)
      } catch (error) {
        console.error('Error:', error)
      }
    }
    fetchData()
  }, [])

  return data
}

export default useFetchData
