import React from "react";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/common/Layout";
import MainPage from "./Pages/MainPage/MainPage";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout><MainPage /></Layout>} />
    </Routes>
  );
}

export default App;
