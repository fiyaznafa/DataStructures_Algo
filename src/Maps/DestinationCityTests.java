package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class DestinationCityTests {

    @Test
    public void test1(){
       List<List<String>>  paths = new ArrayList<>();
       List<String> l1 = new ArrayList<>();
       l1.add("London");
        l1.add("New York");
        List<String> l2 = new ArrayList<>();
        l2.add("New York");
        l2.add("Lima");
        List<String> l3 = new ArrayList<>();
        l3.add("Lima");
        l3.add("Sao Paulo");
        paths.add(l1);
        paths.add(l2);
        paths.add(l3);
        Assert.assertEquals("Sao Paulo",destinationCity(paths));
    }

    @Test
    public void test2(){
        List<List<String>>  paths = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("B");
        l1.add("C");
        List<String> l2 = new ArrayList<>();
        l2.add("D");
        l2.add("B");
        List<String> l3 = new ArrayList<>();
        l3.add("C");
        l3.add("A");
        paths.add(l1);
        paths.add(l2);
        paths.add(l3);
        Assert.assertEquals("A",destinationCity(paths));
    }


    private String destinationCityUsingList(List<List<String>> paths) {
        List<String> list = new ArrayList<>();
        for (List<String> eachPath:paths) list.add(eachPath.get(1));
        for (List<String> eachPath:paths) list.remove(eachPath.get(0));
        return list.get(0);
    }

    private String destinationCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> eachPath:paths) set.add(eachPath.get(1));
        for (List<String> eachPath:paths) set.remove(eachPath.get(0));
        return set.iterator().next();
    }

}
