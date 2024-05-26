import React, { useEffect } from "react";

import Table from 'react-bootstrap/Table';

import styles from "./index.module.css"

const TablePage = () => {
    useEffect(() => {
        document.title = "Новости"
    }, [])

    return (
        <div className={styles.main}>
            <Table striped bordered hover responsive>
                <thead>
                    <tr>
                        <th></th>
                        <th>Квалификация</th>
                        <th>Направление</th>
                        <th>Профиль</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td rowSpan={3}>Бакалавриат</td>
                        <td>Конструирование и производство изделий из композиционных материалов</td>
                        <td>Материаловедение и технологии материалов</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Искусственный интеллект и бизнес-аналитика</td>
                        <td>Прикладная информатика</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Производство и конструирование электронных средств</td>
                        <td>Конструирование и технология электронных средств</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    )

}

export default TablePage