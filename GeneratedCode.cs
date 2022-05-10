using System;
using System.Collections.Generic;

namespace CodeGenTest {
    abstract public class Node {
        public List<Node> connections;
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
public class Car:Vehicle{float x = 1f;float y;public float Square(float x){return x*x;}public float DinMor(){return 3;}public float InLineFunc(float x){float y = 2f;Square(x)+y;x+y;y = Square(x)+y;return Square(x)+x;}public void IfElseTest(){bool testBool = true;bool testBool2 = true;string str;if(testBool==true){str = "If";}else if(testBool2==true){str = "Else";}}public void SwitchTest(){float testNum = 2f;string str;switch(testNum){case 1:  break;case 2:  break;}}public void WhileTest(){bool testBool = true;while(testBool==true){Print("xd");}}public void IndexTest(){ListDcl; float x = numList[1];}public Car(){this.length = 10;this.acceleration = 200;}}public class Truck:Vehicle{string name;public Truck(string name){this.length = 30;this.acceleration = 100;this.name = name;}}public class IONode:Node{public IONode(){}}public class TownRoad:Road{float speedLimit;public TownRoad(float speedLimit,float length,Node startNode,Node endNode){this.speedLimit = speedLimit;this.length = length;this.startNode = startNode;this.endNode = endNode;}}
    class Program {
        static void Main(string[] args) {
            List<Vehicle> vehicleList = new List<Vehicle>();
            List<Node> nodeList = InitNodes();
            List<Road> roadList = InitRoads();
            Output output = new Output();

            int CurrentTick = 0;

            while(!EndCondition()) {
                vehicleList = InitVehicles(vehicleList);
                foreach(Vehicle vehicle in vehicleList) {                    output.Run();

                }
                CurrentTick++;
            }
            output.LogToFile();
            List<Node> InitNodes() {IONode NodeOne = new IONode()ListDcl; IONode NodeTwo = new IONode()NodeTwo.connections = tempConnections;tempConnections.Remove(0)tempConnections.Add(NodeTwo)NodeOne.connections = tempConnections;NodeTwo = NodeOne;            }
            
            List<Road> InitRoads() {ListDcl; NodeTwo.connections = tempConnections;tempConnections.Remove(0)tempConnections.Add(NodeTwo)NodeOne.connections = tempConnections;NodeTwo = NodeOne;TownRoad RoadOne = new TownRoad(50,500,NodeOne,NodeTwo)            }

            List<Vehicle> InitVehicles(List<Vehicle> Vehicles) {if(CurrentTick%5==0){Vehicles.Add(new Car());}if(CurrentTick%10==0){Vehicles.Add(new Truck("Tonni"));}                return vehicleList;
            }

            bool EndCondition() {return CurrentTick>100;            }
        }
        
        public class Output {
            public string fileName = DateTime.Now.ToString(); //Foreslag
            public List<string> dataList = new();

            public void Run() {
                string data = "";Output.Log("EKS");                dataList.Add(data);
        }

            public void LogToFile() {
                //Logic der logger "dataList" listen til en fil med navn "fileName"
            }
        }
    }
}