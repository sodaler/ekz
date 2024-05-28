using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp2
{
    public class City
    {
        public int Id { get; set; }
        public string Name { get; set; }

        [ForeignKey("CityId")]
        public virtual List<Supplier> Suppliers { get; set; }
    }
}
