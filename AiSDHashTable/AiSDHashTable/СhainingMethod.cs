using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AiSDHashTable
{
    class СhainingMethod
    {
        private int size;
        private List<KeyValuePair<string, string>>[] table;

        public СhainingMethod(int size)
        {
            this.size = size;
            table = new List<KeyValuePair<string, string>>[size];
            for (int i = 0; i < size; i++)
            {
                table[i] = new List<KeyValuePair<string, string>>();
            }
        }

        private int HashFunction(string key)
        {
            return key.Length % size;
        }

        public void Add(string key, string value)
        {
            int index = HashFunction(key);
            table[index].Add(new KeyValuePair<string, string>(key, value));
        }

        public string Get(string key)
        {
            int index = HashFunction(key);
            foreach (var pair in table[index])
            {
                if (pair.Key == key)
                    return pair.Value;
            }
            return null; 
        }
    }
}
