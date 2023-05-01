package bo.edu.uagrm.androidprueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Diagnostico extends AppCompatActivity {

    TextView diagn;
    TextView porcn;
    Bundle bundle;
    Button reiniciar;
    boolean banderaRecibida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);

        diagn=findViewById(R.id.textView4);
        porcn=findViewById(R.id.textView5);
        bundle = getIntent().getExtras();
        diagn.setText(bundle.getString("diagnostico").toUpperCase());
        banderaRecibida=bundle.getBoolean("bandera");
        if(banderaRecibida){
        porcn.setText("Probabilidad: " + bundle.getString("porcentaje"));
        }else{
            porcn.setText("");
        }
        reiniciar=findViewById(R.id.button4);
        reiniciar.setOnClickListener(view ->reiniciarD() );
    }
    public void reiniciarD(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}