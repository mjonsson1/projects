package cs2.adt

import org.junit._
import org.junit.Assert._

class DEPQTester {
  //Include your thorough tester code here, including @Begin and @Test methods
  //and any fields needed for testing
    
  var empty:DEPQ[Int] = new DEPQ[Int]() 
  var addOne:DEPQ[Int] = new DEPQ[Int]()
  var addTwo:DEPQ[Int] = new DEPQ[Int]()
  var addThree:DEPQ[Int] = new DEPQ[Int]()
  var addThreeOutOfOrder:DEPQ[Int] = new DEPQ[Int]()
  


  @Before def init():Unit = {
    empty = new DEPQ[Int]()
    addOne = new DEPQ[Int]()
    addOne.add(1)
    addTwo = new DEPQ[Int]()
    addTwo.add(1)
    addTwo.add(2)
    addThree = new DEPQ[Int]()
    addThree.add(1)
    addThree.add(2)
    addThree.add(3)
    addThreeOutOfOrder = new DEPQ[Int]()
    addThreeOutOfOrder.add(2)
    addThreeOutOfOrder.add(1)
    addThreeOutOfOrder.add(3)
  }


  @Test def GIVEN_empty_WHEN_isEmpty_THEN_True():Unit  = {
    assertTrue(empty.isEmpty())
  }


  @Test def GIVEN_addOne_WHEN_isEmpty_THEN_False():Unit = {
    assertFalse(addOne.isEmpty())
  }

  @Test def GIVEN_addTwo_WHEN_isEmpty_THEN_False():Unit = {
    assertFalse(addTwo.isEmpty())
  }


  @Test def GIVEN_addTwo_WHEN_peekMax_THEN_2():Unit = {
    assertEquals(2,addTwo.peekMax()) 
  }

  @Test def GIVEN_addTwo_WHEN_peekMin_THEN_1():Unit = {
    assertEquals(1,addTwo.peekMin()) 
  }

  @Test def GIVEN_addThree_WHEN_peekMax_THEN_3():Unit = {
    assertEquals(3, addThree.peekMax())
  }
  @Test def GIVEN_addThree_WHEN_peekMin_THEN_3():Unit = {
    assertEquals(1,addThree.peekMin())
  }
  @Test def GIVEN_addThreeOutOfOrder_WHEN_peekMax_THEN_3():Unit = {
    assertEquals(3, addThreeOutOfOrder.peekMax())
  }
  @Test def GIVEN_addThreeOutOfOrder_WHEN_peekMin_THEN_3():Unit = {
    assertEquals(1,addThreeOutOfOrder.peekMin())
  }

  @Test def GIVEN_empty_WHEN_Max_THEN_Exception():Unit  = {
    try {
      empty.max()
    }
    catch{
      case _:RuntimeException => return
    }

    fail("Expected RuntimeException")

  }

  @Test def GIVEN_addOne_WHEN_max_THEN_1():Unit = {
    assertEquals(1, addOne.max())
    assertTrue(addOne.isEmpty())
  }

  @Test def GIVEN_addTwo_WHEN_max_THEN_2():Unit = {
    assertEquals(2, addTwo.max())
  }

  @Test def GIVEN_addThree_WHEN_max_THEN_3():Unit = {
    assertEquals(3, addThree.max())
    assertEquals(2, addThree.max())
    assertEquals(1,addThree.max())
    assertTrue(addThree.isEmpty())
  }

   @Test def GIVEN_addThreeOutOfOrder_WHEN_max_THEN_3():Unit = {
    assertEquals(3, addThreeOutOfOrder.max())
    assertEquals(2, addThreeOutOfOrder.max())
    assertEquals(1, addThreeOutOfOrder.max())
    assertTrue(addThreeOutOfOrder.isEmpty())
  }

  @Test def GIVEN_addThreeOutOfOrder_WHEN_min_THEN_3():Unit = {
    assertEquals(1, addThreeOutOfOrder.min())
    assertEquals(2, addThreeOutOfOrder.min())
    assertEquals(3, addThreeOutOfOrder.min())
    assertTrue(addThreeOutOfOrder.isEmpty())
  }


  @Test def GIVEN_addThreeOutOfOrder_WHEN_minmax_THEN_3():Unit = {
    assertEquals(1, addThreeOutOfOrder.min())
    assertEquals(3, addThreeOutOfOrder.max())
    assertEquals(2, addThreeOutOfOrder.min())
    assertTrue(addThreeOutOfOrder.isEmpty())
  }
}
