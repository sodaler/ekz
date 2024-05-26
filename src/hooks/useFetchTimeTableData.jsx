import { useEffect, useState } from "react";

const useFetchTimeTableData = (group) => {
    const [timeTableData, seTimeTableData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(`https://vm.nathoro.ru/timetable/by-group/${group}`);
                const data = await response.json();
                seTimeTableData(data);
            } catch (error) {
                console.error("Error", error)
            }
        };
        fetchData();
    }, [group]);

    return timeTableData;
};

export default useFetchTimeTableData;