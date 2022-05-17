using System;
using System.Collections.Generic;
using System.Linq;

namespace CodeGenTest {

    public class Sim {
        public int CurrentTick;
        public Node[] NodeList = new Node[] { };
        public Road[] RoadList = new Road[] { };
        public Vehicle[] VehicleList = new Vehicle[] { };
    }

    /*abstract public class Node {
        public Node[] connections;
    }

    abstract public class Vehicle {
        public float length;
        public float acceleration;
        public List<Node> path;

        public List<Node> Pathfinding() {
            return new List<Node>();
        }
    }

    abstract public class Road {
        public float length;
        public Node startNode;
        public Node endNode;
    }

    */
    class Program {
        static void Main(string[] args) {
            Sim Simulation = new Sim();
            //Output output = new Output();

            while(Simulation.CurrentTick < 100) {
                //InitVehicles();
                //foreach(Vehicle vehicle in Simulation.VehicleList) {Console.WriteLine("Poggers");;                    output.Run();

                //}
                Simulation.CurrentTick++;
            }
            /*output.LogToFile();

            void InitVehicles() {            }

            bool EndCondition() {            } */
        }
        /*
        public class Output {
            public string fileName = DateTime.Now.ToString(); //Foreslag
            public List<string> dataList = new List<string>();

            public void Run() {
                string data = "";;                dataList.Add(data);
        }

            public void LogToFile() {
                //Logic der logger "dataList" listen til en fil med navn "fileName"
            }
        }*/
    }
}