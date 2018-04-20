package com.undead.nosavvy.menuspluspersistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.undead.nosavvy.menuspluspersistence.repositories.ItemRepository;

public class RegisterItemActivity extends AppCompatActivity {

    private EditText name;
    private EditText price;
    private EditText category;
    private EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_item);
        name = (EditText)findViewById(R.id.itemname);
        price = (EditText)findViewById(R.id.price);
        category = (EditText)findViewById(R.id.category);
        description = (EditText)findViewById(R.id.description);
    }

    public void register_item(View view){
        String nombre = name.getText().toString();
        Double precio = Double.parseDouble(price.getText().toString());
        String categoria = category.getText().toString();
        String descripcion = description.getText().toString();
        String estado = "normal";
        if(nombre.equals("") || categoria.equals("") || descripcion.equals("") || precio == 0){
            Toast.makeText(RegisterItemActivity.this,"Complete todos los campos",Toast.LENGTH_SHORT).show();
            return;
        }

        ItemRepository.create(nombre,categoria,precio,descripcion,estado);
        finish();
    }
}
