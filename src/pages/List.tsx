import React, { useEffect } from 'react'
import styled from 'styled-components'
import Head from '../components/Head'

const StyledCard = styled.div`
  width: 18rem;
  margin-bottom: 20px;
  margin-left: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  overflow: hidden;

  img {
    width: 100%;
    height: auto;
  }

  .cardContent {
    padding: 20px;
    text-align: left;

    h3 {
      margin-bottom: 10px;
      font-size: 18px;
    }

    p {
      margin-bottom: 15px;
    }
  }
`

const Button = styled.button`
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;

  &:hover {
    background-color: #0056b3;
  }
`

const Container = styled.div`
  display: flex;
  margin: 20px;
  margin-left: 50px;
`

const Table = styled.table`
  width: 70%;
  border-collapse: collapse;
  margin-bottom: 20px;
  margin-left: 50px;
`

const StyledTh = styled.th`
  border: 1px solid #ddd;
  padding: 8px;
  background-color: #f2f2f2;
  text-align: left;
`

const StyledTd = styled.td`
  border: 1px solid #ddd;
  padding: 8px;
  background-color: 'white';
`

const StyledTr = styled.tr`
  background-color: #f9f9f9;
`

const List: React.FC = () => {
  useEffect(() => {
    document.title = 'Список новостей'
  }, [])

  return (
    <>
      <Head />
      <Container>
        <StyledCard>
          <img src='information1.img' alt='Новость' />
          <div className='cardContent'>
            <h3>Новость</h3>
            <p>Информация новости новости новости новости.</p>
            <Button>Открыть</Button>
          </div>
        </StyledCard>
        <StyledCard>
          <img src='information2.img' alt='Новость' />
          <div className='cardContent'>
            <h3>Новость</h3>
            <p>Информация новости новости новости новости.</p>
            <Button>Открыть</Button>
          </div>
        </StyledCard>
        <StyledCard>
          <img src='information3.img' alt='Новость' />
          <div className='cardContent'>
            <h3>Новость</h3>
            <p>Информация новости новости новости новости.</p>
            <Button>Открыть</Button>
          </div>
        </StyledCard>
      </Container>
      <Table>
        <thead>
          <StyledTr>
            <th></th>
            <StyledTh>Квалификация</StyledTh>
            <StyledTh>Направление</StyledTh>
            <StyledTh>Профиль</StyledTh>
          </StyledTr>
        </thead>
        <tbody>
          <StyledTr>
            <StyledTd>1</StyledTd>
            <StyledTd rowSpan={3}>Бакалавриат</StyledTd>
            <StyledTd>Конструирование и производство изделий из композиционных материалов</StyledTd>
            <StyledTd>Материаловедение и технологии материалов</StyledTd>
          </StyledTr>
          <StyledTr>
            <StyledTd>2</StyledTd>
            <StyledTd>Искусственный интеллект и бизнес-аналитика</StyledTd>
            <StyledTd>Прикладная информатика</StyledTd>
          </StyledTr>
          <StyledTr>
            <StyledTd>3</StyledTd>
            <StyledTd>Производство и конструирование электронных средств</StyledTd>
            <StyledTd>Конструирование и технология электронных средств</StyledTd>
          </StyledTr>
        </tbody>
      </Table>
    </>
  )
}

export default List
