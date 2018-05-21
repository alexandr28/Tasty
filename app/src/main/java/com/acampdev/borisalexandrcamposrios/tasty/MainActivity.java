package com.acampdev.borisalexandrcamposrios.tasty;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.acampdev.borisalexandrcamposrios.tasty.Adapters.RecetasAdapter;
import com.acampdev.borisalexandrcamposrios.tasty.POJOS.Receta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerRecetas;
    ArrayList<Receta> recetas;
    RecetasAdapter recetasAdapter;
    Data data;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();
        fab= (FloatingActionButton) findViewById(R.id.fab);
        recyclerRecetas = (RecyclerView) findViewById(R.id.recyclerRecetas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerRecetas.setLayoutManager(linearLayoutManager);

        update();
        // hacemos el codigo swiped eliminar hacemos un pipe despues right para hacer otro efecto opcional
        ItemTouchHelper.SimpleCallback simpleCallback=
                new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                RecetasAdapter recetasAdapter= (RecetasAdapter) recyclerRecetas.getAdapter();
                String value = recetasAdapter.recetas.get(position).getNombre();
                data.deteleItem(value);
                update();
            }
        };

        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(simpleCallback);
        // agregamos al recylerview
        itemTouchHelper.attachToRecyclerView(recyclerRecetas);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,AddRecetaActivity.class);
                startActivity(intent);
            }
        });
    }


    public void createData(){
        recetas= new ArrayList<>();
        recetas.add(new Receta(
                "1",
                "Pizza Americana",
                4,
                "pizza america con extra queso",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                1
        ));
        recetas.add(new Receta(
                "2",
                "Pizza Italy",
                4,
                "Pizza Italy Familiar con bastantes embutidos",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                1
        ));
        recetas.add(new Receta(
                "3",
                "Pizza Veggie",
                4,
                "Pizza veggie con verduras organic and olive",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                0
        ));
        recetas.add(new Receta(
                "4",
                "Pizza Spain",
                4,
                "Pizza Spain con bastante cheese y embutidos ",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                1
        ));
        recetas.add(new Receta(
                "5",
                "Sanwitch Pollo",
                2,
                "Rico Sanwicht de pollo con rodojas de tomate lechuga",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                1
        ));
        recetas.add(new Receta(
                "6",
                "Sanwitch Jamon",
                2,
                "Rico Sanwicht de JAmon infles con queso",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                0
        ));
        recetas.add(new Receta(
                "7",
                "Pan con Chorizo",
                2,
                "Rico Pan con chorizo Otto Kunt y muchas papitas",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                1
        ));
        recetas.add(new Receta(
                "8",
                "Sanwitch Salchicha Huachana",
                2,
                "Rico Sanwicht de Salchicha Huachana la especialidad de la casa ",
                "massa de pan y con peperoni pimientos y enbutidos con extra queso",
                "https://www.cicis.com/media/1138/pizza_trad_pepperoni.png",
                0
        ));
        data= new Data(this);
        data.open();
        data.insertRecetas(recetas);
    }

    public List<Receta> getData(){
        List<Receta> recetas = data.getAll();
        return recetas;
    }

    public  void  update(){
        recetasAdapter= new RecetasAdapter(this,getData());
        recyclerRecetas.setAdapter(recetasAdapter);
        //recetasAdapter=new RecetasAdapter(this,recetas);
        //recyclerRecetas.setAdapter(recetasAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.favs:
                //Toast.makeText(this,"Favs",Toast.LENGTH_LONG).show();
                recetasAdapter = new RecetasAdapter(this,data.getFavs());
                recyclerRecetas.setAdapter(recetasAdapter);
                return true;
            case R.id.personas:
                //Toast.makeText(this,"Personas",Toast.LENGTH_LONG).show();
                recetasAdapter= new RecetasAdapter(this,data.getPersonas(2));
                recyclerRecetas.setAdapter(recetasAdapter);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
