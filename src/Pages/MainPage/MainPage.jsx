import React, { useEffect } from "react";

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import styles from "./index.module.css"

const MainPage = () => {
    useEffect(() => {
        document.title = "Главная"
    }, [])

    return (
        <div className={styles.main}>
            <div className={styles.loginFormWrapper}>
                <Form>
                    <Form.Group className="mb-3">
                        <Form.Label>Телефон</Form.Label>
                        <Form.Control type="tel" placeholder="Введите телефон" />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Пароль</Form.Label>
                        <Form.Control type="password" placeholder="Пароль" />
                    </Form.Group>

                    <Button variant="primary" type="submit">
                        Войти
                    </Button>
                </Form>
            </div>
            <div className={styles.image}>
            </div>

        </div>
    )

}

export default MainPage