package cbtis72.regina.deliciouscake;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor=prefs.edit();
        editor.putString("email", "modificado@email.com");
        editor.putString("nombre","Prueba");
        editor.putInt("edad", 23);
        editor.commit();

        //Esto es para cuando no hay nada, valores por defecto
        String language = prefs.getString("email", "");
        int edad = prefs.getInt("edad", 0);



        //instancia de firebase
        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputEditText etEmail = (TextInputEditText) findViewById(R.id.username);
        final TextInputEditText etPassword = (TextInputEditText) findViewById(R.id.password);

        Button btnLogin = (Button) findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validacion de datos de la cuenta

                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.equals("")){
                    Toast.makeText(LoginActivity.this, "Proporcionar un nombre de usuario válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals("")){
                    Toast.makeText(LoginActivity.this, "Proporcione una contraseña de usuario válida", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Autenticando con la FireBase
                firebaseAuth.signInWithEmailAndPassword( email , password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                                }else {
                                    goContainer();
                                }
                            }
                        });
            }
        });

    }

    public void goCreateAccount(View view){
        //en donde estoy y a donde quiero ir
        Intent intent=new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goContainer(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
