import React, { useState } from "react";
import WeatherCard from "../../components/WeatherCard/WeatherCard";
import styles from "./index.module.css";
import useFetchData from "../../hooks/useFetchData";

const MainPage = () => {
    const dataset = useFetchData();
    const [currentPage, setCurrentPage] = useState(1);
    const itemsPerPage = 10; // Количество элементов на странице

    if (!dataset) {
        return <div>Loading...</div>;
    }

    // Вычисление данных для текущей страницы
    const indexOfLastItem = currentPage * itemsPerPage;
    const indexOfFirstItem = indexOfLastItem - itemsPerPage;
    const currentItems = dataset.slice(indexOfFirstItem, indexOfLastItem);

    // Обработчики переключения страниц
    const nextPage = () => {
        if (currentPage < Math.ceil(dataset.length / itemsPerPage)) {
            setCurrentPage(currentPage + 1);
        }
    };

    const prevPage = () => {
        if (currentPage > 1) {
            setCurrentPage(currentPage - 1);
        }
    };

    return (
        <div>
            <div className={styles.cardList}>
                {currentItems.map((data, index) => (
                    <WeatherCard key={index} data={data} />
                ))}
            </div>
            <div className={styles.pagination}>
                <button onClick={prevPage} disabled={currentPage === 1}>
                    Предыдущая
                </button>
                <span>Страница {currentPage} из {Math.ceil(dataset.length / itemsPerPage)}</span>
                <button onClick={nextPage} disabled={currentPage === Math.ceil(dataset.length / itemsPerPage)}>
                    Следующая
                </button>
            </div>
        </div>
    );
};

export default MainPage;
