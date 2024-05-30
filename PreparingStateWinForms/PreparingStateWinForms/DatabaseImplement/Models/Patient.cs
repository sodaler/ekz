using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace PreparingStateWinForms.DatabaseImplement.Models
{
    [Serializable]
    public class Patient
    {
        public int Id { get; set; }
        [Required]
        public string Name { get; set; }
        [Required]
        public int Age { get; set; }
        [Required]
        public string Diagnosis { get; set; }
        [JsonIgnore]
        public Ward Ward { get; set; }

        public int WardNumber { get; set; }

        public Patient() { }

        public Patient(string name, int age, string diagnosis, int ward)
        {
            Name = name;
            Age = age;
            Diagnosis = diagnosis;
            WardNumber = ward;   
        }
    }
}
