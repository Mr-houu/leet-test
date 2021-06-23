package com.hy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("------解决分支测试 -- 手动修改+idea修改");
        System.out.println("----hytest");
        String s = null;
        Map<Character, Integer> map = null;
        Arrays.fill(args,"");
        List l = new ArrayList();
        l.stream().distinct().collect(Collectors.toList());
    }

}
