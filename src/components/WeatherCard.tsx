import React from 'react'
import styled from 'styled-components'

interface WeatherData {
  time: string
  temperature: number
}

interface WeatherCardProps {
  data: WeatherData
}

const CardContainer = styled.div`
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin-bottom: 10px;
  background-color: #f9f9f9;
`

const WeatherCard: React.FC<WeatherCardProps> = ({ data }) => {
  return (
    <CardContainer>
      <div>Дата и время: {data.time}</div>
      <div>Температура: {data.temperature}°C</div>
    </CardContainer>
  )
}

export default WeatherCard
