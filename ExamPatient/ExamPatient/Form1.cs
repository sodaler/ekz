using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Serialization;
using System.IO;

namespace ExamPatient
{
    public partial class Form1 : Form
    {
        List<Patient> patients = new List<Patient>();

        private string fileName = "C:/Users/Алексей/source/repos/ExamPatient/file/patients.xml";
        
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonAddToList_Click(object sender, EventArgs e)
        {
            Patient patient = new Patient(textBoxName.Text, int.Parse(textBoxPatientAge.Text), int.Parse(textBoxRoomNum.Text));
            patients.Add(patient);
            textBoxName.Text = "";
            textBoxPatientAge.Text = "";
            textBoxRoomNum.Text = "";
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(List<Patient>));
            using (FileStream fs = new FileStream(fileName, FileMode.Create))
            {
                serializer.Serialize(fs, patients);
            }
        }

        private void buttonLoad_Click(object sender, EventArgs e)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(List<Patient>));
            using (FileStream fs = new FileStream(fileName, FileMode.Open))
            {
                patients = (List<Patient>)serializer.Deserialize(fs);
            }
        }

        private void buttonCompare_Click(object sender, EventArgs e)
        {
            labelAgeResultHint.Visible = true;
            labelAgeResult.Visible = true;
            labelAgeResult.Text = "";
            if(textBoxAge.Text != "")
            {
                int compareNumber = int.Parse(textBoxAge.Text);
                var patientNames = from patient in patients
                                   where patient.Age > compareNumber
                                   select patient.Name;
                if (patientNames != null)
                {
                    foreach (var name in patientNames)
                    {
                        if (labelAgeResult.Text == "")
                        {
                            labelAgeResult.Text += name;
                        }
                        else
                        {
                            labelAgeResult.Text += ", ";
                            labelAgeResult.Text += name;
                        }
                    }
                }
                else
                {
                    labelAgeResult.Text = "Не найдено";
                }
            }
            else
            {
                labelAgeResult.Text = "Введите возраст для сравнения";
            }
        }

        private void buttonRoomMax_Click(object sender, EventArgs e)
        {
            labelRoomResult.Visible = true;
            var maxRoom = patients
                .GroupBy(p => p.RoomNumber)
                .OrderByDescending(g => g.Count())
                .FirstOrDefault();

            if (maxRoom != null)
            {
                labelRoomResult.Text = $"Палата номер {maxRoom.Key} имеет наибольшее количество пациентов: {maxRoom.Count()}";
            }
            else
            {
                labelRoomResult.Text = "Пациенты не найдены";
            }
        }
    }
}
