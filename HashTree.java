package DS_project;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author srina
 */
public class HashTree<T extends Comparable<T>> extends ConsSet<T>{
T key;
ConsSet<T> Left=getEmpty();
ConsSet<T> Right=getEmpty();
String root;
List<String> txList;
List<String> HashChain=new ArrayList<String>();

static ConsSet<Comparable<Object>> Empty = new 	ConsSet<Comparable<Object>>(){
    @Override
    public boolean has(Comparable<Object> key) {
        return false;
    }
    
    @Override
    public ConsSet add(Comparable<Object> key) {
        return new HashTree(this,key,this);        
    }
    
    @Override
    public String toString(){ return "";}
    @Override
    public List<String> hashLeft(int ParentHash){
        
        return Collections.EMPTY_LIST;
    }
   
    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
    return 0;    
    }
   
    
    @Override
    public List<String> toList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public String Roothash(List a) {
        return "";
    }

    @Override
    public List<String> hash() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void merkle_tree(String root,List txList) {
       
    }

   
    
}; 
    public ConsSet getEmpty()
	{
	return (ConsSet) Empty;
	}
    public HashTree(ConsSet<T> l,T k,ConsSet<T> r){
        key=k;
        Left=l;
        Right=r;
             
    } 
    @Override
    /*
    To check whether an element exists inside the set
    */
    public boolean has(T k) {
        if(k.compareTo(key)<0)  return Left.has(k);
       
        else if(k.compareTo(key)>0) return Right.has(k);
        return true;    
    }

    @Override
    /*
    To add an element to our set and to also check whether the element already exists to preserve the property of a set
    */
    public ConsSet<T> add(T k) {
        
       if(k.compareTo(key)<0) {
          
          
           return new HashTree(Left.add(k),key,Right);
       }
       else if(k.compareTo(key)>0){
           

           return new HashTree(Left,key,Right.add(k));
       }
       
       return this ; 
    }
    /*
    To print the contents of The Bst
    */
    @Override
    public String toString(){
        //System.out.println('('+Left.toString()+","+key+","+Right.toString()+')');
        return Left.toString()+" "+key+Right.toString();
        
    }
    /*
    to get the size of the set
    */
    @Override
    public int size() {
    return 1 + Left.size() + Right.size();
    }
    @Override
    /* 
    to get the height of the tree
    */
    public int height() {
    return 1 + Math.max(Left.height(), Right.height());
    }
    @Override
    /*
    function to initialize our iteration
    */
    public List<String> hash(){
    parentHash=String.valueOf(key).hashCode();
    List<String> HashChain=hashLeft(parentHash);
    return HashChain;
    
}

    @Override
    /*
    Pseudo Code:
    Iteration->
    Parent hash- hash(parent data)
    Child hash-hash(stringof(parent hash+ child data))
    Parent hash=child hash
    */
    public List<String> hashLeft(int parentHash){
    String a;
    hash=parentHash;
   // System.out.println(key+"-"+hash);
    a=key+"-"+hash;
     HashChain.add(key+"-"+hash);
    hash=(String.valueOf(this.hash)+String.valueOf(key)).hashCode();
   
    parentHash=hash;
    if ( Left != null ) { 
            HashChain.addAll(Left.hashLeft(parentHash)); }
    if ( Right != null ) { 
            HashChain.addAll(Right.hashLeft(parentHash)); }

    return HashChain;
    }
   

   
   
   public static void main(String[] args){
       ConsSet s=new HashTree(Empty,5.1,Empty);
       ConsSet s1=s.add(3.5);
       ConsSet s2=s1.add(7.2);
       ConsSet s3=s2.add(6.9);
       ConsSet s4=s3.add(4.8);
       ConsSet s5=s4.add(2.4);
       ConsSet s6=s5.add(1.2);
       //System.out.println(s6);
       List a=s6.toList();
       List b=s6.hash();
       System.out.println(b);
       System.out.println("Merkel Root-"+s6.Roothash(a));
      
     
   
      
   } 

    @Override
    /*
    to return a list of the nodes of our set based on whatever traversal we require
    */
    public List<String> toList() {
        final List<String> asList = new ArrayList<String>();
        asList.add(String.valueOf(key));
        if ( Left != null ) { 
            asList.addAll(Left.toList()); }
	if ( Right != null ) { asList.addAll(Right.toList()); }
	return asList;
    }
    
  @Override
  /*
  Pseudo Code:
  Roothash-merkel root
  Hash(stringof(all hashes from nodes))
  */
  public String Roothash(List a){
      merkle_tree(root,a);
      return MerkelRoot();
  }

    @Override
    /*
    Creates a merkel tree that accepts a list of node values from our ConsSet
    */
    public void merkle_tree(String root,List txList) {
		root="";
                List<String> temp = new ArrayList<String>();

		for (int i = 0; i < txList.size(); i++) {
			temp.add((String) txList.get(i));
		}

		List<String> newList = NewList(temp);
		while (newList.size() != 1) {
			newList = NewList(newList);
		}

		this.root = newList.get(0);
	}
    private List<String> NewList(List<String> temp) {

		List<String> newList = new ArrayList<String>();
		int index = 0;
		while (index < temp.size()) {
			// left
			String left = temp.get(index);
			index++;

			// right
			String right = "";
			if (index != temp.size()) {
				right = temp.get(index);
			}

			
			int t = (left + right).hashCode();
			String s=String.valueOf(t);
                        newList.add(s);
			index++;

		}

		return newList;
	}

        public String MerkelRoot() {
		return this.root;
	}

   


}
    