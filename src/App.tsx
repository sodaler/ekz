import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Main from './pages/Main'
import Weather from './pages/Weather'
import List from './pages/List'
import Timetable from './pages/Timetable'

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Main />} />
        <Route path='/list' element={<List />} />
        <Route path='/timetable' element={<Timetable />} />
        <Route path='/weather' element={<Weather />} />
      </Routes>
    </Router>
  )
}

export default App
