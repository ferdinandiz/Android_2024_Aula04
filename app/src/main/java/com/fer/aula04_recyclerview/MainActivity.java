package com.fer.aula04_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    ItemAdapter adapter;
    ArrayList<ItemData> dadosAL;
    boolean escuro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        dadosAL = new ArrayList<>();
        textView = findViewById(R.id.titulo);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cliquei no título!!", Toast.LENGTH_SHORT).show();
            }
        });

        int modoAtual = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (modoAtual){
            case Configuration.UI_MODE_NIGHT_NO:
                escuro = false;
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                escuro = true;
                TextView textView = findViewById(R.id.titulo);
                textView.setTextColor(Color.WHITE);
                break;
        }

        dadosAL.add(new ItemData("Bulbassauro","Uma estranha semente foi plantada nas suas costas ao nascer. A planta brota e cresce com este POKéMON.",R.drawable.bulbassauro));
        dadosAL.add(new ItemData("Charmander","Obviamente prefere lugares quentes. Quando chove, diz-se que o vapor sai da ponta da cauda.",R.drawable.charmander));
        dadosAL.add(new ItemData("Squirtle","Após o nascimento, suas costas incha e endurece formando uma concha. Pulveriza espuma poderosamente pela boca.",R.drawable.squirtle));
        dadosAL.add(new ItemData("Pikachu","Ele mantém a cauda levantada para monitorar o ambiente. Se você puxar o rabo, ele tentará mordê-lo.",R.drawable.pikachu));
        dadosAL.add(new ItemData("Piplup","Vive ao longo das costas dos países do norte. Nadador habilidoso, mergulha por mais de 10 minutos para caçar.",R.drawable.piplup));
        dadosAL.add(new ItemData("Gengar","Sob a lua cheia, este POKéMON gosta de imitar as sombras das pessoas e rir do seu susto.",R.drawable.gengar));
        dadosAL.add(new ItemData("Marowak","O osso que ele segura é sua arma principal. Ele joga o osso habilmente como um bumerangue para nocautear alvos.",R.drawable.marowak));

        adapter = new ItemAdapter(MainActivity.this, dadosAL, escuro);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}