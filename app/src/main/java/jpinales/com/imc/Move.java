package jpinales.com.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Move extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int idcategoria;
    int numero;
    String [] cat1palabras = new String[6];
    String [] cat2palabras = new String[6];
    String [] cat3palabras = new String[6];
    String [] cat4palabras = new String[6];
    String [] cat5palabras = new String[6];
    String [] cat6palabras = new String[6];
    TextView texto;
    TextView timer;
    //Puntos
    int puntos=0;
    int npuntos=0;
    String word="";
    String nword="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        idcategoria=getIntent().getIntExtra("id", 0);
        texto = findViewById(R.id.palabras);
        timer = findViewById(R.id.timer);
        //TIMER
        CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Intent intent3 = new Intent(Move.this,respuesta.class );
                intent3.putExtra("word", word);
                intent3.putExtra("nword", nword);

                intent3.putExtra("puntos", puntos);
                intent3.putExtra("npuntos", npuntos);
                startActivity(intent3);
            }
        };
        countDownTimer.start();

        //Geografia
        cat1palabras[0]="Brasil";
        cat1palabras[1]="Jamaica";
        cat1palabras[2]="España";
        cat1palabras[3]="EEUU";
        cat1palabras[4]="Chile";
        cat1palabras[5]="Republica Dominicana";

        //Deportes
        cat2palabras[0]="Soccer";
        cat2palabras[1]="Beisbol";
        cat2palabras[2]="Baloncesto";
        cat2palabras[3]="Voleibol";
        cat2palabras[4]="Natacion";
        cat2palabras[5]="Tenis";

        //Animales
        cat3palabras[0]="Perro";
        cat3palabras[1]="Mono";
        cat3palabras[2]="Elefante";
        cat3palabras[3]="Araña";
        cat3palabras[4]="Aguila";
        cat3palabras[5]="Leon";

        //Artistas
        cat4palabras[0]="Juan Luis Guerra";
        cat4palabras[1]="Romeo Santos";
        cat4palabras[2]="Daddy Yankee";
        cat4palabras[3]="Ozuna";
        cat4palabras[4]="El Alfa";
        cat4palabras[5]="Jennifer Lopez";

        //Politica
        cat5palabras[0]="El Penco";
        cat5palabras[1]="Leonel Fernandez";
        cat5palabras[2]="Ejercer el voto";
        cat5palabras[3]="Elecciones";
        cat5palabras[4]="Presidente";
        cat5palabras[5]="Corrupción";

        //Acciones
        cat6palabras[0]="Paseando al Perro";
        cat6palabras[1]="Paracaidismo";
        cat6palabras[2]="Natación";
        cat6palabras[3]="Montar Caballo";
        cat6palabras[4]="Gangnam Style";
        cat6palabras[5]="Competencia de Comida";

        selecion();

        sensorEventListener= new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float z=event.values[2];
                //Hacia abajo correcto
                if (z<-10){
                    puntos++;
                    num();
                 //   word+=texto.getText().toString()+"\n";
                    texto.setText("Correcto");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            selecion();
                        }
                    },500);
                }
                //Hacia Arriba incorrecto
                else if (z>10){
                    npuntos++;
                    num();
                //    nword+=texto.getText().toString()+"\n";
                    texto.setText("Paso");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            selecion();
                        }
                    },500);
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        start();
    }

    public void selecion(){

        if (idcategoria==1){
            texto.setText(cat1palabras[numero]);

        }else if (idcategoria==2){
            texto.setText(cat2palabras[numero]);
        }else if (idcategoria==3){
            texto.setText(cat3palabras[numero]);
        }else if (idcategoria==4){
            texto.setText(cat4palabras[numero]);
        }else if (idcategoria==5){
            texto.setText(cat5palabras[numero]);
        }else if (idcategoria==6){
            texto.setText(cat6palabras[numero]);
        }
    }

    public void num(){
        numero=(int) (Math.random() * 5);
    }
    @Override
    protected void onResume() {
        super.onResume();
        start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        stop();
    }
    private void start(){
        sensorManager.registerListener(sensorEventListener,sensor, SensorManager.SENSOR_DELAY_GAME);
    }
    private void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}
