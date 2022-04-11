package Visitors.TestVisitor;

import Main.TestElement.Element;

public class Inspection implements TestInspector{
    @Override
    public int visit(Element element) {
        return element.getInt();
    }
}
