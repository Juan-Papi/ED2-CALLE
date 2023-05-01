
public class Nodo {
    public static int M=4; //vias
    private int Elemento[];
    private Nodo Hijo[];
    private boolean Estado[];
    
    public Nodo(){
        Elemento = new int[M-1];
        Estado = new boolean[M-1];
        Hijo = new Nodo[M];
        for(int i = 0; i<M-1; i++){
            Estado[i] = false;
            Hijo[i] = null;
        }
        Hijo[M-1] = null;
    }
    
    public int getElem(int i){
        return Elemento[i-1];
    }
    
    public Nodo getHijo(int i){
        return Hijo[i-1];
    }            
    
    public boolean Ocupado(int i){
        return Estado[i-1];
    }
    
    public boolean Vacio(int i){
        return !Estado[i-1];
    }       

    public void setElem(int x, int i){
        Elemento[i-1] = x;
        Estado[i-1] = true;
    }
    
    public void setHijo(Nodo P, int i){
        Hijo[i-1] = P;
    }
    
    public void setVacio(int i){
        Estado[i-1] = false;
    }    
 
    public int CantVacias(){
        int c = 0;
        for(int i = 0; i<Estado.length; i++){
            if(Estado[i] == false){
                c++;
            }
        }
        return c;
    }
    
    public int CantOcupados(){
        return (M-1) - CantVacias();
    }
    
    public boolean Lleno(){
        return (CantVacias() == 0);
    }    
    
    public int sumarN()  {
        int sp=0;
        for(int i=1; i<M; i++)
              sp = sp + getElem(i);                    
        return sp;                     
    }
    
    public boolean seEncuentra(int x) {
        for(int i=1; i<M; i++){
              if(getElem(i)==x)                    
                  return true;
        }
        return false;
    }
        
    public int sumarNPares()  {
        int sp=0;
        for(int i=1; i<M; i++)
            if(getElem(i) % 2==0)
              sp = sp + getElem(i);                    
        return sp;                     
    }
    
    public int mayoresX(int x)  {
        int c=0;
        for(int i=1; i<M; i++)
            if(getElem(i) > x)
              c = c + 1;                    
        return c;                     
    }
    
    //No
    /*public void mostrarParesN(JTextArea jta) {        
        for(int i=1; i<M; i++){
            if(getElem(i)% 2==0)
              jta.append(Integer.toString(getElem(i)) + "  ");
        }
    }*/
        
        
} //end class Nodo
