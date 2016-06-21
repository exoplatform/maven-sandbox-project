package org.exoplatform.swf.sandbox.components.logging;

import static org.junit.Assert.*;


public class HelloWorldTest {


  @org.junit.Test
  public void getMessage() throws Exception {

    HelloWorld hl = new HelloWorld();

    assertNotNull(hl.getMessage());
    assertEquals("Hello World", hl.getMessage());

  }

}
