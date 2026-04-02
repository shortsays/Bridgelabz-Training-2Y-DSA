import java.util.*;
class Problem4{
public static void bubble(int[] a){
for(int i=0;i<a.length;i++){
for(int j=0;j<a.length-i-1;j++){
if(a[j]>a[j+1]){
int t=a[j];a[j]=a[j+1];a[j+1]=t;
}
}
}
}
public static void main(String[] args){
int[] a={5,3,1,4,2};
bubble(a);
System.out.println(Arrays.toString(a));
}
}