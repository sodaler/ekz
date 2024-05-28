using AiSDHashTable;
using System;
using System.Collections;

class Program
{
    static void Main(string[] args)
    {
        DoubleHashing double_hashtable = new DoubleHashing(10);
        double_hashtable.Add("apple", "яблоко");
        double_hashtable.Add("banana", "банан");
        double_hashtable.Add("cherry", "вишня");


        Console.WriteLine("DoubleHashing: ");
        Console.WriteLine(double_hashtable.Get("apple")); // Выводит "яблоко"
        Console.WriteLine(double_hashtable.Get("banana")); // Выводит "банан"
        Console.WriteLine(double_hashtable.Get("cherry")); // Выводит "вишня"
        Console.WriteLine(double_hashtable.Get("orange")); // Выводит null, так как "orange" не добавлен

        СhainingMethod chain_hashtable = new СhainingMethod(10);
        chain_hashtable.Add("train", "поезд");
        chain_hashtable.Add("airplane", "самолёт");
        chain_hashtable.Add("car", "машина");

        Console.WriteLine("СhainingMethod: ");
        Console.WriteLine(chain_hashtable.Get("train")); // Выводит "поезд"
        Console.WriteLine(chain_hashtable.Get("airplane")); // Выводит "самолёт"
        Console.WriteLine(chain_hashtable.Get("car")); // Выводит "машина"
        Console.WriteLine(chain_hashtable.Get("bike")); // Выводит null, так как "bike" не добавлен
    }
}
