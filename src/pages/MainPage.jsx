import React, {useState} from "react";
import Container from 'react-bootstrap/Container';
import useFetchTimeTableData from "../hooks/useFetchTimeTableData";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import TableComponent from "../components/Table";


const MainPage = () => {
    const [group, setGroup] = useState("");
    const [searchGroup, setSearchGroup] = useState("");
    const timeTableData = useFetchTimeTableData(searchGroup);

    const handleChange = (event) => {
        setGroup(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        setSearchGroup(group)
    }

    const handleClear = () => {
        setGroup("");
        setSearchGroup("");
        window.location.reload();
    }

    return (
        <Container>
            <Form className="mb-4 mt-4" onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Control 
                        type="text" 
                        placeholder="Поиск группы"
                        onChange={handleChange}
                        value={group}
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="me-2">
                    Найти
                </Button>
                <Button variant="danger" onClick={handleClear}>
                    Очистить
                </Button>
            </Form>

            {timeTableData.map((data, index) => (
                <TableComponent key={index} data ={data}></TableComponent>
            ))}

        </Container>
    )
};

export default MainPage;