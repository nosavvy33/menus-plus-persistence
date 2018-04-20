package com.undead.nosavvy.menuspluspersistence;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.undead.nosavvy.menuspluspersistence.repositories.UserRepository;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.usuario);
        password = (EditText)findViewById(R.id.contrasena);
    }

    public void login(View view){
        String correo = email.getText().toString();
        String contra = password.getText().toString();
        if(correo.equals("") || contra.equals("")){
            Toast.makeText(LoginActivity.this,"Complete todos los campos",Toast.LENGTH_SHORT).show();
            return;
        }
        String res = UserRepository.login(correo,contra);
        if(res.equals("ok")){
           startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
            finish();
        }else if(res.equals("failed")){
            Toast.makeText(LoginActivity.this,"Correo o contraseña inválidos",Toast.LENGTH_SHORT).show();
        }
    }


    public void to_register(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(LoginActivity.this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();

    }
}
