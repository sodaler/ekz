// Table.tsx
import React from "react";
import { TimeTableEntry, Day, Lesson } from "../../types/types";
import Table from 'react-bootstrap/Table';

interface TableProps {
    data: TimeTableEntry;
    weekIndex: number;
}

const dayNames = ["Пнд", "Втр", "Срд", "Чтв", "Птн", "Сбт", "Вс"];

const TableComponent: React.FC<TableProps> = ({ data, weekIndex }) => {
    return (
        <div>
            <h2>Неделя {weekIndex + 1}</h2>
            <Table striped bordered hover responsive>
                <thead>
                    <tr>
                        <th></th>
                        <th>1-я пара</th>
                        <th>2-я пара</th>
                        <th>3-я пара</th>
                        <th>4-я пара</th>
                        <th>5-я пара</th>
                        <th>6-я пара</th>
                        <th>7-я пара</th>
                        <th>8-я пара</th>
                    </tr>
                </thead>
                <tbody>
                    {data.days.map((day: Day, dayIndex: number) => (
                        <tr key={dayIndex}>
                            <td>{dayNames[dayIndex]}</td>
                            {day.lessons.map((lesson: Lesson | null, lessonIndex: number) => (
                                lesson ? (
                                    <td key={lessonIndex} style={{backgroundColor: "#96ee9e"}}>{lesson.group?.name} <br /> {lesson.subject?.name} <br /> {lesson.room?.name}</td>
                                ) : (
                                    <td key={lessonIndex} style={{backgroundColor: "#e9be86"}}>-</td>
                                )
                            ))}
                        </tr>
                    ))}
                </tbody>
            </Table>
        </div>
    );
};

export default TableComponent;
