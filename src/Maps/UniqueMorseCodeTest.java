package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeTest {

    @Test
    public void test1(){
      String[] words={"gin","zen","gig","msg"};
        Assert.assertEquals(2,uniqueMorseCode(words));
    }

    @Test
    public void test3(){
        String[] words={"a"};
        Assert.assertEquals(1,uniqueMorseCode(words));
    }

    /*
        Pseudocode
        1. Put all morse code of each character in map
        2. Find the morse code transformation of each word
        3. Add the transformation to set
        4. Return the set
     */

    private int uniqueMorseCode(String[] words) {
        Set<String> set = new HashSet<>();
        for (String eachWord:words) {
            set.add(morseCode(eachWord));
        }
        return set.size();
    }

    private String morseCode(String eachWord) {
        StringBuilder sb = new StringBuilder();
        Map<Character,String> map = new HashMap<>();
        map.put('a',".-");
        map.put('b',"-...");
        map.put('c',"-.-.");
        map.put('d',"-..");
        map.put('e',".");
        map.put('f',"..-.");
        map.put('g',"--.");
        map.put('h',"....");
        map.put('i',"..");
        map.put('j',".---");
        map.put('k',"-.-");
        map.put('l',".-..");
        map.put('m',"--");
        map.put('n',"-.");
        map.put('o',"---");
        map.put('p',".--.");
        map.put('q',"--.-");
        map.put('r',".-.");
        map.put('s',"...");
        map.put('t',"-");
        map.put('u',"..-");
        map.put('v',"...-");
        map.put('w',".--");
        map.put('x',"-..-");
        map.put('y',"-.--");
        map.put('z',"--..");

        for (char c:eachWord.toCharArray()) {
            sb.append(map.get(c));
        }
        return  sb.toString();
    }
}
