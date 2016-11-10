package univ.anyang.bindingactivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {

    Intent newintent;
    Button btn_logout;
    Switch switch_id,switch_pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btn_logout = (Button)findViewById(R.id.button_logout);
        switch_id = (Switch)findViewById(R.id.switch_id);
        switch_pw = (Switch)findViewById(R.id.switch_pw);

        setChecked();

        switch_id.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking)  //true일 때
                {
                    SharedPreferences pref = getSharedPreferences("Information", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("idchecked",true);
                    editor.commit();
                } else          //false일 때
                {
                    SharedPreferences pref = getSharedPreferences("Information", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    //editor.remove("id");
                    editor.putBoolean("idchecked",false);
                    editor.commit();
                }
            }
        });

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button_logout:
                logout(v);
        }
    }

    private void setChecked() {
        SharedPreferences pref = getSharedPreferences("Information", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        boolean bool_id = pref.getBoolean("idchecked",false);
        boolean bool_pw = pref.getBoolean("pwchecked",false);
        if(bool_id) {
            switch_id = (Switch)findViewById(R.id.switch_id);
            switch_id.setChecked(true);
        }
        if(bool_pw) {
            switch_pw = (Switch)findViewById(R.id.switch_pw);
            switch_pw.setChecked(true);
        }
    }


    public void logout(View v){
        new AlertDialog.Builder(this)
                .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newintent = new Intent(SettingActivity.this , LoginActivity.class);
                        newintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(newintent);
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
}
