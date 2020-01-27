package gov.nasa.worldwindx;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterCoordinatesActivity extends AppCompatActivity {

    EditText lat,longi;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_coordinates);


        lat = (EditText)findViewById(R.id.latitudenumber);
        longi = (EditText)findViewById(R.id.longitudenumber);

        go = (Button)findViewById(R.id.goButton);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LetsGo();

            }
        });
    }

    private void LetsGo() {

        String la = lat.getText().toString().trim();
        String lo = longi.getText().toString().trim();

        if(la.isEmpty()){
            lat.setError("Enter Latitude");
            lat.requestFocus();
            return;
        }

        if(lo.isEmpty()){

            longi.setError("Enter Latitude");
            longi.requestFocus();
            return;

        }

        Intent intent = new Intent(EnterCoordinatesActivity.this,GeneralGlobeActivity.class);
        intent.putExtra("Latitude__",la);
        intent.putExtra("Longitude__",lo);
        startActivity(intent);



    }
}
