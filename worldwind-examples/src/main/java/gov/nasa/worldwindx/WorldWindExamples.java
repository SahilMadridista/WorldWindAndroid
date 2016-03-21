package gov.nasa.worldwindx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.layer.ShowTessellationLayer;
import gov.nasa.worldwindx.layer.GroundLayer;
import gov.nasa.worldwindx.layer.ImageLayer;

public class WorldWindExamples extends AppCompatActivity {

    protected WorldWindow wwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the World Window and set it as the content view for this activity.
        this.wwd = new WorldWindow(this);
        this.setContentView(this.wwd);

        // Setup the World Window's layers.
        this.wwd.getLayers().addLayer(new ShowTessellationLayer());
        this.wwd.getLayers().addLayer(new ImageLayer(new Sector().setFullSphere(), R.drawable.world_topo_bathy_200405_3));
        this.wwd.getLayers().addLayer(new GroundLayer());

        // Configure a custom navigation controller to spin the globe automatically.
        this.wwd.setNavigatorController(new ExampleController());
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.wwd.onPause(); // pauses the rendering thread
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.wwd.onResume(); // resumes a paused rendering thread
    }
}
