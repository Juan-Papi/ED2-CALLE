package bo.edu.uagrm.androidprueba1.capaN;

import java.util.LinkedList;

public class Arbol {
    protected Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    private static boolean esHoja(Nodo pr) {
        return pr.getHI() == null && pr.getHD() == null;
    }

    public void insertar(int x,String sintoma) {
        Nodo q = new Nodo(x,sintoma);
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
    public void insertarConEnfermedad(int x,String sintoma,String enf,boolean b){
        Nodo q = new Nodo(x,sintoma,enf,b);
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
    public Nodo getRaiz(){
        return this.raiz;
    }
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
//--------------------------------------------------------------------------------------------------
    public Nodo abueloDeXRef(int x) {
        return abueloDeXRef(raiz, x);
    }

    private Nodo abueloDeXRef(Nodo actual, int x) {
        if (actual == null) {
            return null;
        } else {
            if (!esHoja(actual)) {
                if (actual.getHI() == null && actual.getHD() != null) {
                    if (!esHoja(actual.getHD())) {
                        if (padreDeX(actual.getHD(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHD(), x) == actual.getHD().getElem()) {
                                return actual;//si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }
                } else if (actual.getHI() != null && actual.getHD() == null) {
                    if (!esHoja(actual.getHI())) {
                        if (padreDeX(actual.getHI(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHI(), x) == actual.getHI().getElem()) {
                                return actual;// si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }
                } else {
                    if (!esHoja(actual.getHI())) {
                        if (padreDeX(actual.getHI(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHI(), x) == actual.getHI().getElem()) {
                                return actual;// si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }
                    if (!esHoja(actual.getHD())) {
                        if (padreDeX(actual.getHD(), x) != Integer.MAX_VALUE) {
                            if (padreDeX(actual.getHD(), x) == actual.getHD().getElem()) {
                                return actual;//si mi hijo es padre de x
                                //entonces soy su abuelo de x
                            }
                        }
                    }

                }

            }
            Nodo izq = abueloDeXRef(actual.getHI(), x);
            Nodo der = abueloDeXRef(actual.getHD(), x);
            if (izq != null) {
                return izq;
            } else if (der != null) {
                return der;
            } else {
                return null;
            }
        }
    }
}
