import React from 'react'
import styled from 'styled-components'
import { TimeTableEntry, Day, Lesson } from '../../types/types'

interface TableProps {
  data: TimeTableEntry
  weekIndex: number
}

const dayNames = ['Пнд', 'Втр', 'Срд', 'Чтв', 'Птн', 'Сбт', 'Вс']

const StyledTable = styled.table`
  width: 100%;
  border-collapse: collapse;
`

const StyledTh = styled.th`
  border: 1px solid #ddd;
  padding: 8px;
  background-color: #f2f2f2;
`

interface StyledTdProps {
  bgColor?: string
}

const StyledTd = styled.td<StyledTdProps>`
  border: 1px solid #ddd;
  padding: 8px;
  background-color: ${props => props.bgColor || 'white'};
`

const StyledTr = styled.tr`
  &:nth-child(even) {
    background-color: #f9f9f9;
  }
  &:hover {
    background-color: #ddd;
  }
`

const TableComponent: React.FC<TableProps> = ({ data, weekIndex }) => {
  return (
    <div>
      <h2>Неделя {weekIndex + 1}</h2>
      <StyledTable>
        <thead>
          <StyledTr>
            <StyledTh></StyledTh>
            <StyledTh>1-я пара</StyledTh>
            <StyledTh>2-я пара</StyledTh>
            <StyledTh>3-я пара</StyledTh>
            <StyledTh>4-я пара</StyledTh>
            <StyledTh>5-я пара</StyledTh>
            <StyledTh>6-я пара</StyledTh>
            <StyledTh>7-я пара</StyledTh>
            <StyledTh>8-я пара</StyledTh>
          </StyledTr>
        </thead>
        <tbody>
          {data.days.map((day: Day, dayIndex: number) => (
            <StyledTr key={dayIndex}>
              <StyledTd>{dayNames[dayIndex]}</StyledTd>
              {day.lessons.map((lesson: Lesson | null, lessonIndex: number) =>
                lesson ? (
                  <StyledTd key={lessonIndex} bgColor='#96ee9e'>
                    {lesson.group?.name} <br /> {lesson.subject?.name} <br /> {lesson.room?.name}
                  </StyledTd>
                ) : (
                  <StyledTd key={lessonIndex} bgColor='#e9be86'>
                    -
                  </StyledTd>
                )
              )}
            </StyledTr>
          ))}
        </tbody>
      </StyledTable>
    </div>
  )
}

export default TableComponent
