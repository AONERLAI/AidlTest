package com.example.aidltest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class AdditionService extends Service{

	public AdditionService() {
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return new IaidlData.Stub() {
			
			@Override
			public int add(int a, int b) throws RemoteException {
				
				return a+b;
			}
		};
	}
	class AdditionServiceConnection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			arg1=(IBinder) IaidlData.Stub.asInterface(arg1);
			
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			arg0=null;
			Toast.makeText(getApplicationContext(), "Service disconnected", Toast.LENGTH_LONG).show();
			
		}
		
		
		
		
	}

}
