import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

class LongerThan3 implements StringChecker{

  public boolean checkString(String s){
    if(s.length()>3){
      return true;
    }
    return false;
  }
}
public class TestListExamples {
  // Write your grading tests here!

@Test
public void testFilter(){
  ArrayList <String> list = new ArrayList<>();
    list.add("apple");
    list.add("a");
    list.add("banana");
    list.add("b");
    ArrayList <String> expected = new ArrayList<>();
    expected.add("apple");
    expected.add("banana");
    
    StringChecker sc = new LongerThan3();
    

    assertEquals(expected, ListExamples.filter(list,sc));
}

@Test
public void testMerge(){
   ArrayList <String> list = new ArrayList<>();
    ArrayList <String> list2 = new ArrayList<>();
    list.add("apple");
    list.add("b");
    list.add("banana");
    list2.add("cat");
    list2.add("donkey");
    list2.add("elephant");
    list2.add("h");
    ArrayList<String> expected = new ArrayList<>();
    expected.add("apple");
    expected.add("b");
    expected.add("banana");
    expected.add("cat");
    expected.add("donkey");
    expected.add("elephant");
    expected.add("h");
    
    assertEquals(expected, ListExamples.merge(list,list2));
}

}
