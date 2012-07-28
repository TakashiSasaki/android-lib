package com.gmail.takashi316.lib.android.wifi;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

/**
 * WifiListDialog shows the list of Wi-Fi access points.
 * 
 * @author Takashi SASAKI
 * 
 */
public class WifiListDialog extends AlertDialog.Builder {
	private Context context;
	private WifiManager wifiManager;

	/**
	 * The constructor.
	 * 
	 * @param context_
	 */
	public WifiListDialog(Context context_) {
		super(context_);
		this.context = context_;
		this.wifiManager = (WifiManager) this.context
				.getSystemService(Context.WIFI_SERVICE);
	}// the constructor

	@Override
	public AlertDialog show() {
		if (this.wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
			List<ScanResult> results = this.wifiManager.getScanResults();
			final String[] items = new String[results.size()];
			for (int i = 0; i < results.size(); ++i) {
				items[i] = results.get(i).SSID;
			}// for
			if (items.length > 0) {
				setItems(items, null);
			} else {
				setItems(new String[] { "なし" }, null);
			}// if
				// final ArrayAdapter<String> adapter = new
				// ArrayAdapter<String>(this,
				// android.R.layout.simple_list_item_1, items);
				// setListAdapter(adapter);
		}
		setTitle("Wi-Fi access points");
		return super.show();
	}// show

}// WifiListDialog
