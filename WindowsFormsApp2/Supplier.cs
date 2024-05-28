using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp2
{
    public class Supplier
    {
        public int Id { get; set; }
        public int Price { get; set; }
        public string Item { get; set; }
        public string CityName { get; set; }
        public int CityId { get; set; }
        public virtual City City { get; set; }

    }
}
