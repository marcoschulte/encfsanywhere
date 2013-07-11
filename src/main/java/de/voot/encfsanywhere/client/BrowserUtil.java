package de.voot.encfsanywhere.client;

import de.voot.encfsgwt.shared.jre.InputStream;

public class BrowserUtil {

	public static native void download(InputStream inputStream, String filename) /*-{
		var bufferSize = 1024 * 1024;
		var buffers = [];

		var finished = false;
		while (!finished) {
			var buffer = new ArrayBuffer(bufferSize);
			var view = new Uint8Array(buffer);

			var bytesRead = inputStream.@de.voot.encfsgwt.shared.jre.InputStream::read(Lcom/google/gwt/core/client/JsArrayInteger;)(view);

			if (bytesRead == -1) {
				finished = true;
			} else if (bytesRead != view.byteLength) {
				view = view.subarray(0, bytesRead);
				finished = true;
			}

			if (bytesRead > -1) {
				buffers.push(view);
			}

		}

		var blob = new Blob(buffers);
		$wnd.saveAs(blob, filename);
	}-*/;
}
