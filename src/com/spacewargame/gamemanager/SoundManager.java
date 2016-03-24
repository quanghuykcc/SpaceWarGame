package com.spacewargame.gamemanager;

import java.util.HashMap;

import com.spacewargame.R;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {
	private SoundPool mSoundPool;
	private HashMap<Integer, Integer> mSoundPoolMap;
	private AudioManager mAudioManager;
	private Context mContext;

	public static final int SOUND_SHOOT = 1;
	public static final int SOUND_DETONATE = 2;

	public SoundManager(Context context) {
		this.mContext = context;
		this.mSoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		this.mSoundPoolMap = new HashMap<Integer, Integer>();
		this.mAudioManager = (AudioManager) mContext
				.getSystemService(Context.AUDIO_SERVICE);
	}

	public void initSounds() {
		addSound(SoundManager.SOUND_SHOOT, R.raw.sound);
		addSound(SoundManager.SOUND_DETONATE, R.raw.detonate);
	}

	private void addSound(int index, int soundID) {
		mSoundPoolMap.put(index, mSoundPool.load(mContext, soundID, 1));
	}

	public void playSound(int index) {
		int streamVolume = mAudioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		mSoundPool.play(mSoundPoolMap.get(index), streamVolume, streamVolume,
				1, 0, 1.0f);
	}
}
