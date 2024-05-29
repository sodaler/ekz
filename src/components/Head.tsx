import React from 'react'
import styled, { createGlobalStyle } from 'styled-components'
import { Link } from 'react-router-dom'

const GlobalStyle = createGlobalStyle`
  body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-color: ${props => props.theme?.body || '#fff'};
  }

  ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
    display: flex;
  }

  li {
    margin-right: 20px;
  }

  a {
    text-decoration: none;
    color: white;
  }
`

const Header = styled.header`
  background-color: #333;
  color: white;
  padding: 30px;
  height: 20px;
  width: 100%;
  box-sizing: border-box;
`

const Head: React.FC = () => {
  return (
    <>
      <GlobalStyle />
      <Header>
        <nav>
          <ul>
            <li>
              <Link to='/'>Главная</Link>
            </li>
            <li>
              <Link to='/list'>Список</Link>
            </li>
            <li>
              <Link to='/timetable'>Расписание</Link>
            </li>
            <li>
              <Link to='/weather'>Погода</Link>
            </li>
          </ul>
        </nav>
      </Header>
    </>
  )
}

export default Head
