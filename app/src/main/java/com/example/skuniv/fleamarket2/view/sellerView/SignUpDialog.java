package com.example.skuniv.fleamarket2.view.sellerView;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.skuniv.fleamarket2.R;
import com.example.skuniv.fleamarket2.databinding.SignUpBinding;
import com.example.skuniv.fleamarket2.viewModel.sellerViewModel.MainCommand;

public class SignUpDialog extends Dialog {
    Context context;
    SignUpBinding signUpBinding;
    MainCommand mainCommand;
    String sex;


    public SignUpDialog(@NonNull Context context, MainCommand mainCommand) {
        super(context);
        this.context = context;
        this.mainCommand = mainCommand;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = (SignUpBinding)
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.sign_up, null, false);
        setContentView(signUpBinding.getRoot());
        mainCommand.setSignUpDialog(this);

        signUpBinding.sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.male){
                    sex = "male";
                } else if(i == R.id.female){
                    sex = "female";
                }
            }
        });

        signUpBinding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 연동 시
                /*if(signUpBinding.idText.getText().toString().equals("")){
                    Toast.makeText(context,"아이디를 입력하세요",Toast.LENGTH_SHORT).show();
                } else if(signUpBinding.pwText.getText().toString().equals("")){
                    Toast.makeText(context,"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show();
                } else if(signUpBinding.nameText.getText().toString().equals("")){
                    Toast.makeText(context,"이름을 입력하세요",Toast.LENGTH_SHORT).show();
                } else if(signUpBinding.emailText.getText().toString().equals("")){
                    Toast.makeText(context,"이메일을 입력하세요",Toast.LENGTH_SHORT).show();
                } else{
                    //signCommand.signUp(signUpBinding.idText.getText().toString(),signUpBinding.pwText.getText().toString(),
                            //sex,signUpBinding.nameText.getText().toString(), signUpBinding.emailText.getText().toString());
                    System.out.println("아이디 : " + signUpBinding.idText.getText().toString() + "  비밀번호 : " + signUpBinding.pwText.getText().toString() +
                            "  성별 : " + sex + "  이름 : " + signUpBinding.nameText.getText().toString() + "  이메일 : " + signUpBinding.emailText.getText().toString());
                }*/
                // test
                mainCommand.signUptest();
            }
        });
    }
}