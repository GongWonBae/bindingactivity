package univ.anyang.bindingactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class TimetableActivity extends AppCompatActivity {
    LoginActivity lA = new LoginActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        ImageView img=(ImageView)findViewById(R.id.timetime);
        switch (lA.SID){
            case "201131046":
                img.setImageResource(R.drawable.gongtt);
                break;
            case "201031009":
                img.setImageResource(R.drawable.oktt);
                break;
            case "201131069":
                img.setImageResource(R.drawable.leett);
                break;
            case "201031045":
                img.setImageResource(R.drawable.defaulttt);
                break;
            default:
                Toast.makeText(getApplicationContext(),"아이디 확인 오류",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
