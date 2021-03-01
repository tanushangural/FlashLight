package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String cameraId = cameraManager.getCameraIdList()[0];
                    String buttonstate = button.getText().toString();
                    if(buttonstate == "ON"){
                        button.setText("OFF");
                        cameraManager.setTorchMode(cameraId,true);
                    }
                    else{
                        button.setText("ON");
                        cameraManager.setTorchMode(cameraId,false);
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();

                }
            }
        });

    }
}