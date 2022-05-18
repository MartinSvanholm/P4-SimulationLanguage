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

    /*
    abstract public class Node {
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
    } */
public class Car:Vehicle{float x = 1f;float y;public override float Square(float x){return x*x;}public override float DinMor(){return 3;}public override float InLineFunc(float x){float y = 2f;x = Square(x)+y;x = Square(Square(x));y = x+y;y = Square(x)+y;return Square(x)+x;}public override void IfElseTest(){bool testBool = true;bool testBool2 = true;string str;if(testBool==true){str = "If";}else if(testBool2==true){str = "Else";}else{str = "Else";}}public override void SwitchTest(){float testNum = 2f;string str;switch(testNum){case 1: str = "Kasse"; break;case 2: str = "Kasse"; break;default: str = "DenSidste"; break;}}public override void WhileTest(){bool testBool = true;bool testBool2 = true;while(testBool==true ||testBool2==true){Console.WriteLine("xddinmor");;}}public override void IndexTest(){float[] numList = new float[] {1,2,3};numList = numList.Concat(new float[]{4}).ToArray();float x = numList[1];}public override void Potens(){float x = (float)Math.Pow(2,8);}public Car(){this.length = 10;this.acceleration = 200;}}public class Truck:Vehicle{string name;public Truck(string name){this.length = 30;this.acceleration = 100;this.name = name;}}public class IONode:Node{public IONode(){}}public class TownRoad:Road{float speedLimit;public TownRoad(float speedLimit,float length,Node startNode,Node endNode){this.speedLimit = speedLimit;this.length = length;this.startNode = startNode;this.endNode = endNode;}}abstract public class Node {public Node[] connections;}abstract public class Road {public float length;
public Node startNode;
public Node endNode;}abstract public class Vehicle {        public float length;
        public float acceleration;
        public List<Node> path;
public virtual float Square(float x){return 0f;}
public virtual float DinMor(){return 0f;}
public virtual float InLineFunc(float x){return 0f;}
public virtual void IfElseTest(){}
public virtual void SwitchTest(){}
public virtual void WhileTest(){}
public virtual void IndexTest(){}
public virtual void Potens(){}
}
    class Program {
        static void Main(string[] args) {
            Sim Simulation = new Sim();
IONode NodeOne = new IONode();;IONode[] tempConnections = new IONode[] {NodeOne};;IONode NodeTwo = new IONode();;NodeTwo.connections = tempConnections;;tempConnections = tempConnections.Where((source, index) => index != 0).ToArray();tempConnections = tempConnections.Concat(new IONode[]{NodeTwo}).ToArray();NodeOne.connections = tempConnections;;NodeTwo = NodeOne;;Simulation.NodeList = Simulation.NodeList.Concat(new Node[]{NodeOne}).ToArray();Simulation.NodeList = Simulation.NodeList.Concat(new Node[]{NodeTwo}).ToArray();TownRoad RoadOne = new TownRoad(50,500,NodeOne,NodeTwo);;            Output output = new Output();

            while(!EndCondition()) {
                InitVehicles();
                foreach(Vehicle vehicle in Simulation.VehicleList) {string[] tempArr = vehicle.GetType().ToString().Split("."); 
string type = tempArr[tempArr.Length - 1]; 
switch(type){case "Car": Console.WriteLine(vehicle.Square(Simulation.CurrentTick));; break;default: Console.WriteLine("Bling");; break;}                    output.Run();

                }
                Simulation.CurrentTick++;
            }
            output.LogToFile();

            void InitVehicles() {if(Simulation.CurrentTick%5==0){Simulation.VehicleList = Simulation.VehicleList.Concat(new Vehicle[]{new Car()}).ToArray();}if(Simulation.CurrentTick%10==0){Simulation.VehicleList = Simulation.VehicleList.Concat(new Vehicle[]{new Truck("Tonni")}).ToArray();}            }

            bool EndCondition() {return Simulation.CurrentTick>100;            }
        }
        
        public class Output {
            public string fileName = DateTime.Now.ToString(); //Foreslag
            public List<string> dataList = new List<string>();

            public void Run() {
                string data = "";                dataList.Add(data);
        }

            public void LogToFile() {
                //Logic der logger "dataList" listen til en fil med navn "fileName"
            }
        }
    }
}