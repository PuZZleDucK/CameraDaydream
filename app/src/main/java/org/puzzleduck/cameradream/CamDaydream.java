package org.puzzleduck.cameradream;

import android.hardware.Camera;
import android.service.dreams.DreamService;
import android.widget.FrameLayout;

/**
 * Project: Camera Daydream
 * Description: "Camera Daydream" will equip almost any phone or tablet with a mirror or see-through daydream function.
 *   If available the front facing camera will be used to enable a "mirror mode" daydream where everything the camera can see is reflected back in the daydream. For bonus points... setup two Camera Daydreams pointing at each other for that classy "Infinity Dream" look.
 *   If only a single camera is found then the "see through mode" is enabled allowing you to (almost) see right through your device. Now your device is almost undetectable while charging, assuming the camera lens is dangling precariously over the edge of the table, and you're looking at just the right angle.
 *   To enable "Camera Daydream" just go to your devices [Settings] -> [Display] -> [Daydream] and select "Camera Daydream". Then dock or charge your phone anytime to bask in your own glory, go on... do it now, go bask in some of that glory. Your just spectacular!
 * Author: PuZZleDucK.
 * Licence: GPL3
 * Project started: 17/01/16.
 */
public class CamDaydream extends DreamService {
    private Camera dreamCam;

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        if(Camera.getNumberOfCameras() == 1) {
            dreamCam = Camera.open(0);
        } else {
            dreamCam = Camera.open(1);
        }
        Camera.Parameters firstParams = dreamCam.getParameters();
        CameraPreview mPreview1 = new CameraPreview(this, dreamCam);
        FrameLayout preview = new FrameLayout(this); //R.id.surfaceView1
        preview.removeAllViews();
        preview.addView(mPreview1);

        dreamCam.setDisplayOrientation(90);
        setContentView(preview);
    }

    @Override
    public void onDreamingStopped(){
        super.onDreamingStopped();
        if (dreamCam != null){
            dreamCam.release();        // release the camera for other applications
            dreamCam = null;
        }
    }
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFullscreen(true);
    }
    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

}
