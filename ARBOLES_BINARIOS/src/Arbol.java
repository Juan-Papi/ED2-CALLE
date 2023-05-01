
//import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.List;

class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    private boolean esHoja(Nodo pr) {
        return pr.getHI() == null && pr.getHD() == null;
    }

    public void insertar(int x) {
        Nodo q = new Nodo(x);
        if (raiz == null) {
            raiz = q;
            return;
        }
        Nodo pr = raiz;
        Nodo ant = null;
        while (pr != null) {
            ant = pr;
            if (x < pr.getElem()) {
                pr = pr.getHI();
            } else if (x > pr.getElem()) {
                pr = pr.getHD();
            } else {
                return;
            }
        }
        if (x < ant.getElem()) {
            ant.setHI(q);
        } else {
            ant.setHD(q);
        }
    }

    private void preOrden(Nodo pr, JTextArea ta) {
        if (pr != null) {
            ta.append(String.valueOf(pr.getElem() + "  "));
            preOrden(pr.getHI(), ta);
            preOrden(pr.getHD(), ta);
        }
    }

    public void preOrden(JTextArea ta) {
        preOrden(raiz, ta);
    }

    private void InOrden(Nodo pr, JTextArea ta) {
        if (pr != null) {
            InOrden(pr.getHI(), ta);
            ta.append(String.valueOf(pr.getElem() + "  "));
            InOrden(pr.getHD(), ta);
        }
    }

    public void InOrden(JTextArea ta) {
        InOrden(raiz, ta);
    }

    private void postOrden(Nodo pr, JTextArea ta) {
        if (pr != null) {

            postOrden(pr.getHI(), ta);
            postOrden(pr.getHD(), ta);
            ta.append(String.valueOf(pr.getElem() + "  "));
        }
    }

    public void postOrden(JTextArea ta) {
        postOrden(raiz, ta);
    }

    public void porNiveles(JTextArea ta) {
        if (this.raiz == null) {
            return;
        }
        Queue<Nodo> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            Nodo nodoActual = colaDeNodos.poll();
            ta.append(String.valueOf(nodoActual.getElem()));
            if (nodoActual.getHI() != null) {
                colaDeNodos.offer(nodoActual.getHI());
            }
            if (nodoActual.getHD() != null) {
                colaDeNodos.offer(nodoActual.getHD());
            }
        }
    }
//ejercicio en clases

    public boolean exists(int x) {
        //Nodo p=new Nodo(x);
        Nodo actual = this.raiz;
        if (raiz == null) {
            return false;
        }
        while (actual != null) {
            if (x > actual.getElem()) {
                actual = actual.getHD();
            } else {
                if (x < actual.getElem()) {
                    actual = actual.getHI();
                } else {
                    return true;
                }
            }
        }
        return false;
    }
//ejercicio en clases

    public int cantidadNivel() {
        int niv = 0;
        if (this.raiz == null) {
            return niv;
        }
        Queue<Nodo> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            int n = colaDeNodos.size();
            for (int i = 0; i < n; i++) {

                Nodo nodoActual = colaDeNodos.poll();

                if (nodoActual.getHI() != null) {
                    colaDeNodos.offer(nodoActual.getHI());
                }
                if (nodoActual.getHD() != null) {
                    colaDeNodos.offer(nodoActual.getHD());
                }
            }
            niv++;
        }
        return niv++;
    }
//ejercicio en clases

    public int sumaElems() {
        return sumaElems(raiz);
    }

    private int sumaElems(Nodo pr) {
        //ojo: el docente le pone otro caso base de si es nodoH
        if (pr == null) {
            return 0;
        } else {
            int elementoActual = pr.getElem();
            return sumaElems(
                    pr.getHI()) + sumaElems(pr.getHD()) + elementoActual;
        }
    }

//ejercicio en clases
    public int sumaElemsPares() {
        return sumaElemsPares(raiz);
    }

    private int sumaElemsPares(Nodo pr) {
        //ojo: el docente le pone otro caso base de si es nodoH
        if (pr == null) {
            return 0;
        } else {
            int elementoActual = pr.getElem();
            if (elementoActual % 2 == 0) {
                return sumaElemsPares(
                        pr.getHI()) + sumaElemsPares(pr.getHD()) + elementoActual;
            } else {
                return sumaElemsPares(
                        pr.getHI()) + sumaElemsPares(pr.getHD());
            }
        }
    }

    //ejercicio en clases
    public int cantidadDeElementos() {
        return cantidadDeElementos(raiz);
    }

    private int cantidadDeElementos(Nodo pr) {
        if (pr == null) {
            return 0;
        } else {

            return cantidadDeElementos(
                    pr.getHI()) + cantidadDeElementos(pr.getHD()) + 1;
        }
    }

    public int altura() {//Ejercicio en clases
        return altura(this.raiz);
    }

    private int altura(Nodo nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        int alturaPorIzq = altura(nodoActual.getHI());
        int alturaPorDer = altura(nodoActual.getHD());
        return alturaPorIzq > alturaPorDer ? alturaPorIzq + 1 : alturaPorDer + 1;
    }

    //Ejercicio en clases
    public boolean existe(int x) {//existe recursivo
        return existe(this.raiz, x);
    }

    private boolean existe(Nodo pr, int eleABuscar) {
        if (pr == null) {
            return false;
        } else {
            if (eleABuscar == pr.getElem()) {
                return true;
            } else {

                boolean busqPorIzq = existe(pr.getHI(), eleABuscar);
                boolean busqPorDer = existe(pr.getHD(), eleABuscar);
                return busqPorIzq || busqPorDer;

            }
        }
    }
    //practica aparte

    public int alturaDeNodoX(int x) {
        return alturaDeNodoX(raiz, x, false);
    }

    private int alturaDeNodoX(Nodo actual, int x, boolean b) {
        if (actual == null) {
            return 0;
        } else if ((actual.getElem() == x) || b) {
            int ai = alturaDeNodoX(actual.getHI(), x, true);
            int ad = alturaDeNodoX(actual.getHD(), x, true);
            return ai > ad ? ai + 1 : ad + 1;
        } else if (x > actual.getElem()) {
            return alturaDeNodoX(actual.getHD(), x, b);
        } else {
            return alturaDeNodoX(actual.getHI(), x, b);
        }
    }

    //practica aparte
    public int nivelEnQueSeEncuentraX(int x) {
        //Devuelve 0 cuando un x dado no pertenece al arbol
        return nivelEnQueSeEncuentraX(raiz, x, 1);
    }

    private int nivelEnQueSeEncuentraX(Nodo actual, int x, int nivelInicio) {
        if (actual == null) {
            return 0;
        } else {
            if (x == actual.getElem()) {
                return nivelInicio;
            } else {
                if (x > actual.getElem()) {
                    return nivelEnQueSeEncuentraX(actual.getHD(), x, nivelInicio + 1);
                } else {
                    return nivelEnQueSeEncuentraX(actual.getHI(), x, nivelInicio + 1);
                }
            }
        }
    }
//en clases 02/02/2023

    public int incompletos() {
        return incompletos(raiz);
    }

    private int incompletos(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {

            int incompletosPorIzq = incompletos(actual.getHI());
            int incompletosPorDer = incompletos(actual.getHD());
            if (!(actual.getHI() != null && actual.getHD() != null)) {
                return incompletosPorIzq + incompletosPorDer + 1;
            } else {
                return incompletosPorIzq + incompletosPorDer;
            }
        }
    }
//en clases 02/02/2023

    public int cantidadDeHojas() {
        return cantidadDeHojas(raiz);
    }

    private int cantidadDeHojas(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {
            int porIzq = cantidadDeHojas(actual.getHI());
            int porDer = cantidadDeHojas(actual.getHD());
            if (esHoja(actual)) {
                return porIzq + porDer + 1;
            } else {
                return porIzq + porDer;
            }
        }
    }
//en clases 02/02/2023

    public boolean hermanos(int x, int y) {
        return hermanos(raiz, x, y);

    }

    private boolean hermanos(Nodo actual, int x, int y) {
        if (actual == null) {
            return false;
        } else {
            if (actual.getHI() != null && actual.getHD() != null) {
                if ((actual.getHI().getElem() == x && actual.getHD().getElem() == y)
                        || (actual.getHI().getElem() == y && actual.getHD().getElem() == x)) {
                    return true;
                }
            }
        }
        boolean porIzq = hermanos(actual.getHI(), x, y);
        boolean porDer = hermanos(actual.getHD(), x, y);
        return porIzq || porDer;
    }
    //en clases 02/02/2023

    public void mostrarPares(JTextArea ta) {
        mostrarPares(raiz, ta);
    }

    private void mostrarPares(Nodo actual, JTextArea ta) {
        if (actual == null) {
            return;
        } else {
            mostrarPares(actual.getHI(), ta);
            mostrarPares(actual.getHD(), ta);
            if (actual.getElem() % 2 == 0) {
                ta.append(actual.getElem() + " ");//ojo: una forma de casting
            }
        }
    }
    //en clases 02/02/2023

    public void mostrarPadres(JTextArea ta) {
        mostrarPadres(raiz, ta);
    }

    private void mostrarPadres(Nodo actual, JTextArea ta) {
        if (actual == null) {
            return;
        }
        mostrarPadres(actual.getHI(), ta);
        mostrarPadres(actual.getHD(), ta);
        if (!esHoja(actual)) {
            ta.append(actual.getElem() + " ");//ojo: una forma de casting
        }
    }

    //TAREA 
    public int padreDeX(int x) {
        return padreDeX(raiz, x);
    }

    private int padreDeX(Nodo actual, int x) {
        if (actual == null) {
            return Integer.MAX_VALUE;//hace referencia a un valor infinito
            /*significa que el valor x no tiene un padre
            porque el arbol esta vacio o simplemente por que el valor x
            no forma parte del arbol*/
        } else {
            if (!esHoja(actual)) {
                if (actual.getHI() == null && actual.getHD() != null) {
                    if (actual.getHD().getElem() == x) {
                        return actual.getElem();
                    }
                } else if (actual.getHI() != null && actual.getHD() == null) {
                    if (actual.getHI().getElem() == x) {
                        return actual.getElem();
                    }
                } else {//si entra aqui significa que tiene sus 2 hijos
                    if (actual.getHI().getElem() == x || actual.getHD().getElem() == x) {
                        return actual.getElem();
                    }
                }
            }
            int izq = padreDeX(actual.getHI(), x);
            int der = padreDeX(actual.getHD(), x);
            if (izq != Integer.MAX_VALUE) {
                return izq;
            } else if (der != Integer.MAX_VALUE) {
                return der;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
//TAREA

    public int abueloDeX(int x) {
        return abueloDeX(raiz, x);
    }

    private int abueloDeX(Nodo actual, int x) {
        if (actual == null) {
            return Integer.MAX_VALUE;
        } else {
            if (!esHoja(actual)) {
                if (actual.getHI() == null && actual.getHD() != null) {
                    if (!esHoja(actual.getHD())) {
                        if (padreDeX(actual.getHD(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHD(), x) == actual.getHD().getElem()) {
                                return actual.getElem();//si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }
                } else if (actual.getHI() != null && actual.getHD() == null) {
                    if (!esHoja(actual.getHI())) {
                        if (padreDeX(actual.getHI(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHI(), x) == actual.getHI().getElem()) {
                                return actual.getElem();// si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }
                } else {
                    if (!esHoja(actual.getHI())) {
                        if (padreDeX(actual.getHI(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHI(), x) == actual.getHI().getElem()) {
                                return actual.getElem();// si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }
                    if (!esHoja(actual.getHD())) {
                        if (padreDeX(actual.getHD(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHD(), x) == actual.getHD().getElem()) {
                                return actual.getElem();//si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }

                }

            }
            int izq = abueloDeX(actual.getHI(), x);
            int der = abueloDeX(actual.getHD(), x);
            if (izq != Integer.MAX_VALUE) {
                return izq;
            } else if (der != Integer.MAX_VALUE) {
                return der;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
//TAREA

    public void devolverLosHijosDeX(JTextArea ta, int x) {
        devolverLosHijosDeX(ta, raiz, x);
    }

    private void devolverLosHijosDeX(JTextArea ta, Nodo actual, int x) {
        if (actual == null) {
            return;
        } else {
            if (actual.getElem() == x) {
                if (!esHoja(actual)) {
                    if (actual.getHI() == null && actual.getHD() != null) {
                        ta.append(actual.getHD().getElem() + " ");
                    } else if (actual.getHI() != null && actual.getHD() == null) {
                        ta.append(actual.getHI().getElem() + " ");
                    } else {//entra cuando tiene sus 2 hijos
                        ta.append(actual.getHI().getElem() + " ");
                        ta.append(actual.getHD().getElem() + " ");
                    }
                }
            }
            devolverLosHijosDeX(ta, actual.getHI(), x);
            devolverLosHijosDeX(ta, actual.getHD(), x);
        }
    }

    //en clases 03/02/2023
    public int hermanoDeX(int x) {
        return hermanoDeX(raiz, x);
    }

    private int hermanoDeX(Nodo actual, int x) {
        if (actual == null) {
            return Integer.MAX_VALUE;
        } else {
            if (!esHoja(actual)) {
                if (actual.getHI() != null && actual.getHD() != null) {
                    if (actual.getHI().getElem() == x) {
                        return actual.getHD().getElem();
                    } else if (actual.getHD().getElem() == x) {
                        return actual.getHI().getElem();
                    }

                }
            }
            int izq = hermanoDeX(actual.getHI(), x);
            int der = hermanoDeX(actual.getHD(), x);
            if (izq != Integer.MAX_VALUE) {
                return izq;
            } else if (der != Integer.MAX_VALUE) {
                return der;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
    //en clases 03/02/2023

    public Nodo hermanoDeXReferencia(int x) {
        return hermanoDeXReferencia(raiz, x);
    }

    private Nodo hermanoDeXReferencia(Nodo actual, int x) {
        if (actual == null) {
            return null;
        } else {
            if (!esHoja(actual)) {
                if (actual.getHI() != null && actual.getHD() != null) {
                    if (actual.getHI().getElem() == x) {
                        return actual.getHD();
                    } else if (actual.getHD().getElem() == x) {
                        return actual.getHI();
                    }

                }
            }
            Nodo izq = hermanoDeXReferencia(actual.getHI(), x);
            Nodo der = hermanoDeXReferencia(actual.getHD(), x);
            if (izq != null) {
                return izq;
            } else if (der != null) {
                return der;
            } else {
                return null;
            }
        }
    }
    //en clases 03/02/2023

    public boolean iguales(Arbol B) {
        return iguales(this.raiz, B.raiz);
    }

    private boolean iguales(Nodo a, Nodo b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null && b != null || a != null && b == null) {
            return false;
        }
        if (esHoja(a) && esHoja(b)) {
            return a.getElem() == b.getElem();
        }

        if (a.getElem() != b.getElem()) {
            return false;
        }
        boolean izq = iguales(a.getHI(), b.getHI());
        boolean der = iguales(a.getHD(), b.getHD());
        return izq && der;
    }
//metodo del ing. 06/02/2023

    private void MostrarNietos(Nodo p, JTextArea ta, int x) {
        if (p == null || esHoja(p)) {
            return;
        } else {
            if (p.getElem() == x) {
                if (p.getHI() != null && p.getHI().getHI() != null) {
                    ta.append(p.getHI().getHI().getElem() + " ");
                }
                if (p.getHI() != null && p.getHI().getHD() != null) {
                    ta.append(p.getHI().getHD().getElem() + " ");
                }
                if (p.getHD() != null && p.getHD().getHD() != null) {
                    ta.append(p.getHD().getHD().getElem() + " ");
                }
                if (p.getHD() != null && p.getHD().getHI() != null) {
                    ta.append(p.getHD().getHI().getElem() + " ");
                }
                return;
            }
            MostrarNietos(p.getHI(), ta, x);
            MostrarNietos(p.getHD(), ta, x);
        }
    }

    public void MostrarNietos(JTextArea ta, int x) {
        MostrarNietos(raiz, ta, x);
    }

//practicando para el examen
//------------------------------------------------------------------------------
    public void mostrarPrimosX(int x, JTextArea ta) {
        mostrarPrimosX(raiz, x, ta);
    }

    private void mostrarPrimosX(Nodo actual, int x, JTextArea ta) {
        if (actual == null) {
            return;
        } else {

            if (actual.getElem() == x) {
                Nodo abuelo = buscarAbuelo(x);
                int padreX = padre(x);
                if (abuelo != null) {
                    if (!esHoja(abuelo)) {
                        if (abuelo.getHI() != null) {
                            if (abuelo.getHI().getElem() != padreX) {
                                if (abuelo.getHI().getHI() != null) {
                                    ta.append(abuelo.getHI().getHI().getElem() + " ");
                                }
                                if (abuelo.getHI().getHD() != null) {
                                    ta.append(abuelo.getHI().getHD().getElem() + " ");
                                }
                            }
                        }
                        if (abuelo.getHD() != null) {
                            if (abuelo.getHD().getElem() != padreX) {
                                if (abuelo.getHD().getHI() != null) {
                                    ta.append(abuelo.getHD().getHI().getElem() + " ");
                                }
                                if (abuelo.getHD().getHD() != null) {
                                    ta.append(abuelo.getHD().getHD().getElem() + " ");
                                }
                            }
                        }
                    }
                }
            }
            mostrarPrimosX(actual.getHI(), x, ta);
            mostrarPrimosX(actual.getHD(), x, ta);
        }
    }

    //metodo auxiliar 1 para el primos
    public Nodo buscarAbuelo(int x) {
        return buscarAbuelo(this.raiz, x);
    }

    private Nodo buscarAbuelo(Nodo actual, int x) {
        if (actual == null) {
            return null;
        } else {
            if (!esHoja(actual)) {
                if (actual.getHI() != null) {
                    if (actual.getHI().getElem() == padre(x)) {
                        return actual;
                    }
                }
                if (actual.getHD() != null) {
                    if (actual.getHD().getElem() == padre(x)) {
                        return actual;
                    }

                }
            }
            Nodo izq = buscarAbuelo(actual.getHI(), x);
            Nodo der = buscarAbuelo(actual.getHD(), x);
            if (izq != null) {
                return izq;
            } else if (der != null) {
                return der;
            } else {
                return null;
            }
        }
    }

    //metodo auxiliar 2 para el primos
    public int padre(int x) {
        return padreDeX(this.raiz, x);
    }

    private int padre(Nodo actual, int x) {
        if (actual == null) {
            return Integer.MAX_VALUE;
        } else {
            if (!esHoja(actual)) {
                if (actual.getHI() != null) {
                    if (actual.getHI().getElem() == x) {
                        return actual.getElem();
                    }
                }
                if (actual.getHD() != null) {
                    if (actual.getHD().getElem() == x) {
                        return actual.getElem();
                    }
                }

            }
            int izq = padre(actual.getHI(), x);
            int der = padre(actual.getHD(), x);
            if (izq != Integer.MAX_VALUE) {
                return izq;
            } else if (der != Integer.MAX_VALUE) {
                return der;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

//------------------------------------------------------------------------------
    //practicando
    public int devolverNivelDeX(int x) {
        return devolverNivelDeX(this.raiz, x, 1);
    }

    private int devolverNivelDeX(Nodo actual, int x, int nivel) {
        if (actual == null) {
            return -1;
        } else {
            if (actual.getElem() == x) {
                return nivel;
            }
            int izq = devolverNivelDeX(actual.getHI(), x, nivel + 1);//2
            int der = devolverNivelDeX(actual.getHD(), x, nivel + 1);//
            if (izq != -1) {
                return izq;
            } else if (der != -1) {
                return der;
            } else {
                return -1;
            }
        }
    }

    public void retornarElementosDelNivelDeX(int x, JTextArea ta) {
        int nivel = devolverNivelDeX(x);
        retornarElementosDelNivelDeX(this.raiz, nivel, ta);
    }

    private void retornarElementosDelNivelDeX(Nodo actual, int nivel, JTextArea ta) {
        if (actual == null) {
            return;
        } else {
            if (nivel == 1) {
                ta.append(actual.getElem() + " ");
                return;
            }
            retornarElementosDelNivelDeX(actual.getHI(), nivel - 1, ta);
            retornarElementosDelNivelDeX(actual.getHD(), nivel - 1, ta);
        }
    }

    public void mostrarElementosMayoresQueX(int x, JTextArea ta) {
        mostrarElementosMayoresQueX(this.raiz, x, ta);
    }

    private void mostrarElementosMayoresQueX(Nodo actual, int x, JTextArea ta) {
        if (actual == null) {
            return;
        }
        if (actual.getElem() > x) {
            ta.append(actual.getElem() + " ");
        }
        mostrarElementosMayoresQueX(actual.getHI(), x, ta);
        mostrarElementosMayoresQueX(actual.getHD(), x, ta);

    }

    public int cantidadDeHijosDerechos() {
        return cantidadDeHijosDerechos(this.raiz);
    }

    private int cantidadDeHijosDerechos(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int porIzq = cantidadDeHijosDerechos(actual.getHI());
        int porDer = cantidadDeHijosDerechos(actual.getHD());
        if (actual.getHD() != null) {
            return porIzq + porDer + 1;
        }
        return porIzq + porDer;
    }
//-----------------------------------------------------------------------------
    // auxiliar 1

    public int alturaArbol() {
        return alturaArbol(this.raiz);
    }

    private int alturaArbol(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int altPorIzq = alturaArbol(actual.getHI());
        int altPorDer = alturaArbol(actual.getHD());
        if (altPorIzq > altPorDer) {
            return altPorIzq + 1;
        }
        return altPorDer + 1;
    }

    //MetodoPrincipal(BUEN EJERCICIO PARA PRACTICAR)
    public List<Integer> sumasNivel() {
        List<Integer> sumas = new ArrayList<>();
        sumasNivel(this.raiz, sumas);
        return sumas;
    }

    private void sumasNivel(Nodo actual, List<Integer> sumas) {
        for (int i = 1; i <= alturaArbol(); i++) {
            sumas.add(sumaDelNivel(i));
        }

    }
    //auxiliar 2

    public int sumaDelNivel(int nivel) {
        return sumaDelNivel(this.raiz, nivel);
    }

    private int sumaDelNivel(Nodo actual, int nivel) {
        if (actual == null) {
            return 0;
        }
        if (nivel == 1) {
            return actual.getElem();
        }
        int izq = sumaDelNivel(actual.getHI(), nivel - 1);
        int der = sumaDelNivel(actual.getHD(), nivel - 1);
        return izq + der;

    }
//------------------------------------------------------------------------------    

    public void mostrarElesDespuesDeN(int nivel, JTextArea ta) {
        mostrarElesDespuesDeN(this.raiz, 1, nivel, ta);
    }

    private void mostrarElesDespuesDeN(Nodo actual, int nivelInicio, int nivelB, JTextArea ta) {
        if (actual == null) {
            return;
        }
        if (nivelInicio >=nivelB) {
            ta.append(actual.getElem() + " ");
            mostrarElesDespuesDeN(actual.getHI(), nivelInicio + 1, nivelB, ta);
            mostrarElesDespuesDeN(actual.getHD(), nivelInicio + 1, nivelB, ta);
            return;
        }
        mostrarElesDespuesDeN(actual.getHI(), nivelInicio + 1, nivelB, ta);
        mostrarElesDespuesDeN(actual.getHD(), nivelInicio + 1, nivelB, ta);
    }

    public boolean esSubArbol(Arbol b) {
        return esSubArbol(this.raiz, b.raiz, Boolean.FALSE);
    }

    private boolean esSubArbol(Nodo a, Nodo b, boolean band) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null && b != null) {
            return false;
        }
        if (a != null && b == null) {
            return true;
        }
        boolean porIzq;
        boolean porDer;
        if (a.getElem() == b.getElem() || band) {
            if (a.getElem() != b.getElem()) {
                return false;
            }
            band = true;
            porIzq = esSubArbol(a.getHI(), b.getHI(), band);
            porDer = esSubArbol(a.getHD(), b.getHD(), band);
            return porIzq && porDer;
        }
        porIzq = esSubArbol(a.getHI(), b, band);
        porDer = esSubArbol(a.getHD(), b, band);
        return porIzq || porDer;
    }
    //---------------------------------PRACTICAS-----------------------------------

    public void preOrdenPract(JTextArea jta) {
        preOrdenPract(this.raiz, jta);
    }

    private void preOrdenPract(Nodo actual, JTextArea jta) {
        if (actual == null) {
            return;
        }
        jta.append(actual.getElem() + " ");
        preOrdenPract(actual.getHI(), jta);
        preOrdenPract(actual.getHD(), jta);
    }

    public void inOrdenPract(JTextArea jta) {
        inOrdenPract(this.raiz, jta);
    }

    private void inOrdenPract(Nodo actual, JTextArea jta) {
        if (actual == null) {
            return;
        }
        inOrdenPract(actual.getHI(), jta);
        jta.append(actual.getElem() + " ");
        inOrdenPract(actual.getHD(), jta);
    }

    public boolean existePract(int x) {
        return existePract(this.raiz, x);
    }

    private boolean existePract(Nodo actual, int x) {
        if (actual == null) {
            return false;
        }
        if (actual.getElem() == x) {
            return true;
        }
        boolean porIzq = existePract(actual.getHI(), x);//false
        boolean porDer = existePract(actual.getHD(), x);//true
        return porIzq || porDer;
    }

    public int sumaElementesPract() {
        return sumaElementosPract(this.raiz);
    }

    private int sumaElementosPract(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int porIzq = sumaElementosPract(actual.getHI());
        int porDer = sumaElementosPract(actual.getHD());
        return porIzq + porDer + actual.getElem();
    }

    public int sumaParesPract() {
        return sumaParesPract(this.raiz);
    }

    private int sumaParesPract(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int porIzq = sumaParesPract(actual.getHI());
        int porDer = sumaParesPract(actual.getHD());
        if (actual.getElem() % 2 == 0) {
            return porIzq + porDer + actual.getElem();
        }
        return porIzq + porDer;
    }

    public int cantElePract() {
        return cantElePract(this.raiz);
    }

    private int cantElePract(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int porIzq = cantElePract(actual.getHI());
        int porDer = cantElePract(actual.getHD());
        return porIzq + porDer + 1;
    }

    public int alturaPract() {
        return alturaPract(this.raiz);
    }

    private int alturaPract(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int porIzq = alturaPract(actual.getHI());
        int porDer = alturaPract(actual.getHD());
        if (porIzq > porDer) {
            return porIzq + 1;
        }
        return porDer + 1;
    }

    public int cantHojasPract() {
        return cantHojasPract(this.raiz);
    }

    private int cantHojasPract(Nodo actual) {
        if (actual == null) {
            return 0;
        }

        int porIzq = cantHojasPract(actual.getHI());
        int porDer = cantHojasPract(actual.getHD());
        if (esHoja(actual)) {
            return porIzq + porDer + 1;
        }
        return porIzq + porDer;
    }

    public int nivelDeXPract(int x) {
        return nivelDeXPract(this.raiz, x, 1);
    }

    private int nivelDeXPract(Nodo actual, int x, int nivel) {
        if (actual == null) {
            return Integer.MAX_VALUE;//tambien puede ser 0
        }
        if (actual.getElem() == x) {
            return nivel;
        }
        int porIzq = nivelDeXPract(actual.getHI(), x, nivel + 1);
        int porDer = nivelDeXPract(actual.getHD(), x, nivel + 1);

        if (porIzq != Integer.MAX_VALUE) {
            return porIzq;
        }
        if (porDer != Integer.MAX_VALUE) {
            return porDer;
        }
        return Integer.MAX_VALUE;//tambien puede ser 0
    }

    public void mostrarElesDeNPrac(int nivel, JTextArea jta) {
        mostrarElesDeNPrac(this.raiz, nivel, jta);
    }

    private void mostrarElesDeNPrac(Nodo actual, int nivel, JTextArea jta) {
        if (actual == null) {
            return;
        }
        if (nivel == 1) {
            jta.append(actual.getElem() + " ");
            return;
        }
        mostrarElesDeNPrac(actual.getHI(), nivel - 1, jta);
        mostrarElesDeNPrac(actual.getHD(), nivel - 1, jta);
    }
   public void mostrarHastaN(int nivel, JTextArea jta) {
        mostrarHastaN(this.raiz, nivel, jta);
        jta.append("\n");
    }

    private void mostrarHastaN(Nodo actual, int nivel, JTextArea jta) {
        if (actual == null) {
            return;
        }
         jta.append(actual.getElem() + " ");
        if (nivel == 1) {       
            return;
        }
        mostrarHastaN(actual.getHI(), nivel - 1, jta);
        mostrarHastaN(actual.getHD(), nivel - 1, jta);
        
    }
    //----------------------EXTRA----------------------------------------------
 //------------------PRINCIPAL-------------------------------------------------- 
public void mostrarNpar(JTextArea jta){
     int i=1;
    while(i<=alturaDelArbol()){
        if(i%2==0){
            mostrarNivelN(i, jta);
           jta.append("\n");
        }
        i++;
    }
}
  public int alturaDelArbol(){
      return alturaDelArbol(this.raiz);
  }  
  private int alturaDelArbol(Nodo actual){
      if(actual==null){
          return 0;
      }
      int porIzq=alturaDelArbol(actual.getHI());//5
      int porDer=alturaDelArbol(actual.getHD());//4
      
      if(porIzq>porDer){
          return porIzq+1;
      }
      return porDer+1;
  
  }
    
    

    
    public void mostrarNivelN(int n,JTextArea jta){
        mostrarNivelN(this.raiz,n,jta);
    }
    private void mostrarNivelN(Nodo actual,int nivel,JTextArea jta){
        if(actual==null){
            return;
        }
        
        if(nivel==1){
             jta.append(actual.getElem()+" ");
             return;
        }
        mostrarNivelN(actual.getHI(),nivel-1,jta);
        mostrarNivelN(actual.getHD(),nivel-1,jta);
        
    }
 
//Del ingeniero
    /* private int retornarHermano(Nodo p, int x){
      if (p == null || esHoja (p) || incompleto(p))
          return 0;
      else{
      
            if (p.getHI().getElem()==x)
                return p.getHD().getElem();
            if (p.getHD().getElem()==x)
                return p.getHI().getElem();
        
        int ai = retornarHermano(p.getHI(),x);
        int ad = retornarHermano(p.getHD(),x);
        if (ai != 0)
            return ai;
        else
            return ad;
       }          
    }
    
    public int retornarHermano(int x){
      return retornarHermano(raiz,x);
    }*/
}
//end class

