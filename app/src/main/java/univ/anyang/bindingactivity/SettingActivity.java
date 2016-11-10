package univ.anyang.bindingactivity;

import android.content.Intent;
import android.os.Build;
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

        switch_id.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking)  //true일 때
                {

                } else          //false일 때
                {

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


    public void logout(View v){
        Intent logoutIntent = new Intent(this,LoginActivity.class);
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
            newintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        else {
            newintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        stopService(newintent);
        startActivity(logoutIntent);
    }
}
