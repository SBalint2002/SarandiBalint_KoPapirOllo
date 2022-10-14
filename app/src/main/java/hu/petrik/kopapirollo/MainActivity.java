package hu.petrik.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private Button ko, papir, ollo;
    private ImageView enDobas, robotDobas;
    private TextView eredmeny;
    private int[] kepek = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enDobas.setImageResource(R.drawable.rock);
            }
        });
        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enDobas.setImageResource(R.drawable.paper);
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enDobas.setImageResource(R.drawable.scissors);
            }
        });
    }

    private void init(){
        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);
        enDobas = findViewById(R.id.enDobas);
        robotDobas = findViewById(R.id.robotDobas);
        eredmeny = findViewById(R.id.eredmeny);
    }
}