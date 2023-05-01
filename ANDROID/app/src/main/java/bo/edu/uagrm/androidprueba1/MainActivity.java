package bo.edu.uagrm.androidprueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import bo.edu.uagrm.androidprueba1.capaN.Arbol;

public class MainActivity extends AppCompatActivity {
    Button mostrarP;

    TextView textViewP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarP=findViewById(R.id.button);
        mostrarP.setOnClickListener(view -> pantallaPreguntas());



    }
    public void pantallaPreguntas(){
        Intent intent=new Intent(this,Preguntas.class);
        startActivity(intent);
    }
}