package cs2.adt

import org.junit._
import org.junit.Assert._

class DequeTester {
  //Include your thorough tester code here, including @Begin and @Test methods
  //and any fields needed for testing
  var empty:Deque[Int] = Deque[Int]()
  var oneNode:Deque[Int] = Deque[Int]()
  var twoNodeA:Deque[Int] = Deque[Int]()
  var twoNodeP:Deque[Int] = Deque[Int]()
  var threeNodeA:Deque[Int] = Deque[Int]()
  var threeNodeP:Deque[Int] = Deque[Int]()

  @Before def init():Unit = {
    empty = Deque[Int]()
    oneNode = Deque[Int]()
    oneNode.append(1)
    twoNodeA = Deque[Int]()
    twoNodeA.append(1)
    twoNodeA.append(2)
    twoNodeP = Deque[Int]()
    twoNodeP.prepend(1)
    twoNodeP.prepend(2)
    threeNodeA = Deque[Int]()
    threeNodeA.append(1)
    threeNodeA.append(2)
    threeNodeA.append(3)
    threeNodeP = Deque[Int]()
    threeNodeP.prepend(1)
    threeNodeP.prepend(2)
    threeNodeP.prepend(3)
  }

  @Test def GIVEN_newDQ_WHEN_isEmpty_returnsTrue():Unit = {
    assertTrue(empty.isEmpty())
  }

  @Test def GIVEN_NewDQ_WHEN_peekFront_THEN_Exception():Unit = {
    try {
      empty.peekFront()
    }
    catch{
      case _:RuntimeException => return
    }

    fail("Expected RuntimeException")

    
  }

  @Test def GIVEN_NewDQ_WHEN_peekBack_THEN_Exception():Unit = {
    try {
      empty.peekBack()
    }
    catch{
      case _:RuntimeException => return
    }

    fail("Expected RuntimeException")

    
  }

  @Test def GIVEN_NewDQ_WHEN_back_THEN_Exception():Unit = {
    try {
      empty.back()
    }
    catch{
      case _:RuntimeException => return
    }

    fail("Expected RuntimeException")

    
  }

  @Test def GIVEN_NewDQ_WHEN_front_THEN_Exception():Unit = {
    try {
      empty.front()
    }
    catch{
      case _:RuntimeException => return
    }

    fail("Expected RuntimeException")

    
  }

  @Test def GIVEN_NewDQ_WHEN_append_THEN_notEmpty():Unit = {
    empty.append(1)
    assertFalse(empty.isEmpty())
  }

  @Test def GIVEN_NewDQ_WHEN_prepend_THEN_notEmpty():Unit = {
    empty.prepend(1)
    assertFalse(empty.isEmpty())
  }

  @Test def GIVEN_oneNode_WHEN_checkLength_THEN_length1():Unit = {
    assertEquals(1, oneNode.length())
  }

  @Test def GIVEN_twoNodeA_WHEN_Length_THEN_two():Unit = {
    assertEquals(2, twoNodeA.length)
  }

  @Test def GIVEN_twoNodeA_WHEN_peekFront_THEN_one():Unit = {
    assertEquals(1, twoNodeA.peekFront())
  }

  @Test def GIVEN_twoNodeA_WHEN_peekBack_THEN_two():Unit = {
    assertEquals(2, twoNodeA.peekBack())
  }

  @Test def GIVEN_twoNodeP_WHEN_peekFront_THEN_two():Unit = {
    assertEquals(2,twoNodeP.peekFront())
  }
  @Test def GIVEN_twoNodeP_WHEN_peekBack_THEN_one():Unit = {
    assertEquals(1, twoNodeP.peekBack())
  }

  @Test def GIVEN_twoNodeP_WHEN_Length_THEN_two():Unit = {
    assertEquals(2, twoNodeP.length())
  }

  @Test def GIVEN_twoNodeA_WHEN_isEmpty_Then_False():Unit = {
    assertFalse(twoNodeA.isEmpty())
    assertFalse(twoNodeP.isEmpty())
  }


  @Test def GIVEN_threeNodeA_WHEN_Length_THEN_three():Unit = {
    assertEquals(3, threeNodeA.length())
  }

  @Test def GIVEN_threeNodeA_WHEN_peekFront_THEN_one():Unit = {
    assertEquals(1, threeNodeA.peekFront())
  }
  @Test def GIVEN_threeNodeA_WHEN_peekBack_THEN_three():Unit = {
    assertEquals(3, threeNodeA.peekBack())
  }

  @Test def GIVEN_threeNode_WHEN_FrontBack_THEN_check():Unit = {
  assertEquals(1, threeNodeA.front())
  assertEquals(3, threeNodeA.back())
  assertEquals(3, threeNodeP.front())
  assertEquals(1, threeNodeP.back())
  }

  @Test def GIVEN_threeNode_WHEN_3Front_THEN_length0():Unit = {
    assertEquals(1,threeNodeA.front())
    assertEquals(2,threeNodeA.front())
    assertEquals(3,threeNodeA.front())
    assertEquals(3, threeNodeP.front())
    assertEquals(2, threeNodeP.front())
    assertEquals(1, threeNodeP.front())
    assertEquals(0, threeNodeA.length())
    assertEquals(0, threeNodeP.length())
  }

  @Test def GIVEN_threeNode_WHEN_3Back_THEN_length0():Unit = {
    assertEquals(3,threeNodeA.back())
    assertEquals(2,threeNodeA.back())
    assertEquals(1,threeNodeA.back())
    assertEquals(1, threeNodeP.back())
    assertEquals(2, threeNodeP.back())
    assertEquals(3, threeNodeP.back())
    assertEquals(0, threeNodeA.length())
    assertEquals(0, threeNodeP.length())
  }

  @Test def GIVEN_threeNode_WHEN_3BackFRONT_THEN_length0():Unit = {
    assertEquals(3, threeNodeA.back)
    assertEquals(1, threeNodeA.front())
    assertEquals(2, threeNodeA.front())
    assertEquals(1, threeNodeP.back())
    assertEquals(3, threeNodeP.front())
    assertEquals(2, threeNodeP.back())
    assertTrue(threeNodeA.isEmpty())
    assertTrue(threeNodeP.isEmpty())
  }

  @Test def GIVEN_threeNodeA_WHEN_4Front_THEN_Exception():Unit = {
    try {
      threeNodeA.front()
      threeNodeA.front()
      threeNodeA.front()
      threeNodeA.front()
    }
    catch{
      case _:RuntimeException => return
    }

    fail("Expected RuntimeException")

    
  }



  @Test def GIVEN_threeNodeP_WHEN_4Front_THEN_Exception():Unit = {
    try {
      threeNodeP.front()
      threeNodeP.front()
      threeNodeP.front()
      threeNodeP.front()
    }
    catch{
      case _:RuntimeException => return
    }

    fail("Expected RuntimeException")

    
  }
}

