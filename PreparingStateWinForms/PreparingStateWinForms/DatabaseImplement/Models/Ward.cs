using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace PreparingStateWinForms.DatabaseImplement.Models
{
    [Serializable]
    public class Ward
    {
        public int Id { get; set; }
        public int Number { get; set; }
        public int CountPatient { get; set; }
        [JsonIgnore]
        [ForeignKey("PatientId")]
        public virtual List<Patient> Patients { get; set; }

        public Ward()
        {
            Patients = new List<Patient>();
        }

        public Ward(int number)
        {
            Number = number;
        }
    }
}
