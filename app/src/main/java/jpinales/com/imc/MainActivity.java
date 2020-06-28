package jpinales.com.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cat1(View view){
        Intent intent = new Intent(MainActivity.this, cnt.class);
        intent.putExtra("id", 1);
        startActivity(intent);
    }

    public void cat2(View view){
        Intent intent = new Intent(MainActivity.this, cnt.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }

    public void cat3(View view){
        Intent intent = new Intent(MainActivity.this, cnt.class);
        intent.putExtra("id", 3);
        startActivity(intent);
    }

    public void cat4(View view){
        Intent intent = new Intent(MainActivity.this, cnt.class);
        intent.putExtra("id", 4);
        startActivity(intent);
    }

    public void cat5(View view){
        Intent intent = new Intent(MainActivity.this, cnt.class);
        intent.putExtra("id", 5);
        startActivity(intent);
    }

    public void cat6(View view){
        Intent intent = new Intent(MainActivity.this, cnt.class);
        intent.putExtra("id", 6);
        startActivity(intent);
    }



}
