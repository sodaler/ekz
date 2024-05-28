using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp2
{
    public class DBContext : DbContext
    {
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Initial Catalog=DBContext");
            base.OnConfiguring(optionsBuilder);
        } 
        public virtual DbSet<Supplier> Suppliers { get; set; }
        public virtual DbSet<City> Cities { get; set; }
    }
}
