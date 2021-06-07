package com.example.hbwitcher;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private EditText editLogin , editPassword;
    private FirebaseAuth mAuth;
    private Button btStart, btSignIn, btSignUp, btSignOut;
    private TextView tvUserName;


    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_layout);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            signed();

            Toast.makeText(this, "Вхід дозволено", Toast.LENGTH_SHORT).show();
        }
        else {  Toast.makeText(this, "Користувач не існує", Toast.LENGTH_SHORT).show();
           notSigned();
        }
    }



    public void init(){
        btSignOut=findViewById(R.id.btSignOut);
        btSignIn = findViewById(R.id.signIn);
        btSignUp=findViewById(R.id.signUp);
        btStart=findViewById(R.id.bStart);
       tvUserName=findViewById(R.id.tvUserEmail);
       editLogin=findViewById(R.id.edLogin);
       editPassword=findViewById(R.id.edPassword);
       mAuth=FirebaseAuth.getInstance();
    }



private void notSigned(){
    btStart.setVisibility(View.GONE);
    tvUserName.setVisibility(View.GONE);
    btSignOut.setVisibility(View.GONE);
    btSignIn.setVisibility(View.VISIBLE);
    btSignUp.setVisibility(View.VISIBLE);
    editLogin.setVisibility(View.VISIBLE);
    editPassword.setVisibility(View.VISIBLE);
}

private void signed(){

    FirebaseUser currentUser = mAuth.getCurrentUser();

    btStart.setVisibility(View.VISIBLE);
    btSignOut.setVisibility(View.VISIBLE);
    tvUserName.setVisibility(View.VISIBLE);
    String str="Ви можете почати свою подорож як:"+currentUser.getEmail();
    tvUserName.setText(str);
    btSignIn.setVisibility(View.GONE);
    btSignUp.setVisibility(View.GONE);
    editLogin.setVisibility(View.GONE);
    editPassword.setVisibility(View.GONE);}




    public  void onClickSignUp(View view){

        if(!TextUtils.isEmpty(editLogin.getText().toString()) && !TextUtils.isEmpty(editPassword.getText().toString()) ) {
            mAuth.createUserWithEmailAndPassword(editLogin.getText().toString(), editPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        signed();
                      //  sendEmailVer();
                         Toast.makeText(LoginActivity.this, "User SignUp successful", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        notSigned();
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    public  void onClickSignIn(View view){

        if(!TextUtils.isEmpty(editLogin.getText().toString()) && !TextUtils.isEmpty(editPassword.getText().toString()) ) {
      mAuth.signInWithEmailAndPassword(editLogin.getText().toString(), editPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            signed();
            Toast.makeText(LoginActivity.this, "User SignIn successful", Toast.LENGTH_SHORT).show();
        }
        else {
            notSigned();
            Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
});

        }


    }


public void onClickSignOut( View view){
        FirebaseAuth.getInstance().signOut();
        notSigned();
}

public void onClickStart(View view){
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
}

@Override
protected void onDestroy(){
        super.onDestroy();
        finish();
}


}
