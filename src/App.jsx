import React from "react";
import Layout from "./components/Layout";
import MainPage from "./pages/MainPage";
import { Route, Routes } from "react-router-dom";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout children={<MainPage />}/>} />
    </Routes>
  );
}

export default App;
