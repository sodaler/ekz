import React from "react";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/common/Layout";
import MainPage from "./pages/MainPage/MainPage";
import NewsPage from "./pages/NewsPage/NewsPage";
import TablePage from "./pages/TablePage.jsx/NewsPage";


function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout><MainPage /></Layout>} />
      <Route path="/news" element={<Layout><NewsPage /></Layout>} />
      <Route path="/table" element={<Layout><TablePage /></Layout>} />
    </Routes>
  );
}

export default App;
