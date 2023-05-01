package bo.edu.uagrm.androidprueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

import bo.edu.uagrm.androidprueba1.capaN.Arbol;
import bo.edu.uagrm.androidprueba1.capaN.Nodo;

public class Preguntas extends AppCompatActivity {
     TextView pregunta;
     Button bttSI;
    Button bttNo;
    Arbol tree;
    Nodo actual;
    boolean auxiliar=false;
    float contadorSi=0;//cuenta los si
    float contadorNodosPregunta=0;//cuenta los nodos totales
    LinkedList<Float>probabilidades=new LinkedList<>();
LinkedList<String>enfermedades=new LinkedList<>();
   String conclusion="Consulte a su medico para una evaluacion mas precisa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        tree=new Arbol();

        tree.insertar(10000, "Fiebre");

        tree.insertar(20000, "Dolor de cabeza y dolor muscular" );
        tree.insertar(30000, "Tos seca y dolor de garganta");
        tree.insertar(40000, "Dolor de cuerpo y fatiga");
        tree.insertar(40500, "Dolor de pecho y sudores nocturnos");
        tree.insertarConEnfermedad(40250,"Ninguno","Gripe",true);
        tree.insertarConEnfermedad(50000,"Ninguno", "Neumonia Bacteriana",true);

        tree.insertar(30500, "Dolor de oido y de garganta");
        tree.insertarConEnfermedad(30750,"Ninguno","Otitis media aguda",true);
        tree.insertarConEnfermedad(30250,"Ninguno",conclusion,false);

        tree.insertar(20100, "Dificultad para respirar");
        tree.insertar(20500, "Dolor en el pecho y tos con esputo");
        tree.insertarConEnfermedad(20750,"Ninguno","Neumonia",true);
        tree.insertarConEnfermedad(20250,"Ninguno",conclusion,false);

        tree.insertar(20050, "Dolor de Corazon y articular");//corregido al grafico
        tree.insertarConEnfermedad(20070,"Ninguno" , "Fiebre Reumatica",true);//corregido al grafico
        tree.insertarConEnfermedad(20030,"Ninguno",conclusion,false);//corregido al grafico

        tree.insertar(15000, "Dolor de estómago y diarrea");
        tree.insertar(18000, "Náuseas y vómitos");
        tree.insertar(19000, "Dolor abdominal intenso y fiebre alta");
        tree.insertarConEnfermedad(19500,"Ninguno","Apendicitis",true);
        tree.insertarConEnfermedad(18500,"Ninguno", "Gastroenteritis",true);
        tree.insertar(17000, "Dolor de Abdominal y diarrea sangrienta");
        tree.insertarConEnfermedad(17500,"Ninguno","Colitis Infecciosa",true);
        tree.insertarConEnfermedad(16500,"Ninguno",conclusion,false);

        tree.insertar(13000, "Errupcion en la piel");
        tree.insertar(13500, "Dolor de Cabeza y Fiebre Alta");
        tree.insertarConEnfermedad(14000,"Ninguno","Tifoidea",true);
        tree.insertarConEnfermedad(13250,"Ninguno",conclusion,false);

        tree.insertar(12000, "Dolor de Cabeza y fatiga");
        tree.insertarConEnfermedad(12500,"Ninguno","Mononucleosis",true);
        tree.insertarConEnfermedad(11250,"Ninguno",conclusion,false);//corregido del grafico
//--------------------------------------SUBARBOL IZQUIERDO-------------------------------------------------
        tree.insertar(5000, "Dolor de cabeza persistente");
       //su parte izquierda
        tree.insertar(4000,"Dolor de estomago y diarrea");
        tree.insertar(2000,"Tiene dificultad para respirar o tos");
        tree.insertar(4500,"Tiene fiebre y dolor abdominal intenso");
        tree.insertar(1000,"Tiene fatiga y debilidad");
        tree.insertar(3000,"Tiene dolor de pecho y tos con esputo");
        tree.insertarConEnfermedad(4250,"Ninguno","Gastroenteritis",true);
        tree.insertarConEnfermedad(4750,"Ninguno","Colico biliar o pacreatitis",true);
        tree.insertarConEnfermedad(500,"Ninguno",conclusion,false);
        tree.insertarConEnfermedad(1500,"Ninguno","Anemia",true);
        tree.insertarConEnfermedad(2500,"Ninguno",conclusion,false);
        tree.insertarConEnfermedad(3500,"Ninguno","Bronquitis",true);
      //su parte derecha
        tree.insertar(7500, "Problemas de vision o nauseas");
        tree.insertar(8000, "Mareos y nauseas");
         tree.insertarConEnfermedad(8500,"Ninguno","Migraña con aura",true);
        tree.insertarConEnfermedad(7750,"Ninguno","Migraña sin aura",true);
        tree.insertar(6000, "Tension muscular en el cuello y los hombros");

        tree.insertarConEnfermedad(5500,"Ninguno",conclusion,false);
        tree.insertarConEnfermedad(6500,"Ninguno","Usted tiene dolor de cabeza tensional",true);
//---------------------------------------FIN DEL CARGADO DEL ARBOL-------------------------------------------
        actual=tree.getRaiz();

        pregunta=findViewById(R.id.textView);
        mostrarPrimerPregunta();

        bttNo=findViewById(R.id.button3);
        bttNo.setOnClickListener(view ->mostrarPreguntaIzq());
        bttSI=findViewById(R.id.button2);
        bttSI.setOnClickListener(view -> mostrarPreguntaDer());
    }

    public void mostrarPrimerPregunta(){
        String preg=actual.getSintoma();
        pregunta.setText(preg);
    }
    public void mostrarPreguntaIzq(){

        contadorNodosPregunta++;
      //  Toast.makeText(getApplicationContext(), "ContadorNodosPregunta: " + contadorNodosPregunta, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), "ContadorSI: " + contadorSi, Toast.LENGTH_SHORT).show();

        actual=actual.getHI();
        if(actual!=null){
            if(!actual.esHoja()){
                String preg=actual.getSintoma();
                pregunta.setText(preg);
            }else{
                String e=actual.getEnfermedad();
            //    Toast.makeText(getApplicationContext(), "ContadorNodosPregunta: " + contadorNodosPregunta, Toast.LENGTH_SHORT).show();
             //   Toast.makeText(getApplicationContext(), "ContadorSI: " + contadorSi, Toast.LENGTH_SHORT).show();
                float prob=contadorSi/contadorNodosPregunta;
                prob=prob*100;
                if(actual.getBandera()==false){
                    enfermedades.add("");
                    probabilidades.add(0.0F);
                }else{
                    enfermedades.add(actual.getEnfermedad());
                    probabilidades.add(prob);
                }
                tree.abueloDeX(actual.getElem());
              //  diagnostico(e,String.valueOf(prob),actual.getBandera());
            }
        }
    }
    public void mostrarPreguntaDer(){
        contadorSi++;
   //     Toast.makeText(getApplicationContext(), "ContadorSI: " + contadorSi, Toast.LENGTH_SHORT).show();
        contadorNodosPregunta++;
        actual=actual.getHD();
        if(actual!=null){
            if(!actual.esHoja()){
                String preg=actual.getSintoma();
                pregunta.setText(preg);
            }else{
                String e=actual.getEnfermedad();
                float prob=contadorSi/contadorNodosPregunta;
                prob=prob*100;
                if(actual.getBandera()==false){
                    enfermedades.add("");
                    probabilidades.add(0.0F);
                }else{
                    enfermedades.add(actual.getEnfermedad());
                    probabilidades.add(0.0F);
                }
                 tree.metodoAux(tree.abueloDeXRef(actual.getElem()));

               // diagnostico(e,String.valueOf(prob),actual.getBandera());
            }
        }
    }
    public void diagnostico(String diagnostico, String percentage,boolean band) {
        Intent intent = new Intent(this, Diagnostico.class);
        intent.putExtra("diagnostico", diagnostico);
        intent.putExtra("porcentaje", percentage+"%");
        intent.putExtra("bandera",band);
        startActivity(intent);
    }
}