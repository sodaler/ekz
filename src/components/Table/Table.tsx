import React from 'react'
import styled from 'styled-components'
import { TimeTableEntry, Day, Lesson } from '../../types/types'

interface TableProps {
  data: TimeTableEntry
  weekIndex: number
}

const StyledTable = styled.table`
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
`

const StyledTh = styled.th`
  border: 1px solid #ddd;
  padding: 8px;
  background-color: #f2f2f2;
  text-align: left;
`

const StyledTd = styled.td<{ bgColor?: string }>`
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
      {data.days.map((day: Day, dayIndex: number) => (
        <div key={dayIndex}>
          <h3>День {dayIndex + 1}</h3>
          <StyledTable>
            <thead>
              <StyledTr>
                <StyledTh>Пара</StyledTh>
                <StyledTh>Группа</StyledTh>
                <StyledTh>Кабинет</StyledTh>
                <StyledTh>Предмет</StyledTh>
                <StyledTh>Преподаватель</StyledTh>
                <StyledTh>Занятие</StyledTh>
              </StyledTr>
            </thead>
            <tbody>
              {day.lessons.map((lesson: Lesson | null, lessonIndex: number) =>
                lesson ? (
                  <StyledTr key={lessonIndex}>
                    <StyledTd>{lessonIndex + 1}</StyledTd>
                    <StyledTd>{lesson.group?.name || '-'}</StyledTd>
                    <StyledTd>{lesson.room?.name || '-'}</StyledTd>
                    <StyledTd>{lesson.subject?.name || '-'}</StyledTd>
                    <StyledTd>{lesson.subject?.teacher.fullName || '-'}</StyledTd>
                    <StyledTd>{lesson.subject?.type || '-'}</StyledTd>
                  </StyledTr>
                ) : (
                  <StyledTr key={lessonIndex}>
                    <StyledTd>{lessonIndex + 1}</StyledTd>
                    <StyledTd colSpan={5}>-</StyledTd>
                  </StyledTr>
                )
              )}
            </tbody>
          </StyledTable>
        </div>
      ))}
    </div>
  )
}

export default TableComponent
