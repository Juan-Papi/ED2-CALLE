package bo.edu.uagrm.androidprueba1.capaN;

public class Nodo {
    private Nodo hijoIzq;
    private int elem;
    private String sintoma;
    private String enfermedad;
    private Nodo hijoDer;
    private  boolean bandera;
    public Nodo(int ele,String sintoma) {
        hijoIzq=null;
        elem = ele;
        this.sintoma=sintoma;
        hijoDer=null;
    }
    public Nodo(int ele,String sintoma,String e,boolean b) {
        hijoIzq=null;
        elem = ele;
        this.sintoma=sintoma;
        this.enfermedad=e;
        hijoDer=null;
        this.bandera=b;
    }
    public void setHI(Nodo izq){
        hijoIzq = izq;
    }
    public void setElem(int e) {
        elem = e;
    }
    public void setEnfermedad(String e){
        this.enfermedad=e;
    }
    public String getEnfermedad(){
        return enfermedad;
    }
    public String getSintoma(){
        return sintoma;
    }
    public void setHD(Nodo der) {
        hijoDer = der;
    }
    public Nodo getHI() {
        return hijoIzq;
    }
    public int getElem() {
        return elem;
    }
    public Nodo getHD() {
        return hijoDer;
    }
    public boolean esHoja(){
        return this.hijoIzq==null && this.hijoDer==null;
    }
    public boolean getBandera(){
        return bandera;
    }



}
