package com.young.devops.platform;

import com.young.devops.platform.testdouble.JavaDocTestDouble;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test for JavaDocReader class.
 * JavaDocReader class is used to read javadoc on class, method, properties.
 */
@SpringBootTest
class JavaDocReaderTests {

    JavaDocReader javaDocReader;

    JavaDocTree javaDocTreeExpected;

    @BeforeEach
    void beforeTest() {
        javaDocReader = new JavaDocReader();
        javaDocTreeExpected = new JavaDocTree();
        javaDocTreeExpected.rootNode = new JavaDocTree.ClassNode();
        javaDocTreeExpected.rootNode.name = "JavaDocTestDouble";
        javaDocTreeExpected.rootNode.javadoc = "/**\n" +
                " * This is a javadoc test data\n" +
                " */";
    }

    @Test
    void should_read_java_doc_on_class() {

        JavaDocTree javaDocTree = javaDocReader.readClass(JavaDocTestDouble.class);
        Assertions.assertEquals(javaDocTreeExpected.rootNode.name, javaDocTree.rootNode.name);;
        Assertions.assertEquals(javaDocTreeExpected.rootNode.javadoc, javaDocTree.rootNode.javadoc);;

    }
}
