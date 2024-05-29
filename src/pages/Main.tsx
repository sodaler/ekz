import React, { useEffect } from 'react'
import styled from 'styled-components'
import Head from '../components/Head'

const Footer = styled.footer`
  background-color: #333;
  color: white;
  padding: 10px;
  position: fixed;
  bottom: 0;
  width: 100%;
  box-sizing: border-box;
`

const MainContent = styled.div`
  display: flex;
  justify-content: space-between;
`

const Sidebar = styled.div`
  width: 20%;
  height: 800px;
  background-color: #f0f0f0;
  padding: 10px;
  box-sizing: border-box;
`

const Content = styled.div`
  width: 75%;
  padding: 10px;
  box-sizing: border-box;
`

const Form = styled.form`
  display: flex;
  flex-direction: column;
`

const Input = styled.input`
  margin-bottom: 10px;
  padding: 8px;
  font-size: 16px;
`

const Button = styled.button`
  padding: 10px;
  background-color: #333;
  color: white;
  border: none;
  cursor: pointer;

  &:hover {
    background-color: #555;
  }
`

const HeadText = styled.h2`
  text-align: center;
`

const Main: React.FC = () => {
  useEffect(() => {
    document.title = 'Главная страница'
  }, [])
  return (
    <>
      <Head />
      <MainContent>
        <Sidebar>
          <HeadText>Форма входа</HeadText>
          <Form>
            <Input type='text' placeholder='Логин' />
            <Input type='password' placeholder='Пароль' />
            <Button type='submit'>Войти</Button>
          </Form>
        </Sidebar>
        <Content>
          <h1>Главная страница</h1>
        </Content>
      </MainContent>
      <Footer>
        <p>Информация об авторе работы</p>
      </Footer>
    </>
  )
}

export default Main
