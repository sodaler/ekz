using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        private const string FileName = "Suppliers.json";
        public List<Supplier> suppliers  = new List<Supplier>();
        public Form1()
        {
            InitializeComponent();

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            if (!File.Exists(FileName))
                File.Create(FileName);
            var fileData = File.ReadAllText(FileName);
            var des = JsonConvert.DeserializeObject<List<Supplier>>(fileData);
            suppliers = des;
            displaySupps();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            var ser = JsonConvert.SerializeObject(suppliers);
            File.WriteAllText(FileName, ser);
        }


        private void button1_Click(object sender, EventArgs e)
        {
            var supplier = new Supplier
            {
                Item = textBoxItem.Text,
                Price = int.Parse(textBoxPrice.Text),
                CityName = textBoxCityName.Text
            };

            suppliers.Add(supplier);
            displaySupps();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string item = textBoxLinqItem.Text; //from textbox
            var result = suppliers.Where(r => r.Item == item).ToList();
            dataGridView1.DataSource = " ";
            dataGridView1.DataSource = result;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            string cityName = textBoxLinqCity.Text;
            var res2 = suppliers.Where(r => r.CityName == cityName).OrderBy(r => r.Price).ToList();

            dataGridView1.DataSource = " ";
            dataGridView1.DataSource = res2 ;
            //dataGridView1.DataSource = new List<Supplier> { res2 };
        }

        private void displaySupps() {
            dataGridView1.DataSource = " ";
            dataGridView1.DataSource = suppliers;
            
        }
    }
}
