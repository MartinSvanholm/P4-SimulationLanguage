package Main.TestElement;

import Visitors.TestVisitor.TestInspector;

public class Element implements TestInterface {

    int num = 0;

    public Element(int num){
        this.num = num;
    }

    public int getInt(){
        return num+1;
    }

    @Override
    public int accept(TestInspector inspector) {
        return inspector.visit(this);
    }
}
