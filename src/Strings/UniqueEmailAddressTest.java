package Strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddressTest {

    @Test
    public void test1(){
        String[] emails ={"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
         Assert.assertEquals(2, noUniqueEmail(emails));
    }

    @Test
    public void test2() {
        String[] emails = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
        Assert.assertEquals(3, noUniqueEmail(emails));
    }


    @Test
    public void test3(){
        String[] emails={"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        Assert.assertEquals(2, noUniqueEmail(emails));
    }

    private int noUniqueEmail(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email:emails) {
            set.add(uniqueEmail(email));
        }
        return set.size();
    }

    private String uniqueEmail(String email) {
        String[] splitEmail = email.split("@");
        StringBuilder sb = new StringBuilder();

        //removing the plus character if any.
        String[] localName = splitEmail[0].split("\\+");
        sb.append(localName[0].replaceAll("\\.",""));
        sb.append("@");
        sb.append(splitEmail[1]);
        return sb.toString();
    }
}
