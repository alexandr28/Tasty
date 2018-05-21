package com.acampdev.borisalexandrcamposrios.tasty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.acampdev.borisalexandrcamposrios.tasty.POJOS.Receta;

public class AddRecetaActivity extends AppCompatActivity {

    EditText id,nombre,personas,descripcion,preparacion,fav;
    Button add;
    Receta receta;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receta);

        //id= (EditText) findViewById(R.id.id);
        nombre= (EditText) findViewById(R.id.nombre);
        personas= (EditText) findViewById(R.id.personas);
        descripcion= (EditText) findViewById(R.id.descripcion);
        preparacion= (EditText) findViewById(R.id.preparacion);
        fav= (EditText) findViewById(R.id.fav);
        add=(Button) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receta= new Receta(
                        //id.getText().toString(),
                        SQLConstants.GENERAR_ID,
                        nombre.getText().toString(),
                        Integer.valueOf(personas.getText().toString()),
                        descripcion.getText().toString(),
                        preparacion.getText().toString(),
                        "imagen.jpg",
                        Integer.valueOf(fav.getText().toString()));
                data= new Data(getApplicationContext());
                data.open();
                data.insertReceta(receta);
                Toast.makeText(getApplicationContext(),"Se agreggo la receta",
                        Toast.LENGTH_LONG).show();
                finish();

            }
        });

    }
}
