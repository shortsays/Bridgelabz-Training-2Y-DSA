import java.util.*;
class Problem1{
public static double average(int[] a){
int total=0;
for(int i=0;i<a.length;i++) total+=a[i];
return (double)total/a.length;
}
public static void main(String[] args){
int[] t={20,25,22,24,21};
System.out.println(average(t));
}
}