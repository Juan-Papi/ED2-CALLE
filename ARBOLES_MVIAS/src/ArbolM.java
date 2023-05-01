
import javax.swing.JTextArea;

public class ArbolM {

    private Nodo raiz;

    public ArbolM() {
        raiz = null;
    }

    private boolean esHoja(Nodo P) {
        for (int i = 1; i <= P.M; i++) {
            if (P.getHijo(i) != null) {
                return false;
            }
        }
        return true;
    }
    //hijo descendiente 

    private int getHijoDesc(Nodo P, int x) {
        int i = 1;
        while (i < P.M) {
            if (x < P.getElem(i)) {
                return i;
            }
            if (x == P.getElem(i)) {
                return -1;
            }
            i++;
        }
        return P.M;
    }

    private void InsertaOrd(Nodo P, int x) {
        for (int i = 1; i < P.M; i++) {
            if (P.Vacio(i)) {
                P.setElem(x, i);
                return;
            } else {
                if (x == P.getElem(i)) {
                    return;
                } else {
                    if (x < P.getElem(i)) {
                        Recorrer(P, i);
                        P.setElem(x, i);
                        return;
                    }
                }
            }
        }
    }

    private void Recorrer(Nodo P, int i) {
        int num1 = P.getElem(i);
        int num2 = 0;
        int c = P.CantOcupados();
        while (i <= c) {
            if (P.Ocupado(i + 1)) {
                num2 = P.getElem(i + 1);
            }
            P.setElem(num1, i + 1);
            num1 = num2;
            i++;
        }
    }

    public void Insertar(int x) {
        if (raiz == null) {
            raiz = new Nodo();
            raiz.setElem(x, 1);
        } else {
            Nodo P = raiz;
            Nodo AP = null;
            int i = 0;
            while (P != null) {
                AP = P;
                if (!P.Lleno()) {
                    InsertaOrd(P, x);
                    return;
                }
                i = getHijoDesc(P, x);
                if (i == -1) {
                    return; // x esta en el arbol
                }
                P = P.getHijo(i);
            }
            Nodo Q = new Nodo();
            Q.setElem(x, 1);
            AP.setHijo(Q, i);
        }
    }

    private void InOrden(Nodo P, JTextArea jta) {
        if (P == null) {
            return;
        } else {
            if (esHoja(P)) {
                int i = 1; //muestra todos los elementos de nodo P
                while (i <= P.CantOcupados()) {
                    jta.append(String.valueOf(P.getElem(i) + "  "));
                    i++;
                }
            } else {
                for (int i = 1; i <= P.M - 1; i++) {
                    InOrden(P.getHijo(i), jta);
                    jta.append(String.valueOf(P.getElem(i) + "  "));
                }
                InOrden(P.getHijo(P.M), jta);
            }
        }
    }

    public void InOrden(JTextArea ta) {
        InOrden(raiz, ta);
    }

    public void PreOrden(JTextArea ta) {
        PreOrden(raiz, ta);
    }

    private void PreOrden(Nodo P, JTextArea jta) {
        if (P == null) {
            return;
        }
        if (esHoja(P)) {
            int i = 1; //muestra todos los elementos de nodo P
            while (i <= P.CantOcupados()) {
                jta.append(String.valueOf(P.getElem(i) + "  "));
                i++;
            }
        } else {
            //i=1,2,3,4
            //hasta 3
            for (int i = 1; i <= P.M - 1; i++) {
                jta.append(String.valueOf(P.getElem(i) + "  "));
                PreOrden(P.getHijo(i), jta);
            }
            PreOrden(P.getHijo(P.M), jta);
        }

    }

    private void postOrden(Nodo P, JTextArea jta) {
        if (P == null) {
            return;
        } else {
            if (esHoja(P)) {
                int i = 1; //muestra todos los elementos de nodo P
                while (i <= P.CantOcupados()) {
                    jta.append(String.valueOf(P.getElem(i) + "  "));
                    i++;
                }
            } else {
                postOrden(P.getHijo(1), jta);
                for (int i = 1; i <= P.M - 1; i++) {
                    postOrden(P.getHijo(i + 1), jta);
                    jta.append(String.valueOf(P.getElem(i) + "  "));
                }
            }
        }
    }

    //en clases 07/02/2023
    public void postOrden(JTextArea ta) {
        postOrden(raiz, ta);
    }

    //en clases 07/02/2023
    public int cantidadNodos() {
        return cantidadNodos(raiz);
    }

    private int cantidadNodos(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {
            if (esHoja(actual)) {
                return 1;
            } else {
                int cn = 0;
                for (int i = 1; i <= actual.M; i++) {
                    cn = cn + cantidadNodos(actual.getHijo(i));
                }
                return cn + 1;//esto suma al nodo actual en el que estamos parados
            }
        }
    }

    //en clases 07/02/2023
    public int cantElementos() {
        return cantElementos(raiz);
    }

    private int cantElementos(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {
            int cd = 0;
            for (int i = 1; i <= actual.M; i++) {
                cd = cd + cantElementos(actual.getHijo(i));

            }
            return cd + actual.CantOcupados();
        }
    }
    //forma del ing. 08/02/2023

    public int sumarElementos() {
        return sumarElementos(raiz);
    }

    private int sumarElementos(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {
            if (esHoja(actual)) {
                return actual.sumarN();
            } else {
                int s = 0;
                for (int i = 1; i <= actual.M; i++) {
                    s = s + sumarElementos(actual.getHijo(i));
                }
                return s + actual.sumarN();
            }
        }
    }
    //forma del ing. 08/02/2023

    public int sumarElementosPares() {
        return sumarElementosPares(raiz);
    }

    private int sumarElementosPares(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {
            if (esHoja(actual)) {
                return actual.sumarNPares();
            } else {
                int s = 0;
                for (int i = 1; i <= actual.M; i++) {
                    s = s + sumarElementosPares(actual.getHijo(i));
                }
                return s + actual.sumarNPares();
            }
        }
    }

    //en clases 07/02/2023  mi manera
    public int sumaEles() {
        return sumaEles(this.raiz);
    }

    private int sumaEles(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {
            int s = 0;
            for (int i = 1; i <= actual.M - 1; i++) {
                s = s + actual.getElem(i) + sumaEles(actual.getHijo(i));
            }
            s = s + sumaEles(actual.getHijo(actual.M));
            return s;
        }
    }

    //en clases 07/02/2023 mi manera
    public int sumaElesPares() {
        return sumaElesPares(this.raiz);
    }

    private int sumaElesPares(Nodo actual) {
        if (actual == null) {
            return 0;
        } else {
            int s = 0;
            for (int i = 1; i <= actual.M - 1; i++) {
                if (actual.getElem(i) % 2 == 0) {
                    s = s + actual.getElem(i) + sumaElesPares(actual.getHijo(i));
                } else {
                    s = s + sumaElesPares(actual.getHijo(i));
                }
            }
            s = s + sumaElesPares(actual.getHijo(actual.M));
            return s;
        }
    }

    public int sumaDelNivel(int nivel) {
        return sumaDelNivel(this.raiz, nivel);
    }

    private int sumaDelNivel(Nodo actual, int nivel) {
        if (actual == null) {
            return 0;
        }
        if (nivel == 1) {
            return actual.sumarN();
        }
        int s = 0;
        for (int i = 1; i <= actual.M; i++) {
            s = s + sumaDelNivel(actual.getHijo(i), nivel - 1);
        }
        return s;

    }

    public int cantidadDeDatosVacios() {
        return cantidadDeDatosVacios(this.raiz);
    }

    private int cantidadDeDatosVacios(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int cant = actual.CantVacias();
        for (int i = 1; i < actual.M; i++) {
            cant = cant + cantidadDeDatosVacios(actual.getHijo(i));
        }
        cant = cant + cantidadDeDatosVacios(actual.getHijo(actual.M));
        return cant;
    }

    public void mostrarPares(JTextArea ta) {
        mostrarPares(this.raiz, ta);
    }

    private void mostrarPares(Nodo actual, JTextArea ta) {
        if (actual == null) {
            return;
        }
        if (esHoja(actual)) {
            for (int i = 1; i <= actual.CantOcupados(); i++) {
                if (actual.getElem(i) % 2 == 0) {
                    ta.append(actual.getElem(i) + " ");
                }
            }
            return;
        }
        for (int i = 1; i < actual.M; i++) {
            if (actual.getElem(i) % 2 == 0) {
                ta.append(actual.getElem(i) + " ");
            }
            mostrarPares(actual.getHijo(i), ta);
        }
        mostrarPares(actual.getHijo(actual.M), ta);
    }

    public void mostrarPrimosDadoNivel(int nivel, JTextArea ta) {
        mostrarPrimosDadoNivel(this.raiz, nivel, ta);
    }

    private void mostrarPrimosDadoNivel(Nodo actual, int nivel, JTextArea ta) {
        if (actual == null) {
            return;
        }

        if (nivel == 1) {
            for (int i = 1; i <= actual.CantOcupados(); i++) {
                if (esPrimo(actual.getElem(i))) {
                    ta.append(actual.getElem(i) + " ");
                }
            }
            return;
        }

        for (int i = 1; i < actual.M; i++) {
            mostrarPrimosDadoNivel(actual.getHijo(i), nivel - 1, ta);
        }
        mostrarPrimosDadoNivel(actual.getHijo(actual.M), nivel - 1, ta);
    }

    public boolean esPrimo(int ele) {
        int c = 0;
        if (ele == 1) {
            return true;
        }
        for (int i = 1; i <= ele; i++) {
            if ((ele % i) == 0) {
                c++;
            }
        }
        if (c == 2) {
            return true;
        }
        return false;
    }

    public int nivelDeX(int x) {
        return nivelDeX(this.raiz, x, 1);
    }

    private int nivelDeX(Nodo actual, int x, int nivel) {
        if (actual == null) {
            return -1;
        }
        for (int i = 1; i <= actual.CantOcupados(); i++) {
            if (actual.getElem(i) == x) {
                return nivel;
            }
        }
        int n = -1;
        for (int i = 1; i < actual.M; i++) {
            n = nivelDeX(actual.getHijo(i), x, nivel + 1);
            if (n != -1) {
                return n;
            }
        }
        return nivelDeX(actual.getHijo(actual.M), x, nivel + 1);
    }

    //-----------------------------PRACTICANDO-------------------------------------
    public void mostrarHijosDeX(int x, JTextArea jta) {
        mostrarHijosDeX(this.raiz, x, jta, false);
    }

    private void mostrarHijosDeX(Nodo actual, int x, JTextArea jta, boolean band) {
        if (actual == null) {
            return;
        }

        if (band) {
            for (int i = 1; i <= actual.CantOcupados(); i++) {
                jta.append(actual.getElem(i) + " ");
            }
            jta.append("\n");
            return;
        }
        /*  if(esHoja(actual)){//El orden es importante ,mejor no poner pa algunos casos
            return;
        }*/
        // i=1,2
        for (int i = 1; i <= actual.M - 1; i++) {
            int ele = actual.getElem(i);
            if (ele == x) {
                band = true;
                mostrarHijosDeX(actual.getHijo(i), x, jta, band);
                mostrarHijosDeX(actual.getHijo(i + 1), x, jta, band);
                return;
            }
            mostrarHijosDeX(actual.getHijo(i), x, jta, band);
        }
        mostrarHijosDeX(actual.getHijo(actual.M), x, jta, band);

    }
    //---------------------------------------------------------------------------

    public int nivelDelArbol() {
        return nivelDelArbol(this.raiz);

    }

    private int nivelDelArbol(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int nivelTotal = 0;
        for (int i = 1; i <= actual.M; i++) {
            int aux = nivelDelArbol(actual.getHijo(i));
            if (aux > nivelTotal) {
                nivelTotal = aux;
                //
            }
        }
        return nivelTotal + 1;
    }
    //-------------------------------PRINCIPAL---------------------

    public void sumarDesdeN(int n, JTextArea jta) {
        if (n >= 1) {         
            while (n <= nivelDelArbol()) {
                int sumaT = sumaDelNivel(n);
                jta.append("Nivel" + n + " : " + sumaT + "\n");
                n++;
            }
        }
    }
//------------------------------------------------------------------------------

    public int sumaNivel(int nivel) {
        return sumaNivel(this.raiz, nivel);
    }

    private int sumaNivel(Nodo actual, int nivel) {
        if (actual == null) {
            return 0;
        }

        if (nivel == 1) {
            int s = 0;
            for (int i = 1; i <= actual.CantOcupados(); i++) {
                s = s + actual.getElem(i);
            }
           return s;
        }
        int st = 0;
        for (int i = 1; i <= actual.M; i++) {
            st = st + sumaNivel(actual.getHijo(i), nivel - 1);

        }

        return st;
    }
//------------------------------------------------------------------------------
}//end class
