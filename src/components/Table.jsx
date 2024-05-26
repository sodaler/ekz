import React from "react";
import Table from 'react-bootstrap/Table';

const daysNames = ["Пнд", "Втр", "Срд", "Чтв", "Птн", "Сбт"]

const TableComponent = ({data}) => {
    return (
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
                {data.days && data.days.map((day, dayIndex) => (
                    <tr key={dayIndex}>

                        <td>{daysNames[dayIndex]}</td>

                        {day.lessons.map((lesson, lessonIndex) => (
                            lesson ? (
                                <td key={lessonIndex} style={{backgroundColor: '#84ce6e84'}}>
                                    {lesson.group?.name} <br /> {lesson.subject?.name} <br /> {lesson.room?.name}
                                </td>
                            ) : (
                                <td key={lessonIndex} style={{backgroundColor: '#c22c2c84'}}>-</td>
                            )

                        ))}

                    </tr>
                ))}
            </tbody>
        </Table>
    )
};

export default TableComponent;