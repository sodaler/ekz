import React from "react";
import styles from "./index.module.css"

const WeatherCard = ({data}) => {
    return (
        <div className={styles.card}>
            <div>Дата и время: {data.time}</div>
            <div>Температура: {data.temperature}°C</div>
        </div>
    )
};

export default WeatherCard;