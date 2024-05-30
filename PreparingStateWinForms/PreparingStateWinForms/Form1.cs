using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Windows.Forms;
using System.Text.Json;
using PreparingStateWinForms.DatabaseImplement.Models;
using System.Text.Json.Serialization;

namespace PreparingStateWinForms
{
    

    public partial class Form1 : Form
    {
        private List<Patient> patients = new List<Patient>();
        private Ward ward = new Ward();
        private string filePath;

        public Form1()
        {
            InitializeComponent();
            filePath = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments), "patients.json");
            LoadPatients();
            UpdatePatientGrid();
        }

        private void LoadPatients()
        {
            if (File.Exists(filePath))
            {
                string json = File.ReadAllText(filePath);
                patients = JsonSerializer.Deserialize<List<Patient>>(json, new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                });
            }
        }

        private void SavePatients()
        {
            var options = new JsonSerializerOptions
            {
                WriteIndented = true
            };

            string json = JsonSerializer.Serialize(patients, options);
            File.WriteAllText(filePath, json);
        }

        private void UpdatePatientGrid()
        {
            dataGridViewPatients.DataSource = null;
            dataGridViewPatients.DataSource = patients
                .Select(p => new
                {
                    p.Name,
                    p.Age,
                    p.Diagnosis,
                    p.WardNumber
                })
                .ToList();
        }

        private void buttonAddPatient_Click(object sender, EventArgs e)
        {
            string name = textBoxName.Text;
            int age = int.Parse(textBoxAge.Text);
            string diagnosis = textBoxDiagnosis.Text;
            int number = int.Parse(textBoxWard.Text);
            ward = new Ward(number);
            patients.Add(new Patient(name, age, diagnosis, ward.Number));
            SavePatients();
            UpdatePatientGrid();
        }

        private void buttonFindOlder_Click(object sender, EventArgs e)
        {
            int age = int.Parse(textBoxSearchAge.Text);
            var olderPatients = patients
                .Where(p => p.Age > age)
                .Select(p => p.Name);

            labelOlderPatients.Text = "Patients older than " + age + ": " + string.Join(", ", olderPatients);
        }

        private void buttonFindWardWithMostPatients_Click(object sender, EventArgs e)
        {
            var wardWithMostPatients = patients
                .GroupBy(p => p.WardNumber)
                .OrderByDescending(g => g.Count())
                .FirstOrDefault();

            if (wardWithMostPatients != null)
            {
                labelWardWithMostPatients.Text = "Ward " + wardWithMostPatients.Key + " has the most patients: " + wardWithMostPatients.Count();
            }
        }
    }
}
