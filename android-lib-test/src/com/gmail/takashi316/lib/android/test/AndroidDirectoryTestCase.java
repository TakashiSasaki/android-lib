package com.gmail.takashi316.lib.android.test;

import com.gmail.takashi316.lib.android.filesystem.AndroidDirectory;
import com.gmail.takashi316.lib.android.stub.HelloAndroidActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * @author Takashi SASAKI <a href="http://twitter.com/TakashiSasaki"/>
 */
public class AndroidDirectoryTestCase extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	@SuppressWarnings("javadoc")
	public AndroidDirectoryTestCase() {
		super(HelloAndroidActivity.class);
	}// HelloAndroidTestCase

	@SuppressWarnings("javadoc")
	public void testExternalDir() {
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalAlarmsDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalDcimDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalDownloadsDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalFilesDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalMoviesDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalMusicDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalNotificationsDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPicturesDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPodcastsDir(getActivity());
			}
		}));
		assertTrue(doesThrowNullPointerException(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalRingTonesDir(getActivity());
			}
		}));
	}

	@SuppressWarnings("javadoc")
	public void testPublicDir() {
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicAlarmsDir();
			}
		}));

		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicDcimDir();
			}
		}));

		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicDownloadsDir();
			}
		}));
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicMoviesDir();
			}
		}));
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicMusicDir();
			}
		}));
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicNotificationsDir();
			}
		}));
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicPicturesDir();
			}
		}));
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicPodcastsDir();
			}
		}));
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalPublicRingTonesDir();
			}
		}));
	}

	@SuppressWarnings("javadoc")
	public void testExternalStorage() {
		assertTrue(doesThrowNothing(new Runnable() {
			@Override
			public void run() {
				AndroidDirectory.getExternalStorageDirectory();
			}
		}));
	}

	private boolean doesThrowNothing(Runnable runnable) {
		try {
			runnable.run();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean doesThrowNullPointerException(Runnable runnable) {
		try {
			runnable.run();
			return false;
		} catch (NullPointerException e) {
			return true;
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}// setUp

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}// tearDown
}// UsersActivityTestCase

