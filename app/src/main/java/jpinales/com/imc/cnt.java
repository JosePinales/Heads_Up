package jpinales.com.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class cnt extends AppCompatActivity {
    int idcategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnt);
        idcategoria=getIntent().getIntExtra("id", 0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(cnt.this, Move.class);
                intent.putExtra("id", idcategoria);
                startActivity(intent);
                finish();
            }
        },4300); //4300

    }
}
