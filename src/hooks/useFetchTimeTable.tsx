import {useEffect, useState} from "react";

const useFetchTimeTable = () => {
    const [timeTableData, setTimeTableData] = useState([])

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`https://vm.nathoro.ru/timetable/groups`);
                const data = await response.json();
                setTimeTableData(data);
            } catch (error) {
                console.error("Error:", error)
            }
        }
        fetchData()
    }, [])

    return timeTableData;
};

export default useFetchTimeTable;