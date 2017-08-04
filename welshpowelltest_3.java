
import java.util.Scanner;
 

public class welshpowelltest_3
{    
    private int V, numOfColors;
    private int[] color; 
    private int[][] graph;
 
    /** Renk atama işlemi yapılıyor. **/
    public void graphColor(int[][] g, int noc)
    {
        V = g.length;
        numOfColors = noc;
        color = new int[V];
        graph = g;
 
        try
        {
            solve(0);
            System.out.println("Çözüm bulunamadı!!!");
        }
        catch (Exception e)
        {
            System.out.println("\nÇözüm mevcut... ");
            display();
        }
    }
    /** Renkleri yinelemeli olarak atıyor. **/
    public void solve(int v) throws Exception
    {
        /** Eğer çözüm bulunursa **/
        if (v == V)
            throw new Exception("Çözüm bulundu...");
        /** Tüm renkler deneniyor**/
        for (int c = 1; c <= numOfColors; c++)
        {
            if (isPossible(v, c))
            {
                
                /** Sonraki vertex e atama yapılıyor ve ilerleniyor. **/
                color[v] = c;
                solve(v + 1);
                /** Yanlış Atama için**/
                color[v] = 0;
            }
        }    
    }
    /** Fonksiyon rengin vertex e ait olup olmadığını kontrol ediyor. **/
    public boolean isPossible(int v, int c)
    {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }
    /** Çözüm yazdırılıyor. **/
    public void display()
    {
        System.out.print("\nRENKLER :\n\n");
        for (int i = 0; i < V; i++)
            
            System.out.print("Dugum"+(i+1)+": renk"+color[i] +"\n");
        System.out.println();
    }    
  
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welsh Powell Graf Renklendirme Algoritması \n");
        /**  GraphColoring class ından nesne oluşturuluyor. **/
        welshpowelltest_3 gc = new welshpowelltest_3();
 
        /** Vertex sayıları alınıyor. **/
        System.out.println("Köşe sayılarını giriniz:\n");
        int V = scan.nextInt();
 
        /** Komşuluk matrisi alınıyor. **/
        System.out.println("\nKomşuluk matrisini giriniz:\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();
 
        System.out.println("\nRenklerin sayısını giriniz:");
        int c = scan.nextInt();
 
        gc.graphColor(graph, c);
 
    }
}