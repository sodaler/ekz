import React, { useEffect } from "react";

import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

import styles from "./index.module.css"

const NewsPage = () => {
    useEffect(() => {
        document.title = "Новости"
    }, [])

    return (
        <div className={styles.main}>
            <div className={styles.info}>
                Улгту
            </div>
            <div className={styles.cards}>
                <Card style={{ width: '18rem' }}>
                    <Card.Img variant="top" src="podrobnayaInformatsiaOPrieme.webp" />
                    <Card.Body>
                        <Card.Title>Новость</Card.Title>
                        <Card.Text>
                            Информация новости новости новости новости.
                        </Card.Text>
                        <Button variant="primary">Открыть</Button>
                    </Card.Body>
                </Card>
                <Card style={{ width: '18rem' }}>
                    <Card.Img variant="top" src="podrobnayaInformatsiaOPrieme.webp" />
                    <Card.Body>
                        <Card.Title>Новость</Card.Title>
                        <Card.Text>
                            Информация новости новости новости новости.
                        </Card.Text>
                        <Button variant="primary">Открыть</Button>
                    </Card.Body>
                </Card>
                <Card style={{ width: '18rem' }}>
                    <Card.Img variant="top" src="podrobnayaInformatsiaOPrieme.webp" />
                    <Card.Body>
                        <Card.Title>Новость</Card.Title>
                        <Card.Text>
                            Информация новости новости новости новости.
                        </Card.Text>
                        <Button variant="primary">Открыть</Button>
                    </Card.Body>
                </Card>
            </div>

        </div>
    )

}

export default NewsPage