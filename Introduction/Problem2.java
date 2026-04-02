import java.util.*;
class Problem2{
public static boolean linear(String[] a,String t){
for(int i=0;i<a.length;i++) if(a[i].equals(t)) return true;
return false;
}
public static boolean binary(String[] a,String t){
int l=0,r=a.length-1;
while(l<=r){
int m=(l+r)/2;
int c=a[m].compareTo(t);
if(c==0) return true;
else if(c<0) l=m+1;
else r=m-1;
}
return false;
}
public static void main(String[] args){
String[] a={"a","b","c","d"};
System.out.println(linear(a,"c"));
System.out.println(binary(a,"c"));
}
}