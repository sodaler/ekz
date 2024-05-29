import { useEffect, useState } from 'react'
import { TimeTableData } from '../types/types'

const useFetchTimeTableGroup = (group: string): TimeTableData => {
  const [timeTableData, setTimeTableData] = useState<TimeTableData>([])

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`https://vm.nathoro.ru/timetable/by-group/${group}`)
        const data: TimeTableData = await response.json()
        setTimeTableData(data)
      } catch (error) {
        console.error('Error:', error)
      }
    }
    fetchData()
  }, [group])

  return timeTableData
}

export default useFetchTimeTableGroup
