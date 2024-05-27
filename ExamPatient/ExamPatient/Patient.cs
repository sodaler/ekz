using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamPatient
{
    [Serializable]
    public class Patient
    {
        public string Name;
        public int Age;
        public int RoomNumber;

        public Patient()
        {

        }

        public Patient(string name, int age, int roomNumber)
        {
            Name = name;
            Age = age;
            RoomNumber = roomNumber;
        }
    }
}
