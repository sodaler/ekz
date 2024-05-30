namespace PreparingStateWinForms
{
    partial class Form1
    {
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            this.dataGridViewPatients = new System.Windows.Forms.DataGridView();
            this.textBoxName = new System.Windows.Forms.TextBox();
            this.textBoxAge = new System.Windows.Forms.TextBox();
            this.textBoxDiagnosis = new System.Windows.Forms.TextBox();
            this.textBoxWard = new System.Windows.Forms.TextBox();
            this.buttonAddPatient = new System.Windows.Forms.Button();
            this.textBoxSearchAge = new System.Windows.Forms.TextBox();
            this.buttonFindOlder = new System.Windows.Forms.Button();
            this.labelOlderPatients = new System.Windows.Forms.Label();
            this.buttonFindWardWithMostPatients = new System.Windows.Forms.Button();
            this.labelWardWithMostPatients = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewPatients)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridViewPatients
            // 
            this.dataGridViewPatients.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewPatients.Location = new System.Drawing.Point(12, 12);
            this.dataGridViewPatients.Name = "dataGridViewPatients";
            this.dataGridViewPatients.Size = new System.Drawing.Size(776, 150);
            this.dataGridViewPatients.TabIndex = 0;
            // 
            // textBoxName
            // 
            this.textBoxName.Location = new System.Drawing.Point(12, 180);
            this.textBoxName.Name = "textBoxName";
            this.textBoxName.Text = "Name";
            this.textBoxName.Size = new System.Drawing.Size(100, 23);
            this.textBoxName.TabIndex = 1;
            // 
            // textBoxAge
            // 
            this.textBoxAge.Location = new System.Drawing.Point(118, 180);
            this.textBoxAge.Name = "textBoxAge";
            this.textBoxAge.Text = "Age";
            this.textBoxAge.Size = new System.Drawing.Size(100, 23);
            this.textBoxAge.TabIndex = 2;
            // 
            // textBoxDiagnosis
            // 
            this.textBoxDiagnosis.Location = new System.Drawing.Point(224, 180);
            this.textBoxDiagnosis.Name = "textBoxDiagnosis";
            this.textBoxDiagnosis.Text = "Diagnosis";
            this.textBoxDiagnosis.Size = new System.Drawing.Size(100, 23);
            this.textBoxDiagnosis.TabIndex = 3;
            // 
            // textBoxWard
            // 
            this.textBoxWard.Location = new System.Drawing.Point(330, 180);
            this.textBoxWard.Name = "textBoxWard";
            this.textBoxWard.Text = "Ward";
            this.textBoxWard.Size = new System.Drawing.Size(100, 23);
            this.textBoxWard.TabIndex = 4;
            // 
            // buttonAddPatient
            // 
            this.buttonAddPatient.Location = new System.Drawing.Point(436, 179);
            this.buttonAddPatient.Name = "buttonAddPatient";
            this.buttonAddPatient.Size = new System.Drawing.Size(75, 23);
            this.buttonAddPatient.TabIndex = 5;
            this.buttonAddPatient.Text = "Add Patient";
            this.buttonAddPatient.UseVisualStyleBackColor = true;
            this.buttonAddPatient.Click += new System.EventHandler(this.buttonAddPatient_Click);
            // 
            // textBoxSearchAge
            // 
            this.textBoxSearchAge.Location = new System.Drawing.Point(12, 220);
            this.textBoxSearchAge.Name = "textBoxSearchAge";
            this.textBoxSearchAge.Text = "Search Age";
            this.textBoxSearchAge.Size = new System.Drawing.Size(100, 23);
            this.textBoxSearchAge.TabIndex = 6;
            // 
            // buttonFindOlder
            // 
            this.buttonFindOlder.Location = new System.Drawing.Point(118, 219);
            this.buttonFindOlder.Name = "buttonFindOlder";
            this.buttonFindOlder.Size = new System.Drawing.Size(75, 23);
            this.buttonFindOlder.TabIndex = 7;
            this.buttonFindOlder.Text = "Find Older";
            this.buttonFindOlder.UseVisualStyleBackColor = true;
            this.buttonFindOlder.Click += new System.EventHandler(this.buttonFindOlder_Click);
            // 
            // labelOlderPatients
            // 
            this.labelOlderPatients.AutoSize = true;
            this.labelOlderPatients.Location = new System.Drawing.Point(199, 223);
            this.labelOlderPatients.Name = "labelOlderPatients";
            this.labelOlderPatients.Size = new System.Drawing.Size(0, 15);
            this.labelOlderPatients.TabIndex = 8;
            // 
            // buttonFindWardWithMostPatients
            // 
            this.buttonFindWardWithMostPatients.Location = new System.Drawing.Point(12, 263);
            this.buttonFindWardWithMostPatients.Name = "buttonFindWardWithMostPatients";
            this.buttonFindWardWithMostPatients.Size = new System.Drawing.Size(181, 23);
            this.buttonFindWardWithMostPatients.TabIndex = 9;
            this.buttonFindWardWithMostPatients.Text = "Find Ward With Most Patients";
            this.buttonFindWardWithMostPatients.UseVisualStyleBackColor = true;
            this.buttonFindWardWithMostPatients.Click += new System.EventHandler(this.buttonFindWardWithMostPatients_Click);
            // 
            // labelWardWithMostPatients
            // 
            this.labelWardWithMostPatients.AutoSize = true;
            this.labelWardWithMostPatients.Location = new System.Drawing.Point(199, 267);
            this.labelWardWithMostPatients.Name = "labelWardWithMostPatients";
            this.labelWardWithMostPatients.Size = new System.Drawing.Size(0, 15);
            this.labelWardWithMostPatients.TabIndex = 10;
            // 
            // Form1
            // 
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.labelWardWithMostPatients);
            this.Controls.Add(this.buttonFindWardWithMostPatients);
            this.Controls.Add(this.labelOlderPatients);
            this.Controls.Add(this.buttonFindOlder);
            this.Controls.Add(this.textBoxSearchAge);
            this.Controls.Add(this.buttonAddPatient);
            this.Controls.Add(this.textBoxWard);
            this.Controls.Add(this.textBoxDiagnosis);
            this.Controls.Add(this.textBoxAge);
            this.Controls.Add(this.textBoxName);
            this.Controls.Add(this.dataGridViewPatients);
            this.Name = "Form1";
            this.Text = "Patient Management";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewPatients)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        private System.Windows.Forms.DataGridView dataGridViewPatients;
        private System.Windows.Forms.TextBox textBoxName;
        private System.Windows.Forms.TextBox textBoxAge;
        private System.Windows.Forms.TextBox textBoxDiagnosis;
        private System.Windows.Forms.TextBox textBoxWard;
        private System.Windows.Forms.Button buttonAddPatient;
        private System.Windows.Forms.TextBox textBoxSearchAge;
        private System.Windows.Forms.Button buttonFindOlder;
        private System.Windows.Forms.Label labelOlderPatients;
        private System.Windows.Forms.Button buttonFindWardWithMostPatients;
        private System.Windows.Forms.Label labelWardWithMostPatients;
    }
}
