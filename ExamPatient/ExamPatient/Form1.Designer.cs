namespace ExamPatient
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxName = new System.Windows.Forms.TextBox();
            this.textBoxRoomNum = new System.Windows.Forms.TextBox();
            this.textBoxPatientAge = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.buttonAddToList = new System.Windows.Forms.Button();
            this.buttonLoad = new System.Windows.Forms.Button();
            this.buttonSave = new System.Windows.Forms.Button();
            this.buttonCompare = new System.Windows.Forms.Button();
            this.textBoxAge = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.labelAgeResultHint = new System.Windows.Forms.Label();
            this.labelAgeResult = new System.Windows.Forms.Label();
            this.buttonRoomMax = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.labelRoomResult = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(232, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(64, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Пациент";
            // 
            // textBoxName
            // 
            this.textBoxName.Location = new System.Drawing.Point(144, 33);
            this.textBoxName.Name = "textBoxName";
            this.textBoxName.Size = new System.Drawing.Size(152, 22);
            this.textBoxName.TabIndex = 1;
            // 
            // textBoxRoomNum
            // 
            this.textBoxRoomNum.Location = new System.Drawing.Point(144, 61);
            this.textBoxRoomNum.Name = "textBoxRoomNum";
            this.textBoxRoomNum.Size = new System.Drawing.Size(152, 22);
            this.textBoxRoomNum.TabIndex = 2;
            // 
            // textBoxPatientAge
            // 
            this.textBoxPatientAge.Location = new System.Drawing.Point(144, 89);
            this.textBoxPatientAge.Name = "textBoxPatientAge";
            this.textBoxPatientAge.Size = new System.Drawing.Size(152, 22);
            this.textBoxPatientAge.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(24, 33);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(36, 16);
            this.label2.TabIndex = 4;
            this.label2.Text = "Имя ";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(24, 61);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(101, 16);
            this.label3.TabIndex = 5;
            this.label3.Text = "Номер палаты";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(27, 89);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(62, 16);
            this.label4.TabIndex = 6;
            this.label4.Text = "Возраст";
            // 
            // buttonAddToList
            // 
            this.buttonAddToList.Location = new System.Drawing.Point(27, 126);
            this.buttonAddToList.Name = "buttonAddToList";
            this.buttonAddToList.Size = new System.Drawing.Size(97, 24);
            this.buttonAddToList.TabIndex = 7;
            this.buttonAddToList.Text = "Добавить";
            this.buttonAddToList.UseVisualStyleBackColor = true;
            this.buttonAddToList.Click += new System.EventHandler(this.buttonAddToList_Click);
            // 
            // buttonLoad
            // 
            this.buttonLoad.Location = new System.Drawing.Point(27, 187);
            this.buttonLoad.Name = "buttonLoad";
            this.buttonLoad.Size = new System.Drawing.Size(174, 23);
            this.buttonLoad.TabIndex = 8;
            this.buttonLoad.Text = "Загрузить из файла";
            this.buttonLoad.UseVisualStyleBackColor = true;
            this.buttonLoad.Click += new System.EventHandler(this.buttonLoad_Click);
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(30, 217);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(171, 23);
            this.buttonSave.TabIndex = 9;
            this.buttonSave.Text = "Выгрузить в файл";
            this.buttonSave.UseVisualStyleBackColor = true;
            this.buttonSave.Click += new System.EventHandler(this.buttonSave_Click);
            // 
            // buttonCompare
            // 
            this.buttonCompare.Location = new System.Drawing.Point(424, 67);
            this.buttonCompare.Name = "buttonCompare";
            this.buttonCompare.Size = new System.Drawing.Size(161, 23);
            this.buttonCompare.TabIndex = 10;
            this.buttonCompare.Text = "Вывести результат";
            this.buttonCompare.UseVisualStyleBackColor = true;
            this.buttonCompare.Click += new System.EventHandler(this.buttonCompare_Click);
            // 
            // textBoxAge
            // 
            this.textBoxAge.Location = new System.Drawing.Point(424, 39);
            this.textBoxAge.Name = "textBoxAge";
            this.textBoxAge.Size = new System.Drawing.Size(161, 22);
            this.textBoxAge.TabIndex = 11;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(421, 20);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(164, 16);
            this.label5.TabIndex = 12;
            this.label5.Text = "Возраст для сравнения:";
            // 
            // labelAgeResultHint
            // 
            this.labelAgeResultHint.AutoSize = true;
            this.labelAgeResultHint.Location = new System.Drawing.Point(638, 20);
            this.labelAgeResultHint.Name = "labelAgeResultHint";
            this.labelAgeResultHint.Size = new System.Drawing.Size(80, 16);
            this.labelAgeResultHint.TabIndex = 13;
            this.labelAgeResultHint.Text = "Результат:";
            this.labelAgeResultHint.Visible = false;
            // 
            // labelAgeResult
            // 
            this.labelAgeResult.AutoSize = true;
            this.labelAgeResult.Location = new System.Drawing.Point(641, 44);
            this.labelAgeResult.Name = "labelAgeResult";
            this.labelAgeResult.Size = new System.Drawing.Size(0, 16);
            this.labelAgeResult.TabIndex = 14;
            this.labelAgeResult.Visible = false;
            // 
            // buttonRoomMax
            // 
            this.buttonRoomMax.Location = new System.Drawing.Point(424, 159);
            this.buttonRoomMax.Name = "buttonRoomMax";
            this.buttonRoomMax.Size = new System.Drawing.Size(161, 79);
            this.buttonRoomMax.TabIndex = 15;
            this.buttonRoomMax.Text = "Вывести палату с наибольшим кол-вом пациентов";
            this.buttonRoomMax.UseVisualStyleBackColor = true;
            this.buttonRoomMax.Click += new System.EventHandler(this.buttonRoomMax_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(638, 159);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(80, 16);
            this.label7.TabIndex = 16;
            this.label7.Text = "Результат:";
            // 
            // labelRoomResult
            // 
            this.labelRoomResult.AutoSize = true;
            this.labelRoomResult.Location = new System.Drawing.Point(638, 194);
            this.labelRoomResult.Name = "labelRoomResult";
            this.labelRoomResult.Size = new System.Drawing.Size(0, 16);
            this.labelRoomResult.TabIndex = 17;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1057, 450);
            this.Controls.Add(this.labelRoomResult);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.buttonRoomMax);
            this.Controls.Add(this.labelAgeResult);
            this.Controls.Add(this.labelAgeResultHint);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.textBoxAge);
            this.Controls.Add(this.buttonCompare);
            this.Controls.Add(this.buttonSave);
            this.Controls.Add(this.buttonLoad);
            this.Controls.Add(this.buttonAddToList);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textBoxPatientAge);
            this.Controls.Add(this.textBoxRoomNum);
            this.Controls.Add(this.textBoxName);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxName;
        private System.Windows.Forms.TextBox textBoxRoomNum;
        private System.Windows.Forms.TextBox textBoxPatientAge;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button buttonAddToList;
        private System.Windows.Forms.Button buttonLoad;
        private System.Windows.Forms.Button buttonSave;
        private System.Windows.Forms.Button buttonCompare;
        private System.Windows.Forms.TextBox textBoxAge;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label labelAgeResultHint;
        private System.Windows.Forms.Label labelAgeResult;
        private System.Windows.Forms.Button buttonRoomMax;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label labelRoomResult;
    }
}

