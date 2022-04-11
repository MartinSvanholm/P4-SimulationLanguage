package Main.TestElement;

import Visitors.TestVisitor.TestInspector;

public interface TestInterface {
    int accept(TestInspector inspector);
}
