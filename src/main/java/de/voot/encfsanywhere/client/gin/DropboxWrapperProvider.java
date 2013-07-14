/*
  	Copyright (C) 2013 Marco Schulte

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.voot.encfsanywhere.client.gin;

import com.google.inject.Provider;

import de.voot.dropboxgwt.client.DropboxWrapper;

public class DropboxWrapperProvider implements Provider<DropboxWrapper> {

	@Override
	public DropboxWrapper get() {
		return new DropboxWrapper("AIpDZclgp1A=|hHWG5Go3U44gxiBmd8+qMzbC9PaG29DbU/s71VpJEw==");
	}

}
