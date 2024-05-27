using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamMigration
{
    public class Patient
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Age { get; set; }
        public int RoomNumber { get; set; }

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
