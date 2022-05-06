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

    class Program {
        static void Main(string[] args) {
            List<Vehicle> vehicleList = new List<Vehicle>();
            List<Node> nodeList = InitNodes();
            List<Road> roadList = InitRoads();
            Output output = new Output();

            int tick = 0;

            while(!EndCondition()) {
                vehicleList = InitVehicles(vehicleList);
                foreach(Vehicle vehicle in vehicleList) {
                    output.Run();

                }
                tick++;
            }
            output.LogToFile();
            List<Node> InitNodes() {            }
        }public class Car:Vehicle{float x = 1f;float y;public float Square(float x){return x*x;}public float DinMor(){return 3;}public float InLineFunc(float x){float y = 2f;Square(x)+yx+yy = Square(x)+y;return Square(x)+x;}public void IfElseTest(){bool  testBool = true;bool  testBool2 = true;string  str;if(testBool==true){str = "If";}else if(testBool2==true){str = "Else";}else{str = "Else";}}public void WhileTest(){bool  testBool = true;while(testBool==true){Print("xd");}}public void IndexTest(){ListDcl; float x = numList[1];}public Car(){this.length = 10;this.acceleration = 200;}}public class IONode:Node{public IONode(List<Node> connections){this.connections = connections;}public IONode(){}}public class TownRoad:Road{float speedLimit;public TownRoad(float speedLimit,float length,Node startNode,Node endNode){this.speedLimit = speedLimit;this.length = length;this.startNode = startNode;this.endNode = endNode;}}        public class Output {
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