/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS_project;

import java.util.List;

/**
 *
 * @author srina
 */


/*
Abstract data structure-ConsSet also known as an immutable Binary Search Tree
Using This Adt our Cdt will work.
*/

public abstract class ConsSet<T> {
    int hash;
    int parentHash;
    public abstract boolean has(T key);
    public abstract ConsSet<T> add(T key); 

   public abstract List<String> hashLeft(int a);
   public abstract List<String> hash();
   public abstract int size();
   public abstract int height();
   public abstract List<String> toList();
   public abstract String Roothash(List a);
   public abstract void merkle_tree(String root,List txList);
}
