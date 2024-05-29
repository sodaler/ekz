import React, { useState } from 'react'
import styled from 'styled-components'
import WeatherCard from '../components/WeatherCard'
import useFetchData from '../actions/useFetchData'
import Head from '../components/Head'

interface WeatherData {
  time: string
  temperature: number
}

const CardList = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
`

const Pagination = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;

  button {
    margin: 0 5px;
    padding: 5px 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  button:disabled {
    background-color: #ccc;
    cursor: not-allowed;
  }
`

const Weather: React.FC = () => {
  const dataset: WeatherData[] | undefined = useFetchData()
  const [currentPage, setCurrentPage] = useState<number>(1)
  const itemsPerPage: number = 10

  if (!dataset) {
    return <div>Loading...</div>
  }

  const indexOfLastItem: number = currentPage * itemsPerPage
  const indexOfFirstItem: number = indexOfLastItem - itemsPerPage
  const currentItems: WeatherData[] = dataset.slice(indexOfFirstItem, indexOfLastItem)

  const nextPage = () => {
    if (currentPage < Math.ceil(dataset.length / itemsPerPage)) {
      setCurrentPage(currentPage + 1)
    }
  }

  const prevPage = () => {
    if (currentPage > 1) {
      setCurrentPage(currentPage - 1)
    }
  }

  return (
    <div>
      <Head></Head>
      <CardList>
        {currentItems.map((data: WeatherData, index: number) => (
          <WeatherCard key={index} data={data} />
        ))}
      </CardList>
      <Pagination>
        <button onClick={prevPage} disabled={currentPage === 1}>
          Предыдущая
        </button>
        <span>
          Страница {currentPage} из {Math.ceil(dataset.length / itemsPerPage)}
        </span>
        <button onClick={nextPage} disabled={currentPage === Math.ceil(dataset.length / itemsPerPage)}>
          Следующая
        </button>
      </Pagination>
    </div>
  )
}

export default Weather
