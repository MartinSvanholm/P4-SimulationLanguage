package Visitors.TestVisitor;

import Main.TestElement.Element;

public interface TestInspector {
    int visit(Element element);
}
