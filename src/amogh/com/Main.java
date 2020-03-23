package amogh.com;



import java.util.Scanner;

public class Main {
   static int path[][]=new int[100][100];
    static String cities[]=new String[100];
    static String src,dest;
    static int source,destination;

    static void war(int path[][],int n,int source,int destination) {
        int k, j, i;
        for (k = 1; k <= n; k++)
            for (i = 1; i <= n; i++)
                for (j = 1; j <= n; j++)
                     path[i][j]=(path[i][j]!=0)||
                             ((path[i][k]!=0) && (path[k][j]!=0))?1:0;

        if(path[source][destination]==1)   {
            int x=n;
            while (x!=1&&x!=0){
                if(x==destination){
                    x=x-1;
                }
                if(x==source){
                    x=x-1;
                }
                if((path[source][x]==1)&&(path[x][destination]==1)){
                    System.out.println("intermediate  paths are  "+ cities[x]);
                }
                x--;
            }

        }
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.print(path[i][j] + "\t");
            }

            System.out.println();
        }
    }
    static Scanner scanner=new Scanner(System.in);

        public static void main(String[] args) {
            int n;
            System.out.println("enter number of nodes");
            n=scanner.nextInt();
            scanner.nextLine();
            for(int i=1;i<=n;i++){
                System.out.println("enter "+i+"city");
                 cities[i]=scanner.nextLine();
            }

            System.out.println("enter matrix");
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                     path[i][j]=scanner.nextInt();
                     scanner.nextLine();
            System.out.println("enter source to destination");
               src=scanner.nextLine();
            System.out.println("enter dest");
               dest=scanner.nextLine();
            System.out.println("src is"+src+"dest is"+dest);
              for(int i=1;i<=n;i++){
                  int a=cities[i].compareTo(src);
                  if(a==0){
                      source=i;
                      break;
                  }

              }
               if(source<=0){
                   System.out.println("city not there");
               }
              for(int i=1;i<=n;i++){
                  int a=cities[i].compareTo(dest);
                 // System.out.println(a);
                  if(a==0){
                      destination=i;
                      break;
                  }

              }
              if(destination<=0){
                  System.out.println("destination is not there");
              }
             if(path[source][destination]==1){
                 System.out.println("there is a direct train between"+ cities[source]+"to"+cities[destination]);
             }else {

                 war(path, n,source,destination);
             }
























    }
}
