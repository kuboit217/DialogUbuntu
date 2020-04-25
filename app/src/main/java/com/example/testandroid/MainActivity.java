package com.example.testandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDangNhap = (TextView) findViewById(R.id.textviewDangNhap);

        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });
    }
    private void DangNhap(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_customer);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        final EditText edtUsername = (EditText) dialog.findViewById(R.id.edittextUsername);
        final  EditText edtPassword =(EditText) dialog.findViewById(R.id.edittextPassword);
        Button btnDangNhap = (Button) dialog.findViewById(R.id.buttonDangNhap);
        Button btnHuyBo = (Button) dialog.findViewById(R.id.buttonHuyBo);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUsername.getText().toString().trim();
                String passWord = edtPassword.getText().toString().trim();
                if (userName.equals("admin") && passWord.equals("admin")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHuyBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}
