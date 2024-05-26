import React, { useState } from "react";
import Container from 'react-bootstrap/Container';
import TableComponent from "../../components/Table/TableMin";
import useFetchTimeTableGroup from "../../hooks/useFetchTimeTableGroup";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

const MainPage = () => {
    const [group, setGroup] = useState<string>("");
    const [searchGroup, setSearchGroup] = useState<string>(group);
    const timeTableData = useFetchTimeTableGroup(searchGroup);

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setGroup(event.target.value);
    };

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        setSearchGroup(group);
    };

    const handleClear = () => {
        setGroup("");
        setSearchGroup("");
        window.location.reload();
    };

    return (
        <Container>
            <Form className="mb-4 mt-4" onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="groupSearch">
                    <Form.Control 
                        type="text" 
                        placeholder="Поиск по группе" 
                        value={group} 
                        onChange={handleInputChange} 
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="me-2">
                    Найти
                </Button>
                <Button variant="secondary" onClick={handleClear}>
                    Очистить
                </Button>
            </Form>

            {timeTableData.map((data, index) => (
                <TableComponent key={index} data={data} weekIndex={index}></TableComponent>
            ))}
        </Container>
    )
}

export default MainPage;
