package jpinales.com.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class respuesta extends AppCompatActivity {

    String word;
    String nword;
    int puntos;
    int npuntos;

    TextView end1;
    TextView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        word=getIntent().getStringExtra("word");
        nword=getIntent().getStringExtra("nword");

        puntos=getIntent().getIntExtra("puntos",0);
        npuntos=getIntent().getIntExtra("puntos",0);

        end1= findViewById(R.id.partida);
        card1=findViewById(R.id.cartas);

        card1.setText("Palabras Correctas: " + puntos +" \n" + word + "\nPalabras incorrectas: "+ npuntos+ "\n" +nword );


    }

    public void volver(View view){
        Intent intent2 = new Intent(respuesta.this, MainActivity.class);
        startActivity(intent2);
    }

}
