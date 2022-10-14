package hu.petrik.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton ko, papir, ollo;
    private ImageView enDobas, robotDobas, ensziv1, ensziv2, ensziv3, gepsziv1, gepsziv2, gepsziv3;
    private TextView dontetlen;
    private int[] kepek = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};
    private Random r = new Random();
    private int enertek, robotertek;
    private int enpont, robotpont, tie = 0;
    private AlertDialog.Builder ujJatek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enertek = 0;
                enDobas.setImageResource(R.drawable.rock);
                robotKor();
            }
        });
        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enertek = 1;
                enDobas.setImageResource(R.drawable.paper);
                robotKor();
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enertek = 2;
                enDobas.setImageResource(R.drawable.scissors);
                robotKor();
            }
        });
    }

    private void robotKor() {
        robotertek = r.nextInt(3);
        robotDobas.setImageResource(kepek[robotertek]);
        gyoztes();
    }

    private void gyoztes() {
        if (enertek == robotertek) {
            Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
            tie++;
            dontetlen.setText("Döntetlenek száma: " + tie);
        } else if (enertek == 0 && robotertek == 1) {
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
            computer();
        } else if (enertek == 0 && robotertek == 2) {
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
            ember();
        } else if (enertek == 1 && robotertek == 0) {
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
            ember();
        } else if (enertek == 1 && robotertek == 2) {
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
            computer();
        } else if (enertek == 2 && robotertek == 0) {
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
            computer();
        } else if (enertek == 2 && robotertek == 1) {
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
            ember();
        }
        alert();
    }

    private void ember() {
        enpont++;
        if(enpont == 1){
            gepsziv1.setImageResource(R.drawable.heart1);
        }else if(enpont == 2){
            gepsziv2.setImageResource(R.drawable.heart1);
        }else if(enpont == 3){
            gepsziv3.setImageResource(R.drawable.heart1);
        }
    }

    private void computer() {
        robotpont++;
        if(robotpont == 1){
            ensziv1.setImageResource(R.drawable.heart1);
        }else if(robotpont == 2){
            ensziv2.setImageResource(R.drawable.heart1);
        }else if(robotpont == 3){
            ensziv3.setImageResource(R.drawable.heart1);
        }
    }

    private void alert() {
        if (enpont == 3) {
            ujJatek = new AlertDialog.Builder(MainActivity.this);
            ujJatek.setTitle("Győzelem");
            ujJatek.setMessage("Szeretne új játékot játszani?");
            ujJatek.setCancelable(false);
            ujJatek.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            ujJatek.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    newGame();
                }
            });
            ujJatek.create().show();
        } else if (robotpont == 3){
            ujJatek = new AlertDialog.Builder(MainActivity.this);
            ujJatek.setTitle("Vereség");
            ujJatek.setMessage("Szeretne új játékot játszani?");
            ujJatek.setCancelable(false);
            ujJatek.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            ujJatek.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    newGame();
                }
            });
            ujJatek.create().show();
        }
    }

    private void newGame() {
        enpont = 0;
        robotpont = 0;
        enDobas.setImageResource(R.drawable.rock);
        robotDobas.setImageResource(R.drawable.rock);
        ensziv1.setImageResource(R.drawable.heart2);
        ensziv2.setImageResource(R.drawable.heart2);
        ensziv3.setImageResource(R.drawable.heart2);
        gepsziv1.setImageResource(R.drawable.heart2);
        gepsziv2.setImageResource(R.drawable.heart2);
        gepsziv3.setImageResource(R.drawable.heart2);
    }

    private void init() {
        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);
        enDobas = findViewById(R.id.enDobas);
        robotDobas = findViewById(R.id.robotDobas);
        dontetlen = findViewById(R.id.dontetlen);
        ensziv1 = findViewById(R.id.ensziv1);
        ensziv2 = findViewById(R.id.ensziv2);
        ensziv3 = findViewById(R.id.ensziv3);
        gepsziv1 = findViewById(R.id.gepsziv1);
        gepsziv2 = findViewById(R.id.gepsziv2);
        gepsziv3 = findViewById(R.id.gepsziv3);
    }
}