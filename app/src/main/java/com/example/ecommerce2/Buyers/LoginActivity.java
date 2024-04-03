package com.example.ecommerce2.Buyers;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce2.Admin.AdminHomeActivity;
import com.example.ecommerce2.Sellers.SellerProductCategoryActivity;
import com.example.ecommerce2.Model.Users;
import com.example.ecommerce2.Prevalent.Prevalent;
import com.example.ecommerce2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity
{
  private EditText inputPhoneNumber, inputPassword;
  private Button loginButton;
  private ProgressDialog loadingBar;
  private TextView admin, notAdmin, forgetPasswordLink;

  private String parentDbName="Users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=(Button)findViewById(R.id.login_btn);
        inputPassword= (EditText)findViewById(R.id.login_password);
        inputPhoneNumber= (EditText)findViewById(R.id.login_phone_number);
        admin=(TextView)findViewById(R.id.admin_panel_link);
        notAdmin=(TextView)findViewById(R.id.not_admin_panel_link);
        forgetPasswordLink=(TextView)findViewById(R.id.forget_password_link);
        loadingBar=new ProgressDialog(this );

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginUser();
            }
        });

        forgetPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                intent.putExtra("check", "login");
                startActivity(intent);

            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginButton.setText("Login Admin");
                admin.setVisibility(View.INVISIBLE);
                notAdmin.setVisibility(View.VISIBLE);
                parentDbName="Admins";
            }
        });
        notAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                loginButton.setText("Login User ");
                admin.setVisibility(View.VISIBLE);
                notAdmin.setVisibility(View.INVISIBLE);
                parentDbName="Users";
            }
        });
    }

    private void loginUser()
    {
        String phone= inputPhoneNumber.getText().toString();
        String password= inputPassword.getText().toString();

        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(password))
        {

            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        else
            {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("Please wait, while we are checking the credentials");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();

                AllowAccessToAccount(phone,password);

            }
    }

    private void AllowAccessToAccount(  final String phone, final String password)
    {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {

              if(snapshot.child("Users").child(phone).exists())
              {
                  Users usersData= snapshot.child("Users").child(phone).getValue(Users.class);


               if(usersData.getPhone().equals(phone)) {
                   if (usersData.getPassword().equals(password)) {

                       if (parentDbName.equals("Admins")) {
                           Toast.makeText(LoginActivity.this, "Welcome Admin, you are logged in successfully", Toast.LENGTH_SHORT).show();
                           loadingBar.dismiss();
                           Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                           startActivity(intent);
                       } else if (parentDbName.equals("Users")) {
                           Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                           loadingBar.dismiss();
                           Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                           Prevalent.currentOnlineUser = usersData;
                           startActivity(intent);
                       }

                   } else {
                       loadingBar.dismiss();
                       Toast.makeText(LoginActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                   }
               }



              }
              else
              {
                  Toast.makeText(LoginActivity.this, "Account with this" + phone + "number do not exists", Toast.LENGTH_SHORT).show();
                  loadingBar.dismiss();

              }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }
}