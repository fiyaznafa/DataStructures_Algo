package arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharactersTest {

    @Test
    public void test1(){
        String[] words = {"bella","label","roller"};
        System.out.println(commonChar(words));
    }

    @Test
    public void test2(){
        String[] words = {"cool","lock","cook"};
        System.out.println(commonChar(words));
    }

    private List<String> commonChar(String[] words) {
        Map<Character,Integer> initialMap = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            initialMap.put(words[0].charAt(i),initialMap.getOrDefault(words[0].charAt(i),0)+1);
        }
        Map<Character,Integer> tempMap = new HashMap<>();
        for (int i = 1; i < words.length ; i++) {
            tempMap.clear();
            for(int j=0;j<words[i].length();j++){
                char c=words[i].charAt(j);
                if(initialMap.containsKey(c))
                    tempMap.put(c,Math.min(initialMap.get(c),tempMap.getOrDefault(c,0)+1));
            }
            initialMap.clear();
            initialMap.putAll(tempMap);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry:initialMap.entrySet()) {
            for (int i = 0; i <entry.getValue() ; i++) {
                list.add(String.valueOf(entry.getKey()));
            }
        }
        return list;
    }
}
