package com.flipkart.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String args[]){
        // add operations
        List<String> al = new ArrayList<>();
        System.out.println("Initial size of al:"+al.size());
        al.add("Mumbai");
        al.add("Delhi");
        al.add("Bangalore");
        System.out.println("Final size of al:"+al.size());

        // remove operations can be performed by telling index
        al.remove(0);
        System.out.println("Size: "+al.size());
        //al.remove("Delhi");
        //System.out.println("Size: "+al.size());

        // Listing
        // Iterable interface

        // Iterator is interface which is using to iterate the Collection
        Iterator<String> i=al.iterator();
        while(i.hasNext()){

            String test=i.next();
            System.out.println("details of Capital------>" +test);
        }

        // Another way to iterate the collection using for loop

        // Loop through elements.
        for (String value : al) {
            System.out.println("Element: " + value);
        }
    }
}
