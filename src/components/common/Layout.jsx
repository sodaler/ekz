import React from "react";
import Header from "./Header";
import Container from 'react-bootstrap/Container';
import Footer from "./Footer";

const Layout = ({ children }) => {
    return (
        <>
            <Header></Header>
            <Container>
                {children}
            </Container>
            <Footer></Footer>
        </>

    )

}

export default Layout