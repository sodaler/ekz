import React, { useEffect, useState } from 'react'
import styled from 'styled-components'
import TableComponent from '../components/Table/TableMin'
import useFetchTimeTableGroup from '../actions/useFetchTimeTableGroup'
import Head from '../components/Head'

const Container = styled.div`
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
`

const Form = styled.form`
  margin-bottom: 16px;
  margin-top: 16px;
`

const FormGroup = styled.div`
  margin-bottom: 12px;
`

const Input = styled.input`
  width: 100%;
  padding: 8px;
  font-size: 16px;
  margin-bottom: 8px;
`

const Button = styled.button<{ variant?: string }>`
  padding: 10px 20px;
  margin-right: 8px;
  font-size: 16px;
  color: white;
  background-color: ${props => (props.variant === 'primary' ? '#007bff' : '#6c757d')};
  border: none;
  cursor: pointer;

  &:hover {
    background-color: ${props => (props.variant === 'primary' ? '#0056b3' : '#5a6268')};
  }

  &:last-child {
    margin-right: 0;
  }
`

const Timetable: React.FC = () => {
  const [group, setGroup] = useState<string>('')
  const [searchGroup, setSearchGroup] = useState<string>(group)
  const timeTableData = useFetchTimeTableGroup(searchGroup)

  useEffect(() => {
    document.title = 'Расписание'
  }, [])

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setGroup(event.target.value)
  }

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault()
    setSearchGroup(group)
  }

  const handleClear = () => {
    setGroup('')
    setSearchGroup('')
    window.location.reload()
  }

  return (
    <>
      <Head />
      <Container>
        <Form onSubmit={handleSubmit}>
          <FormGroup>
            <Input type='text' placeholder='Поиск по группе' value={group} onChange={handleInputChange} />
          </FormGroup>
          <Button variant='primary' type='submit'>
            Найти
          </Button>
          <Button variant='secondary' onClick={handleClear}>
            Очистить
          </Button>
        </Form>

        {timeTableData.map((data, index) => (
          <TableComponent key={index} data={data} weekIndex={index} />
        ))}
      </Container>
    </>
  )
}

export default Timetable
