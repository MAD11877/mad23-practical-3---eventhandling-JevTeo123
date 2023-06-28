package sg.edu.np.mad.mad_practical_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String title = "Main Activity";
    //    @Override
//    public void onClick(View v){
//        switch (v.getId()) {
//            case R.id.btnFollow:
//                Toast.makeText(this, "Follow button clicked", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        String stringVariableName = extras.getString("StringVariableName");
        int myRecvText = Integer.parseInt(stringVariableName);
        TextView myMessage = findViewById(R.id.textView2);
        myMessage.setText("MAD " + myRecvText);
        Log.v(title, "Recv: "+ myRecvText);

        Button btnFollow = findViewById(R.id.btnFollow);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            private boolean set = false;
            @Override
            public void onClick(View v) {
                set = ! set;
                System.out.println("Followed!");
                btnFollow.setText(set? "Followed" : "Follow");
                if (set == false) {
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onFollowbtnClicked(View view){
        TextView txtFollow = findViewById(R.id.txtWelcome);
        txtFollow.setText("Followed");
    }
}