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
public class IONode:Node{}public class Car:Vehicle{float direction;float brakeDistance = 10f;float speed;Road road;Road previousRoad;public Car(Road townRoad,Road countryRoad){direction = 1;road = townRoad;previousRoad = townRoad;speed = 50;}public override void Drive(){this.speed = this.road.speedLimit;this.position = this.position+this.speed;}public override void Brake(){this.speed = 0;}public override bool isClearToDrive(){bool result = true;return result;}public override bool isCarInFront(Car otherCar){Vehicle hej = new Car();float positionDiff = hej.position-this.position;if(positionDiff>0&&positionDiff<5){return true;}return false;}public override void newSpeedLimit(){if(this.road.speedLimit<this.previousRoad.speedLimit&&this.speed>this.road.speedLimit){this.speed = this.road.speedLimit;}}}public class TownRoad:Road{float speedLimit;public TownRoad(float speedLimit,float length,Node startNode,Node endNode){this.speedLimit = speedLimit;this.length = length;this.startNode = startNode;this.endNode = endNode;}}public class LandevejRoad:Road{float speedLimit;public LandevejRoad(float speedLimit,float length,Node startNode,Node endNode){this.speedLimit = speedLimit;this.length = length;this.startNode = startNode;this.endNode = endNode;}}abstract public class Node {public Node[] connections;}abstract public class Road {public float length;
public Node startNode;
public Node endNode;}abstract public class Vehicle {        public float length;
        public float acceleration;
        public List<Node> path;
public virtual void Drive(){}
public virtual void Brake(){}
public virtual bool isClearToDrive(){return null;}
public virtual bool isCarInFront(Car otherCar){return null;}
public virtual void newSpeedLimit(){}
}
    class Program {
        static void Main(string[] args) {
            Sim Simulation = new Sim();
Node startNode = new IONode();;Node endNode = new IONode();;Road townRoad = new TownRoad(50,1000,startNode,endNode);;Road countryRoad = new LandevejRoad(80,1000,startNode,endNode);;Node[] IONodes = new Node[] {startNode,endNode};;Node[] intersectionConnections = new Node[] {startNode,endNode};;Road[] roads = new Road[] {townRoad,countryRoad};;            Output output = new Output();

            while(!EndCondition()) {
                InitVehicles();
                foreach(Vehicle vehicle in Simulation.VehicleList) {switch(vehicle.Type){case "Car": if(vehicle.isClearToDrive()){vehicle.Drive();}else{vehicle.Break();} break;default:  break;}                    output.Run();

                }
                Simulation.CurrentTick++;
            }
            output.LogToFile();

            void InitVehicles() {if(Simulation.CurrentTick%5==0){Simulation.VehicleList = Simulation.VehicleList.Concat(new Vehicle[]{new Car(townRoad,countryRoad)}).ToArray();}            }

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