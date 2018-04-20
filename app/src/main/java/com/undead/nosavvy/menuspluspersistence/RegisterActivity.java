package com.undead.nosavvy.menuspluspersistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.undead.nosavvy.menuspluspersistence.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText fullname;
    private EditText nickname;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname = (EditText)findViewById(R.id.fullname);
        nickname = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
    }

    public void registrar(View view){
        String nombre = fullname.getText().toString();
        String apodo = nickname.getText().toString();
        String correo = email.getText().toString();
        String contra = password.getText().toString();

        if(nombre.equals("") || apodo.equals("") || correo.equals("") || contra.equals("")){
            Toast.makeText(RegisterActivity.this,"Complete todos los campos",Toast.LENGTH_SHORT).show();
            return;
        }

        UserRepository.create(nombre,apodo,correo,contra);
        finish();

    }
}
