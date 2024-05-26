// Table.tsx
import React from "react";
import { TimeTableEntry, Day, Lesson } from "../../types/types";
import Table from 'react-bootstrap/Table';

interface TableProps {
    data: TimeTableEntry;
    weekIndex: number;
}

const TableComponent: React.FC<TableProps> = ({ data, weekIndex }) => {
    return (
        <div>
            <h2>Неделя {weekIndex + 1}</h2>
            {data.days.map((day: Day, dayIndex: number) => (
                <div key={dayIndex}>
                    <h3>День {dayIndex + 1}</h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>Пара</th>
                                <th>Группа</th>
                                <th>Кабинет</th>
                                <th>Предмет</th>
                                <th>Преподаватель</th>
                                <th>Занятие</th>
                            </tr>
                        </thead>
                        <tbody>
                            {day.lessons.map((lesson: Lesson | null, lessonIndex: number) => (
                                lesson ? (
                                    <tr key={lessonIndex}>
                                        <td>{lessonIndex + 1}</td>
                                        <td>{lesson.group?.name || '-'}</td>
                                        <td>{lesson.room?.name || '-'}</td>
                                        <td>{lesson.subject?.name || '-'}</td>
                                        <td>{lesson.subject?.teacher.fullName || '-'}</td>
                                        <td>{lesson.subject?.type || '-'}</td>
                                    </tr>
                                ) : (
                                    <tr key={lessonIndex}>
                                        <td>{lessonIndex + 1}</td>
                                        <td colSpan={5}>-</td>
                                    </tr>
                                )
                            ))}
                        </tbody>
                    </Table>
                </div>
            ))}
        </div>
    );
};

export default TableComponent;
