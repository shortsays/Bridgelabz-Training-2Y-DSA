import java.util.*;
class Problem3{
public static boolean nested(int[] c,int[] p){
for(int i=0;i<p.length;i++){
boolean f=false;
for(int j=0;j<c.length;j++){
if(p[i]==c[j]){f=true;break;}
}
if(!f) return false;
}
return true;
}
public static boolean hash(int[] c,int[] p){
HashSet<Integer> s=new HashSet<>();
for(int i=0;i<c.length;i++) s.add(c[i]);
for(int i=0;i<p.length;i++) if(!s.contains(p[i])) return false;
return true;
}
public static void main(String[] args){
int[] c={1,2,3,4};
int[] p={2,3};
System.out.println(nested(c,p));
System.out.println(hash(c,p));
}
}