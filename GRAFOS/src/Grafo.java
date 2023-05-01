
import java.util.ArrayList;
import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

    private Lista LVertices;

    public Grafo() {
        LVertices = new Lista();
    }

    public void crearVertice(String nomV) {
        LVertices.insertarUlt(new Vertice(nomV));
    }

    public Vertice buscarVertice(String nomV) {
        Vertice vertice;
        int i = 0;
        while (i < LVertices.dim()) {
            vertice = (Vertice) LVertices.getElem(i);
            if (vertice.getNombre().equals(nomV)) {
                return vertice;
            }
            i++;
        }
        return null;
    }

    public void insertarArco(String X, String Y, float co) {
        Vertice vo = buscarVertice(X);
        Vertice vd = buscarVertice(Y);
        vo.insertarArco(new Arco(vd, co));
    }

    public void imprimir(JTextArea jta) {
        int i = 0;
        Vertice v;
        Arco a;
        while (i < LVertices.dim()) {
            v = (Vertice) LVertices.getElem(i);
            int j = 0;
            while (j < v.LArcos.dim()) {
                jta.append(v.getNombre());
                jta.append("-->");
                a = (Arco) v.LArcos.getElem(j); //Muestra el arco donde apunto
                jta.append(a.getNombreVertD() + "  " + a.getCosto());
                jta.append("\n");
                j++;
            }
            i++;
        }
    }

    //METODOS DE ENSEÑANZA    
    public float peso() {
        int i = 0;
        Vertice v;
        float s = 0;
        while (i < LVertices.dim()) {
            v = (Vertice) LVertices.getElem(i);
            int j = 0;
            Arco a;
            while (j < v.LArcos.dim()) {
                a = (Arco) v.LArcos.getElem(j);
                s = s + a.getCosto();
                j++;
            }
            i++;
        }
        return s;
    }

    public void desmarcarTodos() {
        for (int i = 0; i < this.LVertices.dim(); i++) {
            Vertice v = (Vertice) this.LVertices.getElem(i);
            v.marcado = false;
        }
    }

    public void ordenarVerticesAlf() {
        Vertice aux;
        Vertice v1;
        Vertice v2;
        for (int i = 0; i < LVertices.dim(); i++) {
            for (int j = 0; j < LVertices.dim() - 1; j++) {
                v1 = (Vertice) LVertices.getElem(j);
                v2 = (Vertice) LVertices.getElem(j + 1);
                if (v1.getNombre().compareTo(v2.getNombre()) > 0) {
                    aux = (Vertice) LVertices.getElem(j);
                    LVertices.setElem(v2, j);
                    LVertices.setElem(aux, j + 1);
                }
            }
        }
        for (int i = 0; i < LVertices.dim(); i++) {
            Vertice v = (Vertice) LVertices.getElem(i);
            v.ordenarArcosAlf();
        }
    }

    public void DFS(String A, JTextArea jta) {
        jta.append("DFS: ");
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice v = buscarVertice(A);
        dfs(v, jta);
        jta.append("\n");
    }

    private void dfs(Vertice v, JTextArea jta) {
        jta.append(v.getNombre() + " ");
        v.marcado = true;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if (!w.marcado) {
                dfs(w, jta);
            }
        }
    }

    public void BFS(String s, JTextArea jta) {
        desmarcarTodos();
        ordenarVerticesAlf();
        Arco a;
        Vertice v = buscarVertice(s), w;
        LinkedList<Vertice> C;
        C = new LinkedList<Vertice>();
        C.add(v);
        v.marcado = true;
        jta.append("BFS: ");
        do {
            v = C.pop();
            jta.append(v.getNombre() + " ");
            for (int i = 0; i < v.LArcos.dim(); i++) {
                a = (Arco) v.LArcos.getElem(i);
                w = buscarVertice(a.getNombreVertD());
                if (!w.marcado) {
                    C.add(w);
                    w.marcado = true;
                }
            }
        } while (!C.isEmpty());
        jta.append("\n");
    }

    //RECORRIDO BFS (ANCHURA,AMPLITUD,POR NIVELES) mi manera
    public void MYBFS(String nomVPartida, JTextArea jta) {
        jta.append("BFS: ");
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice v = buscarVertice(nomVPartida);
        ejecutarBFS(v, jta);
        jta.append("\n");
    }

    public void ejecutarBFS(Vertice verticeP, JTextArea jta) {

        Queue<Vertice> cola = new LinkedList<>();
        cola.offer(verticeP);
        verticeP.marcado = true;
        do {
            Vertice verticeEnTurno = cola.poll();
            jta.append(verticeEnTurno.getNombre() + " ");
            for (int i = 0; i < verticeEnTurno.LArcos.dim(); i++) {
                Arco arco = (Arco) verticeEnTurno.LArcos.getElem(i);
                Vertice vertDestino = buscarVertice(arco.getNombreVertD());
                if (!vertDestino.marcado) {
                    cola.offer(vertDestino);
                    vertDestino.marcado = true;
                }
            }
        } while (!cola.isEmpty());
    }

    //16-02-2023
    public boolean existeCamino(String X, String Y) {
        Vertice p = buscarVertice(X);
        Vertice q = buscarVertice(Y);
        if (p != null && q != null) {
            desmarcarTodos();
            ordenarVerticesAlf();
            Vertice v = buscarVertice(X);
            return existeCamino(v, Y);
        }
        return false;
    }
//16-02-2023

    private boolean existeCamino(Vertice v, String Y) {
        v.marcado = true;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if (!w.marcado) {
                if (w.getNombre().equals(Y)) {
                    return true;
                } else if (existeCamino(w, Y)); //si de b a c llego true;
                return true;
            }
        }
        return false;
    }

    //clase 16-02-2023
    public boolean existeCaminoConBFS(String X, String Y) {
        desmarcarTodos();
        ordenarVerticesAlf();
        LinkedList<Vertice> C = new LinkedList<>();
        Vertice v = buscarVertice(X);
        C.add(v);
        v.marcado = true;
        Arco a;
        Vertice w;
        do {
            v = C.pop();

            for (int i = 0; i < v.LArcos.dim(); i++) {
                a = (Arco) v.LArcos.getElem(i);
                w = buscarVertice(a.getNombreVertD());
                if (!w.marcado) {
                    C.add(w);
                    w.marcado = true;
                    if (w.getNombre() == Y) {
                        return true;
                    }
                }
            }
        } while (!C.isEmpty());
        return false;
    }
    //15-02-2023

    public int cantidadCaminos(String X, String Y) {
        Vertice p = buscarVertice(X);
        Vertice q = buscarVertice(Y);
        if (p != null && q != null) {
            desmarcarTodos();
            ordenarVerticesAlf();
            Vertice v = buscarVertice(X);
            return cantidadCaminos(v, Y);
        }
        return 0;
    }
    //15-02-2023

    private int cantidadCaminos(Vertice v, String Y) {
        v.marcado = true;
        int c = 0;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if (!w.marcado) {
                if (w.getNombre().equals(Y)) {
                    c = c + 1;
                } else {
                    c = c + cantidadCaminos(w, Y);
                    w.marcado = false;
                }
            }
        }
        return c;
    }

    private int cantidadCaminosConBFS(String X, String Y) {
        LinkedList<Vertice> C = new LinkedList<>();
        Vertice v = buscarVertice(X);
        C.add(v);
        v.marcado = true;
        Arco a;
        Vertice w;
        int cant = 0;
        do {
            v = C.pop();

            for (int i = 0; i < v.LArcos.dim(); i++) {
                a = (Arco) v.LArcos.getElem(i);
                w = buscarVertice(a.getNombreVertD());
                if (w.getNombre() == Y) {
                    cant++;
                }
                if (!w.marcado) {
                    C.add(w);
                    w.marcado = true;
                }
            }
        } while (!C.isEmpty());
        return cant;
    }

    //en clases
    public boolean esArbolBinario(String X) {
        Vertice vo = buscarVertice(X);
        vo.marcado = true;
        int i = 0;
        if (vo.LArcos.dim() <= 2) {
            while (i < vo.LArcos.dim()) {

                Arco a = (Arco) vo.LArcos.getElem(i);
                Vertice w = buscarVertice(a.getNombreVertD());
                i++;
                if (!w.marcado) {
                    if (!esArbolBinario(a.getNombreVertD())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //en clases
    public void MostrarCaminos(String x, String y, JTextArea jta) {
        Vertice v1 = buscarVertice(x);
        Vertice v2 = buscarVertice(y);
        LinkedList<String> l = new LinkedList<String>();
        l.add(v1.getNombre());
        MostrarCaminos(v1, v2, l, jta);
        l.clear();
    }

    private void MostrarCaminos(Vertice x, Vertice y, LinkedList<String> l, JTextArea jta) {
        if (existeCamino(x.getNombre(), y.getNombre())) {
            Arco a;
            for (int i = 0; i < x.LArcos.dim(); i++) {
                a = (Arco) x.LArcos.getElem(i);
                l.add(a.getNombreVertD());
                if (l.getLast().equals(y.getNombre())) {
                    jta.append(l.toString() + "\n");
                }
                Vertice v = buscarVertice(a.getNombreVertD());
                MostrarCaminos(v, y, l, jta);
                l.removeLast();
            }
        }
    }

    public void MostrarCaminosConCosto(String x, String y, JTextArea jta) {
        Vertice v1 = buscarVertice(x);
        Vertice v2 = buscarVertice(y);
        LinkedList<String> l = new LinkedList<String>();
        l.add(v1.getNombre());
        float costo = 0;
        MostrarCaminosConCosto(v1, v2, l, jta, costo);
        l.clear();
    }
              
    
    //ABD->48
    //ACD->30
    private void MostrarCaminosConCosto(Vertice x, Vertice y, LinkedList<String> l, JTextArea jta, float costo) {
       
        if (existeCamino(x.getNombre(), y.getNombre())) {
            Arco a;
            for (int i = 0; i < x.LArcos.dim(); i++) {
                a = (Arco) x.LArcos.getElem(i);
                Vertice v = buscarVertice(a.getNombreVertD());
                l.add(a.getNombreVertD());//   //A;   ,, ;JTA,0   
              costo = costo + a.getCosto();// 
                if (l.getLast().equals(y.getNombre())) {
                    jta.append(l.toString() + "    " + costo + "\n");
                }                                                                                                
                MostrarCaminosConCosto(v, y, l, jta, costo);
                l.removeLast();
                costo = costo - a.getCosto();
              //A,D;A;JTA,0 
            }
        }
    }

    //TAREA
    public int gradoDeEntradaDeVertice(String nomb) {
        if (buscarVertice(nomb) != null) {
            int entradas = 0;
            for (int i = 0; i < LVertices.dim(); i++) {
                Vertice vertice = (Vertice) LVertices.getElem(i);
                for (int j = 0; j < vertice.getCantArcos(); j++) {
                    Arco arcoAdy = (Arco) vertice.LArcos.getElem(j);
                    if (arcoAdy.getNombreVertD().equals(nomb)) {
                        entradas++;
                    }
                }

            }
            return entradas;
        }
        return -1;//significa que no existe el vertice
    }
//TAREA

    public int gradoDeSalidaDeVertice(String nomb) {
        Vertice verticeBuscado = buscarVertice(nomb);
        if (verticeBuscado != null) {
            return verticeBuscado.getCantArcos();
        }
        return -1;

    }

    //cantidad de arcos(EXTRA)
    public int cantidadDeAristas() {
        int cant = 0;
        for (int i = 0; i < this.LVertices.dim(); i++) {
            Vertice vertice = (Vertice) LVertices.getElem(i);
            cant = cant + gradoDeSalidaDeVertice(vertice.getNombre());
        }
        return cant;
    }
//Repracticando todo

    public boolean sonIguales(Grafo a, Grafo b) {
        a.ordenarVerticesAlf();
        b.ordenarVerticesAlf();
        if (a.LVertices.dim() == b.LVertices.dim()) {
            for (int i = 0; i < a.LVertices.dim(); i++) {
                Vertice verA = (Vertice) a.LVertices.getElem(i);
                Vertice verB = (Vertice) b.LVertices.getElem(i);
                if (verA.getNombre() != verB.getNombre()) {
                    return false;
                }
                if (verA.LArcos.dim() == verB.LArcos.dim()) {
                    for (int j = 0; j < verA.LArcos.dim(); j++) {
                        Arco arcoA = (Arco) verA.LArcos.getElem(j);
                        Arco arcoB = (Arco) verB.LArcos.getElem(j);
                        if (arcoA.getNombreVertD() != arcoB.getNombreVertD()
                                || arcoA.getCosto() != arcoB.getCosto()) {
                            return false;
                        }
                    }
                }

            }
            return true;
        }
        return false;
    }

    public void reDFS(String partida, JTextArea jta) {
        ordenarVerticesAlf();

        Vertice v = buscarVertice(partida);
        jta.append("DFS: ");
        if (v != null) {

            reDFS(v, jta);
            jta.append("\n");
        }

    }

    private void reDFS(Vertice v, JTextArea jta) {

        v.marcado = true;
        jta.append(v.getNombre() + " ");
        for (int i = 0; i < v.LArcos.dim(); i++) {
            Arco arco = (Arco) v.LArcos.getElem(i);
            Vertice vDestino = buscarVertice(arco.getNombreVertD());
            if (!vDestino.marcado) {
                reDFS(vDestino, jta);
            }

        }

    }

    public boolean esArbolBinarioAgain(String x) {
        Vertice v = buscarVertice(x);
        v.marcado = true;
        if (v.LArcos.dim() <= 2) {
            for (int i = 0; i < v.LArcos.dim(); i++) {
                Arco arco = (Arco) v.LArcos.getElem(i);
                Vertice destino = buscarVertice(arco.getNombreVertD());
                if (!destino.marcado) {
                    if (!esArbolBinarioAgain(arco.getNombreVertD())) {
                        return false;
                    }
                } else {
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    /* public boolean tieneCiclos(String x){
        List<Boolean>verificar=new ArrayList<>();
        verificar.add(false);
        tieneCiclos(x,verificar);
        return verificar.get(0);
    }*/
    public boolean tieneCiclos(String x) {
        Vertice v = buscarVertice(x);
        v.marcado = true;
        if (v.LArcos.dim() <= 2) {
            for (int i = 0; i < v.LArcos.dim(); i++) {
                Arco arco = (Arco) v.LArcos.getElem(i);
                Vertice destino = buscarVertice(arco.getNombreVertD());
                if (!destino.marcado) {
                    if (!tieneCiclos(arco.getNombreVertD())) {
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tiene ciclos");
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Vertice buscarVerticeAgain(String x) {
        for (int i = 0; i < LVertices.dim(); i++) {
            Vertice v = (Vertice) LVertices.getElem(i);
            if (v.getNombre() == x) {
                return v;
            }
        }
        return null;
    }

    public float pesoGrafoAgain() {
        ordenarVerticesAlf();//esto es opcional
        //se deberia de poner para buena practica porque un grafo
        //funciona bien cuando esta ordenado
        float s = 0;
        for (int i = 0; i < LVertices.dim(); i++) {
            Vertice v = (Vertice) LVertices.getElem(i);
            for (int j = 0; j < v.LArcos.dim(); j++) {
                Arco arco = (Arco) v.LArcos.getElem(j);
                s = s + arco.getCosto();
            }
        }
        return s;
    }

    public void desmarcarTodosAgain() {
        for (int i = 0; i < LVertices.dim(); i++) {
            Vertice v = (Vertice) LVertices.getElem(i);
            v.marcado = false;
        }
    }

    //con mi logica
    public boolean existeCaminoAgain(String x, String y) {
        ordenarVerticesAlf();
        desmarcarTodos();
        Vertice part = buscarVertice(x);
        Vertice dest = buscarVertice(y);
        if (part != null && dest != null) {
            reDFSin(x);
            if (dest.marcado) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void bfsAgain(String x, JTextArea jta) {
        ordenarVerticesAlf();//obligatorio
        desmarcarTodos();//obligatorio
        Vertice inicio = buscarVertice(x);
        inicio.marcado = true;
        Queue<Vertice> colaV = new LinkedList<>();
        colaV.offer(inicio);
        jta.append("BFS: ");
        do {
            Vertice vActual = colaV.poll();
            jta.append(vActual.getNombre() + " ");
            for (int i = 0; i < vActual.LArcos.dim(); i++) {
                Arco arco = (Arco) vActual.LArcos.getElem(i);
                Vertice destino = buscarVertice(arco.getNombreVertD());
                if (!destino.marcado) {
                    destino.marcado = true;
                    colaV.offer(destino);
                }
            }
        } while (!colaV.isEmpty());
        jta.append("\n");
    }

    public int cantidadDeCaminosAgain(String x, String y) {
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice partida = buscarVertice(x);
        Vertice destino = buscarVertice(y);
        if (partida != null && destino != null) {
            return cantidadDeCaminosAgain(partida, y);
        }
        return -1;
    }

    private int cantidadDeCaminosAgain(Vertice partida, String y) {
        partida.marcado = true;
        int c = 0;
        for (int i = 0; i < partida.LArcos.dim(); i++) {
            Arco arco = (Arco) partida.LArcos.getElem(i);
            Vertice d = buscarVertice(arco.getNombreVertD());
            if (d.getNombre().equals(y)) {
                c++;
            }
            if (!d.marcado) {
                c = c + cantidadDeCaminosAgain(d, y);
            }

        }
        partida.marcado = false;
        return c;
    }

    public void mostrarCaminos(String x, String y, JTextArea jta) {
        ordenarVerticesAlf();
        desmarcarTodos();
        Vertice partida = buscarVertice(x);
        Vertice destino = buscarVertice(y);
        if (partida != null && destino != null) {
            if (existeCamino(x, y)) {
                mostrarCaminos(partida, y, jta);
            }
        }
    }

    private void mostrarCaminos(Vertice partida, String y, JTextArea jta) {
        partida.marcado = true;
        for (int i = 0; i < partida.LArcos.dim(); i++) {
            Arco arco = (Arco) partida.LArcos.getElem(i);
            Vertice d = buscarVertice(arco.getNombreVertD());
            if (arco.getNombreVertD().equals(y)) {
                jta.append(partida.getNombre() + " ");
                jta.append(arco.getNombreVertD() + " ");
                jta.append("\n");
            } else {
                if (existeCamino(arco.getNombreVertD(), y)) {
                    jta.append(partida.getNombre() + " ");
                    if (arco.getNombreVertD().equals(y)) {
                        jta.append(arco.getNombreVertD() + " ");
                        jta.append("\n");

                    } else {
                        if (!d.marcado) {
                            mostrarCaminos(d, y, jta);
                        }
                    }
                }
            }
        }
        partida.marcado = false;
    }
//---------------------------------DFS VERSION LISTA---------------------------
//podria ser solo void

    public List<String> reDFSin(String partida) {
        ordenarVerticesAlf();
        desmarcarTodos();
        List<String> recorrido = new ArrayList<>();
        Vertice v = buscarVertice(partida);
        if (v != null) {
            reDFSin(v, recorrido);
        }
        return recorrido;
    }

    private List<String> reDFSin(Vertice v, List<String> recorrido) {

        v.marcado = true;
        recorrido.add(v.getNombre());
        for (int i = 0; i < v.LArcos.dim(); i++) {
            Arco arco = (Arco) v.LArcos.getElem(i);
            Vertice vDestino = buscarVertice(arco.getNombreVertD());
            if (!vDestino.marcado) {
                reDFSin(vDestino, recorrido);
            }
        }
        return recorrido;
    }
///--------------------------PRACTICANDO PARA EL REPECHAJE----------------------

    public void repechajeDFS(String x, JTextArea jta) {
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice verticeP = buscarVertice(x);
        repechajeDFS(verticeP, jta);
        jta.append("\n");
    }

    private void repechajeDFS(Vertice p, JTextArea jta) {
        p.marcado = true;
        jta.append(p.getNombre() + " ");
        for (int i = 0; i < p.LArcos.dim(); i++) {
            Arco arco = (Arco) p.LArcos.getElem(i);
            Vertice verticeD = buscarVertice(arco.getNombreVertD());
            if (!verticeD.marcado) {
                repechajeDFS(verticeD, jta);
            }
        }
    }

    public void repechajeBFS(String x, JTextArea jta) {
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice verticeP = buscarVertice(x);
        Queue<Vertice> cola = new LinkedList<>();
        cola.offer(verticeP);
        verticeP.marcado = true;
        jta.append("BFS: ");
        do {
            Vertice v = cola.poll();
            jta.append(v.getNombre() + " ");
            for (int i = 0; i < v.LArcos.dim(); i++) {
                Arco arco = (Arco) v.LArcos.getElem(i);
                Vertice d = buscarVertice(arco.getNombreVertD());
                if (!d.marcado) {
                    cola.offer(d);
                    d.marcado = true;
                }
            }
        } while (!cola.isEmpty());
        jta.append("\n");
    }

    public void mostrarCaminosRecorridoBFS(String verticeOrigen, String verticeDestino) {
        Vertice v = buscarVertice(verticeOrigen);
        Vertice w = buscarVertice(verticeDestino);
        if (v == null || w == null) {
            return;
        }

        LinkedList<LinkedList<String>> cola = new LinkedList();
        LinkedList<String> camino = new LinkedList();

        camino.add(verticeOrigen);
        cola.add(camino);

        do {
            camino = cola.pop();//A,B,D
            v = buscarVertice(camino.getLast());//D
            if (v.getNombre().equals(verticeDestino)) {
                System.out.println(camino);

            }

            for (int i = 0; i < v.LArcos.dim(); i++) {
                Arco a = (Arco) v.LArcos.getElem(i);
                w = buscarVertice(a.getNombreVertD());
                if (!camino.contains(w.getNombre())) {
                    LinkedList<String> nuevoCamino = new LinkedList(camino);
                    nuevoCamino.add(w.getNombre());
                    cola.add(nuevoCamino);
                }
            }

        } while (!cola.isEmpty());
    }

    //-------------------PARA EL REPECHAJE------------------------------
    public boolean repeExiteCaminoConDFS(String x, String y) {

        Vertice partida = buscarVertice(x);
        Vertice destino = buscarVertice(y);
        if (partida != null && destino != null) {
            desmarcarTodos();
            ordenarVerticesAlf();
            return repeExisteCaminoConDFS(partida, y);
        }
        return false;
    }

    private boolean repeExisteCaminoConDFS(Vertice v, String y) {
        v.marcado = true;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            Arco arco = (Arco) v.LArcos.getElem(i);
            Vertice d = buscarVertice(arco.getNombreVertD());

            if (arco.getNombreVertD().equals(y)) {
                return true;
            }
            if (!d.marcado) {
                boolean aux = repeExisteCaminoConDFS(d, y);
                if (aux) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean repeExisteCaminoConBFS(String x, String y) {
        Vertice partida = buscarVertice(x);
        Vertice destino = buscarVertice(y);
        if (partida == null || destino == null) {
            return false;
        }
        LinkedList<Vertice> cola = new LinkedList<>();
        cola.add(partida);
        partida.marcado = true;
        do {
            Vertice v = cola.poll();

            for (int i = 0; i < v.LArcos.dim(); i++) {
                Arco arco = (Arco) v.LArcos.getElem(i);
                Vertice d2 = buscarVertice(arco.getNombreVertD());
                if (!d2.marcado) {
                    if (d2.getNombre() == y) {
                        return true;
                    }
                    cola.add(d2);
                    d2.marcado = true;
                }
            }
        } while (!cola.isEmpty());
        return false;
    }

    public int repeCantCaminosConDFS(String x, String y) {
        Vertice part = buscarVertice(x);
        Vertice dest = buscarVertice(y);
        if (part == null || dest == null) {
            return -1;
        }
        return repeCantCaminosConDFS(part, y);
    }

    private int repeCantCaminosConDFS(Vertice p, String y) {
        p.marcado = true;
        int cant = 0;
        for (int i = 0; i < p.LArcos.dim(); i++) {
            Arco arco = (Arco) p.LArcos.getElem(i);
            Vertice d2 = buscarVertice(arco.getNombreVertD());
            if (!d2.marcado) {
                if (d2.getNombre().equals(y)) {
                    cant++;
                }
                cant = cant + repeCantCaminosConDFS(d2, y);

            }

        }
        p.marcado = false;
        return cant;
    }

    public int repeCantCaminosBFS(String x, String y) {
        Vertice part = buscarVertice(x);
        Vertice dest = buscarVertice(y);
        if (part == null || dest == null) {
            return -1;
        }
        desmarcarTodos();
        ordenarVerticesAlf();
        LinkedList<Vertice> cola = new LinkedList<>();
        cola.add(part);
        part.marcado = true;
        int cant = 0;
        while (!cola.isEmpty()) {
            Vertice v = cola.poll();

            for (int i = 0; i < v.LArcos.dim(); i++) {
                Arco arco = (Arco) v.LArcos.getElem(i);
                Vertice d2 = buscarVertice(arco.getNombreVertD());
                if (!d2.marcado) {

                    if (d2.getNombre().equals(y)) {
                        cant++;

                    } else {
                        d2.marcado = true;
                        cola.add(d2);
                    }

                }
            }
        }
        return cant;
    }

    public void mostrarCaminosBFS(String x, String y) {
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice part = buscarVertice(x);
        Vertice dest = buscarVertice(y);
        if (part == null || dest == null) {
            return;
        }
        LinkedList<Vertice> cola = new LinkedList<>();
        cola.add(part);
        part.marcado = true;
        LinkedList<LinkedList<String>> listaCaminos = new LinkedList<>();
        LinkedList<String> camino = new LinkedList<>();
       // camino.add(part.getNombre());
        while (!cola.isEmpty()) {
            Vertice v = cola.poll();
            camino.add(v.getNombre());

            for (int i = 0; i < v.LArcos.dim(); i++) {
                Arco arco = (Arco) v.LArcos.getElem(i);
                Vertice d2 = buscarVertice(arco.getNombreVertD());

                if (!d2.marcado) {
                    cola.add(d2);
                    d2.marcado = true;

                }

            }
        }

        System.out.println(camino);

    }

}  //end class
