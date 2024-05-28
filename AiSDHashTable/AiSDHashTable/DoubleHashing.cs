using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AiSDHashTable
{
    class DoubleHashing
    {
        private int size;
        private string[] keys;
        private string[] values;

        public DoubleHashing(int size)
        {
            this.size = size;
            keys = new string[size];
            values = new string[size];
        }

        private int HashFunction1(string key)
        {

            return key.Length % size;
        }

        private int HashFunction2(string key)
        {
            return 7 - (key.Length % 7);
        }

        public void Add(string key, string value)
        {
            int index = HashFunction1(key);
            int step = HashFunction2(key);
            int i = 1;

            while (keys[index] != null)
            {
                index = (index + i * step) % size;
                i++;
            }

            keys[index] = key;
            values[index] = value;
        }

        public string Get(string key)
        {
            int index = HashFunction1(key);
            int step = HashFunction2(key);
            int i = 1;

            while (keys[index] != null)
            {
                if (keys[index] == key)
                    return values[index];

                index = (index + i * step) % size;
                i++;
            }

            return null;
        }
    }
}
