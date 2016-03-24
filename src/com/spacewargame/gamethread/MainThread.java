package com.spacewargame.gamethread;


import com.spacewargame.gameview.GamePanel;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private  boolean mRunning ;
    private SurfaceHolder mSurfaceHolder;
    private GamePanel mGamePanel;


    public void setRunning(boolean running) {
        this.mRunning = running;
    }

    public MainThread(SurfaceHolder surfaceHolder,GamePanel gamePanel){
        this.mSurfaceHolder =surfaceHolder;
        this.mGamePanel = gamePanel;
    }

    @Override
    public void run() {
        super.run();
        Canvas canvas=null;
        while (mRunning){
            canvas = mSurfaceHolder.lockCanvas();
            if(canvas!=null){
                mGamePanel.onDraw(canvas);
                mSurfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
