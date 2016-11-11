package univ.anyang.bindingactivity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class TimetableActivity extends ActionBarActivity {
    LoginActivity lA = new LoginActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timetable, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }
}
