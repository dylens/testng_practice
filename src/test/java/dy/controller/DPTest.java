package dy.controller;

import dy.DetectAnagrams;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPTest {

    DetectAnagrams detector = new DetectAnagrams();

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][]{
                {"diaper", "hello world zombies pants", new String[]{}},
                {"ant", "tan stand at", new String[]{"tan"}},
                {"master", "stream pigeon maters", new String[]{"stream", "maters"}},
                {"galea", "eagle", new String[]{}},
                {"good", "dog goody", new String[]{}},
                {"listen", "enlists google inlets banana", new String[]{"inlets"}},
                {"Orchestra", "cashregister Carthorse radishes", "Carthorse"},
                {"go", "go Go GO", new String[]{}}
        };
    }

    @Test(dataProvider = "test1")
    public void testDP(String target, String input, String[] actual) {
        Assert.assertEquals(detector.detect(target, input), actual);
    }

}
