package Empresa;
import java.util.Arrays;

public class MainTeste {
public static int[] arranjo = {1, 8,34,67,9,6,78,12,56,41,90};
  
public static void main(String[] args) {    
    Arrays.sort(arranjo);
    System.out.println(Arrays.toString(arranjo));
    int pos = pesquisa(78);
    System.out.println(pos);
  }
  
public static int pesquisa(int x){
int esq=0;
int dir=arranjo.length - 1;
int meio;
 
do{
   meio=esq + (dir - esq)/2;
   if(x<arranjo[meio]){
   dir=meio-1;
   System.out.println("A");}
   else if(x>arranjo[meio]){
   System.out.println("A");
      esq=meio+1;}
   else return meio;
}while(esq<=dir);
return -1; 
}
}