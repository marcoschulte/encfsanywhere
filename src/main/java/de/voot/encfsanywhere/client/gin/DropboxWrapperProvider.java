package de.voot.encfsanywhere.client.gin;

import com.google.inject.Provider;

import de.voot.dropboxgwt.client.DropboxWrapper;

public class DropboxWrapperProvider implements Provider<DropboxWrapper> {

	@Override
	public DropboxWrapper get() {
		return new DropboxWrapper("AIpDZclgp1A=|hHWG5Go3U44gxiBmd8+qMzbC9PaG29DbU/s71VpJEw==");
	}

}
